/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dana Chavez
 */
public class ManejadorConexiones {
    
    // informacion para conectar a la bd
    private final String cadenaConexion = "jdbc:mysql://localhost/ticketWizard";
    private final String usuario = "root";
    private final String contrasenia = "bases123";
    
    public Connection crearConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(
            cadenaConexion,
            usuario,
            contrasenia
        );
        return conexion;

    }   
}
