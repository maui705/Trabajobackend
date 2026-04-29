package pe.edu.upc.kurona.controllers;

import pe.edu.upc.kurona.Entities.AImagenes;
import pe.edu.upc.kurona.dtos.AImagenesDTO;
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
    public ResponseEntity<AImagenesDTO> registrar(@RequestBody AImagenesDTO dto){
        ModelMapper m = new ModelMapper();
        AImagenes c = m.map(dto, AImagenes.class);
        AImagenes cur = iS.insert(c);
        AImagenesDTO responseDTO = m.map(cur, AImagenesDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<AImagenes> imagen = iS.listId(id);

        if (imagen.isPresent()) {
            AImagenesDTO dto = m.map(imagen.get(), AImagenesDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Imagen no encontrada");
        }
    }
    @PutMapping("/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody AImagenesDTO dto) {
        Optional<AImagenes> existente = iS.listId(dto.getIdAImagenes());

        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Imagen no encontrada");
        }

        AImagenes i = existente.get();
        i.setFechaAnalisis(dto.getFechaAnalisis());
        i.setFormato(dto.getFormato());
        i.setDefectosEncontrados(dto.getDefectosEncontrados());
        i.setEstado(dto.isEstado());
        i.setLote(dto.getLote());

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

    @GetMapping("/buscar-formato")
    public ResponseEntity<List<AImagenesDTO>> buscarPorFormato(@RequestParam String formato) {
        ModelMapper m = new ModelMapper();
        List<AImagenesDTO> lista = iS.buscarPorFormato(formato).stream()
                .map(y -> m.map(y, AImagenesDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    // (HU01)
    @GetMapping("/buscar-defecto")
    public ResponseEntity<List<AImagenesDTO>> buscarPorDefecto(@RequestParam String defecto) {
        ModelMapper m = new ModelMapper();
        List<AImagenesDTO> lista = iS.buscarPorDefecto(defecto).stream()
                .map(y -> m.map(y, AImagenesDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    // (HU02)
    @GetMapping("/buscar-lote/{idLote}")
    public ResponseEntity<List<AImagenesDTO>> buscarPorLote(@PathVariable int idLote) {
        ModelMapper m = new ModelMapper();
        List<AImagenesDTO> lista = iS.buscarPorLote(idLote).stream()
                .map(y -> m.map(y, AImagenesDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/cantidad-por-lote")
    public ResponseEntity<List<Object[]>> cantidadImagenesPorLote() {
        List<Object[]> lista = iS.cantidadImagenesPorLote();
        return ResponseEntity.ok(lista);
    }

}
