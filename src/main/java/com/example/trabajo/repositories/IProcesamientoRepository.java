package com.example.trabajo.repositories;

import com.example.trabajo.entities.Procesamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProcesamientoRepository extends JpaRepository<Procesamiento, Integer> {
}