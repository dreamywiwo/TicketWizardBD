/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.TransaccionDTO;
import itson.ticketwizard.entidades.Transaccion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dana Chavez
 */
public class TransaccionDAO {
    
    private ManejadorConexiones manejadorConexiones;
    
    public TransaccionDAO(ManejadorConexiones manejadorConexiones){
        this.manejadorConexiones = manejadorConexiones;
    }
    
    // cambiar a parametro idUsuario y ajustar la consulta
    public List<TransaccionDTO> obtenerTransaccionesPorUsuario(Integer idVendedor, Integer idComprador){
        
         List<TransaccionDTO> listaTransacciones = new ArrayList<>();
        String codigoSQL = """
                           SELECT
                           idTransaccion,
                           fechaHora,
                           monto,
                           comision,
                           idVendedor,
                           idComprador
                           FROM Transacciones WHERE idVendedor = ? OR idComprador= ?;
                           """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
   
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setInt(1, idVendedor);
            comando.setInt(2, idComprador);
            
            ResultSet resultadosConsulta = comando.executeQuery();

            while(resultadosConsulta.next()){

                TransaccionDTO transaccion = new TransaccionDTO(

                        resultadosConsulta.getInt("idTransaccion"),
                        resultadosConsulta.getDate("fechaHora"),
                        resultadosConsulta.getFloat("monto"),
                        resultadosConsulta.getFloat("comision"),
                        resultadosConsulta.getInt("idVendedor"),
                        resultadosConsulta.getInt("idVendedor")

                );
                listaTransacciones.add(transaccion);

            }
         
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }       
        return listaTransacciones;       
    }
    
    public boolean registrarTransaccion(Integer idComprador, Integer idVendedor, float monto, Integer idApartado){
        String codigoSQL = """
                            INSERT INTO(idComprador, idVendedor, monto, idApartado)
                            VALUES(?,?,?,?);
                            """;
                            
           try{
            Connection conexion = manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
       
            comando.setInt(1, idComprador);
            comando.setInt(2, idVendedor);
            comando.setFloat(3, monto);
            comando.setInt(4, idApartado);
            
           }catch(SQLException ex){
               System.err.println(ex.getMessage());
           }
        
        return false;
        
    }
    
}
