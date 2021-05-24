package com.umanizales.api_batalla_naval.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class NodoDE implements Serializable {
    private Object dato;
    private NodoDE siguiente;
    private NodoDE anterior;

    public NodoDE(Object dato) {
        this.dato = dato;
    }
}
