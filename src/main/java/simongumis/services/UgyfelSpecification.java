package simongumis.services;

import org.springframework.data.jpa.domain.Specification;
import simongumis.entities.UgyfelEntity;
import simongumis.entities.UgyfelEntity_;

public class UgyfelSpecification {

    public static Specification<UgyfelEntity> hasNev(String nev){

        return (root, cq, cb) -> cb.equal(root.get(UgyfelEntity_.NEV), nev);
    }

    public static Specification<UgyfelEntity> hasTel(String tel){

        return (root, cq, cb) -> cb.equal(root.get(UgyfelEntity_.TELEFON), tel);
    }

    public static Specification<UgyfelEntity> hasEmail(String email){

        return (root, cq, cb) -> cb.equal(root.get(UgyfelEntity_.EMAIL), email);
    }
}
