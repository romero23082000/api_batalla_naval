package com.umanizales.api_batalla_naval.model.dto;

import com.umanizales.api_batalla_naval.model.entities.Barco;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DistribuicionBarcoDTO implements Serializable {
    private Barco barco;
    private byte orientacion;
    private String estado; //estado= tocado, hundido, intacto
    private CoordenadaDTO[] casillas;

    public DistribuicionBarcoDTO(Barco barco) {
        this.barco = barco;
        this.estado = "intacto";
    }

    public void definirUbicacion(int x, int y, byte orientacion){
        this.casillas = new CoordenadaDTO[barco.getNumeroCasillas()];
        for (int i = 0; i<casillas.length; i++)
        {
            //TODO verificar que la coordenada este libre
            casillas[i]=new CoordenadaDTO(x,y,false);
            if (orientacion==1)//horizontal
            {
                x++;
            }
            else //vertical
            {
                y++;
            }
        }
    }

    public boolean validarExistenciaCoordenada(CoordenadaDTO coordenadaDTO){
    if (casillas != null){
        for (CoordenadaDTO coord : casillas){
            if (coord.equals(casillas)){
                return true;
            }
        }
    }
    return false;
    }

    public CoordenadaDTO[] sugerirUbicacion(int x, int y, byte orientacion){
        CoordenadaDTO[] casillasSugeridas = new CoordenadaDTO[barco.getNumeroCasillas()];
        for (int i = 0; i<casillasSugeridas.length; i++)
        {
            //TODO verificar que la coordenada este libre
            casillas[i]=new CoordenadaDTO(x,y,false);
            if (orientacion==1)//horizontal
            {
                x++;
            }
            else //vertical
            {
                y++;
            }
        }
        return casillasSugeridas;
    }
    public void definirUbicacion(CoordenadaDTO[] coordenadas){
            this.casillas = coordenadas;
    }

}
