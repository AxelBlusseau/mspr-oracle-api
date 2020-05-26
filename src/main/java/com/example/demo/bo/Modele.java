package com.example.demo.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="MODELE")
public class Modele implements Serializable {

    @Id
    @Column(name = "NOMODELE")
    private Integer id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "NOMARQUE")
    private Integer nomMarque;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Modele{");
        sb.append("noModele=").append(id);
        sb.append(", nom=").append(nom);
        sb.append(", nomMarque=").append(nomMarque);
        sb.append('}');
        return sb.toString();
    }

}
