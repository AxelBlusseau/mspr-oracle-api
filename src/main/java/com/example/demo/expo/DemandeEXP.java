package com.example.demo.expo;

import com.example.demo.bo.Demande;
import com.example.demo.bo.Tournee;
import com.example.demo.dataobject.InfoDemande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "infoDemande", produces = "application/json")
public class DemandeEXP {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public ResponseEntity<List<InfoDemande>> readInfoDemande(@RequestParam Integer idDemande) {

        String requete = "select e.raisonsociale, t.*, dd.quantiteenlevee, td.nomtypedechet from demande d join entreprise e on d.siret = e.siret join tournee t on d.notournee = t.notournee join detaildemande dd on d.nodemande = dd.nodemande join typedechet td on dd.notypedechet = td.notypedechet where d.nodemande = ?";

        List<InfoDemande> lstInfoDemande = this.jdbcTemplate.query(requete, new Object[] { idDemande }, (result, row) -> {
            InfoDemande infoDemande = new InfoDemande();
            Tournee tournee = new Tournee();
            tournee.setId(result.getInt( "NOTOURNEE"));
            tournee.setDateTournee(result.getDate( "DATETOURNEE"));
            tournee.setNoImmatric(result.getString( "NOIMMATRIC"));
            tournee.setNoEmploye(result.getInt("NOEMPLOYE"));
            infoDemande.setRaisonSociale(result.getString( "RAISONSOCIALE"));
            infoDemande.setNomTypeDechet(result.getString( "NOMTYPEDECHET"));
            infoDemande.setQuantiteEnlevee(result.getInt( "QUANTITEENLEVEE"));
            infoDemande.setTournee(tournee);

            return infoDemande;
        });

        return ResponseEntity.ok(lstInfoDemande);
    }

}
