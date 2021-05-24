package com.umanizales.api_batalla_naval.repository;

import com.umanizales.api_batalla_naval.model.entities.Barco;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BarcoRepository extends CrudRepository<Barco, Integer> {

    @Query("SELECT barco FROM Barco barco WHERE barco.numeroCasillas=?1")//jql sql pero en java
    Barco encontrarBarcoPorNumeroDeCasillas(short numeroCasillas);



}
