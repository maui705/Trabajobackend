package com.example.trabajo.servicesinterfaces;

import com.example.trabajo.entities.Rol;
import java.util.List;
import java.util.Optional;

public interface IRolService {
    List<Rol> list();
    Rol insert(Rol r);
    Optional<Rol> listId(int id);
    void update(Rol r);
    void delete(int id);
}