package com.example.BD_CU.repositories;

import com.example.BD_CU.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
}
