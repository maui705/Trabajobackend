package com.example.trabajo2.servicesinterfaces;

import com.example.trabajo2.entities.Cosecha;
import java.util.List;
import java.util.Optional;

public interface ICosechaService {
    List<Cosecha> list();
    Cosecha insert(Cosecha c);
    Optional<Cosecha> listId(int id);
    void update(Cosecha c);
    void delete(int id);
}