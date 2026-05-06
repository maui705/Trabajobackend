package com.example.BD_CU.servicesimplement;

import com.example.BD_CU.entities.AImagenes;
import com.example.BD_CU.repositories.IAImagenesRepository;
import com.example.BD_CU.servicesinterfaces.IAImagenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class AImagenesServiceImplement implements IAImagenesService {

    @Autowired
    private IAImagenesRepository aR;

    @Override
    public List<AImagenes> list() { return aR.findAll(); }
    @Override
    public AImagenes insert(AImagenes a) { return aR.save(a); }

    @Override
    public Optional<AImagenes> listId(int id) { return aR.findById(id); }

    @Override
    public void update(AImagenes a) { aR.save(a); }

    @Override
    public void delete(int id) { aR.deleteById(id); }

    @Override
    public List<AImagenes> buscarPorFormato(String formato) {
        return aR.findByFormato(formato);
    }

    @Override
    public List<AImagenes> buscarPorDefecto(String defecto) {
        return aR.buscarPorDefecto(defecto);
    }

    @Override
    public List<Object[]> cantidadImagenesPorLote() {
        return aR.cantidadImagenesPorLote();
    }
}
