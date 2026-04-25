package com.example.trabajo2.repositories;

import com.example.trabajo2.entities.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoteRepository extends JpaRepository<Lote, Integer> {
}
