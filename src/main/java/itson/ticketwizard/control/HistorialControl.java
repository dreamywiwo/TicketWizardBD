/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import java.util.List;
import javax.swing.JOptionPane;
import itson.ticketwizard.entidades.Historial;
import itson.ticketwizard.persistencia.HistorialDAO;
/**
 *
 * @author payde
 */
public class HistorialControl {
 
    private HistorialDAO historialDAO;
//    private FormHistorialBoletos formHistorialBoletos;
    
    public HistorialControl(HistorialDAO historialDAO) {
        this.historialDAO = historialDAO;
    }
    
//    public void iniciarCasoUso() {
//        this.formHistorialBoletos = new FormHistorialBoletos(this);
//        this.formHistorialBoletos.setVisible(true);
//    }

    public List<Historial> obtenerHistorialBoletos(Integer idUsuario) {
        List<Historial> historial = this.historialDAO.obtenerHistorialBoletos(idUsuario);
        
        if (historial == null || historial.isEmpty()) {
//            JOptionPane.showMessageDialog(formHistorialBoletos, "No se encontró historial de boletos", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return historial;
    }

    public void registrarHistorial(Integer idTransaccion, Integer numSerie) {
        boolean exito = this.historialDAO.registrarHistorial(idTransaccion, numSerie);
        
        if (exito) {
//            JOptionPane.showMessageDialog(formHistorialBoletos, "Historial registrado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
//            JOptionPane.showMessageDialog(formHistorialBoletos, "No se pudo registrar el historial", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


