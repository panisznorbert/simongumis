package simongumis.entities;

import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import javax.persistence.*;
import java.util.Arrays;
import java.util.Comparator;


@Entity
@Table(name = "gumik")
public class GumikEntity extends BaseEntity implements Comparable<GumikEntity>{
    private String gyarto;
    private Integer szelesseg;
    private Integer profil;
    private Integer felni;
    private Integer ar;
    private String evszak;
    private String allapot;
    private Integer mennyisegRaktarban;
    @Lob
    private byte[] kep;

    public GumikEntity(){}

    public GumikEntity(String gyarto, Integer szelesseg, Integer profil, Integer felni, Integer ar, String evszak, String allapot, Integer mennyisegRaktarban, byte[] kep) {
        this.gyarto = gyarto;
        this.szelesseg = szelesseg;
        this.profil = profil;
        this.felni = felni;
        this.ar = ar;
        this.evszak = evszak;
        this.allapot = allapot;
        this.mennyisegRaktarban = mennyisegRaktarban;
        this.kep = kep;
    }

    @Override
    public String toString() {
        return gyarto + " " + szelesseg + "/" + profil + "R" + felni + " " + evszak + " " + allapot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GumikEntity that = (GumikEntity) o;
        return gyarto.equalsIgnoreCase(that.gyarto) &&
                szelesseg.equals(that.szelesseg) &&
                profil.equals(that.profil) &&
                felni.equals(that.felni) &&
                evszak.equals(that.evszak) &&
                allapot.equals(that.allapot);
    }

    @Override
    public int hashCode() {
        int result = gyarto != null ? gyarto.hashCode() : 0;
        result = 31 * result + (szelesseg != null ? szelesseg.hashCode() : 0);
        result = 31 * result + (profil != null ? profil.hashCode() : 0);
        result = 31 * result + (felni != null ? felni.hashCode() : 0);
        result = 31 * result + (ar != null ? ar.hashCode() : 0);
        result = 31 * result + (evszak != null ? evszak.hashCode() : 0);
        result = 31 * result + (allapot != null ? allapot.hashCode() : 0);
        result = 31 * result + (mennyisegRaktarban != null ? mennyisegRaktarban.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(kep);
        return result;
    }

    public void setKep(byte[] kep) {
        this.kep = kep;
    }

    public void setKep(MemoryBuffer memoryBuffer) {

        if(!memoryBuffer.getFileName().isEmpty()){
            try{
                this.setKep(memoryBuffer.getInputStream().readAllBytes());
            }catch (Exception ex){
                //hiba dobása
            }
        }
    }

    @Override
    public int compareTo(GumikEntity gumikEntity) {
        return Comparators.GYARTO.compare(this, gumikEntity);
    }

    public static class Comparators {

        public static Comparator<GumikEntity> GYARTO = new Comparator<GumikEntity>() {
            @Override
            public int compare(GumikEntity o1, GumikEntity o2) {
                return o1.getGyarto().compareTo(o2.getGyarto());
            }
        };
        public static Comparator<GumikEntity> MERET = new Comparator<GumikEntity>() {
            @Override
            public int compare(GumikEntity o1, GumikEntity o2) {

                if(o1.getSzelesseg().compareTo(o2.getSzelesseg()) == 0){
                    if(o1.getProfil().compareTo(o2.getProfil()) == 0){
                        return o1.getFelni().compareTo(o2.getFelni());
                    }else{
                        return o1.getProfil().compareTo(o2.getProfil());
                    }
                }else{
                    return o1.getSzelesseg().compareTo(o2.getSzelesseg());
                }
            }
        };
        public static Comparator<GumikEntity> ARNOVEKVO = new Comparator<GumikEntity>() {
            @Override
            public int compare(GumikEntity o1, GumikEntity o2) {
                return o1.getAr().compareTo(o2.getAr());
            }
        };
        public static Comparator<GumikEntity> ARCSOKKENO = new Comparator<GumikEntity>() {
            @Override
            public int compare(GumikEntity o1, GumikEntity o2) {
                return o2.getAr().compareTo(o1.getAr());
            }
        };
    }

    public String getGyarto() {
        return gyarto;
    }

    public void setGyarto(String gyarto) {
        this.gyarto = gyarto;
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

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }

    public String getEvszak() {
        return evszak;
    }

    public void setEvszak(String evszak) {
        this.evszak = evszak;
    }

    public String getAllapot() {
        return allapot;
    }

    public void setAllapot(String allapot) {
        this.allapot = allapot;
    }

    public Integer getMennyisegRaktarban() {
        return mennyisegRaktarban;
    }

    public void setMennyisegRaktarban(Integer mennyisegRaktarban) {
        this.mennyisegRaktarban = mennyisegRaktarban;
    }

    public byte[] getKep() {
        return kep;
    }
}
