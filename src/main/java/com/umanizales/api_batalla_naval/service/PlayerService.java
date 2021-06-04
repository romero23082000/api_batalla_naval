package com.umanizales.api_batalla_naval.service;

import com.umanizales.api_batalla_naval.model.dto.RespuestaDTO;
import com.umanizales.api_batalla_naval.model.entities.TipoUsuarioEntity;
import com.umanizales.api_batalla_naval.model.entities.UsuarioEntity;
import com.umanizales.api_batalla_naval.repository.TypeUserRepository;
import com.umanizales.api_batalla_naval.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service

public class PlayerService {
    private UserRepository userRepository;
    private TypeUserRepository typeUserRepository;
    @Autowired
    public PlayerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Object> getUserByCorreo(String correo){
        UsuarioEntity usuarioEntity = userRepository.obtenerUsuariosPorCorreo(correo);
        if (usuarioEntity == null)
        {
            return new ResponseEntity<>(new RespuestaDTO("Usuario no encontrado",
                    null, "no existe el usuario"), HttpStatus.NOT_FOUND);
        }
        else
        {
            if (usuarioEntity.getTipoUsuarioEntity().getDescripcion().equals("Administrador"))
            {
                return new ResponseEntity<>(new RespuestaDTO("Eres administrador",
                        userRepository.obtenerUsuariosPorCorreo(correo), null), HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(new RespuestaDTO("No es administrador",
                        null, "no existe el usuario"), HttpStatus.NOT_FOUND);
            }

        }

    }

    public ResponseEntity<Object> findUserByCodigo(short codigo){
        return new ResponseEntity<>(new RespuestaDTO("EXITOSO",
                userRepository.obtenerUsuariosPorRol(codigo), null), HttpStatus.OK);
    }
}
