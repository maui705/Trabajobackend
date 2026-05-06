package com.example.BD_CU.controllers;

import com.example.BD_CU.dtos.CosechaDTO;
import com.example.BD_CU.dtos.LoteGeneralDTO;
import com.example.BD_CU.dtos.QuantityCosecha;
import com.example.BD_CU.entities.Cosecha;
import com.example.BD_CU.servicesinterfaces.ICosechaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cosechas")
public class CosechaController {
    @Autowired
    private ICosechaService cS;

    @GetMapping("/listar-cosecha")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar(){
        ModelMapper m = new ModelMapper();
        List<CosechaDTO> listaCosechas = cS.list()
                .stream().map(y->m.map(y, CosechaDTO.class))
                .collect(Collectors.toList());
        if(listaCosechas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay cosecha registrada");
        }
        else{
            return  ResponseEntity.ok(listaCosechas);
        }
    }

    @PostMapping("/registrar-cosecha")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<CosechaDTO> registrar(@RequestBody CosechaDTO dto){
        ModelMapper m=new ModelMapper();
        Cosecha c=m.map(dto, Cosecha.class);
        Cosecha cur= cS.insert(c);
        CosechaDTO responseDTO=m.map(cur,CosechaDTO.class);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Cosecha> cosecha = cS.listId(id);

        if (cosecha.isPresent()) {
            CosechaDTO dto = m.map(cosecha.get(), CosechaDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cosecha no encontrado");
        }


    }
    @PutMapping("/actualizar-cosecha")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody CosechaDTO dto) {
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
    @PostMapping("/cantidad-lote-cosecha")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?>CantidadCosecha(){
        List<Object[]> listaCantidad=cS.quantityCosecha();
        if(listaCantidad.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay cosechas asignadas");
        }
        List<QuantityCosecha> respuesta=new ArrayList<>();
        for(Object[] fila:listaCantidad){
            QuantityCosecha dto=new QuantityCosecha();
            dto.setIdCosecha(((Number)fila[0]).intValue());
            dto.setUbicacion((String) fila[1]);
            dto.setQuantityCosecha(((Number)fila[2]).intValue());
            respuesta.add(dto);
        }
        return  ResponseEntity.ok(respuesta);
    }
}
