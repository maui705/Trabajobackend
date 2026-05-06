package com.example.BD_CU.servicesimplement;

import com.example.BD_CU.entities.Lote;
import com.example.BD_CU.repositories.ILoteRepository;

import com.example.BD_CU.servicesinterfaces.ILoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoteServiceImplement implements ILoteService {
    @Autowired
    private ILoteRepository lR;

    @Override
    public List<Lote> list() {
        return lR.findAll();
    }

    @Override
    public Lote insert(Lote p) {
        return lR.save(p);
    }

    @Override
    public Optional<Lote> listId(int id) {
        return lR.findById(id);
    }

    @Override
    public void update(Lote p) {
    lR.save(p);
    }

    @Override
    public void delete(int id) {
        lR.deleteById(id);
    }

    @Override
    public List<Object[]> quantityLote() {
        return lR.quantityLote();
    }


}
