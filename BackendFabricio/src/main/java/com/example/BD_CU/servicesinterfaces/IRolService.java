package com.example.BD_CU.servicesinterfaces;

import com.example.BD_CU.entities.Rol;
import java.util.List;
import java.util.Optional;

public interface IRolService {
    public List<Rol> list();
    public Rol insert(Rol r);
    public Optional<Rol> listId(int id);
    public void update(Rol r);
    public void delete(int id);
}