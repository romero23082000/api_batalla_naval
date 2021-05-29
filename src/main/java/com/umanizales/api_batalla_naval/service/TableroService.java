package com.umanizales.api_batalla_naval.service;

import com.umanizales.api_batalla_naval.model.ListaDE;
import com.umanizales.api_batalla_naval.model.dto.CasillaBarco;
import com.umanizales.api_batalla_naval.model.dto.CoordenadaDTO;
import com.umanizales.api_batalla_naval.model.dto.RespuestaDTO;
import com.umanizales.api_batalla_naval.model.dto.SelecTablero;
import com.umanizales.api_batalla_naval.model.entities.UsuarioEntity;
import com.umanizales.api_batalla_naval.model.utilities.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableroService
{
    private int id;
    private UsuarioEntity usuarioEntity;
    private boolean estadoTablero;
    private ListaDE listaBarco;
    private UsuarioEntity jugador;
    private List<CoordenadaDTO> disparosRecibidos;
    private CasillaBarco[][] tableroBarco;
    private SelecTablero selecTablero;



    public ResponseEntity<Object> createTablero(int count){
        if (count < 0)
        {
            return new ResponseEntity<>(
                    new RespuestaDTO(Messages.ERROR_ELEMENTS_NEGATIVE, null,
                            Messages.ERROR_ELEMENTS_NEGATIVE)
                    , HttpStatus.CONFLICT);
        }
        else{
            if (count <= 9) {
                tableroBarco = new CasillaBarco[10][10];
                return new ResponseEntity<>(
                        new RespuestaDTO(Messages.SUCCESSFUL, null, null), HttpStatus.CREATED);
            }
            if (count >= 10 && count <= 20) {
                tableroBarco = new CasillaBarco[20][20];
                return new ResponseEntity<>(
                        new RespuestaDTO(Messages.SUCCESSFUL, null, null), HttpStatus.CREATED);
            }
            if (count > 20) {
                tableroBarco = new CasillaBarco[30][30];
                return new ResponseEntity<>(
                        new RespuestaDTO(Messages.SUCCESSFUL, null, null), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        new RespuestaDTO(Messages.MESSAGE_BOARD_VOID, null,
                                Messages.ERROR_BOARD_VOID)
                        , HttpStatus.CONFLICT);
            }
        }

    }
    public ResponseEntity<Object> seeTablero(){
        if (tableroBarco == null) {
            return new ResponseEntity<>(
                    new RespuestaDTO(Messages.MESSAGE_BOARD_VOID, null,
                            Messages.ERROR_BOARD_VOID)
                    , HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(
                    new RespuestaDTO(Messages.SUCCESSFUL, tableroBarco, null), HttpStatus.OK);
        }
    }
}
