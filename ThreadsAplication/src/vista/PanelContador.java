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
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * Clase encargada del panel que contiene el contador de tiempo
 *
 * @author Carlos Guerrero
 * @author Nicolas Diaz
 */
public class PanelContador extends JPanel {

	// atributos para objetos del panel
	private JLabel lblContadorT;
	private JTextField txfContadorT;
	private Ventana vtn;

	/**
	 * Constructor de panel que requiere una ventana para instanciarse
	 *
	 * @param vtn
	 */
	public PanelContador(Ventana vtn) {
		this.vtn = vtn;

		// configuracion del borde del panel
		GridBagLayout gridbag = new GridBagLayout();
		setLayout(gridbag);
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(24, 74, 102), 2), "Contador",
				TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, new Font("SansSerif", 1, 20), new Color(24, 74, 102)));
		setBackground(new Color(160, 240, 168));
		GridBagConstraints gbc;

		// configuracion de label Contador de Tiempo: 
		lblContadorT = new JLabel("Contador de Tiempo: ");
		lblContadorT.setPreferredSize(new Dimension(260, 30));
		lblContadorT.setHorizontalAlignment(SwingConstants.CENTER);
		lblContadorT.setFont(new Font("SansSerif", 1, 25));
		lblContadorT.setForeground(new Color(24, 74, 102));
		gbc = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(lblContadorT, gbc);

		// configuracion de jtxtfield contador
		txfContadorT = new JTextField();
		txfContadorT.setPreferredSize(new Dimension(260, 50));
		txfContadorT.setHorizontalAlignment(SwingConstants.CENTER);
		txfContadorT.setBackground(new Color(24, 74, 102));
		txfContadorT.setFont(new Font("SansSerif", 0, 45));
		txfContadorT.setForeground(Color.WHITE);
		txfContadorT.setText("0:0:0");
		gbc = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0);
		add(txfContadorT, gbc);
	}

	/**
	 *
	 * @return
	 */
	public JLabel getLblContadorT() {
		return lblContadorT;
	}

	/**
	 *
	 * @param lblContadorT
	 */
	public void setLblContadorT(JLabel lblContadorT) {
		this.lblContadorT = lblContadorT;
	}

	/**
	 *
	 * @return
	 */
	public JTextField getTxfContadorT() {
		return txfContadorT;
	}

	/**
	 *
	 * @param txtContadorT
	 */
	public void setTxfContadorT(JTextField txtContadorT) {
		this.txfContadorT = txtContadorT;
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
