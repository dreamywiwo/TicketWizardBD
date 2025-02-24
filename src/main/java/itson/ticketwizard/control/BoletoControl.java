/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.dtos.BoletoEventoDTO;
import itson.ticketwizard.dtos.BoletoEventoTransaccionDTO;
import itson.ticketwizard.persistencia.BoletoDAO;
import itson.ticketwizard.presentacion.ResumenCompraPanel;
import itson.ticketwizard.presentacion.VentaBoletoPanel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Dana Chavez
 */
public class BoletoControl {
    private BoletoDAO boletoDAO;
    private ResumenCompraPanel compraBoleto;
    private VentaBoletoPanel ventaBoleto;
    private static final float COMISION_SERVICIO = 0.03f;

    public BoletoControl(BoletoDAO boletoDAO) {
        this.boletoDAO = boletoDAO;
    }

    public void iniciarCasoUsoVenta() {
        this.ventaBoleto = new VentaBoletoPanel();
        this.ventaBoleto.setVisible(true);
    }

    public void comprarBoleto(Integer numSerie, Integer idComprador, float precio) {
        if (numSerie == null || numSerie <= 0) {
            JOptionPane.showMessageDialog(ventaBoleto, "El número de serie debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (idComprador == null || idComprador <= 0) {
            JOptionPane.showMessageDialog(ventaBoleto, "El ID del comprador debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (precio <= 0) {
            JOptionPane.showMessageDialog(compraBoleto, "El precio debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float montoConComision = precio + (precio * COMISION_SERVICIO);
        boolean exito = boletoDAO.comprarBoleto(numSerie, idComprador, montoConComision);
        if (exito) {
            JOptionPane.showMessageDialog(compraBoleto, "Boleto comprado exitosamente. Se ha aplicado una comisión del 3%.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(compraBoleto, "Saldo insuficiente. El boleto se ha apartado durante 10 minutos.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void venderBoleto(Integer numSerie, Integer idVendedor, float precioReventa, float precioOriginal, String fechaLimiteVenta) {
        if (numSerie == null || numSerie <= 0) {
            JOptionPane.showMessageDialog(ventaBoleto, "El número de serie debe ser mayor a cero y no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (idVendedor == null || idVendedor <= 0) {
            JOptionPane.showMessageDialog(ventaBoleto, "El ID del vendedor debe ser mayor a cero y no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (precioReventa <= 0 || precioReventa > (precioOriginal + (precioOriginal * 0.03f))) {
            JOptionPane.showMessageDialog(ventaBoleto, "El precio de reventa no puede ser mayor al 3% del precio original.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            boolean exito = boletoDAO.venderBoleto(numSerie, idVendedor);
            if (exito) {
                JOptionPane.showMessageDialog(ventaBoleto, "Boleto marcado para reventa con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(ventaBoleto, "Error al poner el boleto a la venta. Verifique que el boleto le pertenezca y que esté reservado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(ventaBoleto, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<BoletoEventoDTO> obtenerBoletosDisponiblesPorEvento(Integer idEvento) {
        if (idEvento == null || idEvento <= 0) {
            JOptionPane.showMessageDialog(compraBoleto, "El ID de evento debe ser mayor a cero y no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        List<BoletoEventoDTO> boletos = boletoDAO.obtenerBoletosDisponiblesPorEvento(idEvento);
        if (boletos.isEmpty()) {
            JOptionPane.showMessageDialog(compraBoleto, "No se encontraron boletos disponibles para este evento.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        return boletos;
    }

    public List<BoletoEventoTransaccionDTO> obtenerBoletosDeUsuario(Integer idUsuario) {
        if (idUsuario == null || idUsuario <= 0) {
            JOptionPane.showMessageDialog(compraBoleto, "El ID de usuario debe ser mayor a cero y no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        List<BoletoEventoTransaccionDTO> boletos = boletoDAO.obtenerBoletosDeUsuario(idUsuario);
        if (boletos.isEmpty()) {
            JOptionPane.showMessageDialog(compraBoleto, "No se encontraron boletos para este usuario.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        return boletos;
    }

    public List<BoletoEventoTransaccionDTO> obtenerBoletosDeUsuarioPorEvento(Integer idUsuario, Integer idEvento) {
        if (idUsuario == null || idUsuario <= 0) {
            JOptionPane.showMessageDialog(compraBoleto, "El ID de usuario debe ser mayor a cero y no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (idEvento == null || idEvento <= 0) {
            JOptionPane.showMessageDialog(compraBoleto, "El ID de evento debe ser mayor a cero y no puede ser nulo.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        List<BoletoEventoTransaccionDTO> boletos = boletoDAO.obtenerBoletosDeUsuarioPorEvento(idUsuario, idEvento);
        if (boletos.isEmpty()) {
            JOptionPane.showMessageDialog(compraBoleto, "No se encontraron boletos para este usuario en el evento seleccionado.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        return boletos;
    }
}

