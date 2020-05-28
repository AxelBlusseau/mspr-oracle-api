package com.example.demo.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "EMPLOYE")
public class Employe implements Serializable {

    @Id
    @Column(name = "NOEMPLOYE")
    private Integer id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "DATENAISS")
    private Date datenaiss;
    @Column(name = "DATEEMBAUCHE")
    private Date dateembauche;
    @Column(name = "SALAIRE")
    private Integer salaire;
    @Column(name = "NOFONCTION")
    private Integer noFonction;
    @Column(name = "NOSITE")
    private Integer noSite;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employe{");
        sb.append("noemploye=").append(id);
        sb.append(", nom=").append(nom);
        sb.append(", prenom=").append(prenom);
        sb.append(", dateembauche=").append(dateembauche);
        sb.append(", datenaiss=").append(datenaiss);
        sb.append(", salaire=").append(salaire);
        sb.append(", noFonction=").append(noFonction);
        sb.append(", noSite=").append(noSite);
        sb.append('}');
        return sb.toString();
    }
}
