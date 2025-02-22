/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.persistencia;

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

    public Usuario obtenerUsuarioPorCorreo(String correoElectronico) {

        return null;

    }

    public Usuario obtenerUsuarioPorId(Integer idUsuario) {

        return null;

    }

    public boolean verificarCredenciales(String correoElectronico, String contrasena) {

        return false;

    }

    public void actualizarSaldo(Integer idUsuario, float nuevoSaldo) {

        String codigoSQL = """
                            UPDATE usuarios SET saldo = ? WHERE id = ? 
                            ;
                           """;

        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            comando.setFloat(1, nuevoSaldo);
            comando.setInt(2, idUsuario);

            ResultSet resultadosConsulta = comando.executeQuery();

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
