package com.example.BD_CU.repositories;

import com.example.BD_CU.entities.Cosecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICosechaRepository extends JpaRepository<Cosecha, Integer> {

    @Query(value = "SELECT c.estado_Cosecha, Count(c.id_Cosecha) \n" +
            "FROM Cosecha c\n" +
            "GROUP BY c.estado_Cosecha;", nativeQuery = true)
            List<Object[]>quantityCosecha();
}
