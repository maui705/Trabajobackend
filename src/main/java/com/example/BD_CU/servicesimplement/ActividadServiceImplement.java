package com.example.BD_CU.servicesimplement;
import com.example.BD_CU.entities.Actividad;
import com.example.BD_CU.repositories.IActividadRepository;
import com.example.BD_CU.servicesinterfaces.IActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadServiceImplement implements IActividadService {
    @Autowired
    private IActividadRepository lR;

    @Override
    public List<Actividad> list() {
        return lR.findAll();
    }

    @Override
    public Actividad insert(Actividad a) {
        return lR.save(a);
    }

    @Override
    public Optional<Actividad> listId(int id) {
        return lR.findById(id);
    }

    @Override
    public void update(Actividad a) {lR.save(a);}

    @Override
    public void delete(int id) {lR.deleteById(id);}

    @Override
    public List<Object[]> quantityActividad() {
        return lR.quantityActividad();
    }

    @Override
    public List<Object[]> quantityActividad2() {
        return lR.quantityActividad2();
    }
}
