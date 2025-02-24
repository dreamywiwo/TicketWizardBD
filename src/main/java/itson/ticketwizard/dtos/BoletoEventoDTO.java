/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.dtos;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Dana Chavez
 */
public class BoletoEventoDTO {
    
    private Integer numSerie;
    public double precio;
    private String disponibilidad;
    public String tipo;
    public Integer numAsiento;
    public String fila;
    private Integer idEvento;
    private String nombreEvento;
    private Date fechaEvento;
    private Time horaEvento;
    public String ciudad;
    public String nombreLocal;

    public BoletoEventoDTO(Integer numSerie, double precio, String disponibilidad, String tipo, Integer numAsiento, String fila, Integer idEvento, String nombreEvento, Date fechaEvento, Time horaEvento, String ciudad, String nombreLocal) {
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

    public BoletoEventoDTO(double precio, String disponibilidad, String tipo, int numAsiento, String fila, String nombreEvento, Date fechaEvento, Time horaEvento, String ciudad, String nombreLocal) {
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.tipo= tipo;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.ciudad = ciudad;
        this.nombreLocal = nombreLocal;
    }
    
    public BoletoEventoDTO(double precio, String disponibilidad, String tipo, int numAsiento, String fila,Integer idEvento, String nombreEvento, Date fechaEvento, Time horaEvento, String ciudad, String nombreLocal) {
        this.precio = precio;
        this.disponibilidad = disponibilidad;
        this.tipo= tipo;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.ciudad = ciudad;
        this.nombreLocal = nombreLocal;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
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
    public String toString() {
        return "BoletoEventoDTO{" + "numSerie=" + numSerie + ", precio=" + precio + ", disponibilidad=" + disponibilidad + ", tipo=" + tipo + ", numAsiento=" + numAsiento + ", fila=" + fila + ", idEvento=" + idEvento + ", nombreEvento=" + nombreEvento + ", fechaEvento=" + fechaEvento + ", horaEvento=" + horaEvento + ", ciudad=" + ciudad + ", nombreLocal=" + nombreLocal + '}';
    }
    
    
    
}
