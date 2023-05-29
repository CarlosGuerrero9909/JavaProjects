package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Diaz
 */
public class PanelDatos extends JPanel {

    // atributos para objetos del panel
    private JLabel lblAltura;
    private JLabel lblPeso;
    private JTextField txtAltura;
    private JTextField txtPeso;

    // creacion de canal para comunicacion de ventana
    private Ventana vtn;

    /**
     * Constructor de panel que requiere una ventana para instanciarse
     *
     * @param vtn
     */
    public PanelDatos(Ventana vtn) {
        // creacion de canal de comunicacion con la ventana
        this.vtn = vtn;

        // creacion y configuracion de layout
        GridBagLayout gridbag = new GridBagLayout();
        setLayout(gridbag);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(24, 74, 102), 1), "Datos",
                TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, new Font("SansSerif", 1, 20), new Color(24, 74, 102)));
        setBackground(new Color(87, 195, 255));
        GridBagConstraints gbc;

        // configuracion de label altura
        lblAltura = new JLabel("Altura (centimetros): ");
        lblAltura.setFont(new Font("SansSerif", 0, 18));
        lblAltura.setForeground(new Color(24, 74, 102));
        gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
        add(lblAltura, gbc);

        // configuracion de label peso
        lblPeso = new JLabel("Peso (kilogramos): ");
        lblPeso.setFont(new Font("SansSerif", 0, 18));
        lblPeso.setForeground(new Color(24, 74, 102));
        gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
        add(lblPeso, gbc);

        // configuracion de label altura
        txtAltura = new JTextField();
        txtAltura.setPreferredSize(new Dimension(180, 30));
        txtAltura.setFont(new Font("SansSerif", 0, 16));
        gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
        add(txtAltura, gbc);

        // configuracion de label peso
        txtPeso = new JTextField();
        txtPeso.setPreferredSize(new Dimension(180, 30));
        txtPeso.setFont(new Font("SansSerif", 0, 16));
        gbc = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
        add(txtPeso, gbc);

    }

    /**
     *
     * @return
     */
    public JLabel getLblAltura() {
        return lblAltura;
    }

    /**
     *
     * @param lblAltura
     */
    public void setLblAltura(JLabel lblAltura) {
        this.lblAltura = lblAltura;
    }

    /**
     *
     * @return
     */
    public JLabel getLblPeso() {
        return lblPeso;
    }

    /**
     *
     * @param lblPeso
     */
    public void setLblPeso(JLabel lblPeso) {
        this.lblPeso = lblPeso;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtAltura() {
        return txtAltura;
    }

    /**
     *
     * @param txtAltura
     */
    public void setTxtAltura(JTextField txtAltura) {
        this.txtAltura = txtAltura;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtPeso() {
        return txtPeso;
    }

    /**
     *
     * @param txtPeso
     */
    public void setTxtPeso(JTextField txtPeso) {
        this.txtPeso = txtPeso;
    }

    /**
     *
     * @return
     */
    public Ventana getVtn() {
        return vtn;
    }

    /**
     *
     * @param vtn
     */
    public void setVtn(Ventana vtn) {
        this.vtn = vtn;
    }

}
