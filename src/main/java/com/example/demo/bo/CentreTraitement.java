package com.example.demo.bo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CENTRETRAITEMENT")
public class CentreTraitement implements Serializable {

    @Id
    @Column(name = "NOCENTRE")
    private Integer id;
    @Column(name = "NOMCENTRE")
    private String nomCentre;
    @Column(name = "NORUECENTRE")
    private Integer noRueCentre;
    @Column(name = "RUECENTRE")
    private String rueCentre;
    @Column(name = "NOVILLE")
    private Integer noVille;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CentreTraitement{");
        sb.append("noCentre=").append(id);
        sb.append(", nomCentre=").append(nomCentre);
        sb.append(", noRueCentre=").append(noRueCentre);
        sb.append(", rueCentre=").append(rueCentre);
        sb.append(", noVille=").append(noVille);
        sb.append('}');
        return sb.toString();
    }
}
