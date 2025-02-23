/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EventoApp extends JFrame {
    private JPanel contenedorEventos;
    private JComboBox<String> comboCiudad, comboFecha;
    private JTextField txtBusqueda;

    public EventoApp(List<Evento> eventos) {
        setTitle("Seleccionar Evento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Panel superior con filtros
        JPanel panelFiltros = new JPanel();
        panelFiltros.setLayout(new FlowLayout());
        
        comboCiudad = new JComboBox<>(new String[]{"Todas", "CD. México", "Guadalajara", "Monterrey"});
        comboFecha = new JComboBox<>(new String[]{"Todas", "Febrero 2025", "Marzo 2025"});
        txtBusqueda = new JTextField(15);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> filtrarEventos(eventos));

        panelFiltros.add(comboCiudad);
        panelFiltros.add(comboFecha);
        panelFiltros.add(txtBusqueda);
        panelFiltros.add(btnBuscar);

        add(panelFiltros, BorderLayout.NORTH);

        // Panel donde se mostrarán los eventos
        contenedorEventos = new JPanel();
        contenedorEventos.setLayout(new BoxLayout(contenedorEventos, BoxLayout.Y_AXIS));

        cargarEventos(eventos);

        JScrollPane scrollPane = new JScrollPane(contenedorEventos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    private void cargarEventos(List<Evento> eventos) {
        contenedorEventos.removeAll();
        for (Evento evento : eventos) {
            contenedorEventos.add(new EventoPanel(evento));
        }
        contenedorEventos.revalidate();
        contenedorEventos.repaint();
    }

    private void filtrarEventos(List<Evento> eventos) {
        // Aquí iría la lógica para filtrar eventos según los filtros seleccionados
        cargarEventos(eventos); // De momento solo recarga los eventos sin filtrar
    }

    private class EventoPanel extends JPanel {
        public EventoPanel(Evento evento) {
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            setBackground(Color.LIGHT_GRAY);
            setPreferredSize(new Dimension(700, 100));

            JLabel lblNombre = new JLabel(evento.nombre);
            JLabel lblFecha = new JLabel(evento.fecha);
            JLabel lblUbicacion = new JLabel(evento.ubicacion);
            JButton btnTickets = new JButton("Obtener tickets");
            JButton btnInfo = new JButton("Información");

            JPanel infoPanel = new JPanel(new GridLayout(3, 1));
            infoPanel.add(lblNombre);
            infoPanel.add(lblFecha);
            infoPanel.add(lblUbicacion);

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(btnTickets);
            buttonPanel.add(btnInfo);

            add(infoPanel, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.EAST);
        }
    }

    static class Evento {
        String id, nombre, fecha, ubicacion;

        public Evento(String id, String nombre, String fecha, String ubicacion) {
            this.id = id;
            this.nombre = nombre;
            this.fecha = fecha;
            this.ubicacion = ubicacion;
        }
    }

    public static void main(String[] args) {
        List<Evento> eventos = List.of(
            new Evento("001", "Hamilton", "28 FEB 2025", "Teatro de Bellas Artes - CD. México"),
            new Evento("002", "Hamilton", "01 MAR 2025", "Teatro de Bellas Artes - CD. México"),
            new Evento("003", "Hamilton", "07 MAR 2025", "Teatro de Bellas Artes - CD. México")
        );
        new EventoApp(eventos);
    }
}

