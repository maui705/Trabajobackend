package com.example.trabajo.servicesimplement;

import com.example.trabajo.entities.TipoProcesamiento;
import com.example.trabajo.repositories.ILoteRepository;
import com.example.trabajo.repositories.ITipoProcesamientoRepository;
import com.example.trabajo.servicesinterfaces.ITipoProcesamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoProcesamientoServiceImplement implements ITipoProcesamientoService {
    @Autowired
    private ITipoProcesamientoRepository Tr;

    @Override
    public List<TipoProcesamiento> list() {
        return Tr.findAll();
    }

    @Override
    public TipoProcesamiento insert(TipoProcesamiento tp) {
        return Tr.save(tp);
    }

    @Override
    public Optional<TipoProcesamiento> listId(int id) {
        return Tr.findById(id);
    }

    @Override
    public void update(TipoProcesamiento tp) {
        Tr.save(tp);
    }

    @Override
    public void delete(int id) {
        Tr.deleteById(id);
    }
}
