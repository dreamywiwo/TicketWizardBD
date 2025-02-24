package itson.ticketwizard.presentacion;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import itson.ticketwizard.dtos.BoletoEventoTransaccionDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BoletoUsuarioFormato extends JPanel {
    private final BoletoEventoTransaccionDTO boleto;

    public BoletoUsuarioFormato(BoletoEventoTransaccionDTO boleto) {
       this.boleto = boleto;

       setLayout(new BorderLayout());
       setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.WHITE));
       setBackground(new Color(36, 11, 30));
       setPreferredSize(new Dimension(640, 140));

       JLabel lblEvento = new JLabel(boleto.nombreEvento);
       lblEvento.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 30));
       lblEvento.setForeground(Color.WHITE);
       lblEvento.setHorizontalAlignment(SwingConstants.CENTER);

       JLabel lblFechaHora = new JLabel(boleto.fechaEvento.toString() + " - " + boleto.horaEvento.toString());
       lblFechaHora.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
       lblFechaHora.setForeground(Color.WHITE);
       lblFechaHora.setHorizontalAlignment(SwingConstants.CENTER);

       JLabel lblAsiento = new JLabel("Fila: " + boleto.fila + " - Asiento: " + boleto.numAsiento);
       lblAsiento.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 20));
       lblAsiento.setForeground(Color.WHITE);
       lblAsiento.setHorizontalAlignment(SwingConstants.CENTER);

       JLabel lblTransaccion = new JLabel("ID Transacción: " + boleto.idTransaccion);
       lblTransaccion.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
       lblTransaccion.setForeground(Color.WHITE);
       lblTransaccion.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnVender = new JButton("Vender");
        btnVender.setPreferredSize(new Dimension(120, 30));
        btnVender.setBackground(Color.WHITE);
        btnVender.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnVender.setForeground(new Color(0, 0, 0));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
        panelBoton.setOpaque(false);
        panelBoton.add(btnVender);
        
        add(panelBoton, BorderLayout.EAST);


       JPanel infoPanel = new JPanel(new GridLayout(5, 1));
       infoPanel.setOpaque(false);
       infoPanel.add(lblFechaHora);
       infoPanel.add(lblEvento);
       infoPanel.add(lblAsiento);
       infoPanel.add(lblTransaccion);

       JPanel barcodePanel = generarPanelCodigoBarras(boleto.numSerie);

       JPanel rightPanel = new JPanel(new BorderLayout());
       rightPanel.setOpaque(false);
       rightPanel.add(btnVender, BorderLayout.EAST);

       add(barcodePanel, BorderLayout.WEST);
       add(infoPanel, BorderLayout.CENTER);
       add(rightPanel, BorderLayout.EAST);
   }
    private JPanel generarPanelCodigoBarras(int numSerie) {
        int width = 200; 
        int height = 60;

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(
                    String.valueOf(numSerie),
                    BarcodeFormat.CODE_128,
                    width,
                    height
            );

            BufferedImage barcodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

            JPanel panelCodigo = new JPanel();
            panelCodigo.setLayout(new BorderLayout());
            panelCodigo.setOpaque(false); 

            JLabel barcodeLabel = new JLabel(new ImageIcon(barcodeImage));
            JLabel lblNumSerie = new JLabel(String.valueOf(numSerie), SwingConstants.CENTER);
            lblNumSerie.setFont(new Font("Leelawadee UI", Font.BOLD, 14));
            lblNumSerie.setForeground(Color.WHITE);

            panelCodigo.add(barcodeLabel, BorderLayout.CENTER);
            panelCodigo.add(lblNumSerie, BorderLayout.SOUTH);

            return panelCodigo;
        } catch (Exception e) {
            e.printStackTrace();
            return new JPanel(); 
        }
    }

}
