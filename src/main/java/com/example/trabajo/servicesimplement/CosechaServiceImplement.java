package com.example.trabajo.servicesimplement;

import com.example.trabajo.entities.Cosecha;
import com.example.trabajo.repositories.ICosechaRepository;
import com.example.trabajo.servicesinterfaces.ICosechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CosechaServiceImplement implements ICosechaService {

    @Autowired
    private ICosechaRepository cR;

    @Override
    public List<Cosecha> list() { return cR.findAll(); }
    @Override
    public Cosecha insert(Cosecha c) { return cR.save(c); }
    @Override
    public Optional<Cosecha> listId(int id) { return cR.findById(id); }
    @Override
    public void update(Cosecha c) { cR.save(c); }
    @Override
    public void delete(int id) { cR.deleteById(id); }
}