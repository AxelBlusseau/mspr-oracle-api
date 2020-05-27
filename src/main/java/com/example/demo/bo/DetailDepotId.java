package com.example.demo.bo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DetailDepotId implements Serializable {
        @Column(name = "NOTOURNEE")
        Integer noTournee;
        @Column(name = "NOTYPEDECHET")
        Integer noTypeDechet;
        @Column(name = "NOCENTRE")
        Integer noCentre;
}
