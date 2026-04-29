package com.example.trabajo2.servicesinterfaces;

import com.example.trabajo2.entities.TipoProcesamiento;
import java.util.List;
import java.util.Optional;

public interface ITipoProcesamientoService {
    List<TipoProcesamiento> list();
    TipoProcesamiento insert(TipoProcesamiento tp);
    Optional<TipoProcesamiento> listId(int id);
    void update(TipoProcesamiento tp);
    void delete(int id);
}
