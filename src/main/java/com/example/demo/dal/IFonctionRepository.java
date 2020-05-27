package com.example.demo.dal;

import com.example.demo.bo.Fonction;
import com.example.demo.bo.Marque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "fonctions-list", collectionResourceRel = "fonctions_data")
public interface IFonctionRepository extends CrudRepository<Fonction, Integer> {
}
