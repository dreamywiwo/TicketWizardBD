/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.EventoDTO;
import itson.ticketwizard.entidades.Evento;
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
public class EventoDAO {
    
    private ManejadorConexiones manejadorConexiones;
   
    public EventoDAO(ManejadorConexiones manejadorConexiones){
        this.manejadorConexiones = manejadorConexiones;
    }

    public Evento buscarEventoPorId(Integer idEvento){
         String codigoSQL = """
                             SELECT 
                                idEvento,
                                nombreEvento,
                                nombreLocal,
                                calle,
                                colonia,
                                ciudad,
                                descripcion,
                                fechaEvento,
                                horaEvento
                             FROM Eventos WHERE idEvento = ?;
                             """;
         
        Evento evento = null;

        try {
            Connection conexion = manejadorConexiones.crearConexion();
   
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            
            comando.setInt(1, idEvento);

            ResultSet resultadosConsulta = comando.executeQuery();
            if (resultadosConsulta.next()) {
                evento = new Evento(
                    resultadosConsulta.getInt("idEvento"),
                    resultadosConsulta.getString("nombreEvento"),
                    resultadosConsulta.getString("nombreLocal"),
                    resultadosConsulta.getString("calle"),
                    resultadosConsulta.getString("colonia"),
                    resultadosConsulta.getString("ciudad"),
                    resultadosConsulta.getString("descripcion"),
                    resultadosConsulta.getDate("fechaEvento"),    
                    resultadosConsulta.getTime("horaEvento")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return evento;
    
    }
    
    public List<EventoDTO> buscarEventosPorFiltro(String ciudad, String nombreEvento, Date fechaEvento) {
        
        List<EventoDTO> listaEventos = new ArrayList<>();
        String codigoSQL = """
                           SELECT 
                                nombreEvento, 
                                nombreLocal,
                                ciudad,
                                fechaEvento, 
                                horaEvento
                           FROM Eventos 
                           WHERE nombreEvento = ? AND ciudad = ? AND fechaEvento = ? ;
                           """;
        try{
            Connection conexion = manejadorConexiones.crearConexion();
   
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            comando.setString(1, ciudad);
            comando.setString(2, nombreEvento);
            comando.setDate(3, fechaEvento);
            
 
            ResultSet resultadosConsulta = comando.executeQuery();

            while(resultadosConsulta.next()){

                EventoDTO evento = new EventoDTO(

                        resultadosConsulta.getString("nombreEvento"),
                        resultadosConsulta.getString("nombreLocal"),
                        resultadosConsulta.getString("ciudad"),
                        resultadosConsulta.getDate("fechaEvento"),
                        resultadosConsulta.getTime("horaEvento")   

                );
                listaEventos.add(evento);

            }
         
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        
        return listaEventos;
    }
        
   
    
    public List<EventoDTO> obtenerTodosLosEventos() {
        
        List<EventoDTO> listaEventos = new ArrayList<>();
        String codigoSQL = """
                            SELECT 
                                idEvento,
                                nombreEvento, 
                                nombreLocal,
                                ciudad,
                                fechaEvento, 
                                horaEvento
                            FROM 
                           	Eventos;
                           """;
        
        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            ResultSet resultadosConsulta = comando.executeQuery();
            
            while(resultadosConsulta.next()){
                
                EventoDTO evento = new EventoDTO(
                        
                        resultadosConsulta.getInt("idEvento"),
                        resultadosConsulta.getString("nombreEvento"),
                        resultadosConsulta.getString("nombreLocal"),
                        resultadosConsulta.getString("ciudad"),
                        resultadosConsulta.getDate("fechaEvento"),
                        resultadosConsulta.getTime("horaEvento")   
                        
                );
                listaEventos.add(evento);
                
            }
            
        } catch (SQLException ex){
            System.err.println("Error al consultar los eventos: " + ex.getMessage());
        }    
        
        return listaEventos;
        
    }
    
}
