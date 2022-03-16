package simongumis.entities;

import javax.persistence.*;


@Entity
@Table(name = "ugyfelek")
public class UgyfelEntity extends BaseEntity {
    private String nev;
    private String telefon;
    private String email;

    public UgyfelEntity(){}

    public UgyfelEntity(String nev, String telefon, String email) {
        this.nev = nev;
        this.telefon = telefon;
        this.email = email;
    }


    @Override
    public String toString() {
        return nev + ", " + telefon + ", " + email;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
