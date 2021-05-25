package com.umanizales.api_batalla_naval.service;

import com.umanizales.api_batalla_naval.model.dto.RespuestaDTO;
import com.umanizales.api_batalla_naval.model.entities.Barco;
import com.umanizales.api_batalla_naval.model.entities.UsuarioEntity;
import com.umanizales.api_batalla_naval.repository.BarcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BarcoService {
    private BarcoRepository barcoRepository;
    @Autowired
    public BarcoService(BarcoRepository barcoRepository) {
        this.barcoRepository = barcoRepository;
    }

    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(new RespuestaDTO("EXITOSO",
                barcoRepository.findAll(), null), HttpStatus.OK);
    }
    public ResponseEntity<Object> createbarco(Barco barco)
    {
        try {
            //Consultar si ya existe un barco con ese numero de casillas
            Barco barcoConsulta = barcoRepository.encontrarBarcoPorNumeroDeCasillas(barco.getNumeroCasillas());
            if (barcoConsulta == null){
                //verificar que el numero de casillas no sea negativo
                if(barco.getNumeroCasillas() < 0)
                {
                    return new ResponseEntity<>(new RespuestaDTO("ERROR",
                            null, "El numero de casillas no puede ser negativo"), HttpStatus.CONFLICT);
                }
                else
                {
                    Barco barcoSave = barcoRepository.save(barco);
                    return new ResponseEntity<>(new RespuestaDTO("EXITOSO",
                            barcoSave, null), HttpStatus.OK);
                }
            }
            else
            {
                return new ResponseEntity<>(new RespuestaDTO("ERROR",
                        null, "Ya existe un barco con ese numero de casillas"), HttpStatus.CONFLICT);
            }
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(new RespuestaDTO("ERROR",
                    null, "Ocurrio un error con el barco"), HttpStatus.CONFLICT);
        }
    }
    //Metodo para actualizar informacion de un barco
    public ResponseEntity<Object> updateBarco(Barco barco){
        if(barcoRepository .existsById(barco.getId()))
        {
            try {
                Barco barcoAlmacenado=barcoRepository.save(barco);
                if(barco.getNumeroCasillas() < 0)
                {
                    return new ResponseEntity<>(new RespuestaDTO("ERROR",
                            null, "El numero de casillas no puede ser negativo"), HttpStatus.CONFLICT);
                }
                return new ResponseEntity<>(
                        new RespuestaDTO("Actualizado con extio",barcoAlmacenado
                                ,null),HttpStatus.ACCEPTED);
            }
            catch (Exception ex)
            {
                return new ResponseEntity<>(
                        new RespuestaDTO("no se pudo actualizar",
                                null
                                ,ex.getMessage()),HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<>(
                new RespuestaDTO("no se encontro el id",
                        null
                        ,"Error"),HttpStatus.NOT_FOUND);

    }
    //Meotodo para borrar barcos  en la base de datos
    public ResponseEntity<Object> deleteBarco(int id){
        if(barcoRepository.existsById(id))
        {
            barcoRepository.deleteById(id);
            return new ResponseEntity<>(
                    new RespuestaDTO("borrado con exito",id
                            ,null),HttpStatus.OK);
        }
        return new ResponseEntity<>(
                new RespuestaDTO("No se borro",
                        null
                        ,"error"),HttpStatus.NOT_FOUND);
    }
}
