package com.example.BD_CU.controllers;

import com.example.BD_CU.dtos.UsuarioDTO;
import com.example.BD_CU.dtos.UsuarioGeneralDTO;
import com.example.BD_CU.entities.Usuario;
import com.example.BD_CU.servicesinterfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService Ts;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<UsuarioDTO> listaUsuario = Ts.list().stream()
                .map(y -> m.map(y, UsuarioDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listaUsuario);
    }


    @PostMapping("/registrar")
    public ResponseEntity<UsuarioGeneralDTO> registrar(@RequestBody UsuarioGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario c = m.map(dto, Usuario.class);
        Usuario cur = Ts.insert(c);
        UsuarioGeneralDTO responseDTO = m.map(cur, UsuarioGeneralDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Usuario> project = Ts.listId(id);

        if (project.isPresent()) {
            UsuarioGeneralDTO dto = m.map(project.get(), UsuarioGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody UsuarioGeneralDTO dto) {
        Optional<Usuario> existente = Ts.listId(dto.getUsuario_Id());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }

        Usuario tp = existente.get();
        tp.setNombre(dto.getNombre());
        tp.setApellido(dto.getApellido());
        tp.setEmail(dto.getEmail());
        tp.setPassword(dto.getPassword());
        Ts.update(tp);
        return ResponseEntity.ok("Usuario actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Usuario> project = Ts.listId(id);

        if (project.isPresent()) {
            Ts.delete(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
    }

}
