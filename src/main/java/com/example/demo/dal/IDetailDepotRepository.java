package com.example.demo.dal;

import com.example.demo.bo.Demande;
import com.example.demo.bo.DetailDepot;
import com.example.demo.bo.DetailDepotId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path = "detaildepots-list", collectionResourceRel = "detaildepots_data")
public interface IDetailDepotRepository extends CrudRepository<DetailDepot, DetailDepotId> {
}
