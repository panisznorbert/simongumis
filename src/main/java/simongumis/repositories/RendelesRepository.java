package simongumis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simongumis.entities.RendelesEntity;
import simongumis.entities.RendelesStatusz;

import java.util.List;

public interface RendelesRepository extends JpaRepository<RendelesEntity, Integer> {
    List<RendelesEntity> findAllByUgyfel_Nev (String nev);

    RendelesEntity findBySession(String session);

    List<RendelesEntity> findAllByStatuszIsNot(RendelesStatusz statusz);

}
