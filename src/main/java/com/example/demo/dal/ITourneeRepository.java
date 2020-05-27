package com.example.demo.dal;

import com.example.demo.bo.Tournee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "tournees-list", collectionResourceRel = "tournees_data")
public interface ITourneeRepository extends CrudRepository<Tournee, Integer> {
}
