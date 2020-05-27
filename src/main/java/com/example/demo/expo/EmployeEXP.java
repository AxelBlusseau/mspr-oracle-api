package com.example.demo.expo;

import com.example.demo.bo.Employe;
import com.example.demo.bo.Tournee;
import com.example.demo.dataobject.EmployeTournee;
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
@RequestMapping(produces = "application/json")
public class EmployeEXP {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(path = "employeTournee")
    public ResponseEntity<List<EmployeTournee>> readEmployeTournee(@RequestParam Integer nbTournee) {

        String requete = "select e.noemploye, e.nom, e.prenom, count(t.notournee) as NBTOURNEE \n" +
                "from employe e join tournee t on e.noemploye = t.noemploye \n" +
                "group by e.noemploye, e.nom, e.prenom \n" +
                "having count(t.notournee) < ? \n" +
                "order by NBTOURNEE ASC";

        List<EmployeTournee> lstEmployeTournee = this.jdbcTemplate.query(requete, new Object[] { nbTournee }, (result, row) -> {
            EmployeTournee employeTournee = new EmployeTournee();
            Employe employe = new Employe();
            employe.setId(result.getInt( "NOEMPLOYE"));
            employe.setNom(result.getString( "NOM"));
            employe.setPrenom(result.getString( "PRENOM"));
            employeTournee.setEmploye(employe);
            employeTournee.setNbTournee(result.getInt("NBTOURNEE"));

            return employeTournee;
        });

        return ResponseEntity.ok(lstEmployeTournee);
    }

}
