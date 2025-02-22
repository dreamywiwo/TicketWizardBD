/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

import java.util.Objects;

/**
 *
 * @author Dana Chavez
 */
public class Boleto {
    
    private Integer numSerie;
    private float precio;
    private Integer numControl;
    private String disponibilidad;
    private Integer numAsiento;
    private String fila;
    private Integer idEvento;
    private Integer idUsuario;

    public Boleto() {
    }

    public Boleto(float precio, Integer numControl, String disponibilidad, Integer numAsiento, String fila, Integer idEvento, Integer idUsuario) {
        this.precio = precio;
        this.numControl = numControl;
        this.disponibilidad = disponibilidad;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
    }

    public Boleto(Integer numSerie, float precio, Integer numControl, String disponibilidad, Integer numAsiento, String fila, Integer idEvento, Integer idUsuario) {
        this.numSerie = numSerie;
        this.precio = precio;
        this.numControl = numControl;
        this.disponibilidad = disponibilidad;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
    }

    public Integer getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Integer numSerie) {
        this.numSerie = numSerie;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Integer getNumControl() {
        return numControl;
    }

    public void setNumControl(Integer numControl) {
        this.numControl = numControl;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Integer getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(Integer numAsiento) {
        this.numAsiento = numAsiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.numSerie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Boleto other = (Boleto) obj;
        return Objects.equals(this.numSerie, other.numSerie);
    }

    @Override
    public String toString() {
        return "Boleto{" + "numSerie=" + numSerie + 
                ", precio=" + precio + 
                ", numControl=" + numControl + 
                ", disponibilidad=" + disponibilidad + 
                ", numAsiento=" + numAsiento + 
                ", fila=" + fila + 
                ", idEvento=" + idEvento + 
                ", idUsuario=" + idUsuario + '}';
    }
            
    
}
