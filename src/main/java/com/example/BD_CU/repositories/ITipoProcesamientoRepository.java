package com.example.BD_CU.repositories;

import com.example.BD_CU.entities.AImagenes;
import com.example.BD_CU.entities.TipoProcesamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoProcesamientoRepository extends JpaRepository<TipoProcesamiento, Integer> {

    List<TipoProcesamiento> findByNombre(String nombre);
}