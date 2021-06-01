package com.umanizales.api_batalla_naval.service;

import com.umanizales.api_batalla_naval.model.dto.RespuestaDTO;
import com.umanizales.api_batalla_naval.model.entities.TipoUsuarioEntity;
import com.umanizales.api_batalla_naval.model.entities.UsuarioEntity;
import com.umanizales.api_batalla_naval.repository.TypeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springfox.documentation.service.ResponseMessage;

@Service
public class TypeUserService {
    private TypeUserRepository typeUserRepository;

    @Autowired
    public TypeUserService(TypeUserRepository typeUserRepository) {
        this.typeUserRepository = typeUserRepository;
    }
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(new RespuestaDTO("EXITOSO",
                typeUserRepository.findAll(), null), HttpStatus.OK);
    }
    public ResponseEntity<Object> createTypeUser(TipoUsuarioEntity tipoUsuarioEntity){
        try {
            TipoUsuarioEntity saveTypeUser = typeUserRepository.save(tipoUsuarioEntity);
            return new ResponseEntity<>(new RespuestaDTO("EXITOSO",
                    saveTypeUser, null), HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(new RespuestaDTO("ERROR",
                    null, "Ocurrio un error con el usuario"), HttpStatus.CONFLICT);
        }
    }
}
