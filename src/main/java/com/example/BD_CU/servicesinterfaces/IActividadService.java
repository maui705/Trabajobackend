package com.example.BD_CU.servicesinterfaces;

import com.example.BD_CU.entities.Actividad;

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