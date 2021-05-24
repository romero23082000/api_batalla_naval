package com.umanizales.api_batalla_naval.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ListaDE implements Serializable {
    private NodoDE cabeza;
    private int count;

    public void adicionarNodo(Object dato){
        if(cabeza == null){
            cabeza = new NodoDE(dato);
        }
        else
        {
            //llamar a mi ayudante y ubicarme en el ultimo
            NodoDE temp = cabeza;
            while (temp.getSiguiente()!=null)
            {
                temp = temp.getSiguiente();
            }
            //parada en el ultimo
            temp.setSiguiente(new NodoDE(dato));
            temp.getSiguiente().setAnterior(temp);
        }
        count++;
    }
    public void adicionarNodoAlInicio(Object dato){

    }

}
