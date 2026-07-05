package com.example.BD_CU.controllers;

import com.example.BD_CU.dtos.*;
import com.example.BD_CU.entities.Actividad;
import com.example.BD_CU.entities.Lote;
import com.example.BD_CU.entities.Usuario;
import com.example.BD_CU.servicesinterfaces.IActividadService;
import com.example.BD_CU.servicesinterfaces.ILoteService;
import com.example.BD_CU.servicesinterfaces.IUsuarioService;
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
@RequestMapping("api/actividad")
public class ActividadController {
    @Autowired
    private IActividadService Ls;
    @Autowired
    private IUsuarioService Us;
    @Autowired
    private ILoteService LoS;


    @GetMapping("/listar-actividad")
  //  @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<ActividadGeneralDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<ActividadGeneralDTO> ListarActividad = Ls.list().stream()
                .map(y -> m.map(y, ActividadGeneralDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(ListarActividad);
    }

    @PostMapping("/registrar-actividad")
// @PreAuthorize("hasAuthority('SUP')")
    public ResponseEntity<?> registrar(@RequestBody ActividadGeneralDTO dto) {

        Optional<Usuario> usuario = Us.listId(dto.getUsuarioId());

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no existe");
        }

        Optional<Lote> lote = LoS.listId(dto.getLoteId());

        if (lote.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El lote no existe");
        }

        Actividad actividad = new Actividad();
        actividad.setDescripcion(dto.getDescripcion());
        actividad.setFechaInicio(dto.getFechaInicio());
        actividad.setFechaFin(dto.getFechaFin());
        actividad.setEstado(dto.getEstado());
        actividad.setUsuario(usuario.get());
        actividad.setLote(lote.get());

        Actividad cur = Ls.insert(actividad);

        ActividadGeneralDTO responseDTO = new ActividadGeneralDTO();
        responseDTO.setActividadid(cur.getActividadid());
        responseDTO.setDescripcion(cur.getDescripcion());
        responseDTO.setFechaInicio(cur.getFechaInicio());
        responseDTO.setFechaFin(cur.getFechaFin());
        responseDTO.setEstado(cur.getEstado());
        responseDTO.setUsuarioId(cur.getUsuario().getUsuario_Id());
        responseDTO.setLoteId(cur.getLote().getLoteId());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
  //  @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Actividad> project = Ls.listId(id);

        if (project.isPresent()) {
            ActividadGeneralDTO dto = m.map(project.get(), ActividadGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Actividad no encontrado");
        }
    }

    @PutMapping("/actualizar-actividad")
  //  @PreAuthorize("hasAuthority('SUP')")
    public ResponseEntity<String> actualizar(@RequestBody ActividadGeneralDTO dto) {
        Optional<Actividad> existente = Ls.listId(dto.getActividadid());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Actividad no encontrado");
        }

        Actividad l = existente.get();
        l.setActividadid(dto.getActividadid());
        l.setFechaInicio(dto.getFechaInicio());
        l.setFechaFin(dto.getFechaFin());
        l.setEstado(dto.getEstado());

        Ls.update(l);

        return ResponseEntity.ok("Actividad actualizado correctamente");
    }
    @DeleteMapping("/{id}")
  //  @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Actividad> project = Ls.listId(id);

        if (project.isPresent()) {
            Ls.delete(id);
            return ResponseEntity.ok("Actividad eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Actividad no encontrado");
        }
    }

    @GetMapping("/cantidad-actividad-lote")
    //  @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?>CantidadVariedadCafe(){
        List<Object[]> listaCantidad=Ls.quantityActividad();
        if(listaCantidad.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay lotes asignadas");
        }
        List<QuantityActividad> respuesta=new ArrayList<>();
        for(Object[] fila:listaCantidad){
            QuantityActividad dto=new QuantityActividad();
            dto.setLoteId(((Number) fila[0]).intValue());
            dto.setVariedadCafe((String) fila[1]);
            dto.setQuantityActividad(((Number) fila[2]).intValue());
            respuesta.add(dto);
        }
        return  ResponseEntity.ok(respuesta);
    }

    @GetMapping("/cantidad-actividad-ususario")
    //   @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> cantidadUsuarioActividad() {
        List<Object[]> listaCantidad = Ls.quantityActividad2();

        if (listaCantidad.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay actividades asignadas");
        }

        List<QuantityActividad2> respuesta=new ArrayList<>();
        for(Object[] fila:listaCantidad){
            QuantityActividad2 dto=new QuantityActividad2();
            dto.setNombre((String) fila[0]);
            dto.setApellido((String) fila[1]);
            dto.setQuantityActividad2(((Number) fila[2]).intValue());
            respuesta.add(dto);
        }

        return ResponseEntity.ok(respuesta);
    }





}
