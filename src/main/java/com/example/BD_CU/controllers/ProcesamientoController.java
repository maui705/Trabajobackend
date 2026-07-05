package com.example.BD_CU.controllers;

import com.example.BD_CU.dtos.ImagenesPorLoteDTO;
import com.example.BD_CU.dtos.ProcesamientoDTO;
import com.example.BD_CU.dtos.QueryProcesxCosechaDTO;
import com.example.BD_CU.dtos.UsuarioDTO;
import com.example.BD_CU.entities.*;
import com.example.BD_CU.servicesinterfaces.ICosechaService;
import com.example.BD_CU.servicesinterfaces.IProcesamientoService;
import com.example.BD_CU.servicesinterfaces.ITipoProcesamientoService;
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
@RequestMapping("/api/procesamiento")
public class ProcesamientoController {

    @Autowired
    private IProcesamientoService Ps;

    @Autowired
    private ICosechaService cS;

    @Autowired
    private ITipoProcesamientoService Ts;

    @GetMapping("/listar-procesamiento")
   // @PreAuthorize("hasAuthority('SUP')")
    public ResponseEntity<?>listar(){
        ModelMapper m = new ModelMapper();
        List<ProcesamientoDTO>listaTareas = Ps.list()
                .stream().map(y->m.map(y, ProcesamientoDTO.class))
                .collect(Collectors.toList());
        if(listaTareas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay procesamientos registrados");
        }
        else{
            return  ResponseEntity.ok(listaTareas);
        }
    }

    @PostMapping("/registrar-procesamiento")
  //  @PreAuthorize("hasAuthority('SUP')")
    public ResponseEntity<?> registrar(@RequestBody ProcesamientoDTO dto) {
        ModelMapper m=new ModelMapper();
        Optional<TipoProcesamiento> tipo = Ts.listId(dto.getTipoId());
        Optional<Cosecha> cosecha = cS.listId(dto.getIdCosecha());

        if (tipo.isPresent() && cosecha.isPresent()) {
            Procesamiento pr=m.map(dto, Procesamiento.class);
            Procesamiento cur= Ps.insert(pr);
            ProcesamientoDTO responseDTO=m.map(cur,ProcesamientoDTO.class);
            return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tipo-Procesamiento o Cosecha no encontrados\nSolicitud de registro denegada");
        }


    }

    @GetMapping("/{id}")
  //  @PreAuthorize("hasAuthority('SUP')")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Procesamiento> proc = Ps.listId(id);
        if (proc.isPresent()) {
            ProcesamientoDTO dto = m.map(proc.get(), ProcesamientoDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Procesamiento no encontrado");
        }
    }


    @PutMapping("/actualizar-procesamiento")
   // @PreAuthorize("hasAuthority('SUP')")
    public ResponseEntity<String> actualizar(@RequestBody ProcesamientoDTO dto) {
        Optional<Procesamiento> existente = Ps.listId(dto.getProcesamientoId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Procesamiento no encontrado");
        }
        Procesamiento p = existente.get();
        p.setProcesamientoId(dto.getProcesamientoId());
        p.setFechaInicio(dto.getFechaInicio());
        p.setFechaFin(dto.getFechaFin());
        p.setCantidad(dto.getCantidad());
        p.setEstado(dto.getEstado());
        Ps.update(p);
        return ResponseEntity.ok("Procesamiento actualizado correctamente");
    }

    @DeleteMapping("/{id}")
  //  @PreAuthorize("hasAuthority('SUP')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Procesamiento> proc = Ps.listId(id);
        if (proc.isPresent()) {
            Ps.delete(id);
            return ResponseEntity.ok("Procesamiento eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Procesamiento no encontrado");
        }
    }

    @GetMapping("/cantidad-proces-cosecha")
   // @PreAuthorize("hasAuthority('SUP')")
    public ResponseEntity<?> cantidadProcescosecha() {
        List<Object[]> resultados = Ps.quantityProcexCoseNative();
        if (resultados.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Aún no hay registros suficientes para mostrar estadísticas de las cosechas.");
        }
        List<QueryProcesxCosechaDTO> listaCantidad=new ArrayList<>();
        for(Object[] fila:resultados){
            QueryProcesxCosechaDTO dto = new QueryProcesxCosechaDTO();
            dto.setIdCosecha(((Number) fila[0]).intValue());
            dto.setCantidad(((Number) fila[1]).intValue());
            dto.setQuantity(((Number) fila[2]).intValue());
            listaCantidad.add(dto);
        }
        return ResponseEntity.ok(listaCantidad);
    }


}