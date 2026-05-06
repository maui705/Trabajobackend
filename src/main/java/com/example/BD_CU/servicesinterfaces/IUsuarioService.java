package com.example.BD_CU.servicesinterfaces;

import com.example.BD_CU.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<Usuario> list();
    public Optional<Usuario> listId(int id);
    public Usuario insert(Usuario Us);
    public void update(Usuario tp);
    public void delete(int id);
    List<Object[]> quantityUsuariosxRolNative();
    List<Object[]> buscarPagoUsuariosNative();
}
