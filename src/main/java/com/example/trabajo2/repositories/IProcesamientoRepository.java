package com.example.trabajo2.repositories;

import com.example.trabajo2.entities.Procesamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProcesamientoRepository extends JpaRepository<Procesamiento, Integer> {

}