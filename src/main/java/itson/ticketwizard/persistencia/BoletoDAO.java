/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.BoletoEventoDTO;
import itson.ticketwizard.dtos.BoletoEventoTransaccionDTO;
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
    private ApartadoDAO apartados;

    public BoletoDAO() {
        this.manejadorConexiones = new ManejadorConexiones();
    }
    
    public List<BoletoEventoDTO> obtenerBoletosDisponiblesPorEvento(Integer idEvento){
        
        List<BoletoEventoDTO> listaBoletos = new ArrayList<>();
        String codigoSQL = """
                           SELECT                                
                           	b.precio,
                           	b.disponibilidad,
                                b.tipo
                           	b.numAsiento,
                           	b.fila,
                           	e.nombreEvento,
                           	e.fechaEvento,
                           	e.horaEvento,
                           	e.ciudad,
                           	e.nombreLocal
                           FROM Boletos b
                           JOIN Eventos e ON b.idEvento = e.idEvento
                           WHERE e.idEvento = ? AND Disponibilidad = 'Disponible';
                           """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
   
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setInt(1, idEvento);
            
            ResultSet resultadosConsulta = comando.executeQuery();

            while(resultadosConsulta.next()){

                BoletoEventoDTO boleto = new BoletoEventoDTO(
                        
                        resultadosConsulta.getFloat("precio"),
                        resultadosConsulta.getString("disponibilidad"),
                        resultadosConsulta.getString("tipo"),
                        resultadosConsulta.getInt("numAsiento"),
                        resultadosConsulta.getString("fila"),
                        resultadosConsulta.getString("nombreEvento"),
                        resultadosConsulta.getDate("fechaEvento"),
                        resultadosConsulta.getTime("horaEvento"),
                        resultadosConsulta.getString("ciudad"),
                        resultadosConsulta.getString("nombreLocal")
                );
                listaBoletos.add(boleto);

            }
         
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        
        return listaBoletos;
        
    }
    
    public List<BoletoEventoTransaccionDTO> obtenerBoletosDeUsuario(Integer idUsuario){
        
        List<BoletoEventoTransaccionDTO> listaBoletos = new ArrayList<>();
        String codigoSQL = """
                           SELECT 
                           	b.numSerie,
                                b.tipo,
                                b.numAsiento,
                                b.fila,
                                e.nombreEvento,
                                e.nombreLocal,
                                e.descripcion,
                                e.fechaEvento,
                           	e.horaEvento,
                           	e.ciudad,
                           	t.idTransaccion,
                                t.fechaHora
                           FROM Eventos e
                           JOIN Boletos b ON e.idEvento = b.idEvento
                           JOIN Historial h ON b.numSerie = h.numSerie
                           JOIN Transacciones t ON h.idTransaccion = t.idTransaccion
                           JOIN Usuarios u ON t.idComprador = u.idUsuario
                           WHERE idUsuario = ?;
                           """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
   
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setInt(1, idUsuario);
            
            ResultSet resultadosConsulta = comando.executeQuery();

            while(resultadosConsulta.next()){

                BoletoEventoTransaccionDTO boleto = new BoletoEventoTransaccionDTO(
                        
                        resultadosConsulta.getInt("numSerie"),                     
                        resultadosConsulta.getString("tipo"),
                        resultadosConsulta.getInt("numAsiento"),
                        resultadosConsulta.getString("fila"),
                        resultadosConsulta.getString("nombreEvento"),
                        resultadosConsulta.getString("nombreLocal"),
                        resultadosConsulta.getString("descripcion"),
                        resultadosConsulta.getDate("fechaEvento"),
                        resultadosConsulta.getTime("horaEvento"),
                        resultadosConsulta.getString("ciudad"),
                        resultadosConsulta.getInt("idTransaccion"),
                        resultadosConsulta.getDate("fechaHora")
                );
                listaBoletos.add(boleto);

            }
         
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        
        return listaBoletos;
        
    }
    
    public List<BoletoEventoTransaccionDTO> obtenerBoletosDeUsuarioPorEvento(Integer idUsuario, Integer idEvento){
        
        List<BoletoEventoTransaccionDTO> listaBoletos = new ArrayList<>();
        String codigoSQL = """
                           SELECT 
                           	b.numSerie,
                                b.tipo,
                                b.numAsiento,
                                b.fila,
                                e.nombreEvento,
                                e.nombreLocal,
                                e.descripcion,
                                e.fechaEvento,
                           	e.horaEvento,
                           	e.ciudad,
                           	t.idTransaccion,
                                t.fechaHora
                           FROM Eventos e
                           JOIN Boletos b ON e.idEvento = b.idEvento
                           JOIN Historial h ON b.numSerie = h.numSerie
                           JOIN Transacciones t ON h.idTransaccion = t.idTransaccion
                           JOIN Usuarios u ON t.idComprador = u.idUsuario
                           WHERE idUsuario = ? AND idEvento = ?;
                           """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
   
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setInt(1, idUsuario);
            comando.setInt(2, idEvento);
            
            ResultSet resultadosConsulta = comando.executeQuery();

            while(resultadosConsulta.next()){

                BoletoEventoTransaccionDTO boleto = new BoletoEventoTransaccionDTO(
                        
                        resultadosConsulta.getInt("numSerie"),                     
                        resultadosConsulta.getString("tipo"),
                        resultadosConsulta.getInt("numAsiento"),
                        resultadosConsulta.getString("fila"),
                        resultadosConsulta.getString("nombreEvento"),
                        resultadosConsulta.getString("nombreLocal"),
                        resultadosConsulta.getString("descripcion"),
                        resultadosConsulta.getDate("fechaEvento"),
                        resultadosConsulta.getTime("horaEvento"),
                        resultadosConsulta.getString("ciudad"),
                        resultadosConsulta.getInt("idTransaccion"),
                        resultadosConsulta.getDate("fechaHora")
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
                                      SELECT saldo 
                                      FROM usuarios 
                                      WHERE idUsuario = ?
                                      """;
    String codigoSQLSelectBoleto = """
                                   SELECT idUsuario 
                                   FROM boletos 
                                   WHERE numSerie = ?
                                   """;
    String codigoSQLUpdateSaldoComprador = """
                                           UPDATE usuarios 
                                           SET saldo = ? 
                                           WHERE idUsuario = ?
                                           """;
    String codigoSQLUpdateSaldoVendedor = """
                                          UPDATE usuarios 
                                          SET saldo = saldo + ? 
                                          WHERE idUsuario = ?
                                          """;
    String codigoSQLUpdateBoleto = """
                                   UPDATE boletos 
                                   SET idUsuario = ?, disponibilidad = 'Reservado' 
                                   WHERE numSerie = ?
                                   """;

    try {
        Connection conexion = this.manejadorConexiones.crearConexion();

        PreparedStatement comandoSelectComprador = conexion.prepareStatement(codigoSQLSelectComprador);
        comandoSelectComprador.setInt(1, idComprador);
        ResultSet resultadoConsultaComprador = comandoSelectComprador.executeQuery();

        PreparedStatement comandoSelectBoleto = conexion.prepareStatement(codigoSQLSelectBoleto);
        comandoSelectBoleto.setInt(1, numSerie);
        ResultSet resultadoConsultaBoleto = comandoSelectBoleto.executeQuery();

        if (resultadoConsultaComprador.next() && resultadoConsultaBoleto.next()) {
            float saldoActualComprador = resultadoConsultaComprador.getFloat("saldo");
            int idVendedor = resultadoConsultaBoleto.getInt("idUsuario");

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
                System.out.println("Saldo insuficiente. Realizando apartado.");
                
                apartados.registrarApartado(numSerie, idComprador);

                new java.util.Timer().schedule(new java.util.TimerTask() {
                    @Override
                    public void run() {
                        apartados.eliminarApartado(numSerie);
                        System.out.println("Apartado eliminado después de 10 minutos.");
                    }
                }, 10 * 60 * 1000);

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
                              SELECT idUsuario, disponibilidad 
                              FROM boletos 
                              WHERE numSerie = ?
                              """;
    String codigoSQLUpdate = """
                              UPDATE boletos 
                              SET disponibilidad = 'Disponible', tipo = 'Reventa' 
                              WHERE numSerie = ?
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
