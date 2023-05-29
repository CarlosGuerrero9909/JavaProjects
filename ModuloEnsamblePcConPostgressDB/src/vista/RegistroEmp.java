package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class RegistroEmp extends JPanel {
        private Ventana vtn;
        private JLabel lblCodEmp;
        private JTextField txfCodEmp;
        private JButton btnRegistrar;

        public RegistroEmp(Ventana vtn) {
                this.vtn = vtn;
                GridBagConstraints gbc;

                this.setLayout(new GridBagLayout());
                this.setBorder(BorderFactory.createTitledBorder(
                                BorderFactory.createLineBorder(new Color(24, 74, 102), 1),
                                "Registro del empleado",
                                TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION,
                                new Font("SansSerif", 1, 20),
                                new Color(24, 74, 102)));
                this.setBackground(new Color(83, 153, 176));

                lblCodEmp = new JLabel("Codigo del empleado ");
                lblCodEmp.setAlignmentX(50);
                lblCodEmp.setFont(new Font("SansSerif", 0, 18));
                lblCodEmp.setForeground(new Color(24, 74, 102));
                gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                new Insets(5, 5, 5, 5), 0, 0);
                add(lblCodEmp, gbc);

                txfCodEmp = new JTextField();
                txfCodEmp.setPreferredSize(new Dimension(180, 30));
                txfCodEmp.setFont(new Font("SansSerif", 0, 16));
                gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                new Insets(5, 5, 5, 5), 0, 0);
                add(txfCodEmp, gbc);

                btnRegistrar = new JButton("");
                btnRegistrar.setPreferredSize(new Dimension(60, 60));
                gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                                new Insets(5, 5, 5, 5), 0, 0);
                ImageIcon imagen1 = new ImageIcon(getClass().getResource("/imgs/btnReg.png"));
                Icon icon1 = new ImageIcon(imagen1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                btnRegistrar.setIcon(icon1);
                btnRegistrar.setActionCommand("Registrar");
                btnRegistrar.addActionListener(this.vtn.getCtrl());
                add(btnRegistrar, gbc);

        }

        public Ventana getVtn() {
                return vtn;
        }

        public JLabel getLblCodEmp() {
                return lblCodEmp;
        }

        public JTextField getTxfCodEmp() {
                return txfCodEmp;
        }

        public JButton getBtnRegistrar() {
                return btnRegistrar;
        }

        public void limpiarCampo() {
                txfCodEmp.setText("");
        }
}
