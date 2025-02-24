/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.ticketwizard.presentacion;

import itson.ticketwizard.dtos.TransaccionDTO;
import javax.swing.*;
import java.awt.*;

public class TransaccionFormato extends JPanel {
    private final TransaccionDTO transaccion;

    public TransaccionFormato(TransaccionDTO transaccion) {
        this.transaccion = transaccion;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setBackground(new Color(36, 11, 30));
        setPreferredSize(new Dimension(640, 120));

        JLabel lblID = new JLabel("ID Transacción: " + transaccion.getIdTransaccion());
        JLabel lblFecha = new JLabel("Fecha y Hora: " + transaccion.getFechaHora().toString());
        JLabel lblMonto = new JLabel("Monto: $" + transaccion.getMonto());
        JLabel lblComision = new JLabel("Comisión: $" + transaccion.getComision());
        JLabel lblVendedor = new JLabel("ID Vendedor: " + transaccion.getIdVendedor());
        JLabel lblComprador = new JLabel("ID Comprador: " + transaccion.getIdComprador());

        Font fuente = new Font("Leelawadee UI Semilight", Font.BOLD, 14);
        Color colorTexto = Color.WHITE;

        for (JLabel label : new JLabel[]{lblID, lblFecha, lblMonto, lblComision, lblVendedor, lblComprador}) {
            label.setFont(fuente);
            label.setForeground(colorTexto);
            label.setHorizontalAlignment(SwingConstants.CENTER);
        }

        JPanel infoPanel = new JPanel(new GridLayout(3, 2));
        infoPanel.setOpaque(false);
        infoPanel.add(lblID);
        infoPanel.add(lblFecha);
        infoPanel.add(lblMonto);
        infoPanel.add(lblComision);
        infoPanel.add(lblVendedor);
        infoPanel.add(lblComprador);

        add(infoPanel, BorderLayout.CENTER);
    }
}

