package com.example.demo.dal;

import com.example.demo.bo.Demande;
import com.example.demo.bo.Fonction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "demandes-list", collectionResourceRel = "demandes_data")
public interface IDemandeRepository extends CrudRepository<Demande, Integer> {
}
