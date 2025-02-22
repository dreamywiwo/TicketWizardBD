/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.dtos;

/**
 *
 * @author Dana Chavez
 */
public class DireccionUsuarioDTO {
    
    private Integer idDireccionUsuario;
    private String calle;
    private String numeroCasa;
    private String colonia;
    private String codigoPostal;

    public DireccionUsuarioDTO(Integer idDireccionUsuario, String calle, String numeroCasa, String colonia, String codigoPostal) {
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
    
}
