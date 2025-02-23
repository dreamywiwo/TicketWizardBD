
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
    
    public boolean registrarTransaccion(Integer idComprador, Integer idVendedor, float monto, Integer idApartado, Integer cantidadBoletos, Integer numSerie, float precio) {

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
        if (cantidadBoletos == null || cantidadBoletos <= 0) {
            throw new IllegalArgumentException("La cantidad de boletos debe ser mayor a cero.");
        }
        if (numSerie == null) {
            throw new IllegalArgumentException("El número de serie no puede ser nulo.");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a cero.");
        }
        
        return transaccionDAO.registrarTransaccion(idComprador, idVendedor, monto, idApartado, cantidadBoletos, numSerie, precio);
    }
    
    public List<TransaccionDTO> consultarTransaccionesPorUsuario(Integer idUsuario) {
        if (idUsuario == null) {
            throw new IllegalArgumentException("El identificador del usuario no puede ser nulo.");
        }
        return transaccionDAO.obtenerTransaccionesPorUsuario(idUsuario);
    }
}