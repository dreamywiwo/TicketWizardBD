/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Dana Chavez
 */
public class ApartadoDAO {
    private ManejadorConexiones manejadorConexiones;
    
    public boolean registrarApartado(Integer numSerie, Integer idUsuario){
        String codigoSQL = """
                            INSERT INTO(numSerie, idUsuario)
                            VALUES(?,?);
                           """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
       
            comando.setInt(1, numSerie);
            comando.setInt(2, idUsuario);
              
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        return false;
        
    }
    
    public boolean eliminarApartado(int idApartado) {
        String codigoSQL = """
                           DELETE FROM apartados
                           WHERE idApartado = ?;
                           """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            
            comando.setInt(1, idApartado);
            int filasAfectadas = comando.executeUpdate();
            
            if (filasAfectadas > 0) {
                return true;
        }
            
            
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return false;
        
    }
    
}
