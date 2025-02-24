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
 * @author leoca
 */
public class BoletoEventoTransaccion {
    
    private Integer numSerie;
    private float precio;
    private String tipo;
    private Integer numAsiento;
    private String fila;
    private Integer idEvento;
    private Integer idUsuario;

    private String nombreEvento;
    private String nombreLocal;
    private String descripcion;
    private Date fechaEvento;
    private Time horaEvento;
    private String ciudad;
    private String calle;
    private String colonia;
    
    private Integer idTransaccion;
    private Date fechaHora;
    private float monto;
    private float comision;
    private Integer idVendedor;
    private Integer idComprador;

    public BoletoEventoTransaccion() {
    }

    public BoletoEventoTransaccion(float precio, String tipo, Integer numAsiento, String fila, Integer idUsuario, String nombreEvento, String nombreLocal, String descripcion, Date fechaEvento, Time horaEvento, String ciudad, String calle, String colonia, Date fechaHora, float monto, float comision, Integer idVendedor, Integer idComprador) {
        this.precio = precio;
        this.tipo = tipo;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.idUsuario = idUsuario;
        this.nombreEvento = nombreEvento;
        this.nombreLocal = nombreLocal;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.ciudad = ciudad;
        this.calle = calle;
        this.colonia = colonia;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.comision = comision;
        this.idVendedor = idVendedor;
        this.idComprador = idComprador;
    }

    public BoletoEventoTransaccion(int numSerie, String tipo, Integer numAsiento, String fila, Integer idEvento, Integer idUsuario, String nombreEvento, String nombreLocal, String descripcion, Date fechaEvento, Time horaEvento, String ciudad, String calle, String colonia, Integer idTransaccion, Date fechaHora, float monto, float comision, Integer idVendedor, Integer idComprador) {
        this.numSerie = numSerie;
        this.tipo = tipo;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
        this.nombreEvento = nombreEvento;
        this.nombreLocal = nombreLocal;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.ciudad = ciudad;
        this.calle = calle;
        this.colonia = colonia;
        this.idTransaccion = idTransaccion;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.comision = comision;
        this.idVendedor = idVendedor;
        this.idComprador = idComprador;
    }

    
    
    public Integer getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Integer numSerie) {
        this.numSerie = numSerie;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(Integer numAsiento) {
        this.numAsiento = numAsiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.numSerie);
        hash = 97 * hash + Objects.hashCode(this.idEvento);
        hash = 97 * hash + Objects.hashCode(this.idTransaccion);
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
        final BoletoEventoTransaccion other = (BoletoEventoTransaccion) obj;
        if (!Objects.equals(this.numSerie, other.numSerie)) {
            return false;
        }
        return Objects.equals(this.idEvento, other.idEvento);
    }

    @Override
    public String toString() {
        return "BoletoEventoTransaccion{" + "numSerie=" + numSerie + ", precio=" + precio + ", tipo=" + tipo + ", numAsiento=" + numAsiento + ", fila=" + fila + ", idEvento=" + idEvento + ", idUsuario=" + idUsuario + ", nombreEvento=" + nombreEvento + ", nombreLocal=" + nombreLocal + ", descripcion=" + descripcion + ", fechaEvento=" + fechaEvento + ", horaEvento=" + horaEvento + ", ciudad=" + ciudad + ", calle=" + calle + ", colonia=" + colonia + ", idTransaccion=" + idTransaccion + ", fechaHora=" + fechaHora + ", monto=" + monto + ", comision=" + comision + ", idVendedor=" + idVendedor + ", idComprador=" + idComprador + '}';
    }

    

    
    
    
    
    
}
