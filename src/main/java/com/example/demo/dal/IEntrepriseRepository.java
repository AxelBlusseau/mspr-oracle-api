package com.example.demo.dal;

import com.example.demo.bo.Entreprise;
import com.example.demo.bo.Fonction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "entreprises-list", collectionResourceRel = "entreprises_data")
public interface IEntrepriseRepository extends CrudRepository<Entreprise, Integer> {
}
