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
 * @author Dana Chavez
 */
public class Evento {
    
    private Integer idEvento;
    private String nombreEvento;
    private String nombreLocal;
    private String calle;
    private String colonia;
    private String codigoPostal;
    private String descripcion;
    private Date fechaEvento;
    private Time horaEvento;

    public Evento() {
    }

    public Evento(String nombreEvento, String nombreLocal, String calle, String colonia, String codigoPostal, String descripcion, Date fechaEvento, Time horaEvento) {
        this.nombreEvento = nombreEvento;
        this.nombreLocal = nombreLocal;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
    }

    public Evento(Integer idEvento, String nombreEvento, String nombreLocal, String calle, String colonia, String codigoPostal, String descripcion, Date fechaEvento, Time horaEvento) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.nombreLocal = nombreLocal;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.idEvento);
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
        final Evento other = (Evento) obj;
        return Objects.equals(this.idEvento, other.idEvento);
    }

    @Override
    public String toString() {
        return "Evento{" + "idEvento=" + idEvento + 
                ", nombreEvento=" + nombreEvento + 
                ", nombreLocal=" + nombreLocal + 
                ", descripcion=" + descripcion + 
                ", fechaEvento=" + fechaEvento + 
                ", horaEvento=" + horaEvento + '}';
    }   
    
}
