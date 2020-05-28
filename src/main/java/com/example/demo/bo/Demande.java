package com.example.demo.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity(name = "demande")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "DEMANDE")
public class Demande implements Serializable {

    @Id
    @Column(name = "NODEMANDE")
    private Integer id;
    @Column(name = "DATEDEMANDE")
    private Date dateDemande;
    @Column(name = "DATEENLEVEMENT")
    private Date dateElevement;
    @Column(name = "SIRET")
    private Long siret;
    @Column(name = "NOTOURNEE")
    private Integer noTournee;
    @Column(name = "NOSITE")
    private Integer noSite;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employe{");
        sb.append("nodemande=").append(id);
        sb.append(", dateDemande=").append(dateDemande);
        sb.append(", dateElevement=").append(dateElevement);
        sb.append(", siret=").append(siret);
        sb.append(", noTournee=").append(noTournee);
        sb.append(", noSite=").append(noSite);
        sb.append('}');
        return sb.toString();
    }
}
