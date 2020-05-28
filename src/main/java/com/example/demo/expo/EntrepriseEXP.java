package com.example.demo.expo;

import com.example.demo.dataobject.EntreprisesTopDemandes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class EntrepriseEXP {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(path = "topDemandesRealiseesEntreprises")
    public ResponseEntity<List<EntreprisesTopDemandes>> readNumberDemandesRealiseesEntreprises(@RequestParam String raisonSociale) {

        //http://localhost:8080/topDemandesRealiseesEntreprises?raisonSociale=bricorama

        String requete = "select e.raisonsociale, count(d.nodemande) as NBDEMANDE \n" +
                "from entreprise e \n" +
                "join demande d on e.siret = d.siret \n" +
                "group by e.raisonsociale \n" +
                "having count(d.nodemande) > (select count(d.nodemande) from demande d join entreprise e on d.siret = e.siret where e.raisonsociale = ? ) \n" +
                "order by NBDEMANDE DESC";

        List<EntreprisesTopDemandes> listEntreprisesTopDemandes = this.jdbcTemplate.query(requete, new Object[] { raisonSociale }, (result, row) -> {
            EntreprisesTopDemandes entreprisesTopDemandes = new EntreprisesTopDemandes();
            entreprisesTopDemandes.setRaisonSociale(result.getString( "RAISONSOCIALE"));
            entreprisesTopDemandes.setNbDemande(result.getInt( "NBDEMANDE"));

            return entreprisesTopDemandes;
        });

        return ResponseEntity.ok(listEntreprisesTopDemandes);
    }


}
