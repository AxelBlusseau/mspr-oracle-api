package com.example.demo.dal;

import com.example.demo.bo.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "villes-list", collectionResourceRel = "villes_data")
public interface IVilleRepository extends CrudRepository<Ville, Integer> {
}
