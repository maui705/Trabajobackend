package com.example.trabajo2.servicesinterfaces;

import com.example.trabajo2.entities.Procesamiento;
import java.util.List;
import java.util.Optional;

public interface IProcesamientoService {
    List<Procesamiento> list();
    Procesamiento insert(Procesamiento p);
    Optional<Procesamiento> listId(int id);
    void update(Procesamiento p);
    void delete(int id);
    List<Procesamiento> findByEstado(String estado);
}