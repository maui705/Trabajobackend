package com.example.BD_CU.repositories;

import com.example.BD_CU.entities.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IActividadRepository extends JpaRepository<Actividad, Integer> {

    @Query (value = "SELECT \n" +
            "    l.variedad_cafe,  \n" +
            "    a.estado AS estado_actividad, \n" +
            "    a.responsable,  \n" +
            "    COUNT(l.lote_id) AS cantidad_total_lotes\n" +
            " FROM \n" +
            "    lote l\n" +
            " JOIN \n" +
            "    actividad a ON l.lote_id = a.lote_id\n" +
            " GROUP BY \n" +
            "    l.variedad_cafe, a.estado, a.responsable;  ", nativeQuery = true)
    List<Object[]>quantityActividad();

    @Query(value = " SELECT \n" +
            "    u.nombre, \n" +
            "    u.apellido, \n" +
            "    a.descripcion, \n" +
            "    a.estado AS estado_actividad, \n" +
            "    a.responsable, \n" +
            "    COUNT(a.actividadid)\n" +
            "FROM \n" +
            "    usuario u \n" +
            "JOIN \n" +
            "    actividad a ON u.usuario_id = a.usuario_id\n" +
            "GROUP BY \n" +
            "    u.nombre, u.apellido, a.descripcion, a.estado, a.responsable;", nativeQuery = true)
    List<Object[]> quantityActividad2();

}