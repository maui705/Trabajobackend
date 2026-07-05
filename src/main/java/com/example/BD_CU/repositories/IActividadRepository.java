package com.example.BD_CU.repositories;

import com.example.BD_CU.entities.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IActividadRepository extends JpaRepository<Actividad, Integer> {

    @Query(value = "SELECT " +
            "l.lote_id, " +
            "l.variedad_cafe, " +
            "COUNT(a.actividadid) " +
            "FROM lote l " +
            "JOIN actividad a ON l.lote_id = a.lote_id " +
            "GROUP BY l.lote_id, l.variedad_cafe " +
            "ORDER BY COUNT(a.actividadid) DESC",
            nativeQuery = true)
    List<Object[]> quantityActividad();

    @Query(value = "SELECT " +
            "u.username, " +
            "u.apellido, " +
            "COUNT(a.actividadid) " +
            "FROM usuario u " +
            "JOIN actividad a ON u.usuario_id = a.usuario_id " +
            "WHERE a.estado = 'Terminado' " +
            "GROUP BY u.usuario_id, u.username, u.apellido " +
            "ORDER BY COUNT(a.actividadid) DESC",
            nativeQuery = true)
    List<Object[]> quantityActividad2();
}