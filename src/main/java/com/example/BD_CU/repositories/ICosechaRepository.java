package com.example.BD_CU.repositories;

import com.example.BD_CU.entities.Cosecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICosechaRepository extends JpaRepository<Cosecha,Integer> {

}
