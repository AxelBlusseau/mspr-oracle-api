package com.example.demo.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ENTREPRISE")
public class Entreprise implements Serializable {

    @Id
    @Column(name = "SIRET")
    private Long id;
    @Column(name = "RAISONSOCIALE")
    private String raisonSociale;
    @Column(name = "NORUENNTR")
    private Integer noruenntr;
    @Column(name = "RUEENTR")
    private String rueentr;
    @Column(name = "NOTEL")
    private String notel;
    @Column(name = "CONTACT")
    private String contact;
    @Column(name = "NOVILLE")
    private Integer noville;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Entreprise{");
        sb.append("siret=").append(id);
        sb.append(", raisonsociale=").append(raisonSociale);
        sb.append(", noruenntr=").append(noruenntr);
        sb.append(", rueentr=").append(rueentr);
        sb.append(", notel=").append(notel);
        sb.append(", contact=").append(contact);
        sb.append(", noville=").append(noville);
        sb.append('}');
        return sb.toString();
    }
}
