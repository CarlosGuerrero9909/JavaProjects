package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Diaz
 */
public class PanelBotones extends JPanel {

    private final String CALCULAR = "Calcular IMC";
    private final String SALIR = "Salir";
    private final String NUEVOC = "Nuevo Calculo";
    private final String GUARDAR = "Guardar IMC";
    private Ventana vtn;
    private JButton btnNuevoC;
    private JButton btnSalir;
    private JButton btnGuardar;
    private JButton btnCalcular;

    public PanelBotones(Ventana vtn) {
        this.vtn = vtn;

        // configuracion del panel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(24, 74, 102), 1), "Hospital de Tangamandapio",
                TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION, new Font("SansSerif", 1, 22), new Color(24, 74, 102)));
        setLayout(new FlowLayout());
        setBackground(new Color(87, 195, 255));

        // configuracion de boton nuevo calculo
        btnNuevoC = new JButton("");
        btnNuevoC.setPreferredSize(new Dimension(80, 80));
        btnNuevoC.setActionCommand(NUEVOC);
        btnNuevoC.addActionListener(this.vtn.getControl());
        // asignando imagenes
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/img/nuevo.jpg"));
        Icon icon1 = new ImageIcon(imagen1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        btnNuevoC.setIcon(icon1);
        add(btnNuevoC);

        // configuracion de boton calcular
        btnCalcular = new JButton("");
        btnCalcular.setPreferredSize(new Dimension(80, 80));
        btnCalcular.setActionCommand(CALCULAR);
        btnCalcular.addActionListener(this.vtn.getControl());
        ImageIcon imagen2 = new ImageIcon(getClass().getResource("/img/calcular.png"));
        Icon icon2 = new ImageIcon(imagen2.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        btnCalcular.setIcon(icon2);
        add(btnCalcular);

        // configuracion de boton guardar
        btnGuardar = new JButton("");
        btnGuardar.setPreferredSize(new Dimension(80, 80));
        btnGuardar.setActionCommand(GUARDAR);
        btnGuardar.addActionListener(this.vtn.getControl());
        ImageIcon imagen3 = new ImageIcon(getClass().getResource("/img/guardar.jpg"));
        Icon icon3 = new ImageIcon(imagen3.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        btnGuardar.setIcon(icon3);
        add(btnGuardar);

        // configuracion de boton salir
        btnSalir = new JButton("");
        btnSalir.setPreferredSize(new Dimension(80, 80));
        btnSalir.setActionCommand(SALIR);
        btnSalir.addActionListener(this.vtn.getControl());
        ImageIcon imagen4 = new ImageIcon(getClass().getResource("/img/salir.png"));
        Icon icon4 = new ImageIcon(imagen4.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        btnSalir.setIcon(icon4);
        add(btnSalir);

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

    /**
     *
     * @return
     */
    public JButton getBtnNuevoC() {
        return btnNuevoC;
    }

    /**
     *
     * @param btnNuevoC
     */
    public void setBtnNuevoC(JButton btnNuevoC) {
        this.btnNuevoC = btnNuevoC;
    }

    /**
     *
     * @return
     */
    public JButton getBtnSalir() {
        return btnSalir;
    }

    /**
     *
     * @param btnSalir
     */
    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }

    /**
     *
     * @return
     */
    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    /**
     *
     * @param btnGuardar
     */
    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    /**
     *
     * @return
     */
    public JButton getBtnCalcular() {
        return btnCalcular;
    }

    /**
     *
     * @param btnCalcular
     */
    public void setBtnCalcular(JButton btnCalcular) {
        this.btnCalcular = btnCalcular;
    }

}
