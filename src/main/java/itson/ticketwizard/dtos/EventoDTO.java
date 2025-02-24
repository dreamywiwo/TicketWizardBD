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
public class EventoDTO {
    
    private Integer idEvento;
    private String nombreEvento;
    private String nombreLocal;
    private String descripcion;
    private Date fechaEvento;
    private Time horaEvento;
    private String ciudad;
    private String calle;
    private String colonia;
 
    public EventoDTO(Integer idEvento, String nombreEvento, String nombreLocal, String descripcion, Date fechaEvento, Time horaEvento, String ciudad, String calle, String colonia) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.nombreLocal = nombreLocal;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.ciudad = ciudad;
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
    }   
    
    // Constructor filtrado para consultas
    public EventoDTO(String nombreEvento, String nombreLocal, String ciudad, Date fechaEvento, Time horaEvento) {
        this.nombreEvento = nombreEvento;
        this.nombreLocal = nombreLocal;
        this.ciudad = ciudad;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
    }
    
    public EventoDTO (String ciudad, String nombreLocal, Date fechaEvento){
        this.ciudad = ciudad;
        this.nombreLocal = nombreLocal;
        this.fechaEvento = fechaEvento;
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

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getciudad() {
        return ciudad;
    }

    public void setciudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    

    
}
