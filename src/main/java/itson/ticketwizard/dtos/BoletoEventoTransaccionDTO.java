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
public class BoletoEventoTransaccionDTO {
    
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

    public BoletoEventoTransaccionDTO(Integer numSerie, String tipo, Integer numAsiento, String fila, String nombreEvento, String nombreLocal, String descripcion, Date fechaEvento, Time horaEvento, String ciudad, Integer idTransaccion, Date fechaHora) {
        this.numSerie = numSerie;
        this.tipo = tipo;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.nombreEvento = nombreEvento;
        this.nombreLocal = nombreLocal;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.horaEvento = horaEvento;
        this.ciudad = ciudad;
        this.idTransaccion = idTransaccion;
        this.fechaHora = fechaHora;
    }

    public BoletoEventoTransaccionDTO(Integer numSerie, float precio, String tipo, Integer numAsiento, String fila, Integer idEvento, String nombreEvento, String nombreLocal, String descripcion, Date fechaEvento, Time horaEvento, String ciudad, String calle, String colonia, Integer idTransaccion, Date fechaHora, float monto, Integer idVendedor, Integer idComprador) {
        this.numSerie = numSerie;
        this.precio = precio;
        this.tipo = tipo;
        this.numAsiento = numAsiento;
        this.fila = fila;
        this.idEvento = idEvento;
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
    
    
    
}
