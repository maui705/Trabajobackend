package com.example.trabajo.controllers;

import com.example.trabajo.dtos.CosechaDTO;
import com.example.trabajo.entities.Cosecha;
import com.example.trabajo.entities.Lote;
import com.example.trabajo.servicesinterfaces.ICosechaService;
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
@RequestMapping("api/cosechas")
public class CosechaController {

    @Autowired
    private ICosechaService cS;

    @Autowired
    private ILoteService lS;

    @GetMapping("/listar")
    public ResponseEntity<List<CosechaDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<CosechaDTO> lista = cS.list().stream()
                .map(y -> m.map(y, CosechaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody CosechaDTO dto) {
        Optional<Lote> lote = lS.listId(dto.getLoteId());
        if (lote.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lote no encontrado");
        }
        Cosecha c = new Cosecha();
        c.setCantidad(dto.getCantidad());
        c.setEstadoCosecha(dto.getEstadoCosecha());
        c.setFirmaElectronica(dto.getFirmaElectronica());
        c.setResponsable(dto.getResponsable());
        c.setMetodos(dto.getMetodos());
        c.setLote(lote.get());
        Cosecha saved = cS.insert(c);
        ModelMapper m = new ModelMapper();
        return ResponseEntity.status(HttpStatus.CREATED).body(m.map(saved, CosechaDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Cosecha> cosecha = cS.listId(id);
        if (cosecha.isPresent()) {
            return ResponseEntity.ok(m.map(cosecha.get(), CosechaDTO.class));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cosecha no encontrada");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody CosechaDTO dto) {
        Optional<Cosecha> existente = cS.listId(dto.getCosechaId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cosecha no encontrada");
        }
        Cosecha c = existente.get();
        c.setCantidad(dto.getCantidad());
        c.setEstadoCosecha(dto.getEstadoCosecha());
        c.setFirmaElectronica(dto.getFirmaElectronica());
        c.setResponsable(dto.getResponsable());
        c.setMetodos(dto.getMetodos());
        cS.update(c);
        return ResponseEntity.ok("Cosecha actualizada correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Cosecha> cosecha = cS.listId(id);
        if (cosecha.isPresent()) {
            cS.delete(id);
            return ResponseEntity.ok("Cosecha eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cosecha no encontrada");
        }
    }
}