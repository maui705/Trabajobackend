package com.example.trabajo2.controllers;

import com.example.trabajo2.dtos.LoteDTO;
import com.example.trabajo2.dtos.LoteGeneralDTO;
import com.example.trabajo2.entities.Lote;
import com.example.trabajo2.servicesimplements.ILoteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lote")
public class LoteController {
    @Autowired
    private ILoteService lS;

    @GetMapping("/listar")
    public ResponseEntity<List<LoteDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<LoteDTO> listaLotes = lS.list().stream()
                .map(y -> m.map(y, LoteDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok( listaLotes);
    }

    @PostMapping("/registrar")
    public ResponseEntity<LoteGeneralDTO> registrar(@RequestBody LoteGeneralDTO dto){
        ModelMapper m=new ModelMapper();
        Lote c=m.map(dto, Lote.class);
        Lote cur= lS.insert(c);
        LoteGeneralDTO responseDTO=m.map(cur,LoteGeneralDTO.class);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Lote> lote = lS.listId(id);

        if (lote.isPresent()) {
            LoteGeneralDTO dto = m.map(lote.get(), LoteGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Lote no encontrado");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody LoteGeneralDTO dto) {
        Optional<Lote> existente = lS.listId(dto.getLoteId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Lote no encontrado");
        }
        Lote p = existente.get();
        p.setLoteId(dto.getLoteId());
        p.setEstado(dto.getEstado());
        p.setObservacion(dto.getObservacion());
        p.setTamaño(dto.getTamaño());
        p.setVariedadCafe(dto.getVariedadCafe());

        lS.update(p);

        return ResponseEntity.ok("Lote actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Lote> project = lS.listId(id);

        if (project.isPresent()) {
            lS.delete(id);
            return ResponseEntity.ok("Lote eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Lote encontrado");
        }
    }
}
