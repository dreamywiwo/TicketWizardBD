

package itson.ticketwizard.control;

import javax.swing.JOptionPane;
import itson.ticketwizard.dtos.UsuarioDTO;
import itson.ticketwizard.persistencia.UsuarioDAO;
//import itson.ticketwizard.persistencia.UsuarioDAOImpl;
//import itson.ticketwizard.presentacion.FormIniciarSesion;
//import itson.ticketwizard.presentacion.FormRecargarSaldo;


/**
 *
 * @author Dana Chavez
 */

public class UsuarioControl {

    private UsuarioDAO usuarioDAO;
//    private FormIniciarSesion formIniciarSesion;
//    private FormRecargarSaldo formRecargarSaldo;

    public UsuarioControl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }


//    public void iniciarCasoUso() {
//        this.formIniciarSesion = new FormIniciarSesion(this);
//        this.formIniciarSesion.setVisible(true);
//    }


//    public UsuarioDTO iniciarSesion(String correoElectronico, String contrasena) {
//        // Validaciones básicas
//        if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
//            JOptionPane.showMessageDialog(formIniciarSesion, "El correo no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//        if (contrasena == null || contrasena.trim().isEmpty()) {
//            JOptionPane.showMessageDialog(formIniciarSesion, "La contraseña no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//        
//        UsuarioDTO usuario = usuarioDAO.iniciarSesion(correoElectronico, contrasena);
//        if (usuario == null) {
//            JOptionPane.showMessageDialog(formIniciarSesion, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        return usuario;
//    }


//    public void mostrarFormularioRecargarSaldo() {
//        this.formRecargarSaldo = new FormRecargarSaldo(this);
//        this.formRecargarSaldo.setVisible(true);
//    }


//    public void recargarSaldo(Integer idUsuario, float sumaSaldo) {
//        // Validaciones
//        if (idUsuario == null || idUsuario <= 0) {
//            JOptionPane.showMessageDialog(formRecargarSaldo, "ID de usuario inválido", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        if (sumaSaldo <= 0) {
//            JOptionPane.showMessageDialog(formRecargarSaldo, "La cantidad a recargar debe ser mayor a 0", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        
//        boolean exito = usuarioDAO.recargarSaldo(idUsuario, sumaSaldo);
//        if (exito) {
//            JOptionPane.showMessageDialog(formRecargarSaldo, "Saldo recargado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(formRecargarSaldo, "No se pudo recargar el saldo", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
}

