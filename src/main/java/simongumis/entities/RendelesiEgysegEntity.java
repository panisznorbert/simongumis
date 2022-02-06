package simongumis.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "rendelesi_egysegek")
public class RendelesiEgysegEntity extends BaseEntity implements Comparable<RendelesiEgysegEntity>{
    @OneToOne(cascade = CascadeType.ALL)
    private GumikEntity gumi;
    private Integer mennyiseg;
    private Integer reszosszeg;

    @Override
    public String toString() {
        return gumi.toString() + ", " + mennyiseg + " db," + reszosszeg + " Ft";
    }

    @Override
    public int compareTo(RendelesiEgysegEntity rendelesiEgysegEntity) {
        if(this.getGumi().getGyarto().compareTo(rendelesiEgysegEntity.getGumi().getGyarto()) != 0){
            return this.getGumi().getGyarto().compareTo(rendelesiEgysegEntity.getGumi().getGyarto());
        }
        return this.getGumi().getMeret().compareTo(rendelesiEgysegEntity.getGumi().getMeret());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RendelesiEgysegEntity that = (RendelesiEgysegEntity) o;

        if (gumi != null ? !gumi.equals(that.gumi) : that.gumi != null) return false;
        if (mennyiseg != null ? !mennyiseg.equals(that.mennyiseg) : that.mennyiseg != null) return false;
        return reszosszeg != null ? reszosszeg.equals(that.reszosszeg) : that.reszosszeg == null;
    }

    @Override
    public int hashCode() {
        int result = gumi != null ? gumi.hashCode() : 0;
        result = 31 * result + (mennyiseg != null ? mennyiseg.hashCode() : 0);
        result = 31 * result + (reszosszeg != null ? reszosszeg.hashCode() : 0);
        return result;
    }

    public GumikEntity getGumi() {
        return gumi;
    }

    public void setGumi(GumikEntity gumi) {
        this.gumi = gumi;
    }

    public Integer getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(Integer mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public Integer getReszosszeg() {
        return reszosszeg;
    }

    public void setReszosszeg(Integer reszosszeg) {
        this.reszosszeg = reszosszeg;
    }
}
