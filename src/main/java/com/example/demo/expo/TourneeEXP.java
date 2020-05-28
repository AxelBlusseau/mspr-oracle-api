package com.example.demo.expo;

import com.example.demo.bo.Tournee;
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
public class TourneeEXP {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping(path = "tourneesEmployeUneDate")
    public ResponseEntity<List<Tournee>> readEmployeTourneeUneDate(@RequestParam Integer idEmploye, @RequestParam String dateTournee ) {

        //tourneesEmployeUneDate?idEmploye=1&dateTournee=26/05/2020
        String requete = "select * from tournee t join employe e on t.noemploye = e.noemploye where e.noemploye = ? and t.datetournee = ?";

        List<Tournee> lstTourneeEmployeUneDate = this.jdbcTemplate.query(requete, new Object[] { idEmploye , dateTournee }, (result, row) -> {
            Tournee tournee = new Tournee();
            tournee.setId(result.getInt( "NOTOURNEE"));
            tournee.setDateTournee(result.getDate( "DATETOURNEE"));
            tournee.setNoImmatric(result.getString( "NOIMMATRIC"));
            tournee.setNoEmploye(result.getInt( "NOEMPLOYE"));

            return tournee;
        });

        return ResponseEntity.ok(lstTourneeEmployeUneDate);
    }

}
