/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.entidades.Boleto;
import java.util.List;

/**
 *
 * @author Dana Chavez
 */
public class BoletoDAO {
    
    public List<Boleto> obtenerBoletosDisponiblesPorEvento(Integer idEvento){
        
        return null;
        
    }
    
    public List<Boleto> obtenerBoletosDeUsuario(Integer idUsuario){
        
        return null;
        
    }
    
    public boolean actualizarDisponibilidadBoleto(Integer numSerie, String estado){
        
        return false;
        
    }
    
    public boolean apartarBoleto(Integer numSerie, Integer idUsuario){
        
        return false;
        
    }
    
    public boolean comprarBoleto(Integer numSerie, Integer idComprador, float precio){
        
        return false;
        
    }
    
    public boolean venderBoleto(Integer numSerie, Integer idVendedor, float precio){
        
        return false;
        
    }
    
    
      
}
