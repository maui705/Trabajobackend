package pe.edu.upc.kurona.controllers;

import pe.edu.upc.kurona.Entities.AImagenes;
import pe.edu.upc.kurona.dtos.AImagenesDTO;
import pe.edu.upc.kurona.dtos.AImagenesGeneralDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.kurona.servicesinterfaces.IAImagenesService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/imagenes")
public class AImagenesController {
    @Autowired
    private IAImagenesService iS;

    @GetMapping("/list")
    public ResponseEntity<List<AImagenesDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<AImagenesDTO> listaImagenes = iS.list().stream()
                .map(y -> m.map(y, AImagenesDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaImagenes);
    }
    @PostMapping("/web")
    public ResponseEntity<AImagenesGeneralDTO> registrar(@RequestBody AImagenesGeneralDTO dto){
        ModelMapper m = new ModelMapper();
        AImagenes c = m.map(dto, AImagenes.class);
        AImagenes cur = iS.insert(c);
        AImagenesGeneralDTO responseDTO = m.map(cur, AImagenesGeneralDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<AImagenes> imagen = iS.listId(id);

        if (imagen.isPresent()) {
            AImagenesGeneralDTO dto = m.map(imagen.get(), AImagenesGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Imagen no encontrada");
        }
    }
    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody AImagenesGeneralDTO dto) {
        Optional<AImagenes> existente = iS.listId(dto.getIdImagen());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Imagen no encontrada");
        }
        if (dto.getFechaSubida() == null) {
            return ResponseEntity.badRequest()
                    .body("La fecha de subida no puede ser nula");
        }

        AImagenes i = existente.get();
        i.setNombreImagen(dto.getNombreImagen());
        i.setUrlImagen(dto.getUrlImagen());
        i.setFechaSubida(dto.getFechaSubida());
        i.setAnalisisIA(dto.getAnalisisIA());
        i.setEstadoProcesamiento(dto.isEstadoProcesamiento());

        iS.update(i);

        return ResponseEntity.ok("Imagen actualizada correctamente");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<AImagenes> imagen = iS.listId(id);

        if (imagen.isPresent()) {
            iS.delete(id);
            return ResponseEntity.ok("Imagen eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Imagen no encontrada");
        }
    }
}
