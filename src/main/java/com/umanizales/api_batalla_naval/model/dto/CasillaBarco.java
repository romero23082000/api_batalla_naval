package com.umanizales.api_batalla_naval.model.dto;

import com.umanizales.api_batalla_naval.model.entities.Barco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class CasillaBarco implements Serializable {
    private Barco barco;
    private boolean marcada;


}
