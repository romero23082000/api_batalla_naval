package com.umanizales.api_batalla_naval.service;

import com.umanizales.api_batalla_naval.model.ListaDE;
import com.umanizales.api_batalla_naval.model.NodoDE;
import com.umanizales.api_batalla_naval.model.dto.DistribuicionBarcoDTO;
import com.umanizales.api_batalla_naval.model.dto.RespuestaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListaDEService {
    private ListaDE listaBarcos;

    public ListaDEService() {
        listaBarcos = new ListaDE();
    }

    public ResponseEntity<Object> adicionarBarco(DistribuicionBarcoDTO distribucion){
        listaBarcos.adicionarNodo(distribucion);
        return new ResponseEntity<>(new RespuestaDTO("EXITOSO","barco adicionado"
                , null), HttpStatus.OK);
    }
    public ResponseEntity<Object> visualizarListaDE(){
        return new ResponseEntity<>(new RespuestaDTO("EXITOSO",listarDatos()
                , null), HttpStatus.OK);
    }

    public List<DistribuicionBarcoDTO> listarDatos(){
        List<DistribuicionBarcoDTO> listado = new ArrayList<>();
        //ciclo para recorrer la lista de principio a fin
        NodoDE temp = listaBarcos.getCabeza();
        while (temp!=null){
            listado.add((DistribuicionBarcoDTO) temp.getDato());
            temp = temp.getSiguiente();
        }
        return listado;
    }
}
