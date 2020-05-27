package com.example.demo.dal;

import com.example.demo.bo.Marque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "marques-list", collectionResourceRel = "marques_data")
public interface IMarqueRepository extends CrudRepository<Marque, Integer> {

}
