package com.umanizales.api_batalla_naval.service;

import com.umanizales.api_batalla_naval.model.ListaDE;
import com.umanizales.api_batalla_naval.model.NodoDE;
import com.umanizales.api_batalla_naval.model.dto.DistribuicionBarcoDTO;
import com.umanizales.api_batalla_naval.model.dto.RespuestaDTO;
import com.umanizales.api_batalla_naval.model.entities.Barco;
import com.umanizales.api_batalla_naval.model.utilities.Messages;
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
        return new ResponseEntity<>(new RespuestaDTO(Messages.SUCCESSFUL,Messages.BOARD_ADITION
                , null), HttpStatus.OK);
    }
    public ResponseEntity<Object> visualizarListaDE(){
        return new ResponseEntity<>(new RespuestaDTO(Messages.SUCCESSFUL,listarDatos()
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
    public Barco encontrarBarcoCodigo(int id){
        return (Barco) this.listaBarcos.EncontrarDatoPorCodigo(id);
    }
}
