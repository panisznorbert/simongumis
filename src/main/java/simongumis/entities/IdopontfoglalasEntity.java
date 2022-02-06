package simongumis.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "idopontfoglalasok")
public class IdopontfoglalasEntity extends BaseEntity implements Comparable<IdopontfoglalasEntity>{
    private LocalDateTime datum;
    @ManyToOne(cascade = CascadeType.ALL)
    private UgyfelEntity ugyfel;
    private String megjegyzes;


    @Override
    public int compareTo(IdopontfoglalasEntity o) {
        return this.getDatum().compareTo((o.getDatum()));
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public UgyfelEntity getUgyfel() {
        return ugyfel;
    }

    public void setUgyfel(UgyfelEntity ugyfel) {
        this.ugyfel = ugyfel;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }
}
