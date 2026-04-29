package pe.edu.upc.kurona.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.kurona.Entities.AImagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAImagenesRepository extends JpaRepository<AImagenes,Integer> {
    List<AImagenes> findByFormato(String formato);

    @Query("SELECT a FROM AImagenes a WHERE a.defectosEncontrados LIKE %:defecto%")
    List<AImagenes> buscarPorDefecto(@Param("defecto") String defecto);

    @Query("SELECT a FROM AImagenes a WHERE a.lote.idLote = :idLote")
    List<AImagenes> buscarPorLote(@Param("idLote") int idLote);

    @Query(value = "SELECT l.Lote_id, COUNT(a.AImagenes_id) \n" +
            "FROM Lote l \n" +
            "INNER JOIN A_Imagenes a \n" +
            "ON l.Lote_id = a.Lote_id \n" +
            "GROUP BY l.Lote_id", nativeQuery = true)
    List<Object[]> cantidadImagenesPorLote();
}
