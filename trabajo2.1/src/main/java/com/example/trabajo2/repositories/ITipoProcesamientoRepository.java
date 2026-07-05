package com.example.trabajo2.repositories;

import com.example.BD_CU.entities.TipoProcesamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoProcesamientoRepository extends JpaRepository<TipoProcesamiento, Integer> {
}