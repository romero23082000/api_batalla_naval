package com.umanizales.api_batalla_naval.model.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Barco implements Serializable {
    private int id;
    private String nombre;
    private short numeroCasillas;

    @Id
    @Column(name = "id", nullable = false)
    //Se genera autonumericamente el id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 30)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "numero_casillas", nullable = false)
    public short getNumeroCasillas() {
        return numeroCasillas;
    }

    public void setNumeroCasillas(short numeroCasillas) {
        this.numeroCasillas = numeroCasillas;
    }

    @Override
    public String toString() {
        return "Barco{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numeroCasillas=" + numeroCasillas +
                '}';
    }
}
