package com.example.BD_CU.controllers;

import com.example.BD_CU.dtos.QueryNative2DTO;
import com.example.BD_CU.dtos.RolDTO;
import com.example.BD_CU.dtos.RolGeneralDTO;
import com.example.BD_CU.entities.Rol;
import com.example.BD_CU.servicesinterfaces.IRolService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/roles")
public class RolController {

    @Autowired
    private IRolService Rs;

    @GetMapping("/listar-rol")
    public ResponseEntity<List<RolDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<RolDTO> lista = Rs.list().stream()
                .map(y -> m.map(y, RolDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar-rol")
    public ResponseEntity<RolGeneralDTO> registrar(@RequestBody RolGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        Rol ro = Rs.insert(r);
        RolGeneralDTO responseDTO=m.map(ro,RolGeneralDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
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

    @PutMapping("/actualizar-rol")
    public ResponseEntity<String> actualizar(@RequestBody RolGeneralDTO dto) {
        Optional<Rol> existente = Rs.listId(dto.getRolId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado");
        }
        if (dto.getFechaCreacion() == null ) {
            return ResponseEntity.badRequest()
                    .body("Las fechas no puede ser nula");
        }
        Rol r = existente.get();
        r.setNombreRol(dto.getNombreRol());
        r.setDescripcion(dto.getDescripcion());
        r.setSueldo((int) dto.getSueldo());
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