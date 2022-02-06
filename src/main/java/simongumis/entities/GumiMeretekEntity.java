package simongumis.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "gumi_meretek")
public class GumiMeretekEntity extends BaseEntity implements Comparable<GumiMeretekEntity>{
    private Integer szelesseg;
    private Integer profil;
    private Integer felni;

    @Override
    public String toString() {
        return szelesseg + "/" + profil + "R" + felni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GumiMeretekEntity that = (GumiMeretekEntity) o;
        return Objects.equals(szelesseg, that.szelesseg) &&
                Objects.equals(profil, that.profil) &&
                Objects.equals(felni, that.felni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), szelesseg, profil, felni);
    }

    @Override
    public int compareTo(GumiMeretekEntity o) {
        if(this.getSzelesseg().compareTo(o.getSzelesseg()) == 0){
            if(this.getProfil().compareTo(o.getProfil()) == 0){
                return this.getFelni().compareTo(o.getFelni());
            }else{
                return this.getProfil().compareTo(o.getProfil());
            }
        }else{
            return this.getSzelesseg().compareTo(o.getSzelesseg());
        }
    }

    public Integer getSzelesseg() {
        return szelesseg;
    }

    public void setSzelesseg(Integer szelesseg) {
        this.szelesseg = szelesseg;
    }

    public Integer getProfil() {
        return profil;
    }

    public void setProfil(Integer profil) {
        this.profil = profil;
    }

    public Integer getFelni() {
        return felni;
    }

    public void setFelni(Integer felni) {
        this.felni = felni;
    }
}
