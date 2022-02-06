package simongumis.entities;

import com.vaadin.flow.component.upload.receivers.MemoryBuffer;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Objects;


@Entity
@Table(name = "gumik")
public class GumikEntity extends BaseEntity implements Comparable<GumikEntity>{
    private String gyarto;
    @ManyToOne(cascade = {CascadeType.ALL})
    protected GumiMeretekEntity meret;
    private Integer ar;
    private String evszak;
    private String allapot;
    private Integer mennyisegRaktarban;
    @Lob
    private byte[] kep;

    @Override
    public String toString() {
        return gyarto + " " + meret + " " + evszak + " " + allapot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GumikEntity that = (GumikEntity) o;
        return gyarto.equalsIgnoreCase(that.gyarto) &&
                meret.equals(that.meret) &&
                evszak.equals(that.evszak) &&
                allapot.equals(that.allapot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gyarto, meret, evszak, allapot);
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
                return o1.getMeret().compareTo(o2.getMeret());
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

    public GumiMeretekEntity getMeret() {
        return meret;
    }

    public void setMeret(GumiMeretekEntity meret) {
        this.meret = meret;
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
