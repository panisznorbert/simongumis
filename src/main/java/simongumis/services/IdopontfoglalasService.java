package simongumis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import simongumis.entities.IdopontfoglalasEntity;
import simongumis.entities.UgyfelEntity;
import simongumis.repositories.IdopontfoglalasRepository;
import simongumis.repositories.UgyfelRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class IdopontfoglalasService {

    private final static Logger LOGGER = Logger.getLogger(IdopontfoglalasService.class.getName());

    @Autowired
    IdopontfoglalasRepository idopontfoglalasRepository;

    @Autowired
    UgyfelRepository ugyfelRepository;

    public IdopontfoglalasEntity keresesIdopontra(LocalDateTime localDateTime){
        return idopontfoglalasRepository.findByDatum(localDateTime);
    }


    public IdopontfoglalasEntity idopontLefoglalas(IdopontfoglalasEntity foglalas){

        Specification<UgyfelEntity> spec = Specification.where(null);
        spec = spec.and(UgyfelSpecification.hasNev(foglalas.getUgyfel().getNev()));
        spec = spec.and(UgyfelSpecification.hasEmail(foglalas.getUgyfel().getEmail()));
        spec = spec.and(UgyfelSpecification.hasTel(foglalas.getUgyfel().getTelefon()));
        List<UgyfelEntity> ugyfel = ugyfelRepository.findAll(spec);
        if (!ugyfel.isEmpty()){
            LOGGER.info("van ugyfel ");
            foglalas.setUgyfel(ugyfel.get(0));
        }
        return idopontfoglalasRepository.save(foglalas);
    }
}
