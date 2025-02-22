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
import java.util.LinkedList;
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
    
    public Evento buscarEventoPorId(){
        
        return null;
        
    }
    
    public List<Evento> buscarEventosPorFiltro(String ciudad, String nombreLocal, Date fecha) {
        
        return null;
        
    }
    
    public List<Evento> obtenerTodosLosEventos() {
        
        List<Evento> listaEventos = new ArrayList<>();
        String codigoSQL = """
                            SELECT 
                           	idEvento, 
                           	nombreEvento, 
                           	nombreLocal, 
                           	calle, 
                           	colonia, 
                           	fechaEvento, 
                           	horaEvento
                            FROM 
                           	Eventos e;
                           """;
        
        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            ResultSet resultadosConsulta = comando.executeQuery();
            
            while(resultadosConsulta.next()){
                
                Evento evento = new EventoDTO(
                        
                        resultadosConsulta.getInt("idEvento"),
                        resultadosConsulta.getString("nombreEvento"),
                        resultadosConsulta.getString("nombreLocal"),
                        resultadosConsulta.getString("calle"),
                        resultadosConsulta.getString("colonia"),
                        resultadosConsulta.getDate("fechaEvento"),
                        resultadosConsulta.getTime("horaEvento")   
                        
                );
                listaEventos.add(evento);
                
            }
            
        } catch (SQLException ex){
            System.err.println("Error al consultar los eventos: " + ex.getMessage());
        }    
        
        return null;
        
    }
    
}
