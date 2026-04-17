package pe.edu.upc.trabajo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.trabajo.entities.Actividad;


@Repository
public interface IActividadRepository extends JpaRepository<Actividad, Integer> {

}
