package com.example.BD_CU.repositories;

import com.example.BD_CU.entities.Cosecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICosechaRepository extends JpaRepository<Cosecha, Integer> {

    @Query(value = "SELECT \n" +
            "    l.lote_id,\n" +
            "    l.ubicacion,\n" +
            "    SUM(c.cantidad) AS total_cosechado\n" +
            "FROM lote l\n" +
            "INNER JOIN cosecha c \n" +
            "    ON l.lote_id = c.lote_id\n" +
            "GROUP BY \n" +
            "    l.lote_id, l.ubicacion;", nativeQuery = true)
            List<Object[]>quantityCosecha();
}
