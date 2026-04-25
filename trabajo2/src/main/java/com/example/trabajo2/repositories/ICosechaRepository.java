package com.example.trabajo2.repositories;

import com.example.trabajo2.entities.Cosecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICosechaRepository extends JpaRepository<Cosecha, Integer> {
}
