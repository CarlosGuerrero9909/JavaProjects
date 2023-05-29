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
 * Clase encargada del panel que contiene los datos a rellenar (labels y jtextfield)
 *
 * @author Carlos Guerrero
 * @author Nicolas Diaz
 */
public class PanelDatos extends JPanel {

	// atributos para objetos del panel
	private JLabel lblHoras;
	private JLabel lblMinutos;
	private JLabel lblSegundos;
	private JTextField txfHoras;
	private JTextField txfMinutos;
	private JTextField txfSegundos;

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
		setBackground(new Color(160, 240, 168));
		GridBagConstraints gbc;

		// configuracion de label Horas
		lblHoras = new JLabel("Horas: ");
		lblHoras.setPreferredSize(new Dimension(120, 30));
		lblHoras.setFont(new Font("SansSerif", 0, 18));
		lblHoras.setForeground(new Color(24, 74, 102));
		//gbd = new GridBagConstraints
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lblHoras, gbc);

		// configuracion de label Minutos
		lblMinutos = new JLabel("Minutos: ");
		lblMinutos.setPreferredSize(new Dimension(120, 30));
		lblMinutos.setFont(new Font("SansSerif", 0, 18));
		lblMinutos.setForeground(new Color(24, 74, 102));
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lblMinutos, gbc);

		// configuracion de label Segundos
		lblSegundos = new JLabel("Segundos: ");
		lblSegundos.setPreferredSize(new Dimension(120, 30));
		lblSegundos.setFont(new Font("SansSerif", 0, 18));
		lblSegundos.setForeground(new Color(24, 74, 102));
		gbc = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lblSegundos, gbc);

		// configuracion de jtextfield horas
		txfHoras = new JTextField();
		txfHoras.setPreferredSize(new Dimension(160, 30));
		txfHoras.setFont(new Font("SansSerif", 0, 16));
		gbc = new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(txfHoras, gbc);

		// configuracion de jtextfield minutos
		txfMinutos = new JTextField();
		txfMinutos.setPreferredSize(new Dimension(160, 30));
		txfMinutos.setFont(new Font("SansSerif", 0, 16));
		gbc = new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(txfMinutos, gbc);

		// configuracion de jtextfield segundos
		txfSegundos = new JTextField();
		txfSegundos.setPreferredSize(new Dimension(160, 30));
		txfSegundos.setFont(new Font("SansSerif", 0, 16));
		gbc = new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(txfSegundos, gbc);

	}

	/**
	 *
	 * @return
	 */
	public JLabel getLblHoras() {
		return lblHoras;
	}

	/**
	 *
	 * @param lblHoras
	 */
	public void setLblHoras(JLabel lblHoras) {
		this.lblHoras = lblHoras;
	}

	/**
	 *
	 * @return
	 */
	public JLabel getLblMinutos() {
		return lblMinutos;
	}

	/**
	 *
	 * @param lblMinutos
	 */
	public void setLblMinutos(JLabel lblMinutos) {
		this.lblMinutos = lblMinutos;
	}

	/**
	 *
	 * @return
	 */
	public JLabel getLblSegundos() {
		return lblSegundos;
	}

	/**
	 *
	 * @param lblSegundos
	 */
	public void setLblSegundos(JLabel lblSegundos) {
		this.lblSegundos = lblSegundos;
	}

	/**
	 *
	 * @return
	 */
	public JTextField getTxfHoras() {
		return txfHoras;
	}

	/**
	 *
	 * @param txtHoras
	 */
	public void setTxtHoras(JTextField txtHoras) {
		this.txfHoras = txtHoras;
	}

	/**
	 *
	 * @return
	 */
	public JTextField getTxfMinutos() {
		return txfMinutos;
	}

	/**
	 *
	 * @param txtMinutos
	 */
	public void setTxfMinutos(JTextField txtMinutos) {
		this.txfMinutos = txtMinutos;
	}

	/**
	 *
	 * @return
	 */
	public JTextField getTxfSegundos() {
		return txfSegundos;
	}

	/**
	 *
	 * @param txtSegundos
	 */
	public void setTxfSegundos(JTextField txtSegundos) {
		this.txfSegundos = txtSegundos;
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
