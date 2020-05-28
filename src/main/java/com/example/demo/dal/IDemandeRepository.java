package com.example.demo.dal;

import com.example.demo.bo.Demande;
import com.example.demo.bo.Fonction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "demandes-list", collectionResourceRel = "demandes_data")
public interface IDemandeRepository extends CrudRepository<Demande, Integer> {
    //List<Demande> findAllByDateDemandeAfter(@Param("date") Date date);
    List<Demande> getByDateDemande(@Param("date") Date date);

    @Query("select d.id from demande d inner join tournee t on d.id = t.id " +
            "where t.dateTournee = :dateTournee")
    List<Demande> getAllByDateTournee(@Param("date") Date dateTournee);
}
