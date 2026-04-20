package com.example.trabajo.controllers;

import com.example.trabajo.dtos.ProcesamientoDTO;
import com.example.trabajo.dtos.ProcesamientoGeneralDTO;
import com.example.trabajo.entities.Procesamiento;
import com.example.trabajo.servicesinterfaces.IProcesamientoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/procesamiento")
public class ProcesamientoController {

    @Autowired
    private IProcesamientoService Ps;

    @GetMapping("/listar")
    public ResponseEntity<List<ProcesamientoDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<ProcesamientoDTO> lista = Ps.list().stream()
                .map(y -> m.map(y, ProcesamientoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    public ResponseEntity<ProcesamientoGeneralDTO> registrar(@RequestBody ProcesamientoGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        Procesamiento p = m.map(dto, Procesamiento.class);
        Procesamiento saved = Ps.insert(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(m.map(saved, ProcesamientoGeneralDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Procesamiento> proc = Ps.listId(id);
        if (proc.isPresent()) {
            return ResponseEntity.ok(m.map(proc.get(), ProcesamientoGeneralDTO.class));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Procesamiento no encontrado");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody ProcesamientoGeneralDTO dto) {
        Optional<Procesamiento> existente = Ps.listId(dto.getProcesamientoId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Procesamiento no encontrado");
        }
        Procesamiento p = existente.get();
        p.setCosechaId(dto.getCosechaId());
        p.setTipoId(dto.getTipoId());
        p.setFechaInicio(dto.getFechaInicio());
        p.setFechaFin(dto.getFechaFin());
        p.setMetodo(dto.getMetodo());
        p.setCantidad(dto.getCantidad());
        p.setEstado(dto.getEstado());
        Ps.update(p);
        return ResponseEntity.ok("Procesamiento actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Procesamiento> proc = Ps.listId(id);
        if (proc.isPresent()) {
            Ps.delete(id);
            return ResponseEntity.ok("Procesamiento eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Procesamiento no encontrado");
        }
    }
}