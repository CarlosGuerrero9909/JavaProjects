package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
public class PanelResultado extends JPanel {

    // atributos para objetos del panel
    private JLabel lblResultado;
    private JTextField txtResultado;
    private Ventana vtn;

    /**
     * Constructor de panel que requiere una ventana para instanciarse
     *
     * @param vtn
     */
    public PanelResultado(Ventana vtn) {
        this.vtn = vtn;

        // configuracion del borde del panel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(24, 74, 102), 2), "Resultado",
                TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, new Font("SansSerif", 1, 20), new Color(24, 74, 102)));
        setLayout(new FlowLayout());
        setBackground(new Color(55, 167, 230));

        // configuracion de label resultado
        lblResultado = new JLabel("IMC: ");
        lblResultado.setFont(new Font("SansSerif", 1, 18));
        lblResultado.setForeground(new Color(24, 74, 102));
        add(lblResultado);

        // configuracion de txt resultado
        txtResultado = new JTextField();
        txtResultado.setPreferredSize(new Dimension(90, 30));
        txtResultado.setFont(new Font("SansSerif", 0, 16));
        add(txtResultado);

    }

    /**
     *
     * @return
     */
    public JLabel getLblResultado() {
        return lblResultado;
    }

    /**
     *
     * @param lblResultado
     */
    public void setLblResultado(JLabel lblResultado) {
        this.lblResultado = lblResultado;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtResultado() {
        return txtResultado;
    }

    /**
     *
     * @param txtResultado
     */
    public void setTxtResultado(JTextField txtResultado) {
        this.txtResultado = txtResultado;
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
