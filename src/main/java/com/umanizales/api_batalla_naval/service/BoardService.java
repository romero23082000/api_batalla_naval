package com.umanizales.api_batalla_naval.service;

import com.umanizales.api_batalla_naval.model.Tablero;
import com.umanizales.api_batalla_naval.model.dto.CasillaBarco;
import com.umanizales.api_batalla_naval.model.dto.RespuestaDTO;
import com.umanizales.api_batalla_naval.model.entities.Barco;
import com.umanizales.api_batalla_naval.model.utilities.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.JobKOctets;

@Service
public class BoardService {
    private Tablero tablero;
    private ListaDEService listaDEService;


    public ResponseEntity<Object> createBoard(int count){
        tablero = new Tablero();
        tablero.setNumElementos(count);
        if(tablero.getNumElementos() < 0)
        {
            return new ResponseEntity<>(
                    new RespuestaDTO(Messages.ERROR_ELEMENTS_NEGATIVE, null, null), HttpStatus.CONFLICT);
        }
        else{
            if (tablero.getNumElementos() <= 9) {
                tablero.setCasillas(new CasillaBarco[10][10]);
                return new ResponseEntity<>(
                        new RespuestaDTO(Messages.SUCCESSFUL, null, null), HttpStatus.CREATED);
            }
            if (count >= 10 && count <= 20) {
                tablero.setCasillas(new CasillaBarco[20][20]);
                return new ResponseEntity<>(
                        new RespuestaDTO(Messages.SUCCESSFUL, null, null), HttpStatus.CREATED);
            }
            if (count > 20) {
                tablero.setCasillas(new CasillaBarco[30][30]);
                return new ResponseEntity<>(
                        new RespuestaDTO(Messages.SUCCESSFUL, null, null), HttpStatus.CREATED);
            }
             else {
                return new ResponseEntity<>(
                        new RespuestaDTO(Messages.MESSAGE_BOARD_VOID, null,
                                Messages.ERROR_BOARD_VOID)
                        , HttpStatus.CONFLICT);
            }
        }
    }
    public ResponseEntity<Object> seeBoard(){
        if (tablero == null) {
            return new ResponseEntity<>(
                    new RespuestaDTO(Messages.MESSAGE_BOARD_VOID, null,
                            Messages.ERROR_BOARD_VOID)
                    , HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(
                    new RespuestaDTO(Messages.SUCCESSFUL, tablero, null), HttpStatus.OK);
        }
    }

    /*public ResponseEntity<Object> ubicarBarco(Barco barco, int x, int y, boolean orientacion){

        if (y < tablero.getCasillas().length && y >= 0 && x >=0 && x < tablero.getCasillas()[0].length)
        {
            if (orientacion)
            {
                for (int i=y; i < (y+barco.getNumeroCasillas()); i++)
                {
                    tablero.setCasillas(new CasillaBarco[x][i]);
                    if (tablero.getCasillas() != null){

                    }
                    else
                    {
                        break;
                    }
                }
            }
            else
            {
                //El barco al ponerlo supera el tablero

            }
        }
        else
        {
            // horizontal

        }

    }*/

}
