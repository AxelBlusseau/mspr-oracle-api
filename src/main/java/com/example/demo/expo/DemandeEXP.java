package com.example.demo.expo;

import com.example.demo.bo.Demande;
import com.example.demo.bo.Tournee;
import com.example.demo.dataobject.InfoDemande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class DemandeEXP {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(path = "infoDemande")
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

    @PostMapping(path = "demande")
    public ResponseEntity<String> readInfoDemande(@RequestBody Demande demande) {

        String requete = "INSERT INTO DEMANDE \n" +
                "(DATEDEMANDE, DATEENLEVEMENT, SIRET, NOTOURNEE, NOSITE) \n" +
                "VALUES \n" +
                "(?, ?, ?, ?, ?);";

        jdbcTemplate.update(requete, demande.getDateDemande(), demande.getDateElevement(), demande.getSiret(), demande.getNoTournee(), demande.getNoSite());

        return ResponseEntity.ok("Demande insérée");
    }

    @GetMapping(path = "insertDetailDemande")
    public ResponseEntity<String> insertDetailDemande(@RequestParam Integer qte, @RequestParam String remarque,
                                                       @RequestParam Integer nomTypeDechet) {

        //Récupération du dernier id demande
        String requete = "select nodemande from DEMANDE where rownum < 2 order by nodemande DESC";

        Integer noDemande = jdbcTemplate.queryForObject(requete, Integer.class);



        return ResponseEntity.ok("oui");
    };


    @GetMapping(path = "demandeNonAffectee")
    public ResponseEntity<List<Demande>> readDemandeNoTournee() {

        String requete = "select * from demande where notournee is null\n";

        List<Demande> lstDemande = this.jdbcTemplate.query(requete, new Object[] {}, (result, row) -> {
            Demande demande = new Demande();

            demande.setId(result.getInt( "NODEMANDE"));
            demande.setSiret(result.getLong( "SIRET"));
            demande.setNoSite(result.getInt( "NOSITE"));
            demande.setDateDemande(result.getDate( "DATEDEMANDE"));
            demande.setDateElevement(result.getDate( "DATEENLEVEMENT"));

            return demande;
        });

        return ResponseEntity.ok(lstDemande);
    }

    @GetMapping(path = "demandePostSaisieAgent")
    public ResponseEntity<List<Demande>> readDemandeDate(@RequestParam String dateDemande) {

        //localhost:8080/demandePostSaisieAgent?dateDemande=24/05/2020
        String requete = "select * from demande where datedemande > ?";

        List<Demande> lstDemande = this.jdbcTemplate.query(requete, new Object[] { dateDemande }, (result, row) -> {
            Demande demande = new Demande();
            demande.setId(result.getInt( "NODEMANDE"));
            demande.setSiret(result.getLong( "SIRET"));
            demande.setNoSite(result.getInt( "NOSITE"));
            demande.setDateElevement(result.getDate( "DATEENLEVEMENT"));

            return demande;
        });

        return ResponseEntity.ok(lstDemande);
    }

    @GetMapping(path = "demandeDateTournee")
    public ResponseEntity<List<Demande>> readDemandeDateTournee(@RequestParam String dateTournee) {

        //localhost:8080/demandeDateTournee?dateTournee=24/05/2020
        String requete = "select * from demande d join tournee t on d.notournee = t.notournee where t.datetournee = ?";

        List<Demande> lstDemande = this.jdbcTemplate.query(requete, new Object[] { dateTournee }, (result, row) -> {
            Demande demande = new Demande();
            demande.setId(result.getInt( "NODEMANDE"));
            demande.setSiret(result.getLong( "SIRET"));
            demande.setNoSite(result.getInt( "NOSITE"));
            demande.setDateDemande(result.getDate( "DATEDEMANDE"));
            demande.setDateElevement(result.getDate( "DATEENLEVEMENT"));

            return demande;
        });

        return ResponseEntity.ok(lstDemande);
    }



}
