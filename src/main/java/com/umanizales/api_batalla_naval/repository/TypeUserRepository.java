package com.umanizales.api_batalla_naval.repository;

import com.umanizales.api_batalla_naval.model.entities.TipoUsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface TypeUserRepository extends CrudRepository<TipoUsuarioEntity, Integer> {

}
