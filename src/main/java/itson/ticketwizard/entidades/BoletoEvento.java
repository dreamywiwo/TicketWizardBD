/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

/**
 *
 * @author leoca
 */
public class BoletoEvento {

    private Integer numSerie;
    private float precio;
    private String disponibilidad;
    private String tipo;
    private Integer numAsiento;
    private String fila;
    private Integer idEvento;
    private String nombreEvento;
    private Date fechaEvento;
    private Time horaEvento;
    private String ciudad;
    private String nombreLocal;

    public BoletoEvento() {
    }

    public BoletoEvento(float precio, String disponibilidad, String tipo, Integer numAsiento, String fila, String nombreEvento, Date fechaEvento, Time horaEvento, String ciudad, String nombreLocal) {
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.tipo = tipo;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.ciudad = ciudad;
        this.nombreLocal = nombreLocal;
    }

    public BoletoEvento(Integer numSerie, float precio, String disponibilidad, String tipo, Integer numAsiento, String fila, Integer idEvento, String nombreEvento, Date fechaEvento, Time horaEvento, String ciudad, String nombreLocal) {
        this.numSerie = numSerie;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.tipo = tipo;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.ciudad = ciudad;
        this.nombreLocal = nombreLocal;
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

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public Time getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(Time horaEvento) {
        this.horaEvento = horaEvento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.numSerie);
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
        final BoletoEvento other = (BoletoEvento) obj;
        return Objects.equals(this.numSerie, other.numSerie);
    }

    @Override
    public String toString() {
        return "BoletoEvento{" + "numSerie=" + numSerie + ", precio=" + precio + ", disponibilidad=" + disponibilidad + ", tipo=" + tipo + ", numAsiento=" + numAsiento + ", fila=" + fila + ", idEvento=" + idEvento + ", nombreEvento=" + nombreEvento + ", fechaEvento=" + fechaEvento + ", horaEvento=" + horaEvento + ", ciudad=" + ciudad + ", nombreLocal=" + nombreLocal + '}';
    }
    
    
    
    
}
