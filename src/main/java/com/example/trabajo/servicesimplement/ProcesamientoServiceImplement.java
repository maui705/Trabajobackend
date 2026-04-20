package com.example.trabajo.servicesimplement;

import com.example.trabajo.entities.Procesamiento;
import com.example.trabajo.repositories.IProcesamientoRepository;
import com.example.trabajo.servicesinterfaces.IProcesamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcesamientoServiceImplement implements IProcesamientoService {

    @Autowired
    private IProcesamientoRepository pR;

    @Override
    public List<Procesamiento> list() { return pR.findAll(); }

    @Override
    public Procesamiento insert(Procesamiento p) { return pR.save(p); }

    @Override
    public Optional<Procesamiento> listId(int id) { return pR.findById(id); }

    @Override
    public void update(Procesamiento p) { pR.save(p); }

    @Override
    public void delete(int id) { pR.deleteById(id); }
}