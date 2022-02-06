package simongumis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import simongumis.entities.GumikEntity;

import java.util.List;

public interface GumikRepository extends JpaRepository<GumikEntity, Integer> {
    GumikEntity findByGyartoAndMeret_SzelessegAndMeret_ProfilAndMeret_FelniAndEvszakAndAllapotAndAr(String gyarto, Integer szelesseg, Integer profil, Integer felni, String evszak, String allapot, Integer ar);

    List<GumikEntity> findAllByMeretId(Integer id);

    GumikEntity findGumikEntityById(Integer id);

}
