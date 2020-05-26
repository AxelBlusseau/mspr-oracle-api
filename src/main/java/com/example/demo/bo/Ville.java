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
@Table(name="VILLE")
public class Ville implements Serializable {

    @Id
    @Column(name = "NOVILLE")
    private Integer id;
    @Column(name = "VILLE")
    private String ville;
    @Column(name = "ZIP")
    private String zip;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ville{");
        sb.append("noVille=").append(id);
        sb.append(", ville=").append(ville);
        sb.append(", zip=").append(zip);
        sb.append('}');
        return sb.toString();
    }
}
