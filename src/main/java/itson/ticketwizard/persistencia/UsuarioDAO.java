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

            ResultSet resultadosConsulta = comando.executeQuery();
            if (resultadosConsulta.next()) {
                usuario = new UsuarioDTO(
                        resultadosConsulta.getString("correoElectronico"),
                        resultadosConsulta.getString("contrasena")
                );
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar el usuario: " + ex.getMessage());

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
        } catch (SQLException ex) {
            System.err.println("Error al consultar el usuario: " + ex.getMessage());
        }

        return usuario;

    }

    public UsuarioDTO iniciarSesion(String correoElectronico, String contrasena) {

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
                           FROM Usuarios 
                           WHERE correoElectronico = ? AND contrasena = ?;
                           """;

        UsuarioDTO usuario = null;

        try {
            Connection conexion = manejadorConexiones.crearConexion();

            PreparedStatement comando = conexion.prepareStatement(codigoSQL);

            comando.setString(1, correoElectronico);
            comando.setString(2, contrasena);

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
        } catch (SQLException ex) {
            System.err.println("Error al iniciar sesion: " + ex.getMessage());
        }

        return usuario;

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

    public boolean recargarSaldo(Integer idUsuario, float sumaSaldo) {

        String codigoSQLSelect = """
                              SELECT saldo 
                              FROM usuarios 
                              WHERE idUsuario = ?
                              """;
        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comandoSelect = conexion.prepareStatement(codigoSQLSelect);

            comandoSelect.setInt(1, idUsuario);
            ResultSet resultadoConsulta = comandoSelect.executeQuery();

            if (resultadoConsulta.next()) {
                float saldoActual = resultadoConsulta.getFloat("saldo");
                float nuevoSaldo = saldoActual + sumaSaldo;

                actualizarSaldo(idUsuario, nuevoSaldo);

                System.out.println("Saldo recargado con éxito.");
                return true;
            } else {
                System.out.println("Usuario no encontrado.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarNombreUsuario(Integer idUsuario, String nombres, String apellidoP, String apellidoM) {
        String codigoSQLUpdate = """
                             UPDATE usuarios 
                             SET nombres = ?, apellidoP = ?, apellidoM = ? 
                             WHERE idUsuario = ?
                             """;

        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comandoUpdate = conexion.prepareStatement(codigoSQLUpdate);

            comandoUpdate.setString(1, nombres);
            comandoUpdate.setString(2, apellidoP);
            comandoUpdate.setString(3, apellidoM);
            comandoUpdate.setInt(4, idUsuario);
            int filasAfectadas = comandoUpdate.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Usuario actualizado con éxito.");
                return true;
            } else {
                System.out.println("No se encontró al usuario con el id proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarCorreoElectronico(Integer idUsuario, String correoElectronico) {
        String codigoSQLUpdate = """
                             UPDATE usuarios 
                             SET correoElectronico = ? 
                             WHERE idUsuario = ?
                             """;

        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comandoUpdate = conexion.prepareStatement(codigoSQLUpdate);

            comandoUpdate.setString(1, correoElectronico);
            comandoUpdate.setInt(2, idUsuario);
            int filasAfectadas = comandoUpdate.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Correo electrónico actualizado con éxito.");
                return true;
            } else {
                System.out.println("No se encontró al usuario con el id proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarContrasena(Integer idUsuario, String contrasena) {
        String codigoSQLUpdate = """
                             UPDATE usuarios 
                             SET contrasena = ? 
                             WHERE idUsuario = ?
                             """;

        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comandoUpdate = conexion.prepareStatement(codigoSQLUpdate);

            comandoUpdate.setString(1, contrasena);
            comandoUpdate.setInt(2, idUsuario);
            int filasAfectadas = comandoUpdate.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Contraseña actualizada con éxito.");
                return true;
            } else {
                System.out.println("No se encontró al usuario con el id proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarTelefono(Integer idUsuario, String telefono) {
        String codigoSQLUpdate = """
                             UPDATE usuarios 
                             SET telefono = ? 
                             WHERE idUsuario = ?
                             """;

        try {
            Connection conexion = this.manejadorConexiones.crearConexion();
            PreparedStatement comandoUpdate = conexion.prepareStatement(codigoSQLUpdate);

            comandoUpdate.setString(1, telefono);
            comandoUpdate.setInt(2, idUsuario);
            int filasAfectadas = comandoUpdate.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Teléfono actualizado con éxito.");
                return true;
            } else {
                System.out.println("No se encontró al usuario con el id proporcionado.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizarDireccion(Integer idUsuario, String calle, String colonia, String numeroCasa) {
    String codigoSQLUpdate = """
                             UPDATE usuarios 
                             SET calle = ?, colonia = ?, numeroCasa = ? 
                             WHERE idUsuario = ?
                             """;

    try {
        Connection conexion = this.manejadorConexiones.crearConexion();
        PreparedStatement comandoUpdate = conexion.prepareStatement(codigoSQLUpdate);

        comandoUpdate.setString(1, calle);
        comandoUpdate.setString(2, colonia);
        comandoUpdate.setString(3, numeroCasa);
        comandoUpdate.setInt(4, idUsuario);
        int filasAfectadas = comandoUpdate.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Dirección actualizada con éxito.");
            return true;
        } else {
            System.out.println("No se encontró al usuario con el id proporcionado.");
            return false;
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
