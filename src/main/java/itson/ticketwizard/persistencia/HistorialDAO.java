/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.entidades.Historial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dana Chavez
 */
public class HistorialDAO {
    private ManejadorConexiones manejadorConexiones;

    public HistorialDAO(ManejadorConexiones manejadorConexiones) {
        this.manejadorConexiones = manejadorConexiones;
    }
    
    
    
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
        String codigoSQL = """
                           INSERT(idTransaccion, numSerie)
                           VALUES(?,?);
                           """;
        
        try{
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
       
            comando.setInt(1, idTransaccion);
            comando.setInt(2, numSerie);
            int filasAfectadas = comando.executeUpdate();
            
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
       
        return false;
        
    }
    
    
}
