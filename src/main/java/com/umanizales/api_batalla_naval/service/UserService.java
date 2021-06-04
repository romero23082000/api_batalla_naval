package com.umanizales.api_batalla_naval.service;

import com.umanizales.api_batalla_naval.model.dto.RespuestaDTO;
import com.umanizales.api_batalla_naval.model.entities.UsuarioEntity;
import com.umanizales.api_batalla_naval.model.utilities.Messages;
import com.umanizales.api_batalla_naval.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(new RespuestaDTO(Messages.SUCCESSFUL,
                userRepository.findAll(), null), HttpStatus.OK);
    }
    public ResponseEntity<Object> createUser(UsuarioEntity usuarioEntity)
    {
        try {
            UsuarioEntity userSave = userRepository.save(usuarioEntity);
            return new ResponseEntity<>(new RespuestaDTO(Messages.SUCCESSFUL,
                    userSave, null), HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(new RespuestaDTO(Messages.ERROR_DATA_NOT_FOUND,
                    null, Messages.DATA_NOT_FOUND), HttpStatus.CONFLICT);
        }
    }
    public ResponseEntity<Object> findUserByRol(short codigo){
        return new ResponseEntity<>(new RespuestaDTO(Messages.SUCCESSFUL,
                userRepository.obtenerUsuariosPorRol(codigo), null), HttpStatus.OK);
    }
}
