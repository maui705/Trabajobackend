package com.example.trabajo.controllers;

import com.example.trabajo.dtos.RolDTO;
import com.example.trabajo.dtos.RolGeneralDTO;
import com.example.trabajo.entities.Rol;
import com.example.trabajo.servicesinterfaces.IRolService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/roles")
public class RolController {

    @Autowired
    private IRolService Rs;

    @GetMapping("/listar")
    public ResponseEntity<List<RolDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<RolDTO> lista = Rs.list().stream()
                .map(y -> m.map(y, RolDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    public ResponseEntity<RolGeneralDTO> registrar(@RequestBody RolGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        Rol saved = Rs.insert(r);
        return ResponseEntity.status(HttpStatus.CREATED).body(m.map(saved, RolGeneralDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Rol> rol = Rs.listId(id);
        if (rol.isPresent()) {
            return ResponseEntity.ok(m.map(rol.get(), RolGeneralDTO.class));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody RolGeneralDTO dto) {
        Optional<Rol> existente = Rs.listId(dto.getRolId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        }
        Rol r = existente.get();
        r.setNombreRol(dto.getNombreRol());
        r.setDescripcion(dto.getDescripcion());
        r.setSueldo(dto.getSueldo());
        r.setExtras(dto.getExtras());
        r.setPermisos(dto.getPermisos());
        r.setFechaCreacion(dto.getFechaCreacion());
        Rs.update(r);
        return ResponseEntity.ok("Rol actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Rol> rol = Rs.listId(id);
        if (rol.isPresent()) {
            Rs.delete(id);
            return ResponseEntity.ok("Rol eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        }
    }
}