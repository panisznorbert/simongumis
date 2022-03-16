package simongumis.repositories;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import simongumis.entities.GumikEntity;

import java.util.List;

public interface GumikRepository extends JpaRepository<GumikEntity, Integer>, JpaSpecificationExecutor<GumikEntity> {

    GumikEntity findGumikEntityById(Integer id);

    //GumikEntity find(Specification<GumikEntity> spec);

    //List<GumikEntity> findAll(Specification<GumikEntity> spec);




}
