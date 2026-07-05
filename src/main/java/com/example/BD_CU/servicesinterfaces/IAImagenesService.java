package com.example.BD_CU.servicesinterfaces;


import com.example.BD_CU.entities.AImagenes;
import java.util.List;
import java.util.Optional;

public interface IAImagenesService {
    public List<AImagenes> list();
    public AImagenes insert(AImagenes a);
    public Optional<AImagenes> listId(int id);
    public void update(AImagenes a);
    public void delete(int id);
    List<AImagenes> buscarPorFormato(String formato);
    List<AImagenes> buscarPorDefecto(String defecto);
    List<Object[]> cantidadImagenesPorLote();
}