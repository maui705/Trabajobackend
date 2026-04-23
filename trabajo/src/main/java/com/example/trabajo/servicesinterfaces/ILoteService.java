package com.example.trabajo.servicesinterfaces;

import com.example.trabajo.entities.Lote;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ILoteService {
    public List<Lote> list();
    public Lote insert(Lote l);
    public Optional<Lote> listId(int id);
    public void update(Lote l);
    public void delete(int id);

}
