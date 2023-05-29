package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ConsultaClie extends JPanel {
        private Ventana vtn;
        private JLabel lblCedClie;
        private JTextField txfCedClie;
        private JButton btnConsultar;

        public ConsultaClie(Ventana vtn) {
                this.vtn = vtn;
                GridBagConstraints gbc;

                this.setLayout(new GridBagLayout());
                this.setBorder(BorderFactory.createTitledBorder(
                                BorderFactory.createLineBorder(new Color(24, 74, 102), 1),
                                "Consulta del cliente",
                                TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION,
                                new Font("SansSerif", 1, 20),
                                new Color(24, 74, 102)));
                this.setBackground(new Color(83, 153, 176));

                lblCedClie = new JLabel("Cedula del cliente");
                lblCedClie.setFont(new Font("SansSerif", 0, 18));
                lblCedClie.setForeground(new Color(24, 74, 102));
                gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                new Insets(5, 5, 5, 5), 0, 0);
                add(lblCedClie, gbc);

                txfCedClie = new JTextField();
                txfCedClie.setPreferredSize(new Dimension(180, 30));
                txfCedClie.setFont(new Font("SansSerif", 0, 16));
                gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                new Insets(5, 5, 5, 5), 0, 0);
                add(txfCedClie, gbc);

                btnConsultar = new JButton("");
                btnConsultar.setPreferredSize(new Dimension(60, 60));
                gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                new Insets(5, 5, 5, 5), 0, 0);
                ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imgs/consulta.jpg"));
                Icon icon1 = new ImageIcon(imagen1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                btnConsultar.setIcon(icon1);
                btnConsultar.setActionCommand("Consultar");
                btnConsultar.addActionListener(this.vtn.getCtrl());
                add(btnConsultar, gbc);
        }

        public void limpiarCampo() {
                txfCedClie.setText("");
        }

        public Ventana getVtn() {
                return vtn;
        }

        public JLabel getLblCedClie() {
                return lblCedClie;
        }

        public JTextField getTxfCedClie() {
                return txfCedClie;
        }

        public JButton getBtnConsultar() {
                return btnConsultar;
        }

}
