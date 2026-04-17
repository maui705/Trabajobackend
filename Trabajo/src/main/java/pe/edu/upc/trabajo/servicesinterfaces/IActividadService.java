package pe.edu.upc.trabajo.servicesinterfaces;

import pe.edu.upc.trabajo.entities.Actividad;

import java.util.List;
import java.util.Optional;

public interface IActividadService {
public List<Actividad> list();
public Actividad insert(Actividad a);
public Optional<Actividad> listId(int id);
public void update(Actividad a);
public void delete(int id);

}
