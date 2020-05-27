package com.example.demo.dal;


import com.example.demo.bo.CentreTraitement;
import com.example.demo.bo.Fonction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "centretraitements-list", collectionResourceRel = "centretraitements_data")
public interface ICentreTraitementRepository extends CrudRepository<CentreTraitement, Integer> {
}
