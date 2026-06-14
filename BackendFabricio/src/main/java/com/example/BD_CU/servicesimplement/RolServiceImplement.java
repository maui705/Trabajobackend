package com.example.BD_CU.servicesimplement;

import com.example.BD_CU.entities.Rol;
import com.example.BD_CU.repositories.IRolRepository;
import com.example.BD_CU.servicesinterfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private IRolRepository rR;

    @Override
    public List<Rol> list() { return rR.findAll(); }

    @Override
    public Rol insert(Rol r) { return rR.save(r); }

    @Override
    public Optional<Rol> listId(int id) { return rR.findById(id); }

    @Override
    public void update(Rol r) { rR.save(r); }

    @Override
    public void delete(int id) { rR.deleteById(id); }

}