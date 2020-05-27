package com.example.demo.dal;


import com.example.demo.bo.Camion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "camions-list", collectionResourceRel = "camions_data")
public interface ICamionRepository extends CrudRepository<Camion, Integer> {
}
