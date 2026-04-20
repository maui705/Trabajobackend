package com.example.BD_CU.servicesinterfaces;

import com.example.BD_CU.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<Usuario> list();
    public Usuario insert(Usuario tp);
    public Optional<Usuario> listId(int id);
    public void update(Usuario tp);
    public void delete(int id);
}
