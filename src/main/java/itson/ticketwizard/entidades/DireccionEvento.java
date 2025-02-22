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
public class DireccionEvento {
    
    private Integer idDireccionEvento;
    private String nombreLocal;
    private String calle;
    private String colonia;
    private String codigoPostal;

    public DireccionEvento() {
    }

    public DireccionEvento(String nombreLocal, String calle, String colonia, String codigoPostal) {
        this.nombreLocal = nombreLocal;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public DireccionEvento(Integer idDireccionEvento, String nombreLocal, String calle, String colonia, String codigoPostal) {
        this.idDireccionEvento = idDireccionEvento;
        this.nombreLocal = nombreLocal;
        this.calle = calle;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public Integer getIdDireccionEvento() {
        return idDireccionEvento;
    }

    public void setIdDireccionEvento(Integer idDireccionEvento) {
        this.idDireccionEvento = idDireccionEvento;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idDireccionEvento);
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
        final DireccionEvento other = (DireccionEvento) obj;
        return Objects.equals(this.idDireccionEvento, other.idDireccionEvento);
    }

    @Override
    public String toString() {
        return "DireccionesEventos{" + "idDireccionEvento=" + idDireccionEvento + 
                ", nombreLocal=" + nombreLocal + 
                ", calle=" + calle + 
                ", colonia=" + colonia + 
                ", codigoPostal=" + codigoPostal + '}';
    }
    
    
    
}
