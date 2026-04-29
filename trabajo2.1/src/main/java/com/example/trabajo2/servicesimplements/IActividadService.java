package com.example.trabajo2.servicesimplements;

import com.example.trabajo2.entities.Actividad;

import java.util.List;
import java.util.Optional;

public interface IActividadService {
    public List<Actividad> list();
    public Actividad insert(Actividad a);
    public Optional<Actividad> listId(int id);
    public void update(Actividad a);
    public void delete(int id);
    List<Object[]>quantityActividad();
    List<Object[]> quantityActividad2();

}