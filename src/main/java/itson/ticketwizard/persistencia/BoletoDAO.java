/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.entidades.Boleto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dana Chavez
 */
public class BoletoDAO {
    
    private ManejadorConexiones manejadorConexiones;

    public BoletoDAO() {
        this.manejadorConexiones = new ManejadorConexiones();
    }
    
    
    // Falta agregar nombre local y ciudad a los boletos
    
    public List<BoletoDTO> obtenerBoletosDisponiblesPorEvento(Integer idEvento){
        
        List<BoletoDTO> listaBoletos = new ArrayList<>();
        String codigoSQL = """
                           SELECT 
                           	precio,
                           	disponibilidad,
                           	numAsiento,
                           	fila,
                           	idEvento,
                           	idUsuario
                               FROM Boletos WHERE idEvento = ? AND (Disponibilidad = 'Disponible' OR 'Reventa');
                           """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
   
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setInt(1, idEvento);
            
            ResultSet resultadosConsulta = comando.executeQuery();

            while(resultadosConsulta.next()){

                BoletoDTO boleto = new BoletoDTO(
                        
                        resultadosConsulta.getFloat("precio"),
                        resultadosConsulta.getString("disponibilidad"),
                        resultadosConsulta.getInt("numAsiento"),
                        resultadosConsulta.getString("fila")

                );
                listaBoletos.add(boleto);

            }
         
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        
        return listaBoletos;
        
    }
    
    public List<BoletoDTO> obtenerBoletosDeUsuario(Integer idUsuario){
        
        List<BoletoDTO> listaBoletos = new ArrayList<>();
        String codigoSQL = """
                           SELECT 
                                numSerie,
                           	precio,
                           	numAsiento,
                           	fila,
                           	idEvento,
                               FROM Boletos WHERE idUsuario = ?;
                           """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
   
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setInt(1, idUsuario);
            
            ResultSet resultadosConsulta = comando.executeQuery();

            while(resultadosConsulta.next()){

                BoletoDTO boleto = new BoletoDTO(
                        
                        resultadosConsulta.getInt("numSerie"),
                        resultadosConsulta.getFloat("precio"),
                        resultadosConsulta.getInt("numAsiento"),
                        resultadosConsulta.getString("fila")

                );
                listaBoletos.add(boleto);

            }
         
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        
        return listaBoletos;
        
    }
    
    public boolean actualizarDisponibilidadBoleto(Integer numSerie, String estado){
        
        return false;
        
    }
    
    public boolean apartarBoleto(Integer numSerie, Integer idUsuario){
        
        return false;
        
    }
    
    public boolean comprarBoleto(Integer numSerie, Integer idComprador, float precio) {
    String codigoSQLSelectComprador = """
                                       SELECT saldo FROM usuarios WHERE idUsuario = ?
                                       """;
    String codigoSQLSelectBoleto = """
                                    SELECT idUsuario FROM boletos WHERE numSerie = ?
                                    """;
    String codigoSQLUpdateSaldoComprador = """
                                            UPDATE usuarios SET saldo = ? WHERE idUsuario = ?
                                            """;
    String codigoSQLUpdateSaldoVendedor = """
                                           UPDATE usuarios SET saldo = saldo + ? WHERE idUsuario = ?
                                           """;
    String codigoSQLUpdateBoleto = """
                                    UPDATE boletos SET idUsuario = ?, disponibilidad = 'Reservado' WHERE numSerie = ?
                                    """;

    try {
        Connection conexion = this.manejadorConexiones.crearConexion();

        PreparedStatement comandoSelectComprador = conexion.prepareStatement(codigoSQLSelectComprador);
        comandoSelectComprador.setInt(1, idComprador);
        ResultSet rsComprador = comandoSelectComprador.executeQuery();

        PreparedStatement comandoSelectBoleto = conexion.prepareStatement(codigoSQLSelectBoleto);
        comandoSelectBoleto.setInt(1, numSerie);
        ResultSet rsBoleto = comandoSelectBoleto.executeQuery();

        if (rsComprador.next() && rsBoleto.next()) {
            float saldoActualComprador = rsComprador.getFloat("saldo");
            int idVendedor = rsBoleto.getInt("idUsuario");

            if (saldoActualComprador >= precio) {
                float nuevoSaldoComprador = saldoActualComprador - precio;

                PreparedStatement comandoUpdateSaldoComprador = conexion.prepareStatement(codigoSQLUpdateSaldoComprador);
                comandoUpdateSaldoComprador.setFloat(1, nuevoSaldoComprador);
                comandoUpdateSaldoComprador.setInt(2, idComprador);
                comandoUpdateSaldoComprador.executeUpdate();

                PreparedStatement comandoUpdateSaldoVendedor = conexion.prepareStatement(codigoSQLUpdateSaldoVendedor);
                comandoUpdateSaldoVendedor.setFloat(1, precio);
                comandoUpdateSaldoVendedor.setInt(2, idVendedor);
                comandoUpdateSaldoVendedor.executeUpdate();

                PreparedStatement comandoUpdateBoleto = conexion.prepareStatement(codigoSQLUpdateBoleto);
                comandoUpdateBoleto.setInt(1, idComprador);
                comandoUpdateBoleto.setInt(2, numSerie);
                comandoUpdateBoleto.executeUpdate();

                System.out.println("Boleto comprado con éxito. Saldo actualizado: " + nuevoSaldoComprador);
                return true;
            } else {
                System.out.println("Saldo insuficiente.");
                return false;
            }
        } else {
            System.out.println("Comprador o boleto no encontrado.");
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    
    public boolean venderBoleto(Integer numSerie, Integer idVendedor) {
    String codigoSQLSelect = """
                              SELECT idUsuario, disponibilidad FROM boletos WHERE numSerie = ?
                              """;
    String codigoSQLUpdate = """
                              UPDATE boletos SET disponibilidad = 'Reventa' WHERE numSerie = ?
                              """;

    try {
        Connection conexion = this.manejadorConexiones.crearConexion();
        PreparedStatement comandoSelect = conexion.prepareStatement(codigoSQLSelect);
        PreparedStatement comandoUpdate = conexion.prepareStatement(codigoSQLUpdate);

        comandoSelect.setInt(1, numSerie);
        ResultSet rs = comandoSelect.executeQuery();
        
        if (rs.next()) {
            int idUsuario = rs.getInt("idUsuario");
            String disponibilidad = rs.getString("disponibilidad");

            if (idVendedor.equals(idUsuario) && "Reservado".equals(disponibilidad)) {

                comandoUpdate.setInt(1, numSerie);
                comandoUpdate.executeUpdate();

                System.out.println("Boleto marcado como 'Reventa' con éxito.");
                return true;
            } else {
                throw new IllegalArgumentException("El boleto no es del vendedor o no está en estado 'Reservado'.");
            }
        } else {
            System.out.println("Boleto no encontrado.");
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
   
}
