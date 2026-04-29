package com.example.trabajo2.repositories;


import com.example.trabajo2.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

}