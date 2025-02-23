

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
        return usuarioDAO.obtenerUsuarioPorCorreo(correoElectronico);
    }

    public UsuarioDTO obtenerUsuarioPorId(Integer idUsuario) {
        return usuarioDAO.obtenerUsuarioPorId(idUsuario);
    }

    public boolean actualizarNombreUsuario(Integer idUsuario, String nombres, String apellidoP, String apellidoM) {
        return usuarioDAO.actualizarNombreUsuario(idUsuario, nombres, apellidoP, apellidoM);
    }

    public boolean actualizarCorreoElectronico(Integer idUsuario, String correoElectronico) {
        return usuarioDAO.actualizarCorreoElectronico(idUsuario, correoElectronico);
    }

    public boolean actualizarContrasena(Integer idUsuario, String contrasena) {
    if (contrasena == null || contrasena.trim().isEmpty()) {
        JOptionPane.showMessageDialog(iniciarSesionPanel, "La contraseña no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    String contrasenaEncriptada = BCrypt.hashpw(contrasena, BCrypt.gensalt());
    return usuarioDAO.actualizarContrasena(idUsuario, contrasenaEncriptada);
    }

    public boolean actualizarTelefono(Integer idUsuario, String telefono) {
        return usuarioDAO.actualizarTelefono(idUsuario, telefono);
    }

    public boolean actualizarDireccion(Integer idUsuario, String calle, String colonia, String numeroCasa) {
        return usuarioDAO.actualizarDireccion(idUsuario, calle, colonia, numeroCasa);
    }

    public void mostrarRecargarSaldo(){
        this.iniciarSesionPanel = new IniciarSesionPanel();
        this.iniciarSesionPanel.setVisible(true);
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

