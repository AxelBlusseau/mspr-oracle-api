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
@Table(name = "CAMION")
public class Camion implements Serializable {

    @Id
    @Column(name = "NOIMMATRIC")
    private String id;
    @Column(name = "DATEACHAT")
    private Date dateAchat;
    @Column(name = "NOMODELE")
    private Integer noModele;
    @Column(name = "NOSITE")
    private Integer noSite;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CentreTraitement{");
        sb.append("noImmatric=").append(id);
        sb.append(", dateAchat=").append(dateAchat);
        sb.append(", noModele=").append(noModele);
        sb.append(", noSite=").append(noSite);
        sb.append('}');
        return sb.toString();
    }
}
