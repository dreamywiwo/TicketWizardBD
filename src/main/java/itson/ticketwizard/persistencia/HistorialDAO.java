/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.entidades.Historial;
import java.util.List;

/**
 *
 * @author Dana Chavez
 */
public class HistorialDAO {
    
    public List<Historial> obtenerHistorialBoletos(Integer idUsuario){
        
        String codigoSQL = """
                           SELECT 
                           	idRegistro,
                           	idTransaccion,
                           	numSerie
                           FROM Historial WHERE numSerie = ?;
                           """;
        return null;
        
    }
    
    public boolean registrarHistorial(Integer idTransaccion, Integer numSerie){
        
        return false;
        
    }
    
    
}
