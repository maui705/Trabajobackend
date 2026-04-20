package com.example.BD_CU.servicesinterfaces;

import com.example.BD_CU.entities.Cosecha;

import java.util.List;
import java.util.Optional;

public interface ICosechaService {
    public List<Cosecha> list();
    public Cosecha insert(Cosecha l);
    public Optional<Cosecha> listId(int id);
    public void update(Cosecha l);
    public void delete(int id);

}
