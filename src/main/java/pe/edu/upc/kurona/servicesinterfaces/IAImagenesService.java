package pe.edu.upc.kurona.servicesinterfaces;

import pe.edu.upc.kurona.Entities.AImagenes;
import java.util.List;
import java.util.Optional;

public interface IAImagenesService {
    public List<AImagenes> list();
    public AImagenes insert(AImagenes a);
    public Optional<AImagenes> listId(int id);
    public void update(AImagenes a);
    public void delete(int id);
}