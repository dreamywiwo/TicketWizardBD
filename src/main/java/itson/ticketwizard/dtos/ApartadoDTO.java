/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.dtos;

import java.sql.Date;

/**
 *
 * @author Dana Chavez
 */
public class ApartadoDTO {
    
    private Integer idApartado;
    private Date fechaHora;
    private Integer idTransaccion;

    public ApartadoDTO(Integer idApartado, Date fechaHora, Integer idTransaccion) {
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
    
    
    
}
