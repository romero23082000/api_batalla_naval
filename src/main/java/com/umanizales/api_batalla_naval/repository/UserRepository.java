package com.umanizales.api_batalla_naval.repository;

import com.umanizales.api_batalla_naval.model.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UsuarioEntity,Integer>{
    @Query("SELECT usuario FROM UsuarioEntity usuario WHERE usuario.tipoUsuarioEntity.codigo=?1")
    List<UsuarioEntity>obtenerUsuariosPorRol(short codigo);

    @Query("SELECT usuario FROM UsuarioEntity usuario WHERE usuario.correo=?1")
    UsuarioEntity obtenerUsuariosPorCorreo(String correo);
}
