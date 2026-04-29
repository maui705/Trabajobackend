package com.example.trabajo2.servicesimplements;

import com.example.trabajo2.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<Usuario> list();
    public Optional<Usuario> listId(int id);
    public Usuario insert(Usuario Us);
    public void update(Usuario tp);
    public void delete(int id);

}