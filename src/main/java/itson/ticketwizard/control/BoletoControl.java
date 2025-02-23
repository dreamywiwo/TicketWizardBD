/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoEventoDTO;
import itson.ticketwizard.dtos.BoletoEventoTransaccionDTO;
import itson.ticketwizard.persistencia.BoletoDAO;
import itson.ticketwizard.presentacion.VentaBoletoPanel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Dana Chavez
 */
public class BoletoControl {



    private BoletoDAO boletoDAO;
//    private CompraBoletoPanel compraBoleto;
    private VentaBoletoPanel ventaBoleto;


    public BoletoControl(BoletoDAO boletoDAO) {
        this.boletoDAO = boletoDAO;
    }


//    public void iniciarCasoUsoCompra() {
//        this.formCompraBoleto = new CompraBoletoPanel(this);
//        this.formCompraBoleto.setVisible(true);
//    }

    public void iniciarCasoUsoVenta() {
        this.ventaBoleto = new VentaBoletoPanel();
        this.ventaBoleto.setVisible(true);
    }

 
    public void comprarBoleto(Integer numSerie, Integer idComprador, float precio) {
        // Validaciones de datos para la compra
        if (numSerie == null) {
            JOptionPane.showMessageDialog(ventaBoleto, "El número de serie no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (numSerie <= 0) {
            JOptionPane.showMessageDialog(ventaBoleto, "El número de serie debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (idComprador == null) {
            JOptionPane.showMessageDialog(ventaBoleto, "El ID del comprador no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (idComprador <= 0) {
            JOptionPane.showMessageDialog(ventaBoleto, "El ID del comprador debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        if (precio <= 0) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "El precio debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        boolean exito = boletoDAO.comprarBoleto(numSerie, idComprador, precio);
//        if (exito) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "Boleto comprado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(formCompraBoleto, "Error al comprar el boleto.", "Error", JOptionPane.ERROR_MESSAGE);
//        }

    }


    public void venderBoleto(Integer numSerie, Integer idVendedor) {
 
        if (numSerie == null) {
            JOptionPane.showMessageDialog(ventaBoleto, "El número de serie no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (numSerie <= 0) {
            JOptionPane.showMessageDialog(ventaBoleto, "El número de serie debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (idVendedor == null) {
            JOptionPane.showMessageDialog(ventaBoleto, "El ID del vendedor no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (idVendedor <= 0) {
            JOptionPane.showMessageDialog(ventaBoleto, "El ID del vendedor debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            boolean exito = boletoDAO.venderBoleto(numSerie, idVendedor);
            if (exito) {
                JOptionPane.showMessageDialog(ventaBoleto, "Boleto vendido exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(ventaBoleto, "Error al vender el boleto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(ventaBoleto, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

//    public List<BoletoEventoDTO> obtenerBoletosDisponiblesPorEvento(Integer idEvento) {
//        if (idEvento == null) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "El ID de evento no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//        if (idEvento <= 0) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "El ID de evento debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//        List<BoletoEventoDTO> boletos = boletoDAO.obtenerBoletosDisponiblesPorEvento(idEvento);
//        if (boletos.isEmpty()) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "No se encontraron boletos disponibles para este evento.", "Información", JOptionPane.INFORMATION_MESSAGE);
//        }
//        return boletos;
//    }

//    public List<BoletoEventoTransaccionDTO> obtenerBoletosDeUsuario(Integer idUsuario) {
//        if (idUsuario == null) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "El ID de usuario no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//        if (idUsuario <= 0) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "El ID de usuario debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//        List<BoletoEventoTransaccionDTO> boletos = boletoDAO.obtenerBoletosDeUsuario(idUsuario);
//        if (boletos.isEmpty()) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "No se encontraron boletos para este usuario.", "Información", JOptionPane.INFORMATION_MESSAGE);
//        }
//        return boletos;
//    }


//    public List<BoletoEventoTransaccionDTO> obtenerBoletosDeUsuarioPorEvento(Integer idUsuario, Integer idEvento) {
//        if (idUsuario == null) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "El ID de usuario no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//        if (idUsuario <= 0) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "El ID de usuario debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//        if (idEvento == null) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "El ID de evento no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//        if (idEvento <= 0) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "El ID de evento debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
//            return null;
//        }
//        List<BoletoEventoTransaccionDTO> boletos = boletoDAO.obtenerBoletosDeUsuarioPorEvento(idUsuario, idEvento);
//        if (boletos.isEmpty()) {
//            JOptionPane.showMessageDialog(formCompraBoleto, "No se encontraron boletos para este usuario en el evento seleccionado.", "Información", JOptionPane.INFORMATION_MESSAGE);
//        }
//        return boletos;
//    }

}

