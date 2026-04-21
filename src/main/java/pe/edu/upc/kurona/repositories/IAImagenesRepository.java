package pe.edu.upc.kurona.repositories;

import pe.edu.upc.kurona.Entities.AImagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAImagenesRepository extends JpaRepository<AImagenes,Integer> {
}
