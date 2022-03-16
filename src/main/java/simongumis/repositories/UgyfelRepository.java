package simongumis.repositories;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import simongumis.entities.UgyfelEntity;

import java.util.List;


@Repository
public interface UgyfelRepository extends JpaRepository<UgyfelEntity, Integer>, JpaSpecificationExecutor<UgyfelEntity> {

    List<UgyfelEntity> findAll(Specification<UgyfelEntity> spec);
}
