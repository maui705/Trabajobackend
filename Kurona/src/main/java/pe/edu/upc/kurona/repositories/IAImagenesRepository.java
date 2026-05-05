package pe.edu.upc.kurona.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.kurona.Entities.AImagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAImagenesRepository extends JpaRepository<AImagenes,Integer> {
    List<AImagenes> findByFormatoIgnoreCase(String formato);

    // Nuevo Reporte: Cantidad de defectos agrupados por lote
    @Query(value = "SELECT l.ubicacion, a.defectos_encontrados, COUNT(a.idaimagenes)\n" +
            "FROM lote l \n" +
            "JOIN aimagenes a \n" +
            "ON l.lote_id = a.lote_id \n" +
            "GROUP BY l.ubicacion, a.defectos_encontrados", nativeQuery = true)
    List<Object[]> quantityDefectosPorLote();

    @Query("SELECT a FROM AImagenes a WHERE a.lote.loteId = :idLote")
    List<AImagenes> buscarPorLote(@Param("idLote") int idLote);

    @Query(value = "SELECT l.lote_Id, COUNT(a.idaimagenes)\n" +
            "FROM lote l\n" +
            "INNER JOIN aimagenes a\n" +
            "ON l.lote_Id = a.lote_Id\n" +
            "GROUP BY l.lote_Id", nativeQuery = true)
    List<Object[]> cantidadImagenesPorLote();
}
