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
public class Usuario {
    
    private Integer idUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String numTelefono;
    private String correoElectronico;
    private String contrasena;
    private float saldo;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String numTelefono, String correoElectronico, String contrasena, float saldo) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.numTelefono = numTelefono;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.saldo = saldo;
    }

    public Usuario(Integer idUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String numTelefono, String correoElectronico, String contrasena, float saldo) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.numTelefono = numTelefono;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.saldo = saldo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idUsuario);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.idUsuario, other.idUsuario);
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + 
                ", nombres=" + nombres + 
                ", apellidoPaterno=" + apellidoPaterno + 
                ", apellidoMaterno=" + apellidoMaterno + 
                ", fechaNacimiento=" + fechaNacimiento + 
                ", numTelefono=" + numTelefono + 
                ", correoElectronico=" + correoElectronico + 
                ", contrasena=" + contrasena + 
                ", saldo=" + saldo + '}';
    }
    
    
    
}
