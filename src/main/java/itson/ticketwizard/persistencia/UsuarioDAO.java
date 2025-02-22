/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

import itson.ticketwizard.dtos.UsuarioDTO;
import itson.ticketwizard.entidades.Boleto;
import itson.ticketwizard.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dana Chavez
 */
public class UsuarioDAO {

    private ManejadorConexiones manejadorConexiones;

    public UsuarioDAO() {
        this.manejadorConexiones = new ManejadorConexiones();
    }
    
    public UsuarioDTO obtenerUsuarioPorCorreo(String correoElectronico) {
        
        String codigoSQL = """
                           SELECT 
                           	correoElectronico
                                contrasena
                           FROM Usuarios 
                           WHERE correoElectronico = ?;
                           """;
        
        UsuarioDTO usuario = null;

        try {
            Connection conexion = manejadorConexiones.crearConexion();
   
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            
            comando.setString(1, correoElectronico);

            ResultSet rs = comando.executeQuery();
            if (rs.next()) {
                usuario = new UsuarioDTO(
                    rs.getString("correoElectronico"),
                    rs.getString("contrasena")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public UsuarioDTO obtenerUsuarioPorId(Integer idUsuario) {

        String codigoSQL = """
                           SELECT
                           	idUsuario,
                           	nombres,
                           	apellidoPaterno,
                           	apellidoMaterno,
                           	fechaNacimiento,
                           	numTelefono,
                           	correoElectronico,
                                contrasena,
                           	saldo
                           FROM Usuarios WHERE idUsuario = ?;
                           """;
        
        UsuarioDTO usuario = null;

        try {
            Connection conexion = manejadorConexiones.crearConexion();
   
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);
            
            comando.setInt(1, idUsuario);

            ResultSet resultadosConsulta = comando.executeQuery();
            if (resultadosConsulta.next()) {
                usuario = new UsuarioDTO(
                    resultadosConsulta.getInt("idUsuario"),
                    resultadosConsulta.getString("nombres"),
                    resultadosConsulta.getString("apellidoPaterno"),
                    resultadosConsulta.getString("apellidoMaterno"),
                    resultadosConsulta.getDate("fechaNacimiento"),
                    resultadosConsulta.getString("numTelefono"),
                    resultadosConsulta.getString("correoElectronico"),
                    resultadosConsulta.getString("contrasena"),    
                    resultadosConsulta.getFloat("saldo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;

    }

    public boolean verificarCredenciales(String correoElectronico, String contrasena) {

        return false;

    }

    public void actualizarSaldo(Integer idUsuario, float nuevoSaldo) {

        String codigoSQL = """
                            UPDATE usuarios SET saldo = ? WHERE idUsuario = ? 
                            ;
                           """;

        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            comando.setFloat(1, nuevoSaldo);
            comando.setInt(2, idUsuario);

            int rowsAffected = comando.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Saldo actualizado correctamente.");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public List<Usuario> obtenerDatosUsuario(Integer idUsuario) {

        return null;

    }

}
