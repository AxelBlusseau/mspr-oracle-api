package com.example.demo.dal;

import com.example.demo.bo.Employe;
import com.example.demo.bo.Fonction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "employes-list", collectionResourceRel = "employes_data")
public interface IEmployeRepository extends CrudRepository<Employe, Integer> {
}
