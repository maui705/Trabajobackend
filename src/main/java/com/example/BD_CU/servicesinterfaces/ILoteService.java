package com.example.BD_CU.servicesinterfaces;

import com.example.BD_CU.entities.Lote;

import java.util.List;
import java.util.Optional;

public interface ILoteService {
    public List<Lote> list();
    public Lote insert(Lote p);
    public Optional<Lote> listId(int id);
    public void update(Lote p);
    public void delete(int id);
    List<Object[]> quantityLote();
}
