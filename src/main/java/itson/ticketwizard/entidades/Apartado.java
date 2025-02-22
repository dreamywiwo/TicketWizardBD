/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.entidades;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Dana Chavez
 */
public class Apartado {
    
    private Integer idApartado;
    private Date fechaHora;
    private Integer idTransaccion;

    public Apartado() {
    }

    public Apartado(Date fechaHora, Integer idTransaccion) {
        this.fechaHora = fechaHora;
        this.idTransaccion = idTransaccion;
    }

    public Apartado(Integer idApartado, Date fechaHora, Integer idTransaccion) {
        this.idApartado = idApartado;
        this.fechaHora = fechaHora;
        this.idTransaccion = idTransaccion;
    }

    public Integer getIdApartado() {
        return idApartado;
    }

    public void setIdApartado(Integer idApartado) {
        this.idApartado = idApartado;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idApartado);
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
        final Apartado other = (Apartado) obj;
        return Objects.equals(this.idApartado, other.idApartado);
    }

    @Override
    public String toString() {
        return "Apartado{" + "idApartado=" + idApartado + 
                ", fechaHora=" + fechaHora + 
                ", idTransaccion=" + idTransaccion + '}';
    }
    
}
