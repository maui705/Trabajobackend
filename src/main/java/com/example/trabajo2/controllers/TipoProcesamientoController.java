package com.example.trabajo2.controllers;

import com.example.trabajo2.dtos.TipoProcesamientoDTO;
import com.example.trabajo2.dtos.TipoProcesamientoGeneralDTO;
import com.example.trabajo2.entities.TipoProcesamiento;
import com.example.trabajo2.servicesinterfaces.ITipoProcesamientoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/tipoProcesamiento")
public class TipoProcesamientoController {

    @Autowired
    private ITipoProcesamientoService Ts;

    @GetMapping("/listar-tipoProcesamiento")
    public ResponseEntity<List<TipoProcesamientoDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<TipoProcesamientoDTO> lista = Ts.list().stream()
                .map(y -> m.map(y, TipoProcesamientoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar-TipoProcesamiento")
    public ResponseEntity<TipoProcesamientoGeneralDTO> registrar(@RequestBody TipoProcesamientoGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoProcesamiento tp = m.map(dto, TipoProcesamiento.class);
        TipoProcesamiento tpr = Ts.insert(tp);
        return ResponseEntity.status(HttpStatus.CREATED).body(m.map(tpr, TipoProcesamientoGeneralDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<TipoProcesamiento> tipo = Ts.listId(id);
        if (tipo.isPresent()) {
            return ResponseEntity.ok(m.map(tipo.get(), TipoProcesamientoGeneralDTO.class));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TipoProcesamiento no encontrado");
        }
    }

    @PutMapping("/actualizar-TipoProcesamiento")
    public ResponseEntity<String> actualizar(@RequestBody TipoProcesamientoGeneralDTO dto) {
        Optional<TipoProcesamiento> existente = Ts.listId(dto.getTipoId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TipoProcesamiento no encontrado");
        }
        TipoProcesamiento tp = existente.get();
        tp.setNombre(dto.getNombre());
        tp.setDescripcion(dto.getDescripcion());
        Ts.update(tp);
        return ResponseEntity.ok("TipoProcesamiento actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<TipoProcesamiento> tp = Ts.listId(id);
        if (tp.isPresent()) {
            Ts.delete(id);
            return ResponseEntity.ok("TipoProcesamiento eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TipoProcesamiento no encontrado");
        }
    }
}

