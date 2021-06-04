package com.umanizales.api_batalla_naval.model;


import com.umanizales.api_batalla_naval.model.dto.CoordenadaDTO;
import com.umanizales.api_batalla_naval.model.dto.DistribuicionBarcoDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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

    public ListaDE clonarLista(){
        ListaDE listaCopia = new ListaDE();
        NodoDE temp = cabeza;
        while (temp != null){
            listaCopia.adicionarNodo(temp.getDato());
            temp = temp.getSiguiente();
        }
        return listaCopia;
    }
    //metodo para validar la existencia de coordenadas
    public boolean validarExistenciaCoordenadas(CoordenadaDTO[] coordenadaDTO){
        if (cabeza != null)
        {
            NodoDE temp = cabeza;
            while (temp != null)
            {
                for (CoordenadaDTO coord : coordenadaDTO)
                {
                    if(((DistribuicionBarcoDTO) temp.getDato()).validarExistenciaCoordenada(coord)){
                        return true;
                    }
                }

                temp = temp.getSiguiente();
            }
        }
        return false;
    }
    //Metodo para encontrar barco por codigo
    public Object EncontrarDatoPorCodigo(int id){
        if (cabeza != null){
            NodoDE temp=cabeza;
            while (temp!=null){
                if (temp.getDato().equals(id)){
                    return temp.getDato();
                }
                temp = temp.getSiguiente();
            }
        }
        return null;
    }

}
