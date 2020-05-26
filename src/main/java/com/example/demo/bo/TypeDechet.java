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
@Table(name="TYPEDECHET")
public class TypeDechet implements Serializable {
    @Id
    @Column(name = "NOTYPEDECHET")
    private Integer id;
    @Column(name = "NOMTYPEDECHET")
    private String nomTypeDeDechet;
    @Column(name = "NIVDANGER")
    private Integer nivDanger;
    @Column(name = "SEUIL")
    private String seuil;
    @Column(name = "TARIFFORFAITAIRE")
    private Integer tarifForfaitaire;
    @Column(name = "TARIFLOT")
    private Integer tarifLot;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TypeDechet{");
        sb.append("noTypeDechet=").append(id);
        sb.append(", nomTypeDeDechet=").append(nomTypeDeDechet);
        sb.append(", nivDanger=").append(nivDanger);
        sb.append(", seuil=").append(seuil);
        sb.append(", tarifForfaitaire=").append(tarifForfaitaire);
        sb.append(", tarifLot=").append(tarifLot);
        sb.append('}');
        return sb.toString();
    }
}
