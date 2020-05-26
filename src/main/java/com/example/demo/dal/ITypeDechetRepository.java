package com.example.demo.dal;

import com.example.demo.bo.TypeDechet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "typeDechets-list", collectionResourceRel = "typeDechets_data")
public interface ITypeDechetRepository extends CrudRepository<TypeDechet, Integer> {
}
