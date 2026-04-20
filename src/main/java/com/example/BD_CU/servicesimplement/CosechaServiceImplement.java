package com.example.BD_CU.servicesimplement;

import com.example.BD_CU.entities.Cosecha;
import com.example.BD_CU.repositories.ICosechaRepository;
import com.example.BD_CU.servicesinterfaces.ICosechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CosechaServiceImplement implements ICosechaService {
    @Autowired
    private ICosechaRepository lR;

    @Override
    public List<Cosecha> list() {
        return  lR.findAll();
    }

    @Override
    public Cosecha insert(Cosecha l) {
        return  lR.save(l);
    }

    @Override
    public Optional<Cosecha> listId(int id) {
        return lR.findById(id);
    }

    @Override
    public void update(Cosecha l) {
        lR.save(l);
    }

    @Override
    public void delete(int id) {
        lR.deleteById(id);
    }


}
