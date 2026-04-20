package com.example.trabajo.controllers;

import com.example.trabajo.dtos.LoteDTO;
import com.example.trabajo.dtos.LoteGeneralDTO;
import com.example.trabajo.entities.Lote;
import com.example.trabajo.repositories.ILoteRepository;
import com.example.trabajo.servicesinterfaces.ILoteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/lotes")
public class LoteController {
    @Autowired
    private ILoteService Ls;

    @GetMapping("/listar")
    public ResponseEntity<List<LoteDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<LoteDTO> listaLotes = Ls.list().stream()
                .map(y -> m.map(y, LoteDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listaLotes);

    }

    @PostMapping("/web")
    public ResponseEntity<LoteGeneralDTO> registrar(@RequestBody LoteGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        Lote c = m.map(dto, Lote.class);
        Lote cur = Ls.insert(c);
        LoteGeneralDTO responseDTO = m.map(cur, LoteGeneralDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Lote> project = Ls.listId(id);

        if (project.isPresent()) {
            LoteGeneralDTO dto = m.map(project.get(), LoteGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody LoteGeneralDTO dto) {
        Optional<Lote> existente = Ls.listId(dto.getLoteid());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado");
        }

        Lote l = existente.get();
        l.setUbicacion(dto.getUbicacion());
        l.setTamaño(dto.getTamaño());
        l.setVariedadcafe(dto.getVariedadcafe());
        l.setObservacion(dto.getObservacion());
        l.setEstado(dto.getEstado());

        Ls.update(l);

        return ResponseEntity.ok("Proyecto actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Lote> project = Ls.listId(id);

        if (project.isPresent()) {
            Ls.delete(id);
            return ResponseEntity.ok("Proyecto eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado");
        }
    }
}


