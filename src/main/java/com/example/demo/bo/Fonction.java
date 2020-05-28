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
@Table(name="FONCTION")
public class Fonction implements Serializable {

    @Id
    @Column(name = "NOFONCTION")
    private Integer id;

    @Column(name = "NOMFONCTION")
    private String nom;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fonction{");
        sb.append("nofonction=").append(id);
        sb.append(", nom=").append(nom);
        sb.append('}');
        return sb.toString();
    }

}
