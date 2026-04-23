package com.example.trabajo.controllers;

import com.example.trabajo.dtos.LoteDTO;
import com.example.trabajo.dtos.LoteGeneralDTO;
import com.example.trabajo.dtos.TipoProcesamientoDTO;
import com.example.trabajo.dtos.TipoProcesamientoGeneralDTO;
import com.example.trabajo.entities.Lote;
import com.example.trabajo.entities.TipoProcesamiento;
import com.example.trabajo.servicesinterfaces.ILoteService;
import com.example.trabajo.servicesinterfaces.ITipoProcesamientoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/TipoProcesamiento")
public class TipoProcesamientoController {

    @Autowired
    private ITipoProcesamientoService Ts;

    @GetMapping("/listar")
    public ResponseEntity<List<TipoProcesamientoDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<TipoProcesamientoDTO> listaTipoProcesamiento = Ts.list().stream()
                .map(y -> m.map(y, TipoProcesamientoDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listaTipoProcesamiento);
    }


    @PostMapping("/registrar")
    public ResponseEntity<TipoProcesamientoGeneralDTO> registrar(@RequestBody TipoProcesamientoGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoProcesamiento c = m.map(dto, TipoProcesamiento.class);
        TipoProcesamiento cur = Ts.insert(c);
        TipoProcesamientoGeneralDTO responseDTO = m.map(cur, TipoProcesamientoGeneralDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<TipoProcesamiento> project = Ts.listId(id);

        if (project.isPresent()) {
            TipoProcesamientoGeneralDTO dto = m.map(project.get(), TipoProcesamientoGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody TipoProcesamientoGeneralDTO dto) {
        Optional<TipoProcesamiento> existente = Ts.listId(dto.getTipoId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado");
        }

        TipoProcesamiento tp = existente.get();
        tp.setNombre(dto.getNombre());
        tp.setDescripcion(dto.getDescripcion());
        Ts.update(tp);
        return ResponseEntity.ok("Proyecto actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<TipoProcesamiento> project = Ts.listId(id);

        if (project.isPresent()) {
            Ts.delete(id);
            return ResponseEntity.ok("Proyecto eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado");
        }
    }

}
