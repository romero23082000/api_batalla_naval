package com.umanizales.api_batalla_naval.repository;

import com.umanizales.api_batalla_naval.model.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UsuarioEntity,Integer>{

}
