package com.example.BD_CU.servicesimplement;

import com.example.BD_CU.entities.Usuario;
import com.example.BD_CU.repositories.IUsuarioRepository;
import com.example.BD_CU.servicesinterfaces.IUsuarioService;
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
    public Usuario insert(Usuario tp) {
        return Tr.save(tp);
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
