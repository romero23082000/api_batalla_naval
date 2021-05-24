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
            if (barcoConsulta == null ){
                Barco barcoSave = barcoRepository.save(barco);
                return new ResponseEntity<>(new RespuestaDTO("EXITOSO",
                        barcoSave, null), HttpStatus.OK);
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
}
