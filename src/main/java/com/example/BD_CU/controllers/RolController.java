package com.example.BD_CU.controllers;

import com.example.BD_CU.dtos.QueryNative2DTO;
import com.example.BD_CU.dtos.RolDTO;
import com.example.BD_CU.dtos.RolGeneralDTO;
import com.example.BD_CU.entities.Rol;
import com.example.BD_CU.entities.Usuario;
import com.example.BD_CU.servicesinterfaces.IRolService;
import com.example.BD_CU.servicesinterfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private IRolService Rs;

    @Autowired
    private IUsuarioService Us;


    @GetMapping("/listar-rol")
    public ResponseEntity<List<RolGeneralDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<RolGeneralDTO> lista = Rs.list().stream()
                .map(y -> m.map(y, RolGeneralDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar-rol")
// @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> registrar(@RequestBody RolGeneralDTO dto) {
        Optional<Usuario> usuario = Us.listId(dto.getUser_id());

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El Usuario no existe");
        }

        Rol r = new Rol();
        r.setUsuarios(usuario.get());
        r.setDescripcion(dto.getDescripcion());
        r.setSueldo(dto.getSueldo());
        r.setFechaCreacion(dto.getFechaCreacion());
        r.setPermisos(dto.getPermisos());
        r.setRol(dto.getRol());

        Rol rol = Rs.insert(r);

        RolGeneralDTO responseDTO = new RolGeneralDTO();
        responseDTO.setRolId(rol.getRolId());
        responseDTO.setRol(rol.getRol());
        responseDTO.setDescripcion(rol.getDescripcion());
        responseDTO.setSueldo(rol.getSueldo());
        responseDTO.setFechaCreacion(rol.getFechaCreacion());
        responseDTO.setPermisos(rol.getPermisos());
        responseDTO.setUser_id(rol.getUsuarios().getUsuario_Id());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
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
        r.setRolId(dto.getRolId());
        r.setRol(dto.getRol());
        r.setDescripcion(dto.getDescripcion());
        r.setSueldo(dto.getSueldo());
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