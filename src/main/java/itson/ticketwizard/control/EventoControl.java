
package itson.ticketwizard.control;
import itson.ticketwizard.persistencia.EventoDAO;
import itson.ticketwizard.entidades.Evento;
import itson.ticketwizard.dtos.EventoDTO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dana Chavez
 */

public class EventoControl {    
    private EventoDAO eventoDAO;
    
    public EventoControl(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }
     
    
    public Evento buscarEventoPorId(Integer idEvento) {
        if (idEvento == null || idEvento <= 0) {
            throw new IllegalArgumentException("El identificador del evento es inválido.");
        }
        Evento evento = eventoDAO.buscarEventoPorId(idEvento);
        if (evento == null) {
            System.out.println("No se encontró evento con id: " + idEvento);
        }
        return evento;
    }
    

    public List<EventoDTO> buscarEventosPorFiltro(String ciudad, String nombreEvento, Date fechaEvento) {
        if (ciudad == null || ciudad.trim().isEmpty()) {
            throw new IllegalArgumentException("La ciudad no puede ser nula o vacía.");
        }
        if (nombreEvento == null || nombreEvento.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del evento no puede ser nulo o vacío.");
        }
        if (fechaEvento == null) {
            throw new IllegalArgumentException("La fecha del evento no puede ser nula.");
        }
        
        List<EventoDTO> listaEventos = eventoDAO.buscarEventosPorFiltro(ciudad, nombreEvento, fechaEvento);
        if (listaEventos == null || listaEventos.isEmpty()) {
            System.out.println("No se encontraron eventos con los criterios especificados.");
        }
        return listaEventos;
    }
    
    
    public List<EventoDTO> obtenerTodosLosEventos() {
        List<EventoDTO> listaEventos = eventoDAO.obtenerTodosLosEventos();
        if (listaEventos == null) {
            // En caso de error, se retorna una lista vacía para evitar nulls.
            listaEventos = new ArrayList<>();
            System.out.println("No se encontraron eventos.");
        }
        return listaEventos;
    }
}

