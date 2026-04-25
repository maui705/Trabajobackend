package com.example.trabajo.servicesimplement;

import com.example.trabajo.entities.Lote;
import com.example.trabajo.repositories.ILoteRepository;
import com.example.trabajo.servicesinterfaces.ILoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoteServiceImplement implements ILoteService {

    @Autowired
    private ILoteRepository lR;

    @Override
    public List<Lote> list() { return lR.findAll(); }
    @Override
    public Lote insert(Lote l) { return lR.save(l); }
    @Override
    public Optional<Lote> listId(int id) { return lR.findById(id); }
    @Override
    public void update(Lote l) { lR.save(l); }
    @Override
    public void delete(int id) { lR.deleteById(id); }
}