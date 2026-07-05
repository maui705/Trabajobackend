package com.example.BD_CU.repositories;

import com.example.BD_CU.entities.AImagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAImagenesRepository extends JpaRepository<AImagenes,Integer> {

    List<AImagenes> findByFormato(String formato);

    @Query("SELECT a FROM AImagenes a WHERE a.defectosEncontrados LIKE %:defecto%")
    List<AImagenes> buscarPorDefecto(@Param("defecto") String defecto);

    @Query(value = "SELECT l.lote_Id, COUNT(a.idaimagenes)\n" +
            "FROM lote l\n" +
            "INNER JOIN aimagenes a\n" +
            "ON l.lote_Id = a.lote_Id\n" +
            "GROUP BY l.lote_Id", nativeQuery = true)
    List<Object[]> cantidadImagenesPorLote();

    @Query("SELECT a FROM AImagenes a JOIN FETCH a.lote")
    List<AImagenes> findAllWithLote();
}
