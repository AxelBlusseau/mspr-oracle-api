package com.example.demo.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="SITE")
public class Site implements Serializable {

    @Id
    @Column(name = "NOSITE")
    private Integer id;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "NOVILLE")
    private Integer noVille;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Site{");
        sb.append("noSite=").append(id);
        sb.append(", nom=").append(nom);
        sb.append(", noVille=").append(noVille);
        sb.append('}');
        return sb.toString();
    }
}
