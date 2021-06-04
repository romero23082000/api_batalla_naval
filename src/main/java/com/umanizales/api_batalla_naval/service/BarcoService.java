package com.umanizales.api_batalla_naval.service;

import com.umanizales.api_batalla_naval.model.dto.RespuestaDTO;
import com.umanizales.api_batalla_naval.model.entities.Barco;
import com.umanizales.api_batalla_naval.model.entities.UsuarioEntity;
import com.umanizales.api_batalla_naval.model.utilities.Messages;
import com.umanizales.api_batalla_naval.repository.BarcoRepository;
import org.aspectj.bridge.Message;
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
        return new ResponseEntity<>(new RespuestaDTO(Messages.SUCCESSFUL,
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
                    return new ResponseEntity<>(new RespuestaDTO(Messages.MESSAGE_BOXES_NEGATIVE,
                            null, Messages.ERROR_BOXES_NEGATIVE), HttpStatus.CONFLICT);
                }
                else
                {
                    Barco barcoSave = barcoRepository.save(barco);
                    return new ResponseEntity<>(new RespuestaDTO(Messages.SUCCESSFUL,
                            barcoSave, null), HttpStatus.OK);
                }
            }
            else
            {
                return new ResponseEntity<>(new RespuestaDTO(Messages.MESSAGE_NUM_BOX_REPEAT,
                        null, Messages.ERROR_NUM_BOX_REPEAT), HttpStatus.CONFLICT);
            }
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(new RespuestaDTO(Messages.DATA_NOT_FOUND,
                    null, Messages.ERROR_DATA_NOT_FOUND), HttpStatus.CONFLICT);
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
                    return new ResponseEntity<>(new RespuestaDTO(Messages.MESSAGE_BOXES_NEGATIVE,
                            null, Messages.ERROR_BOXES_NEGATIVE), HttpStatus.CONFLICT);
                }
                return new ResponseEntity<>(
                        new RespuestaDTO(Messages.SUCCESSFUL,barcoAlmacenado
                                ,null),HttpStatus.ACCEPTED);
            }
            catch (Exception ex)
            {
                return new ResponseEntity<>(
                        new RespuestaDTO(Messages.ERROR_DATA_NOT_FOUND,
                                null
                                ,ex.getMessage()),HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<>(
                new RespuestaDTO(Messages.ERROR_DATA_NOT_FOUND,
                        null
                        ,Messages.ERROR_DATA_NOT_FOUND),HttpStatus.NOT_FOUND);

    }
    //Meotodo para borrar barcos  en la base de datos
    public ResponseEntity<Object> deleteBarco(int id){
        if(barcoRepository.existsById(id))
        {
            barcoRepository.deleteById(id);
            return new ResponseEntity<>(
                    new RespuestaDTO(Messages.SUCCESSFUL,id
                            ,null),HttpStatus.OK);
        }
        return new ResponseEntity<>(
                new RespuestaDTO(Messages.ERROR_BOARD_NOT_DELETE ,
                        null
                        ,Messages.MESSAGE_BOARD_NOT_DELETE),HttpStatus.NOT_FOUND);
    }
}
