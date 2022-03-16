package simongumis.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "rendelesek")
public class RendelesEntity extends BaseEntity implements Comparable<RendelesEntity>{
    @OneToOne(cascade = CascadeType.ALL)
    private UgyfelEntity ugyfel;

    @OneToMany(cascade = CascadeType.ALL,  fetch=FetchType.EAGER)
    private List<RendelesiEgysegEntity> rendelesiEgysegek;

    private Integer vegosszeg;

    @Enumerated(EnumType.STRING)
    private RendelesStatusz statusz;

    private LocalDate datum;

    private String session;

    @Override
    public int compareTo(RendelesEntity o) {
        return o.getDatum().compareTo(this.getDatum());
    }

    public UgyfelEntity getUgyfel() {
        return ugyfel;
    }

    public void setUgyfel(UgyfelEntity ugyfel) {
        this.ugyfel = ugyfel;
    }

    public List<RendelesiEgysegEntity> getRendelesiEgysegek() {
        return rendelesiEgysegek;
    }

    public void setRendelesiEgysegek(List<RendelesiEgysegEntity> rendelesiEgysegek) {
        this.rendelesiEgysegek = rendelesiEgysegek;
    }

    public Integer getVegosszeg() {
        return vegosszeg;
    }

    public void setVegosszeg(Integer vegosszeg) {
        this.vegosszeg = vegosszeg;
    }

    public RendelesStatusz getStatusz() {
        return statusz;
    }

    public void setStatusz(RendelesStatusz statusz) {
        this.statusz = statusz;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
