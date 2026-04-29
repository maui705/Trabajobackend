package com.example.trabajo2.servicesinterfaces;

import com.example.trabajo2.entities.Lote;
import java.util.List;
import java.util.Optional;

public interface ILoteService {
    List<Lote> list();
    Lote insert(Lote l);
    Optional<Lote> listId(int id);
    void update(Lote l);
    void delete(int id);
}