package com.umanizales.api_batalla_naval.model;

import com.umanizales.api_batalla_naval.model.dto.CasillaBarco;
import com.umanizales.api_batalla_naval.model.entities.Barco;
import com.umanizales.api_batalla_naval.model.entities.UsuarioEntity;
import lombok.Data;

import java.io.Serializable;
@Data
public class Tablero implements Serializable {
    private CasillaBarco[][] casillas;
    private UsuarioEntity jugador;
    private int numElementos;

    /*public void crearTablero(int x, int y){
        casillas = new CasillaBarco[x][y];
    }*/

    /*public void posicionarBarco(Barco barco, int x, int y, boolean orientacion){
        if (y < casillas.length && y >= 0 && x >=0 && x < casillas[0].length)
        {
            //el valor de x esta dentro del tablero
            if (orientacion)
            {
                //vertical
                if (y+ barco.getNumeroCasillas() < casillas.length)
                {
                    for (int i=y; i < (y+barco.getNumeroCasillas()); i++)
                    {
                        if(casillas[x][i].getBarco()!=null){
                            casillas[x][i].setBarco(barco);
                        }
                        else
                        {
                            //hay un barco en la casilla
                            break;
                        }
                    }
                }
                else
                {
                    //el barco al ponerlo supera el tablero
                    //no lo puedo posicionar
                }
            }
            else
            {
                //horizontal
            }
        }
    }*/
}
