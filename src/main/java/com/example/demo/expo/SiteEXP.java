package com.example.demo.expo;

import com.example.demo.bo.Employe;
import com.example.demo.dataobject.EmployeTournee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class SiteEXP {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //qteCollecteSite?noSite=1&nomTypeDechet=Papier&dateDebut=01/09/2018&dateFin=30/09/2018
    @GetMapping(path = "qteCollecteSite")
    public ResponseEntity<Integer> readQteCollecteSite(@RequestParam Integer noSite, @RequestParam String nomTypeDechet,
                                                       @RequestParam Date dateDebut, @RequestParam Date dateFin) {

        int qte = jdbcTemplate.queryForObject("SELECT qtecollectesite(?,?,?,?) from dual", new Object[] {noSite, nomTypeDechet, dateDebut, dateFin}, Integer.class);

        return ResponseEntity.ok(qte);
    }


    //qteCollecteSiteNational?nomTypeDechet=Papier&dateDebut=01/09/2018&dateFin=30/09/2018
    @GetMapping(path = "qteCollecteSiteNational")
    public ResponseEntity<Integer> readQteCollecteSite(@RequestParam String nomTypeDechet, @RequestParam Date dateDebut, @RequestParam Date dateFin) {

        int qte = jdbcTemplate.queryForObject("SELECT qtecollectenational(?,?,?) from dual", new Object[] {nomTypeDechet, dateDebut, dateFin}, Integer.class);

        return ResponseEntity.ok(qte);
    }

}
