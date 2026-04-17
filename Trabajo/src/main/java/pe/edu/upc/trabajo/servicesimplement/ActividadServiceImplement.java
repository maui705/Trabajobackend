package pe.edu.upc.trabajo.servicesimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.trabajo.entities.Actividad;
import pe.edu.upc.trabajo.repositories.IActividadRepository;
import pe.edu.upc.trabajo.servicesinterfaces.IActividadService;

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
    public void update(Actividad a) {
        lR.save(a);

    }

    @Override
    public void delete(int id) {
        lR.deleteById(id);

    }
}
