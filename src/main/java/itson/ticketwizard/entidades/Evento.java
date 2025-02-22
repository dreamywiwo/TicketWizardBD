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
    private String descripcion;
    private Date fechaEvento;
    private Time horaEvento;
    private DireccionEvento direccionEvento;

    public Evento() {
    }

    public Evento(String nombreEvento, String nombreLocal, String descripcion, Date fechaEvento, Time horaEvento, DireccionEvento direccionEvento) {
        this.nombreEvento = nombreEvento;
        this.nombreLocal = nombreLocal;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.direccionEvento = direccionEvento;
    }

    public Evento(Integer idEvento, String nombreEvento, String nombreLocal, String descripcion, Date fechaEvento, Time horaEvento, DireccionEvento direccionEvento) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.nombreLocal = nombreLocal;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.direccionEvento = direccionEvento;
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

    public DireccionEvento getDireccionEvento() {
        return direccionEvento;
    }

    public void setDireccionEvento(DireccionEvento direccionEvento) {
        this.direccionEvento = direccionEvento;
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
                ", horaEvento=" + horaEvento + 
                ", direccionEvento=" + direccionEvento + '}';
    }   
    
}
