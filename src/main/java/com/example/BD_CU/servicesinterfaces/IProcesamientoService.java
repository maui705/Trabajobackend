package com.example.BD_CU.servicesinterfaces;

import com.example.BD_CU.entities.Procesamiento;
import java.util.List;
import java.util.Optional;

public interface IProcesamientoService {
    public List<Procesamiento> list();
    public Procesamiento insert(Procesamiento p);
    public Optional<Procesamiento> listId(int id);
    public void update(Procesamiento p);
    public void delete(int id);
    List<Object[]> quantityProcexCoseNative();
}