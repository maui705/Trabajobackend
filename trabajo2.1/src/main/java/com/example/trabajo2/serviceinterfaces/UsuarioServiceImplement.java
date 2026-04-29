package com.example.trabajo2.serviceinterfaces;

import com.example.trabajo2.entities.Usuario;
import com.example.trabajo2.repositories.IUsuarioRepository;
import com.example.trabajo2.servicesimplements.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository Tr;

    @Override
    public List<Usuario> list() {
        return Tr.findAll();
    }

    @Override
    public Usuario insert(Usuario Us) {
        return Tr.save(Us);
    }

    @Override
    public Optional<Usuario> listId(int id) {
        return Tr.findById(id);
    }

    @Override
    public void update(Usuario tp) {
        Tr.save(tp);
    }

    @Override
    public void delete(int id) {
        Tr.deleteById(id);
    }




}
