package com.example.demo.dal;

import com.example.demo.bo.Employe;
import com.example.demo.bo.Fonction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(path = "employes-list", collectionResourceRel = "employes_data")
public interface IEmployeRepository extends CrudRepository<Employe, Integer> {

    List<Employe> findByNomAndPrenomAndPassword(@Param("nom") String nom, @Param("prenom") String prenom, @Param("password") String password );
}
