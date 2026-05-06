package com.example.BD_CU.controllers;

import com.example.BD_CU.dtos.QueryNative2DTO;
import com.example.BD_CU.dtos.QueryNativeDTO;
import com.example.BD_CU.dtos.RolDTO;
import com.example.BD_CU.dtos.UsuarioDTO;
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

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("usuario")
public class UsuarioController {


    @Autowired
    private IUsuarioService Us;
    @Autowired
    private IRolService Rs;

    @GetMapping("/listar-usuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?>listar(){
        ModelMapper m = new ModelMapper();
        List<UsuarioDTO>listaTareas = Us.list()
                .stream().map(y->m.map(y, UsuarioDTO.class))
                .collect(Collectors.toList());
        if(listaTareas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay usuarios registrados");
        }
        else{
            return  ResponseEntity.ok(listaTareas);
        }
    }

    @PostMapping("/registrar-usuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m=new ModelMapper();
        Optional<Rol> rol = Rs.listId(dto.getRolId());
        if (rol.isPresent()) {
            Usuario us=m.map(dto, Usuario.class);
            Usuario cur= Us.insert(us);
            UsuarioDTO responseDTO=m.map(cur,UsuarioDTO.class);
            return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Rol no encontrado\nSolicitud de registro denegada");
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
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

    @PutMapping("/actualizar-usuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody UsuarioDTO dto) {
        Optional<Usuario> existente = Us.listId(dto.getUsuario_Id());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
        Usuario tp = existente.get();
        tp.setUsuario_Id(dto.getUsuario_Id());
        tp.setNombre(dto.getNombre());
        tp.setApellido(dto.getApellido());
        tp.setEmail(dto.getEmail());
        tp.setPassword(dto.getPassword());
        tp.setExtras(dto.getExtras());
        tp.setEstado(dto.getEstado());
        tp.setFechaRegistro(dto.getFechaRegistro());
        Us.update(tp);
        return ResponseEntity.ok("Usuario actualizado correctamente");
    }

    @DeleteMapping("/eliminar{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
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

    @GetMapping("/cantidad-usuarios")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> obtenercantUsuxRol(){
        List<Object[]> listaCantidad=Us.quantityUsuariosxRolNative();
        if(listaCantidad.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay usuarios asignados");
        }
        List<QueryNativeDTO> respuesta=new ArrayList<>();
        for(Object[] fila:listaCantidad){
            QueryNativeDTO dto=new QueryNativeDTO();
            dto.setRolId(((Number)fila[0]).intValue());
            dto.setNombreRol((String) fila[1]);
            dto.setQuantityUsuarios(((Number)fila[2]).intValue());
            respuesta.add(dto);
        }
        return  ResponseEntity.ok(respuesta);
    }
    @GetMapping("/buscar-pagos-usuario")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscarPagaDeUsuarios(){
        List<Object[]> listaPaga= Us.buscarPagoUsuariosNative();
        if(listaPaga.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay usuarios");
        }
        List<QueryNative2DTO> respuesta2 =new ArrayList<>();
        for(Object[] fila:listaPaga){
            QueryNative2DTO dto2 = new QueryNative2DTO();
            dto2.setUsuario_Id(((Number)fila[0]).intValue());
            dto2.setNombre((String)fila[1]);
            dto2.setApellido((String)fila[2]);
            dto2.setSueldoTotal(((Number)fila[3]).intValue());
            respuesta2.add(dto2);
        }
        return  ResponseEntity.ok(respuesta2);
    }

}
