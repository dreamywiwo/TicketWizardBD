
package itson.ticketwizard.control;

import itson.ticketwizard.dtos.TransaccionDTO;
import itson.ticketwizard.persistencia.TransaccionDAO;
import java.util.List;


/**
 *
 * @author Dana Chavez
 */

public class TransaccionControl {
    private TransaccionDAO transaccionDAO;
    
    public TransaccionControl(TransaccionDAO transaccionDAO) {
        this.transaccionDAO = transaccionDAO;
    }

    public boolean registrarTransaccion(Integer idComprador, Integer idVendedor, float monto, Integer idApartado) {
        // Validaciones de datos de entrada
        if (idComprador == null || idVendedor == null) {
            throw new IllegalArgumentException("Los identificadores del comprador y vendedor no pueden ser nulos.");
        }
        if (idComprador.equals(idVendedor)) {
            throw new IllegalArgumentException("El comprador y el vendedor deben ser diferentes.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }
        if (idApartado == null) {
            throw new IllegalArgumentException("El identificador del apartado no puede ser nulo.");
        }
        
     
        return transaccionDAO.registrarTransaccion(idComprador, idVendedor, monto, idApartado);
    }
    
    
    public List<TransaccionDTO> consultarTransaccionesPorUsuario(Integer idUsuario) {
        if (idUsuario == null) {
            throw new IllegalArgumentException("El identificador del usuario no puede ser nulo.");
        }
        return transaccionDAO.obtenerTransaccionesPorUsuario(idUsuario);
    }
}
