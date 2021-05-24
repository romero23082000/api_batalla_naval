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
}
