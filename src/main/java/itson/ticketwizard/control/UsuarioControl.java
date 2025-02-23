

package itson.ticketwizard.control;

import javax.swing.JOptionPane;
import itson.ticketwizard.dtos.UsuarioDTO;
import itson.ticketwizard.persistencia.UsuarioDAO;
import itson.ticketwizard.presentacion.IniciarSesionPanel;
import itson.ticketwizard.presentacion.RecargarSaldoPanel;
//import itson.ticketwizard.persistencia.UsuarioDAOImpl;
//import itson.ticketwizard.presentacion.FormIniciarSesion;
//import itson.ticketwizard.presentacion.FormRecargarSaldo;


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
        
        UsuarioDTO usuario = usuarioDAO.iniciarSesion(correoElectronico, contrasena);
        if (usuario == null) {
            JOptionPane.showMessageDialog(iniciarSesionPanel, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return usuario;
    }

      
    public void mostrarRecargarSaldo(){
        this.iniciarSesionPanel = new IniciarSesionPanel();
        this.iniciarSesionPanel.setVisible(true);
    }

    public void recargarSaldo(Integer idUsuario, float sumaSaldo) {
        // Validaciones
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

