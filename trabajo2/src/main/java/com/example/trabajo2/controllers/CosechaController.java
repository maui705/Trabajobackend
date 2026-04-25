package com.example.trabajo2.controllers;

import com.example.trabajo2.dtos.CosechaDTO;
import com.example.trabajo2.dtos.LoteGeneralDTO;
import com.example.trabajo2.entities.Cosecha;
import com.example.trabajo2.entities.Lote;
import com.example.trabajo2.servicesimplements.ICosechaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cosechas")
public class CosechaController {
    @Autowired
    private ICosechaService cS;

    @GetMapping("/listarCosecha")
    public ResponseEntity<?> listar(){
        ModelMapper m = new ModelMapper();
        List<CosechaDTO> listaCosechas = cS.list()
                .stream().map(y->m.map(y, CosechaDTO.class))
                .collect(Collectors.toList());
        if(listaCosechas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay tarea registrada");
        }
        else{
            return  ResponseEntity.ok(listaCosechas);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody CosechaDTO dto){
        ModelMapper m=new ModelMapper();
        Optional<Cosecha> cosecha = cS.listId(dto.getIdCosecha());
        if (cosecha.isPresent()) {
            Cosecha ta=m.map(dto, Cosecha.class);
            Cosecha cur= cS.insert(ta);
            CosechaDTO responseDTO=m.map(cur,CosechaDTO.class);
            return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cosechas no encontrado\nSolicitud de registro denegada");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Cosecha> cosecha = cS.listId(id);

        if (cosecha.isPresent()) {
            LoteGeneralDTO dto = m.map(cosecha.get(), LoteGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cosecha no encontrado");
        }


    }
    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Cosecha dto) {
        Optional<Cosecha> existente = cS.listId(dto.getIdCosecha());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cosecha no encontrada");
        }
        Cosecha p = existente.get();
        p.setIdCosecha(dto.getIdCosecha());
        p.setCantidad(dto.getCantidad());
        p.setEstadoCosecha(dto.getEstadoCosecha());
        p.setMetodos(dto.getMetodos());
        p.setFirmaElectronica(dto.getFirmaElectronica());
        p.setResponsable(dto.getResponsable());
        cS.update(p);

        return ResponseEntity.ok("Cosecha actualizada correctamente");
    }

}
