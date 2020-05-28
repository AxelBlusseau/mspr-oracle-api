package com.example.demo.dataobject;

import com.example.demo.bo.Employe;
import com.example.demo.bo.Tournee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeTournee {
    private Employe employe;

    private Integer nbTournee;
    
}
