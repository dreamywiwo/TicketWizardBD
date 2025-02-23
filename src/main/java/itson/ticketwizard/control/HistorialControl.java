package itson.ticketwizard.control;

import java.util.List;
import itson.ticketwizard.entidades.Historial;
import itson.ticketwizard.persistencia.HistorialDAO;

/**
 * 
@author payde
*/

public class HistorialControl {

    private HistorialDAO historialDAO;

    public HistorialControl(HistorialDAO historialDAO) {
        this.historialDAO = historialDAO;
    }

    
    public List<Historial> obtenerHistorialBoletos(Integer idUsuario) {
        if (idUsuario == null || idUsuario <= 0) {
            throw new IllegalArgumentException("El identificador del usuario es inválido.");
        }
        
        List<Historial> historial = this.historialDAO.obtenerHistorialBoletos(idUsuario);

        if (historial == null || historial.isEmpty()) {
            System.out.println("No se encontró historial de boletos para el usuario con id: " + idUsuario);
        }

        return historial;
    }


    public boolean registrarHistorial(Integer idTransaccion, Integer numSerie) {
        if (idTransaccion == null || idTransaccion <= 0) {
            throw new IllegalArgumentException("El identificador de transacción es inválido.");
        }
        if (numSerie == null || numSerie <= 0) {
            throw new IllegalArgumentException("El número de serie es inválido.");
        }
        
        boolean exito = this.historialDAO.registrarHistorial(idTransaccion, numSerie);
        
        if (exito) {
            System.out.println("Historial registrado correctamente.");
        } else {
            System.err.println("No se pudo registrar el historial.");
        }
        
        return exito;
    }
}

