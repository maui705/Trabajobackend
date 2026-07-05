package com.example.trabajo2.servicesinterfaces;

import com.example.BD_CU.entities.TipoProcesamiento;
import java.util.List;
import java.util.Optional;

public interface ITipoProcesamientoService {
   public List<TipoProcesamiento> list();
   public TipoProcesamiento insert(TipoProcesamiento tp);
   public Optional<TipoProcesamiento> listId(int id);
   public void update(TipoProcesamiento tp);
   public void delete(int id);
}
