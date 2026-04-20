package com.example.BD_CU.controllers;

import com.example.BD_CU.dtos.CosechaDTO;
import com.example.BD_CU.dtos.CosechaGeneralDTO;
import com.example.BD_CU.entities.Cosecha;
import com.example.BD_CU.servicesinterfaces.ICosechaService;
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
public class CosechaController {
    @Autowired
    private ICosechaService Ls;

    @GetMapping("/listar")
    public ResponseEntity<List<CosechaDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<CosechaDTO> listaCosecha = Ls.list().stream()
                .map(y -> m.map(y, CosechaDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listaCosecha);

    }

    @PostMapping("/Registrar")
    public ResponseEntity<CosechaGeneralDTO> registrar(@RequestBody CosechaGeneralDTO dto) {
        ModelMapper m = new ModelMapper();
        Cosecha c = m.map(dto, Cosecha.class);
        Cosecha cur = Ls.insert(c);
        CosechaGeneralDTO responseDTO = m.map(cur, CosechaGeneralDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Cosecha> project = Ls.listId(id);

        if (project.isPresent()) {
            CosechaGeneralDTO dto = m.map(project.get(), CosechaGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cosecha no encontrado");
        }
    }

    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody CosechaGeneralDTO dto) {
        Optional<Cosecha> existente = Ls.listId(dto.getCosecha_Id());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cosecha no encontrado");
        }

        Cosecha l = existente.get();
        l.setCantidad(dto.getCantidad());
        l.setEstado(dto.getEstado());
        l.setMetodo(dto.getMetodo());
        l.setObservaciones(dto.getObservaciones());
        l.setResponsable(dto.getResponsable());

        Ls.update(l);

        return ResponseEntity.ok("Cosecha actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Cosecha> project = Ls.listId(id);

        if (project.isPresent()) {
            Ls.delete(id);
            return ResponseEntity.ok("Cosecha eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cosecha no encontrado");
        }
    }
}


