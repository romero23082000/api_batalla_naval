package com.umanizales.api_batalla_naval.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class CoordenadaDTO implements Serializable {
    private int x;
    private int y;
    private boolean estado;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof  CoordenadaDTO)
        {
            //no se comporte como un object si no como una coordenada esto es POLIMORFISMO
            CoordenadaDTO objDTO = (CoordenadaDTO) obj;
            if (this.x == objDTO.x && this.y == objDTO.y)
            {

            }
        }
        return false;
    }
}
