package com.example.BD_CU.controllers;

import com.example.BD_CU.dtos.AImagenesDTO;
import com.example.BD_CU.dtos.ImagenesPorLoteDTO;
import com.example.BD_CU.dtos.QuantityLote;
import com.example.BD_CU.entities.AImagenes;
import com.example.BD_CU.entities.Lote;
import com.example.BD_CU.servicesinterfaces.IAImagenesService;
import com.example.BD_CU.servicesinterfaces.ILoteService;
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
@RequestMapping("/api/imagen")
public class AImagenesController {
    @Autowired
    private IAImagenesService iS;

    @Autowired
    private ILoteService loteService;

    @GetMapping("/listar-imagen")
   // @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<AImagenesDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<AImagenesDTO> listaImagenes = iS.list().stream()
                .map(y -> m.map(y, AImagenesDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaImagenes);
    }
    @PostMapping("/registrar-imagen")
  //  @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AImagenesDTO> registrar(@RequestBody AImagenesDTO dto){
        ModelMapper m = new ModelMapper();
        AImagenes c = m.map(dto, AImagenes.class);
        AImagenes cur = iS.insert(c);
        AImagenesDTO responseDTO = m.map(cur, AImagenesDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
   // @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<AImagenes> imagen = iS.listId(id);

        if (imagen.isPresent()) {
            AImagenesDTO dto = m.map(imagen.get(), AImagenesDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La imagen con ID " + id + " no existe.");
        }
    }
    @PutMapping("/actualizar-imagen")
  //  @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody AImagenesDTO dto) {
        Optional<AImagenes> existente = iS.listId(dto.getIdAImagenes());

        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se pudo actualizar: La imagen no fue encontrada.");
        }

        AImagenes i = existente.get();
        i.setFechaAnalisis(dto.getFechaAnalisis());
        i.setFormato(dto.getFormato());
        i.setDefectosEncontrados(dto.getDefectosEncontrados());
        i.setEstado(dto.isEstado());

        Optional<Lote> loteExistente = loteService.listId(dto.getLoteId());

        if (loteExistente.isPresent()) {
            i.setLote(loteExistente.get()); // Enlazamos el nuevo lote a la imagen
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No se pudo actualizar: El lote con ID " + dto.getLoteId() + " no existe.");
        }


        iS.update(i);
        return ResponseEntity.ok("Imagen actualizada correctamente");
    }
    @DeleteMapping("/{id}")
   // @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<AImagenes> imagen = iS.listId(id);

        if (imagen.isPresent()) {
            iS.delete(id);
            return ResponseEntity.ok("Imagen eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se pudo eliminar: La imagen con ID " + id + " no existe.");
        }
    }

    @GetMapping("/buscar-formato-imagen")
   // @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscarPorFormato(@RequestParam String formato) {
        List<AImagenes> listaOriginal = iS.buscarPorFormato(formato);
        if (listaOriginal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existen imágenes guardadas con el formato: " + formato);
        }
        ModelMapper m = new ModelMapper();
        List<AImagenesDTO> lista = iS.buscarPorFormato(formato).stream()
                .map(y -> m.map(y, AImagenesDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    // (HU01)
    @GetMapping("/buscar-defecto-imagen")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscarPorDefecto(@RequestParam String defecto) {
        List<AImagenes> listaOriginal = iS.buscarPorDefecto(defecto);

        if (listaOriginal.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Excelente noticia: No se detectaron imágenes con el defecto '" + defecto + "'.");
        }
        ModelMapper m = new ModelMapper();
        List<AImagenesDTO> lista = iS.buscarPorDefecto(defecto).stream()
                .map(y -> m.map(y, AImagenesDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    // 4. Endpoint del Query Nativo (Reporte Estructurado)
    @GetMapping("/cantidad-por-lote")
   // @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> cantidadImagenesPorLote() {
        List<Object[]> resultadosRaw = iS.cantidadImagenesPorLote();
        if (resultadosRaw.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Aún no hay registros suficientes para mostrar estadísticas de los lotes.");
        }
        List<ImagenesPorLoteDTO> listaCantidad=new ArrayList<>();
        for(Object[] fila:resultadosRaw){
            ImagenesPorLoteDTO dto = new ImagenesPorLoteDTO();
            dto.setLoteId(((Number) fila[0]).intValue());
            dto.setCantidadImagenes(((Number) fila[1]).intValue());
            listaCantidad.add(dto);
        }
        return ResponseEntity.ok(listaCantidad);
    }

}
