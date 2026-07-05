package com.example.BD_CU.controllers;

import com.example.BD_CU.dtos.AImagenesDTO;
import com.example.BD_CU.dtos.TipoProcesamientoDTO;
import com.example.BD_CU.dtos.TipoProcesamientoGeneralDTO;
import com.example.BD_CU.entities.AImagenes;
import com.example.BD_CU.entities.TipoProcesamiento;
import com.example.BD_CU.servicesinterfaces.ITipoProcesamientoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tipoprocesamiento")
public class TipoProcesamientoController {

    @Autowired
    private ITipoProcesamientoService Ts;

    @GetMapping("/listar-tipoprocesamiento")
   // @PreAuthorize("hasAuthority('SUP')")

    public ResponseEntity<List<TipoProcesamientoDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<TipoProcesamientoDTO> lista = Ts.list().stream()
                .map(y -> m.map(y, TipoProcesamientoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar-tipoprocesamiento")
    //@PreAuthorize("hasAuthority('SUP')")
    public ResponseEntity<TipoProcesamientoGeneralDTO> registrar(@RequestBody TipoProcesamientoGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoProcesamiento tp = m.map(dto, TipoProcesamiento.class);
        TipoProcesamiento tpr = Ts.insert(tp);
        return ResponseEntity.status(HttpStatus.CREATED).body(m.map(tpr, TipoProcesamientoGeneralDTO.class));
    }

    @GetMapping("/{id}")
   // @PreAuthorize("hasAuthority('SUP')")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<TipoProcesamiento> tipo = Ts.listId(id);
        if (tipo.isPresent()) {
            return ResponseEntity.ok(m.map(tipo.get(), TipoProcesamientoGeneralDTO.class));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TipoProcesamiento no encontrado");
        }
    }

    @PutMapping("/actualizar-tipoprocesamiento")
    //@PreAuthorize("hasAuthority('SUP')")
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
   // @PreAuthorize("hasAuthority('SUP')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<TipoProcesamiento> tp = Ts.listId(id);
        if (tp.isPresent()) {
            Ts.delete(id);
            return ResponseEntity.ok("TipoProcesamiento eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TipoProcesamiento no encontrado");
        }
    }

    @GetMapping("/buscar-tipoprocesamiento")
   // @PreAuthorize("hasAuthority('SUP')")
    public ResponseEntity<?> buscarPorTipoFor(@RequestParam String nombre) {
        List<TipoProcesamiento> lista = Ts.findByNombre(nombre);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existen tipos guardados con el nomnre: " + nombre);
        }
        ModelMapper m = new ModelMapper();
        List<TipoProcesamientoGeneralDTO> listaa = Ts.findByNombre(nombre).stream()
                .map(y -> m.map(y, TipoProcesamientoGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaa);
    }
}

