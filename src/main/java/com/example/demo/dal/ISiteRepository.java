package com.example.demo.dal;

import com.example.demo.bo.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "sites-list", collectionResourceRel = "sites_data")
public interface ISiteRepository extends CrudRepository<Site, Integer> {
}
