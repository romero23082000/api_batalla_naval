package com.umanizales.api_batalla_naval.model.dto;

import com.umanizales.api_batalla_naval.model.entities.Barco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class SelecTablero implements Serializable {
    private Barco barco;
    private int numElementos;
}
