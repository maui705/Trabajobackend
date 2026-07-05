package com.example.trabajo2.controllers;

import com.example.BD_CU.dtos.*;
import com.example.BD_CU.entities.Actividad;
import com.example.BD_CU.servicesinterfaces.IActividadService;
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

    @GetMapping("/listar-actividad")
    public ResponseEntity<List<ActividadDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<ActividadDTO> ListarActividad = Ls.list().stream()
                .map(y -> m.map(y, ActividadDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(ListarActividad);
    }

    @PostMapping("/registrar-actividad")
    public ResponseEntity<ActividadGeneralDTO> registrar(@RequestBody ActividadGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        Actividad c = m.map(dto, Actividad.class);
        Actividad cur = Ls.insert(c);
        ActividadGeneralDTO responseDTO = m.map(cur, ActividadGeneralDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
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
    public ResponseEntity<String> actualizar(@RequestBody ActividadGeneralDTO dto) {
        Optional<Actividad> existente = Ls.listId(dto.getActividadid());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Actividad no encontrado");
        }

        Actividad l = existente.get();
        l.setActividadid(dto.getActividadid());
        l.setDescripcion(dto.getDescripcion());
        l.setFechaInicio(dto.getFechaInicio());
        l.setFechaFin(dto.getFechaFin());
        l.setResponsable(dto.getResponsable());
        l.setEstado(dto.getEstado());

        Ls.update(l);

        return ResponseEntity.ok("Actividad actualizado correctamente");
    }
    @DeleteMapping("/{id}")
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

    @PostMapping("/cantidad-variedadcafe-actividad")
    public ResponseEntity<?>CantidadVariedadCafe(){
        List<Object[]> listaCantidad=Ls.quantityActividad();
        if(listaCantidad.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay lotes asignadas");
        }
        List<QuantityActividad> respuesta=new ArrayList<>();
        for(Object[] fila:listaCantidad){
            QuantityActividad dto=new QuantityActividad();
            dto.setVariedadCafe((String) fila[0]);
            dto.setResponsable((String) fila[1]);
            dto.setEstado((String) fila[2]);
            dto.setQuantityActividad(((Number) fila[3]).intValue());
            respuesta.add(dto);
        }
        return  ResponseEntity.ok(respuesta);
    }

    @PostMapping("/cantidad-usuario-actividad")
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
            dto.setDescripcion((String) fila[2]);
            dto.setEstadoActividad((String) fila[3]);
            dto.setResponsable((String) fila[4]);
            dto.setQuantityActividad2(((Number) fila[5]).intValue());

            respuesta.add(dto);
        }

        return ResponseEntity.ok(respuesta);
    }




}
