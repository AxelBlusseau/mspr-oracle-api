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
@Table(name="TOURNEE")
public class Tournee implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "NOTOURNEE")
    private Integer id;
    @Column(name = "DATETOURNEE")
    private Date dateTournee;
    @Column(name = "NOIMMATRIC")
    private String noImmatric;
    @Column(name = "NOEMPLOYE")
    private Integer noEmploye;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tournee{");
        sb.append("noTournee=").append(id);
        sb.append(", dateTournee=").append(dateTournee);
        sb.append(", noImmatric=").append(noImmatric);
        sb.append(", noEmploye=").append(noEmploye);
        sb.append('}');
        return sb.toString();
    }

}
