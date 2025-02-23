/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.persistencia.ApartadoDAO;

/**
 *
 * @author payde
 */
public class ApartadoControl {  
    private ApartadoDAO apartadoDAO;

    
    public ApartadoControl(ApartadoDAO apartadoDAO) {
        this.apartadoDAO = apartadoDAO;
    }

    public boolean registrarApartado(Integer numSerie, Integer idUsuario) {
        if (numSerie == null || numSerie <= 0) {
            throw new IllegalArgumentException("El número de serie debe ser mayor que cero y no nulo.");
        }
        if (idUsuario == null || idUsuario <= 0) {
            throw new IllegalArgumentException("El identificador del usuario debe ser mayor que cero y no nulo.");
        }
        
        return apartadoDAO.registrarApartado(numSerie, idUsuario);
    }
    
    
    public boolean eliminarApartado(int idApartado) {
        if (idApartado <= 0) {
            throw new IllegalArgumentException("El identificador del apartado debe ser mayor que cero.");
        }
        
        return apartadoDAO.eliminarApartado(idApartado);
    }
}




