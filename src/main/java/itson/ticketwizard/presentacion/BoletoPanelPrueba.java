package itson.ticketwizard.presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoletoPanelPrueba extends JPanel {
    private JPanel contenedorBoletos;
    private JPanel panelSeleccionados;
    private JLabel lblTotal;
    private List<Boleto> boletosSeleccionados;
    private double total;

    public BoletoPanelPrueba(List<Boleto> boletos) {
        setLayout(new BorderLayout());

        boletosSeleccionados = new ArrayList<>();
        total = 0;

        contenedorBoletos = new JPanel();
        contenedorBoletos.setLayout(new BoxLayout(contenedorBoletos, BoxLayout.Y_AXIS));
        contenedorBoletos.setBackground(Color.decode("#240B1E"));

        for (Boleto boleto : boletos) {
            contenedorBoletos.add(new BoletoPanel(boleto));
        }

        JScrollPane scrollPane = new JScrollPane(contenedorBoletos);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(350, 400));

        panelSeleccionados = new JPanel();
        panelSeleccionados.setLayout(new BoxLayout(panelSeleccionados, BoxLayout.Y_AXIS));
        panelSeleccionados.setBackground(Color.decode("#5A0E33"));

        lblTotal = new JLabel("Total: $0.00");
        lblTotal.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        lblTotal.setForeground(Color.WHITE);

        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(e -> JOptionPane.showMessageDialog(this, "Continuando con la compra..."));

        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BorderLayout());
        panelDerecho.setPreferredSize(new Dimension(200, 400));
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Boletos Seleccionados"));

        panelDerecho.add(panelSeleccionados, BorderLayout.CENTER);
        panelDerecho.add(lblTotal, BorderLayout.NORTH);
        panelDerecho.add(btnSiguiente, BorderLayout.SOUTH);

        add(scrollPane, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.EAST);
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

            JLabel lblLocalCiudad = new JLabel(boleto.local + " - " + boleto.ciudad);
            lblLocalCiudad.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
            lblLocalCiudad.setHorizontalAlignment(SwingConstants.CENTER);

            JLabel lblPrecio = new JLabel("$" + boleto.precio);
            lblPrecio.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
            lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);

            JLabel lblTipo = new JLabel(boleto.tipo);
            lblTipo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
            lblTipo.setHorizontalAlignment(SwingConstants.CENTER);

            JLabel lblFilaAsiento = new JLabel(boleto.fila + "\n" + boleto.numero);
            lblFilaAsiento.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
            lblFilaAsiento.setVerticalAlignment(SwingConstants.CENTER);
            lblFilaAsiento.setHorizontalAlignment(SwingConstants.LEFT);
            lblFilaAsiento.setPreferredSize(new Dimension(50, 100));

            btnSeleccionar = new JButton("Seleccionar");
            btnSeleccionar.addActionListener(e -> toggleSeleccionBoleto());

            JPanel infoPanel = new JPanel(new BorderLayout());
            infoPanel.add(lblLocalCiudad, BorderLayout.NORTH);
            infoPanel.add(lblPrecio, BorderLayout.CENTER);
            infoPanel.add(lblTipo, BorderLayout.SOUTH);

            add(lblFilaAsiento, BorderLayout.WEST);
            add(infoPanel, BorderLayout.CENTER);
            add(btnSeleccionar, BorderLayout.EAST);
        }

        private void toggleSeleccionBoleto() {
            if (boletosSeleccionados.contains(boleto)) {
                boletosSeleccionados.remove(boleto);
                btnSeleccionar.setText("Seleccionar");
            } else {
                boletosSeleccionados.add(boleto);
                btnSeleccionar.setText("Deseleccionar");
            }
            actualizarBoletosSeleccionados();
        }
    }

    private void actualizarBoletosSeleccionados() {
        panelSeleccionados.removeAll();
        total = 0;

        for (Boleto boleto : boletosSeleccionados) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1));
            panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
            panel.setBackground(Color.decode("#D9D9D9"));
            panel.add(new JLabel("Fila: " + boleto.fila + " - Número: " + boleto.numero));
            panel.add(new JLabel(boleto.local + " - " + boleto.ciudad));

            panelSeleccionados.add(panel);
            total += boleto.precio;
        }

        lblTotal.setText("Total: $" + total);
        panelSeleccionados.revalidate();
        panelSeleccionados.repaint();
    }

    static class Boleto {
        String idBoleto, local, ciudad, tipo, fila, numero;
        double precio;

        public Boleto(String idBoleto, String local, String ciudad, String tipo, String fila, String numero, double precio) {
            this.idBoleto = idBoleto;
            this.local = local;
            this.ciudad = ciudad;
            this.tipo = tipo;
            this.fila = fila;
            this.numero = numero;
            this.precio = precio;
        }
    }

    public static void main(String[] args) {
        List<Boleto> boletos = List.of(
            new Boleto("001", "Auditorio Nacional", "CDMX", "VIP", "A", "1", 1700.00),
            new Boleto("002", "Teatro de la Ciudad", "Monterrey", "General", "B", "15", 750.00),
            new Boleto("003", "Centro de Convenciones", "Guadalajara", "Preferente", "C", "22", 1200.00)
        );

        JFrame frame = new JFrame("BoletoApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.add(new BoletoPanelPrueba(boletos));
        frame.setVisible(true);
    }
}