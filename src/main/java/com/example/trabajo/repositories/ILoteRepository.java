package com.example.trabajo.repositories;

import com.example.trabajo.entities.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoteRepository extends JpaRepository<Lote, Integer> {
}