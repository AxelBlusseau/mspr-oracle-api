package com.example.demo.dal;

import com.example.demo.bo.Modele;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "modeles-list", collectionResourceRel = "modeles_data")
public interface IModeleRepository extends CrudRepository<Modele, Integer> {

}
