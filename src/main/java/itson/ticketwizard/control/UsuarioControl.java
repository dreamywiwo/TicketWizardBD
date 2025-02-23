

package itson.ticketwizard.control;

import javax.swing.JOptionPane;
import itson.ticketwizard.dtos.UsuarioDTO;
import itson.ticketwizard.persistencia.UsuarioDAO;
import itson.ticketwizard.presentacion.IniciarSesionPanel;
import itson.ticketwizard.presentacion.RecargarSaldoPanel;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Dana Chavez
 */

public class UsuarioControl {

    private UsuarioDAO usuarioDAO;
    private IniciarSesionPanel iniciarSesionPanel;
    private RecargarSaldoPanel recargarSaldoPanel;

    public UsuarioControl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public UsuarioControl(IniciarSesionPanel iniciarSesionPanel) {
        this.iniciarSesionPanel = iniciarSesionPanel;
        this.iniciarSesionPanel.setVisible(true);
    }


    public UsuarioDTO iniciarSesion(String correoElectronico, String contrasena) {
    if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
        JOptionPane.showMessageDialog(iniciarSesionPanel, "El correo no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    if (!correoElectronico.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
        JOptionPane.showMessageDialog(iniciarSesionPanel, "El correo no tiene un formato válido", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    if (contrasena == null || contrasena.trim().isEmpty()) {
        JOptionPane.showMessageDialog(iniciarSesionPanel, "La contraseña no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    UsuarioDTO usuario = usuarioDAO.obtenerUsuarioPorCorreo(correoElectronico);
    if (usuario == null || !BCrypt.checkpw(contrasena, usuario.getContrasena())) {
        JOptionPane.showMessageDialog(iniciarSesionPanel, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }
    return usuario;
}

    public UsuarioDTO obtenerUsuarioPorCorreo(String correoElectronico) {
        if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
            throw new IllegalArgumentException("El correo no puede estar vacío");
        }
        return usuarioDAO.obtenerUsuarioPorCorreo(correoElectronico);
    }

    public UsuarioDTO obtenerUsuarioPorId(Integer idUsuario) {
        if (idUsuario == null || idUsuario <= 0) {
            throw new IllegalArgumentException("El ID del usuario no es válido");
        }
        return usuarioDAO.obtenerUsuarioPorId(idUsuario);
    }

    public boolean actualizarNombreUsuario(Integer idUsuario, String nombres, String apellidoP, String apellidoM) {
        if (idUsuario == null || idUsuario <= 0) {
            throw new IllegalArgumentException("El ID del usuario no es válido");
        }
        if (nombres == null || nombres.trim().isEmpty() || apellidoP == null || apellidoP.trim().isEmpty() || apellidoM == null || apellidoM.trim().isEmpty()) {
            throw new IllegalArgumentException("Los nombres y apellidos no pueden estar vacíos");
        }

        return usuarioDAO.actualizarNombreUsuario(idUsuario, nombres, apellidoP, apellidoM);
    }

    public boolean actualizarCorreoElectronico(Integer idUsuario, String correoElectronico) {
        if (idUsuario == null || idUsuario <= 0) {
            throw new IllegalArgumentException("El ID del usuario no es válido");
        }
        return usuarioDAO.actualizarCorreoElectronico(idUsuario, correoElectronico);
    }

    public boolean actualizarContrasena(Integer idUsuario, String contrasena) {
        if (idUsuario == null || idUsuario <= 0) {
            throw new IllegalArgumentException("El ID del usuario no es válido");
        }
        if (contrasena == null || contrasena.trim().isEmpty()) {
            JOptionPane.showMessageDialog(iniciarSesionPanel, "La contraseña no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String contrasenaEncriptada = BCrypt.hashpw(contrasena, BCrypt.gensalt());
        return usuarioDAO.actualizarContrasena(idUsuario, contrasenaEncriptada);
    }

    public boolean actualizarTelefono(Integer idUsuario, String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        return usuarioDAO.actualizarTelefono(idUsuario, telefono);
    }

    public boolean actualizarDireccion(Integer idUsuario, String calle, String colonia, String numeroCasa) {
        if (idUsuario == null || idUsuario <= 0) {
            throw new IllegalArgumentException("El ID del usuario no es válido");
        }

        if (calle == null || colonia == null || numeroCasa == null || calle.trim().isEmpty() || colonia.trim().isEmpty() || numeroCasa.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede tener campos vacíos");
        }

        return usuarioDAO.actualizarDireccion(idUsuario, calle, colonia, numeroCasa);
    }


    public void recargarSaldo(Integer idUsuario, float sumaSaldo) {
        if (idUsuario == null || idUsuario <= 0) {
            JOptionPane.showMessageDialog(iniciarSesionPanel, "ID de usuario inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (sumaSaldo <= 0) {
            JOptionPane.showMessageDialog(iniciarSesionPanel, "La cantidad a recargar debe ser mayor a 0", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean exito = usuarioDAO.recargarSaldo(idUsuario, sumaSaldo);
        if (exito) {
            JOptionPane.showMessageDialog(iniciarSesionPanel, "Saldo recargado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(iniciarSesionPanel, "No se pudo recargar el saldo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
