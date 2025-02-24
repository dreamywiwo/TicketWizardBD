/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package itson.ticketwizard;

import itson.ticketwizard.persistencia.ManejadorConexiones;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author leoca
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ManejadorConexiones man = new ManejadorConexiones();
        Connection conexion = man.crearConexion();
    }
    
}
