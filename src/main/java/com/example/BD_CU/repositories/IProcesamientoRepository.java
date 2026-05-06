package com.example.BD_CU.repositories;

import com.example.BD_CU.entities.AImagenes;
import com.example.BD_CU.entities.Procesamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProcesamientoRepository extends JpaRepository<Procesamiento, Integer> {

    @Query(value = "SELECT c.id_Cosecha, c.cantidad, COUNT(p.procesamiento_Id)\n" +
            "FROM cosecha c\n" +
            "INNER JOIN procesamiento p\n" +
            "ON  c.id_Cosecha = c.id_Cosecha\n" +
            "GROUP BY c.id_Cosecha", nativeQuery = true)
    List<Object[]> quantityProcexCoseNative();
}