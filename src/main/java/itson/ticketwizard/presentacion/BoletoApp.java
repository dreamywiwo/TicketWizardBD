/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BoletoApp extends JFrame {
    private JPanel contenedorBoletos;
    private JPanel panelSeleccionados;
    private JLabel lblTotal;
    private List<Boleto> boletosSeleccionados;
    private double total;

    public BoletoApp(List<Boleto> boletos) {
        setTitle("Boletos Disponibles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        boletosSeleccionados = new ArrayList<>();
        total = 0;

        // Panel donde se mostrarán los boletos disponibles
        contenedorBoletos = new JPanel();
        contenedorBoletos.setLayout(new BoxLayout(contenedorBoletos, BoxLayout.Y_AXIS));

        for (Boleto boleto : boletos) {
            contenedorBoletos.add(new BoletoPanel(boleto));
        }

        JScrollPane scrollPane = new JScrollPane(contenedorBoletos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(350, 400));

        // Panel donde se mostrarán los boletos seleccionados
        panelSeleccionados = new JPanel();
        panelSeleccionados.setLayout(new BoxLayout(panelSeleccionados, BoxLayout.Y_AXIS));

        lblTotal = new JLabel("Total: $0.00");

        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Continuando con la compra...");
        });

        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BorderLayout());
        panelDerecho.setPreferredSize(new Dimension(200, 400));
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Boletos Seleccionados"));

        panelDerecho.add(panelSeleccionados, BorderLayout.CENTER);
        panelDerecho.add(lblTotal, BorderLayout.NORTH);
        panelDerecho.add(btnSiguiente, BorderLayout.SOUTH);

        add(scrollPane, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.EAST);

        setVisible(true);
    }

    private class BoletoPanel extends JPanel {
        private Boleto boleto;
        private JButton btnSeleccionar;

        public BoletoPanel(Boleto boleto) {
            this.boleto = boleto;
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            setBackground(Color.LIGHT_GRAY);
            setPreferredSize(new Dimension(300, 100));

            JLabel lblEvento = new JLabel("Evento: " + boleto.evento);
            JLabel lblFila = new JLabel("Fila: " + boleto.fila);
            JLabel lblNumero = new JLabel("Número: " + boleto.numero);
            JLabel lblPrecio = new JLabel("Precio: $" + boleto.precio);
            btnSeleccionar = new JButton("Seleccionar");

            btnSeleccionar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (boletosSeleccionados.contains(boleto)) {
                        boletosSeleccionados.remove(boleto);
                        actualizarBoletosSeleccionados();
                        btnSeleccionar.setText("Seleccionar");
                    } else {
                        boletosSeleccionados.add(boleto);
                        actualizarBoletosSeleccionados();
                        btnSeleccionar.setText("Deseleccionar");
                    }
                }
            });

            JPanel infoPanel = new JPanel(new GridLayout(4, 1));
            infoPanel.add(lblEvento);
            infoPanel.add(lblFila);
            infoPanel.add(lblNumero);
            infoPanel.add(lblPrecio);

            add(infoPanel, BorderLayout.CENTER);
            add(btnSeleccionar, BorderLayout.EAST);
        }
    }

    private void actualizarBoletosSeleccionados() {
        panelSeleccionados.removeAll();
        total = 0;

        for (Boleto boleto : boletosSeleccionados) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1));
            panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            panel.add(new JLabel("Fila: " + boleto.fila + " - Número: " + boleto.numero));
            panel.add(new JLabel(boleto.evento));

            panelSeleccionados.add(panel);
            total += boleto.precio;
        }

        lblTotal.setText("Total: $" + total);
        panelSeleccionados.revalidate();
        panelSeleccionados.repaint();
    }

    static class Boleto {
        String idBoleto, evento, fila, numero;
        double precio;

        public Boleto(String idBoleto, String evento, String fila, String numero, double precio) {
            this.idBoleto = idBoleto;
            this.evento = evento;
            this.fila = fila;
            this.numero = numero;
            this.precio = precio;
        }
    }

    public static void main(String[] args) {
        List<Boleto> boletos = List.of(
            new Boleto("001", "Concierto Rock", "A", "1", 1700.00),
            new Boleto("002", "Teatro Clásico", "A", "2", 1751.00),
            new Boleto("003", "Feria Tecnológica", "A", "3", 1700.00)
        );

        new BoletoApp(boletos);
    }
}

