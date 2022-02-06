package simongumis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simongumis.entities.UgyfelEntity;


@Repository
public interface UgyfelRepository extends JpaRepository<UgyfelEntity, Integer> {

    UgyfelEntity findByNevAndTelefonAndEmail(String nev, String telefon, String email);
}
