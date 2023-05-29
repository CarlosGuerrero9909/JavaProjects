package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Clase encargada del panel que contine los botones
 *
 * @author Carlos Guerrero
 * @author Nicolas Diaz
 */
public class PanelBotones extends JPanel {

	private final String INICIAR0 = "Iniciar en 0";
	private final String CARGARVALORES = "Cargar valores";
	private final String INCIAR = "Iniciar";
	private final String REINICIAR = "Reiniciar";
	private final String SALIR = "Salir";
	private Ventana vtn;
	private JButton btnIniciar0;
	private JButton btnCargarVal;
	private JButton btnIniciar;
	private JButton btnReiniciar;
	private JButton btnSalir;

	public PanelBotones(Ventana vtn) {
		this.vtn = vtn;

		// configuracion del panel
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(24, 74, 102), 1), "Botones",
				TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION, new Font("SansSerif", 1, 18), new Color(24, 74, 102)));
		setLayout(new FlowLayout());
		setBackground(new Color(160, 240, 168));

		// configuracion de boton Iniciar en 0
		btnIniciar0 = new JButton("Iniciar en 0");
		btnIniciar0.setPreferredSize(new Dimension(130, 50));
		btnIniciar0.setActionCommand(INICIAR0);
		btnIniciar0.addActionListener(this.vtn.getControl());
		add(btnIniciar0);

		// configuracion de boton Cargar Valores
		btnCargarVal = new JButton("Cargar Valores");
		btnCargarVal.setPreferredSize(new Dimension(130, 50));
		btnCargarVal.setActionCommand(CARGARVALORES);
		btnCargarVal.addActionListener(this.vtn.getControl());
		add(btnCargarVal);

		// configuracion de boton Iniciar
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setPreferredSize(new Dimension(130, 50));
		btnIniciar.setActionCommand(INCIAR);
		btnIniciar.addActionListener(this.vtn.getControl());
		add(btnIniciar);

		// configuracion de boton Reiniciar
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setPreferredSize(new Dimension(130, 50));
		btnReiniciar.setActionCommand(REINICIAR);
		btnReiniciar.addActionListener(this.vtn.getControl());
		add(btnReiniciar);

		// configuracion de boton salir
		btnSalir = new JButton("Salir");
		btnSalir.setPreferredSize(new Dimension(130, 50));
		btnSalir.setActionCommand(SALIR);
		btnSalir.addActionListener(this.vtn.getControl());
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
	public JButton getBtnIniciar0() {
		return btnIniciar0;
	}

	/**
	 *
	 * @param btnIniciar0
	 */
	public void setBtnIniciar0(JButton btnIniciar0) {
		this.btnIniciar0 = btnIniciar0;
	}

	/**
	 *
	 * @return
	 */
	public JButton getBtnCargarVal() {
		return btnCargarVal;
	}

	/**
	 *
	 * @param btnCargarVal
	 */
	public void setBtnCargarVal(JButton btnCargarVal) {
		this.btnCargarVal = btnCargarVal;
	}

	/**
	 *
	 * @return
	 */
	public JButton getBtnIniciar() {
		return btnIniciar;
	}

	/**
	 *
	 * @param btnIniciar
	 */
	public void setBtnIniciar(JButton btnIniciar) {
		this.btnIniciar = btnIniciar;
	}

	/**
	 *
	 * @return
	 */
	public JButton getBtnReiniciar() {
		return btnReiniciar;
	}

	/**
	 *
	 * @param btnReiniciar
	 */
	public void setBtnReiniciar(JButton btnReiniciar) {
		this.btnReiniciar = btnReiniciar;
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

}
