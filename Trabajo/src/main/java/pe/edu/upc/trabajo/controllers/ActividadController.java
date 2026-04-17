package pe.edu.upc.trabajo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.trabajo.dtos.ActividadDTO;
import pe.edu.upc.trabajo.dtos.ActividadGeneralDTO;
import pe.edu.upc.trabajo.entities.Actividad;
import pe.edu.upc.trabajo.repositories.IActividadRepository;
import pe.edu.upc.trabajo.servicesinterfaces.IActividadService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RestController
@RequestMapping("api/actividad")
public class ActividadController {
    @Autowired
    private IActividadService Ls;

    @GetMapping("/listar")
    public ResponseEntity<List<ActividadDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<ActividadDTO> ListarActividad = Ls.list().stream()
                .map(y -> m.map(y, ActividadDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(ListarActividad);
    }

    @PostMapping("/web")
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
                    .body("Proyecto no encontrado");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody ActividadGeneralDTO dto) {
        Optional<Actividad> existente = Ls.listId(dto.getActividadid());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado");
        }

        Actividad l = existente.get();
        l.setActividadid(dto.getActividadid());
        l.setDescripcion(dto.getDescripcion());
        l.setFechaInicio(dto.getFechaInicio());
        l.setFechaFin(dto.getFechaFin());
        l.setResponsable(dto.getResponsable());
        l.setEstado(dto.getEstado());

        Ls.update(l);

        return ResponseEntity.ok("Proyecto actualizado correctamente");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Actividad> project = Ls.listId(id);

        if (project.isPresent()) {
            Ls.delete(id);
            return ResponseEntity.ok("Proyecto eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado");
        }
    }



}
