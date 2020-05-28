package com.example.demo.dataobject;

import com.example.demo.bo.Tournee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InfoDemande {
    private String raisonSociale;

    private Tournee tournee;

    private Integer quantiteEnlevee;

    private String nomTypeDechet;
}
