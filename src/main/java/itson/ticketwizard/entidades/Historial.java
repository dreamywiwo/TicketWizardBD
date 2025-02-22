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
public class Historial {
    
    private Integer idRegistro;
    private Integer idTransaccion;
    private Integer numSerie;

    public Historial() {
    }

    public Historial(Integer idTransaccion, Integer numSerie) {
        this.idTransaccion = idTransaccion;
        this.numSerie = numSerie;
    }

    public Historial(Integer idRegistro, Integer idTransaccion, Integer numSerie) {
        this.idRegistro = idRegistro;
        this.idTransaccion = idTransaccion;
        this.numSerie = numSerie;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Integer getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Integer numSerie) {
        this.numSerie = numSerie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idRegistro);
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
        final Historial other = (Historial) obj;
        return Objects.equals(this.idRegistro, other.idRegistro);
    }

    @Override
    public String toString() {
        return "Historial{" + "idRegistro=" + idRegistro + 
                ", idTransaccion=" + idTransaccion + 
                ", numSerie=" + numSerie + '}';
    }
    
    
}
