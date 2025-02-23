/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.control;

import itson.ticketwizard.persistencia.ApartadoDAO;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author payde
 */
public class ApartadoControl {
    
    private ApartadoDAO apartadoDAO;
    //private FormRegistroApartado formRegistroApartado;
   // private FormCatalogoApartados formCatalogoApartados;

    public ApartadoControl(ApartadoDAO apartadoDAO) {
        this.apartadoDAO = apartadoDAO;
    }
    
//    public void iniciarCasoUso() {
//        this.formRegistroApartado = new FormRegistroApartado(this);
//        this.formRegistroApartado.setVisible(true);
//    }

//    public void registrarApartado(Integer numSerie, Integer idUsuario) {
//        boolean exito = this.apartadoDAO.registrarApartado(numSerie, idUsuario);
//        
//        if (exito) {
//            JOptionPane.showMessageDialog(formRegistroApartado, "Se registró el apartado", "Información", JOptionPane.INFORMATION_MESSAGE);
//            this.mostrarFormularioCatalogoApartados();
//        } else {
//            JOptionPane.showMessageDialog(formRegistroApartado, "No se pudo registrar el apartado", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }

//    public void eliminarApartado(int idApartado) {
//        boolean exito = this.apartadoDAO.eliminarApartado(idApartado);
//        
//        if (exito) {
//            JOptionPane.showMessageDialog(formCatalogoApartados, "Apartado eliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(formCatalogoApartados, "No se pudo eliminar el apartado", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    private void mostrarFormularioCatalogoApartados() {
//        this.formCatalogoApartados = new FormCatalogoApartados(this);
//        this.formCatalogoApartados.setVisible(true);
//    }
}


