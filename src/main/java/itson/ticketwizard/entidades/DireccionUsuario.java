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
public class DireccionUsuario {
    
    private Integer idDireccionUsuario;
    private String calle;
    private String numeroCasa;
    private String colonia;
    private String codigoPostal;

    public DireccionUsuario() {
    }

    public DireccionUsuario(String calle, String numeroCasa, String colonia, String codigoPostal) {
        this.calle = calle;
        this.numeroCasa = numeroCasa;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public DireccionUsuario(Integer idDireccionUsuario, String calle, String numeroCasa, String colonia, String codigoPostal) {
        this.idDireccionUsuario = idDireccionUsuario;
        this.calle = calle;
        this.numeroCasa = numeroCasa;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public Integer getIdDireccionUsuario() {
        return idDireccionUsuario;
    }

    public void setIdDireccionUsuario(Integer idDireccionUsuario) {
        this.idDireccionUsuario = idDireccionUsuario;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
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
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idDireccionUsuario);
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
        final DireccionUsuario other = (DireccionUsuario) obj;
        return Objects.equals(this.idDireccionUsuario, other.idDireccionUsuario);
    }

    @Override
    public String toString() {
        return "DireccionesUsuarios{" + "idDireccionUsuario=" + 
                idDireccionUsuario + ", calle=" + calle + 
                ", numeroCasa=" + numeroCasa + 
                ", colonia=" + colonia + 
                ", codigoPostal=" + codigoPostal + '}';
    }
    
    
    
}
