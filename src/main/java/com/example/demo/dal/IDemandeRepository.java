package com.example.demo.dal;

import com.example.demo.bo.Demande;
import com.example.demo.bo.Fonction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "demandes-list", collectionResourceRel = "demandes_data")
public interface IDemandeRepository extends CrudRepository<Demande, Integer> {
}
