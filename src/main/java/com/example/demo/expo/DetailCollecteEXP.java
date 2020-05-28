package com.example.demo.expo;

import com.example.demo.bo.DetailCollecte;
import com.example.demo.bo.Tournee;
import com.example.demo.dataobject.InfoDemande;
import com.example.demo.dataobject.QuantiteEnlevee;
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
public class DetailCollecteEXP {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(path = "quantiteTotaleCollectee")
    public ResponseEntity<List<QuantiteEnlevee>> readQuantiteTotaleCollectee(@RequestParam String mois, @RequestParam String annee) {

        String requete = "select SUM(dc.quantiteenlevee) as QTEENLEVEE, td.nomtypedechet from detailcollecte dc join typedechet td on dc.notypedechet = td.notypedechet join demande d on dc.nodemande = d.nodemande join tournee t on d.notournee = t.notournee where extract(MONTH FROM t.datetournee) = ? and extract(YEAR FROM t.datetournee) = ? group by td.nomtypedechet";
        System.out.println(requete);
        List<QuantiteEnlevee> lstQuantiteEnlevee = this.jdbcTemplate.query(requete, new Object[] {mois , annee }, (result, row) -> {
            System.out.println(requete);
            QuantiteEnlevee quantiteEnlevee = new QuantiteEnlevee();
            quantiteEnlevee.setNomTypeDechet(result.getString( "NOMTYPEDECHET"));
            quantiteEnlevee.setQuantiteEnlevee(result.getInt( "QTEENLEVEE"));
            System.out.println(quantiteEnlevee);
            return quantiteEnlevee;
        });

        return ResponseEntity.ok(lstQuantiteEnlevee);
    }

}
