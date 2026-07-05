package com.example.trabajo2.repositories;

import com.example.BD_CU.entities.Procesamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProcesamientoRepository extends JpaRepository<Procesamiento, Integer> {

}