package simongumis.services;

import org.springframework.data.jpa.domain.Specification;
import simongumis.entities.GumikEntity;
import simongumis.entities.GumikEntity_;


public class GumiSpecification {


    public static Specification<GumikEntity> hasNev(String gyarto){

        return (root, cq, cb) -> cb.equal(root.get(GumikEntity_.GYARTO), gyarto);
    }

    public static Specification<GumikEntity> hasSzelesseg(Integer szelesseg){

        return (root, cq, cb) -> cb.equal(root.get(GumikEntity_.SZELESSEG), szelesseg);
    }

    public static Specification<GumikEntity> hasProfil(Integer profil){

        return (root, cq, cb) -> cb.equal(root.get(GumikEntity_.PROFIL), profil);
    }

    public static Specification<GumikEntity> hasFelni(Integer felni){

        return (root, cq, cb) -> cb.equal(root.get(GumikEntity_.FELNI), felni);
    }

    public static Specification<GumikEntity> hasAr(Integer ar){

        return (root, cq, cb) -> cb.equal(root.get(GumikEntity_.AR), ar);
    }

    public static Specification<GumikEntity> hasEvszak(String evszak){

        return (root, cq, cb) -> cb.equal(root.get(GumikEntity_.EVSZAK), evszak);
    }

    public static Specification<GumikEntity> hasAllapot(String allapot){

        return (root, cq, cb) -> cb.equal(root.get(GumikEntity_.ALLAPOT), allapot);
    }

    public static Specification<GumikEntity> hasMennyiseg(Integer mennyiseg){

        return (root, cq, cb) -> cb.equal(root.get(GumikEntity_.MENNYISEG_RAKTARBAN), mennyiseg);
    }
}
