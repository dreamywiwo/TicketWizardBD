/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.presentacion;

import itson.ticketwizard.dtos.BoletoEventoDTO;
import itson.ticketwizard.dtos.EventoDTO;
import itson.ticketwizard.persistencia.BoletoDAO;
import itson.ticketwizard.persistencia.ManejadorConexiones;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class BusquedaEventoFormato extends JPanel {

    private EventoDTO evento;
    private BusquedaEventoPanel parentPanel;
    ManejadorConexiones conexiones = new ManejadorConexiones();

    public BusquedaEventoFormato(EventoDTO evento, BusquedaEventoPanel parentPanel) {
        this.evento = evento;
        this.parentPanel = parentPanel;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
        setBackground(new Color(36, 11, 30));

        JLabel lblLocalCiudad = new JLabel(evento.getNombreLocal() + " - " + evento.getCiudad());
        lblLocalCiudad.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
        lblLocalCiudad.setForeground(Color.WHITE);
        lblLocalCiudad.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblNombreEvento = new JLabel(evento.getNombreEvento());
        lblNombreEvento.setFont(new Font("Baskerville Old Face", Font.BOLD, 32));
        lblNombreEvento.setForeground(Color.WHITE);
        lblNombreEvento.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblBoletosDisponibles = new JLabel("BOLETOS DISPONIBLES");
        lblBoletosDisponibles.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
        lblBoletosDisponibles.setForeground(new Color(255, 182, 193));
        lblBoletosDisponibles.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblFechaHora = new JLabel("<html>" + evento.getFechaEvento() + "<br>" + evento.getHoraEvento() + "</html>");
        lblFechaHora.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
        lblFechaHora.setForeground(Color.WHITE);
        lblFechaHora.setVerticalAlignment(SwingConstants.CENTER);
        lblFechaHora.setHorizontalAlignment(SwingConstants.LEFT);
        lblFechaHora.setPreferredSize(new Dimension(100, 100));

        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setOpaque(false);
        infoPanel.add(lblLocalCiudad, BorderLayout.NORTH);
        infoPanel.add(lblNombreEvento, BorderLayout.CENTER);
        infoPanel.add(lblBoletosDisponibles, BorderLayout.SOUTH);

        JButton btnObtenerBoletos = new JButton("Obtener Boletos");
        btnObtenerBoletos.setPreferredSize(new Dimension(150, 30));
        btnObtenerBoletos.setBackground(Color.WHITE);
        btnObtenerBoletos.setFont(new Font("Century Gothic", Font.BOLD, 12));
        btnObtenerBoletos.setForeground(new Color(0, 0, 0));

        btnObtenerBoletos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoletoEventoPanel boletoEvento = new BoletoEventoPanel(inicializarListaBoletos(evento.getIdEvento()));
                boletoEvento.setVisible(true);

            }
        });

        JButton btnMasInformacion = new JButton("Más Información");
        btnMasInformacion.setPreferredSize(new Dimension(150, 30));
        btnMasInformacion.setBackground(Color.WHITE);
        btnMasInformacion.setFont(new Font("Century Gothic", Font.BOLD, 12));
        btnMasInformacion.setForeground(new Color(0, 0, 0));

        JPanel btnPanel = new JPanel(new GridBagLayout());
        btnPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        btnPanel.add(btnObtenerBoletos, gbc);

        gbc.gridy = 1;
        btnPanel.add(btnMasInformacion, gbc);

        add(lblFechaHora, BorderLayout.WEST);
        add(infoPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.EAST);
    }
    
    public java.util.List<BoletoEventoDTO> inicializarListaBoletos(Integer idEvento) {
    java.util.List<BoletoEventoDTO> listaBoletos;
    BoletoDAO boletoDAO = new BoletoDAO(conexiones);
    listaBoletos = boletoDAO.obtenerBoletosDisponiblesPorEvento(idEvento);
    if (listaBoletos == null) {
        listaBoletos = new ArrayList<>(); // Evita que la lista sea nula
    }
        System.out.println(listaBoletos);
    return listaBoletos;
}
}
