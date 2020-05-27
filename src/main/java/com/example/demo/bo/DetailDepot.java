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
@Table(name = "DETAILDEPOT")
public class DetailDepot implements Serializable {
    @EmbeddedId DetailDepotId id;
    @Column(name = "QUANTITEDEPOSEE")
    private Integer quantiteDeposee;
    @Column(name = "REMARQUE")
    private String remarque;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DetailDepot{");
        sb.append("DetailDepot=").append(id);
        sb.append(", quantiteDeposee=").append(quantiteDeposee);
        sb.append(", remarque=").append(remarque);
        sb.append('}');
        return sb.toString();
    }

}

