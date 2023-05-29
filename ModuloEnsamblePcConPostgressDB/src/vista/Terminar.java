package vista;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.*;
import javax.swing.*;

public class Terminar extends JPanel{
    private Ventana vtn;
    private JLabel lblTotalProSer, lblIva, lblTotalFact;
    private JTextField txfTotalProSer, txfIva, txfTotalFact;
    private JButton btnSalir, btnVolver;

    public Terminar(Ventana vtn){
        this.vtn = vtn;
        GridBagConstraints gbc;
        
        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(24, 74, 102), 1),
                "Calculo del total",
                TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, new Font("SansSerif", 1, 20),
                new Color(24, 74, 102)));
        this.setBackground(new Color(83, 153, 176));

        lblTotalProSer = new JLabel("Total productos y servicios");
        lblTotalProSer.setFont(new Font("SansSerif", 0, 16));
        lblTotalProSer.setForeground(new Color(24, 74, 102));
        gbc = new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0);
        this.add(lblTotalProSer, gbc);

        txfTotalProSer = new JTextField();
        txfTotalProSer.setPreferredSize(new Dimension(180, 30));
        txfTotalProSer.setEditable(false);
        txfTotalProSer.setFont(new Font("SansSerif", 0, 16));
        gbc = new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0);
        this.add(txfTotalProSer, gbc);

        lblIva = new JLabel("Iva(16% sobre el total)");
        lblIva.setFont(new Font("SansSerif", 0, 16));
        lblIva.setForeground(new Color(24, 74, 102));
        gbc = new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0);
        this.add(lblIva, gbc);

        txfIva = new JTextField();
        txfIva.setPreferredSize(new Dimension(180, 30));
        txfIva.setEditable(false);
        txfIva.setFont(new Font("SansSerif", 0, 16));
        gbc = new GridBagConstraints(0, 3, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0);
        this.add(txfIva, gbc);

        lblTotalFact = new JLabel("Total Factura");
        lblTotalFact.setFont(new Font("SansSerif", 0, 16));
        lblTotalFact.setForeground(new Color(24, 74, 102));
        gbc = new GridBagConstraints(0, 4, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0);
        this.add(lblTotalFact, gbc);

        txfTotalFact = new JTextField();
        txfTotalFact.setPreferredSize(new Dimension(180, 30));
        txfTotalFact.setEditable(false);
        txfTotalFact.setFont(new Font("SansSerif", 0, 16));
        gbc = new GridBagConstraints(0, 5, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0);
        this.add(txfTotalFact, gbc);

        btnVolver = new JButton("");
        btnVolver.setPreferredSize(new Dimension(80, 50));
        gbc = new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0);
        ImageIcon imagen3 = new ImageIcon(getClass().getResource("/imgs/volver.jpg"));
        Icon icon3 = new ImageIcon(imagen3.getImage().getScaledInstance(75, 45, Image.SCALE_DEFAULT));
        btnVolver.setIcon(icon3);
        btnVolver.setActionCommand("VolverEnsamble");
        btnVolver.addActionListener(this.vtn.getCtrl());
        this.add(btnVolver, gbc);

        btnSalir = new JButton("");
        btnSalir.setPreferredSize(new Dimension(70, 50));
        gbc = new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0);
        ImageIcon imagen2 = new ImageIcon(getClass().getResource("/imgs/salir.jpg"));
        Icon icon2 = new ImageIcon(imagen2.getImage().getScaledInstance(90, 50, Image.SCALE_DEFAULT));
        btnSalir.setIcon(icon2);
        btnSalir.setActionCommand("Salir");
        btnSalir.addActionListener(this.vtn.getCtrl());
        this.add(btnSalir, gbc);
    }

    public void limpiarCampos() {
        txfTotalProSer.setText("");
        txfIva.setText("");
        txfTotalFact.setText("");
    }

    public Ventana getVtn() {
        return vtn;
    }

    public JLabel getLblTotalProSer() {
        return lblTotalProSer;
    }

    public JLabel getLblIva() {
        return lblIva;
    }

    public JLabel getLblTotalFact() {
        return lblTotalFact;
    }

    public JTextField getTxfTotalProSer() {
        return txfTotalProSer;
    }

    public JTextField getTxfIva() {
        return txfIva;
    }

    public JTextField getTxfTotalFact() {
        return txfTotalFact;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    
    
}
