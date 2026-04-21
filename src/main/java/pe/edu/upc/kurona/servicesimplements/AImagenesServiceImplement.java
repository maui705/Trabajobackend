package pe.edu.upc.kurona.servicesimplements;

import pe.edu.upc.kurona.Entities.AImagenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.kurona.repositories.IAImagenesRepository;
import pe.edu.upc.kurona.servicesinterfaces.IAImagenesService;

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
}
