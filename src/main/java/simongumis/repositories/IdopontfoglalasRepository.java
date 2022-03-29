package simongumis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simongumis.entities.IdopontfoglalasEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IdopontfoglalasRepository extends JpaRepository<IdopontfoglalasEntity, Integer> {

    IdopontfoglalasEntity findByDatum(LocalDateTime localDateTime);

    List<IdopontfoglalasEntity> findAllByDatumAfter(LocalDateTime localDateTime);

    List<IdopontfoglalasEntity> findAllByDatumBetween(LocalDateTime start, LocalDateTime end);
}