package com.example.trabajo.servicesinterfaces;

import com.example.trabajo.entities.Lote;
import com.example.trabajo.entities.TipoProcesamiento;

import java.util.List;
import java.util.Optional;

public interface ITipoProcesamientoService {
    public List<TipoProcesamiento> list();
    public TipoProcesamiento insert(TipoProcesamiento tp);
    public Optional<TipoProcesamiento> listId(int id);
    public void update(TipoProcesamiento tp);
    public void delete(int id);
}
