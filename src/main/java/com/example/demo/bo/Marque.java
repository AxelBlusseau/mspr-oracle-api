package com.example.demo.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="MARQUE")
public class Marque implements Serializable {

    @Id
    @Column(name = "NOMARQUE")
    private Integer id;

    @Column(name = "NOMMARQUE")
    private String nom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Marque() {
    }

    public Marque(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Marque{");
        sb.append("nomarque=").append(id);
        sb.append(", nom=").append(nom);
        sb.append('}');
        return sb.toString();
    }
}
