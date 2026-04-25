package com.example.trabajo.controllers;

import com.example.trabajo.dtos.LoteDTO;
import com.example.trabajo.dtos.LoteGeneralDTO;
import com.example.trabajo.entities.Lote;
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
    private ILoteService lS;

    @GetMapping("/listar")
    public ResponseEntity<List<LoteDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<LoteDTO> lista = lS.list().stream()
                .map(y -> m.map(y, LoteDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    public ResponseEntity<LoteGeneralDTO> registrar(@RequestBody LoteGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        Lote l = m.map(dto, Lote.class);
        Lote saved = lS.insert(l);
        return ResponseEntity.status(HttpStatus.CREATED).body(m.map(saved, LoteGeneralDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Lote> lote = lS.listId(id);
        if (lote.isPresent()) {
            return ResponseEntity.ok(m.map(lote.get(), LoteGeneralDTO.class));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lote no encontrado");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody LoteGeneralDTO dto) {
        Optional<Lote> existente = lS.listId(dto.getLoteId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lote no encontrado");
        }
        Lote l = existente.get();
        l.setUbicacion(dto.getUbicacion());
        l.setTamaño(dto.getTamaño());
        l.setVariedadCafe(dto.getVariedadCafe());
        l.setObservacion(dto.getObservacion());
        l.setEstado(dto.getEstado());
        lS.update(l);
        return ResponseEntity.ok("Lote actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Lote> lote = lS.listId(id);
        if (lote.isPresent()) {
            lS.delete(id);
            return ResponseEntity.ok("Lote eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lote no encontrado");
        }
    }
}