package com.example.trabajo2.controllers;
import com.example.trabajo2.dtos.UsuarioDTO;
import com.example.trabajo2.entities.Usuario;
import com.example.trabajo2.servicesimplements.IUsuarioService;
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
    private IUsuarioService Us;
    @Autowired


    @GetMapping("/listar")
    public ResponseEntity<?>listar(){
        ModelMapper m = new ModelMapper();
        List<UsuarioDTO>listaTareas = Us.list()
                .stream().map(y->m.map(y, UsuarioDTO.class))
                .collect(Collectors.toList());
        if(listaTareas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay tarea registrada");
        }
        else{
            return  ResponseEntity.ok(listaTareas);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Usuario> project = Us.listId(id);

        if (project.isPresent()) {
            UsuarioDTO dto = m.map(project.get(), UsuarioDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody UsuarioDTO dto) {
        Optional<Usuario> existente = Us.listId(dto.getUsuario_Id());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }

        Usuario tp = existente.get();
        tp.setNombre(dto.getNombre());
        tp.setApellido(dto.getApellido());
        tp.setEmail(dto.getEmail());
        tp.setPassword(dto.getPassword());
        tp.setEstado(dto.getEstado());
        tp.setFechaRegistro(dto.getFechaRegistro());
        Us.update(tp);
        return ResponseEntity.ok("Usuario actualizado correctamente");
    }

    @DeleteMapping("/eliminar{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Usuario> project = Us.listId(id);

        if (project.isPresent()) {
            Us.delete(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
    }

}
