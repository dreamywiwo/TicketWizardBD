package itson.ticketwizard.presentacion;

import itson.ticketwizard.dtos.BoletoEventoDTO;
import java.awt.*;
import javax.swing.*;

public class BoletoEventoFormato extends JPanel {
    private BoletoEventoDTO boleto;
    private JButton btnSeleccionar;
    private boolean seleccionado = false;
    private BoletoEventoPanel parentPanel;

    public BoletoEventoFormato(BoletoEventoDTO boleto, BoletoEventoPanel parentPanel) {
        this.boleto = boleto;
        this.parentPanel = parentPanel;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
        setBackground(new Color(36, 11, 30)); 

        JLabel lblLocalCiudad = new JLabel(boleto.nombreLocal + " - " + boleto.ciudad);
        lblLocalCiudad.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
        lblLocalCiudad.setForeground(Color.WHITE);
        lblLocalCiudad.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblPrecio = new JLabel("$" + boleto.precio);
        lblPrecio.setFont(new Font("Baskerville Old Face", Font.BOLD, 40));
        lblPrecio.setForeground(Color.WHITE);
        lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblTipo = new JLabel(boleto.tipo);
        lblTipo.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
        lblTipo.setForeground(Color.WHITE);
        lblTipo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblFilaAsiento = new JLabel("<html>" + boleto.fila + "<br>" + boleto.numAsiento + "</html>");
        lblFilaAsiento.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 22));
        lblFilaAsiento.setForeground(Color.WHITE);
        lblFilaAsiento.setVerticalAlignment(SwingConstants.CENTER);
        lblFilaAsiento.setHorizontalAlignment(SwingConstants.LEFT);
        lblFilaAsiento.setPreferredSize(new Dimension(50, 100));

        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.setOpaque(false);
        infoPanel.add(lblLocalCiudad, BorderLayout.NORTH);
        infoPanel.add(lblPrecio, BorderLayout.CENTER);
        infoPanel.add(lblTipo, BorderLayout.SOUTH);

        btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setPreferredSize(new Dimension(120, 30));
        btnSeleccionar.setBackground(Color.WHITE);
        btnSeleccionar.setFont(new Font("Century Gothic", Font.BOLD, 12));
        btnSeleccionar.setForeground(new Color(0, 0, 0));

        btnSeleccionar.addActionListener(e -> toggleSeleccionBoleto());

        JPanel btnSeleccionarPanel = new JPanel(new GridBagLayout()); 
        btnSeleccionarPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;  
        gbc.gridy = 0;  
        gbc.anchor = GridBagConstraints.CENTER; 
        btnSeleccionarPanel.add(btnSeleccionar, gbc);

        add(lblFilaAsiento, BorderLayout.WEST);
        add(infoPanel, BorderLayout.CENTER);
        add(btnSeleccionarPanel, BorderLayout.EAST);
    }

    private void toggleSeleccionBoleto() {
        if (seleccionado) {
            parentPanel.removerBoletoSeleccionado(boleto);
        } else {
            parentPanel.agregarBoletoSeleccionado(boleto);
        }
        seleccionado = !seleccionado;
        actualizarEstilo();
    }

    private void actualizarEstilo() {
        if (seleccionado) {
            setBackground(new Color(90, 14, 51)); 
            btnSeleccionar.setBackground(new Color(50, 0, 30));
            btnSeleccionar.setForeground(Color.WHITE);
        } else {
            setBackground(new Color(36, 11, 30));
            btnSeleccionar.setBackground(Color.WHITE); 
            btnSeleccionar.setForeground(new Color(90, 14, 51)); 
        }
        btnSeleccionar.setText(seleccionado ? "Deseleccionar" : "Seleccionar");

        revalidate();  
        repaint();
    }
}
