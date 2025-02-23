/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.presentacion;

import itson.ticketwizard.dtos.BoletoDTO;
import itson.ticketwizard.dtos.BoletoEventoDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Dana Chavez
 */
public class BoletoPanel extends JPanel {
    private BoletoEventoDTO boleto;
    private JButton btnSeleccionar;
    private boolean seleccionado = false;

    public BoletoPanel(BoletoEventoDTO boleto) {
        this.boleto = boleto;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(new Color(36, 11, 30));
        setPreferredSize(new Dimension(400, 110));

        // Crear etiquetas con la información del boleto
        JLabel lblLocal = new JLabel(boleto.getNombreLocal() + " - " + boleto.getCiudad());
        lblLocal.setForeground(Color.WHITE);
        lblLocal.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));

        JLabel lblPrecio = new JLabel("$" + boleto.getPrecio());
        lblPrecio.setForeground(Color.WHITE);
        lblPrecio.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
        lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblFilaAsiento = new JLabel("Fila: " + boleto.getFila() + " | Asiento: " + boleto.getNumAsiento());
        lblPrecio.setForeground(Color.WHITE);
        lblFilaAsiento.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));

        // Botón para seleccionar/deseleccionar boleto
        btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addActionListener(e -> toggleSeleccion());

        // Panel de información
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 1));
        infoPanel.add(lblLocal);
        infoPanel.add(lblPrecio);
        infoPanel.add(lblFilaAsiento);

        add(infoPanel, BorderLayout.CENTER);
        add(btnSeleccionar, BorderLayout.SOUTH);
    }

    private void toggleSeleccion() {
        seleccionado = !seleccionado;
        btnSeleccionar.setText(seleccionado ? "Deseleccionar" : "Seleccionar");
        setBackground(seleccionado ? Color.GREEN : Color.LIGHT_GRAY);
        // Aquí puedes agregar lógica para actualizar el total o moverlo a otra lista
        
    }
}