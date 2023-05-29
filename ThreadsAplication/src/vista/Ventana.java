package vista;

import control.Controlador;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase encargada del frame (ventana) y de mostrar todo lo correspondiente a la interaccion con el
 * cliente
 *
 * @author Carlos Guerrero
 * @author Nicolas Diaz
 */
public class Ventana extends JFrame {

	// se crea comunicacion con los paneles y con el controlador
	private PanelDatos pData;
	private PanelBotones pBtn;
	private PanelContador pCont;
	private Controlador control;

	/**
	 * Constructor de ventana
	 */
	public Ventana() {
		// se crea canal de comunicacion con el controlador
		this.control = new Controlador(this);

		// se crea canal de comunicacion con los panel
		pData = new PanelDatos(this);
		pBtn = new PanelBotones(this);
		pCont = new PanelContador(this);

		// se configura el layout de la ventan y se agregan los paneles
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(pData, BorderLayout.WEST);
		getContentPane().add(pCont, BorderLayout.CENTER);
		getContentPane().add(pBtn, BorderLayout.SOUTH);

		// se configura la ventana
		setIconImage(new ImageIcon(getClass().getResource("/img/reloj.png")).getImage());
		setResizable(false);
		setTitle("Conteo de tiempo");
		setSize(705, 370);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// se bloquean objetos que deben estr bloqueados antes de dejar visible la ventana
		bloquearObjetos();

		// pone visible la ventana
		setVisible(true);

	}

	/**
	 * Metodo que bloquea objetos al iniciar aplicacion
	 */
	public void bloquearObjetos() {
		pBtn.getBtnIniciar().setEnabled(false);
		pData.getTxfSegundos().setEditable(false);
		pData.getTxfMinutos().setEditable(false);
		pData.getTxfHoras().setEditable(false);
		pCont.getTxfContadorT().setEditable(false);
	}

	/**
	 * Metodo para configurar objetos de la ventana para iniciar conteo, ya sea en 0 o personalizado
	 */
	public void iniciarConteoInterfaz() {
		pBtn.getBtnIniciar0().setEnabled(false);
		pBtn.getBtnIniciar().setEnabled(false);
		pData.getTxfSegundos().setEditable(false);
		pData.getTxfMinutos().setEditable(false);
		pData.getTxfHoras().setEditable(false);
	}

	/**
	 * Metodo para configurar objetos de la ventana para personalizar inicio de contador
	 */
	public void cargarValoresInterfaz() {
		pData.getTxfSegundos().setEditable(true);
		pData.getTxfMinutos().setEditable(true);
		pData.getTxfHoras().setEditable(true);
		pBtn.getBtnIniciar().setEnabled(true);
		pBtn.getBtnIniciar0().setEnabled(false);
		pBtn.getBtnCargarVal().setEnabled(false);
	}

	/**
	 * Metodo para configurar objetos de la ventana para rainiciar a valores de inicio
	 */
	public void reiniciarInterfaz() {
		pData.getTxfSegundos().setText("");
		pData.getTxfMinutos().setText("");
		pData.getTxfHoras().setText("");
		pBtn.getBtnIniciar0().setEnabled(true);
		pBtn.getBtnCargarVal().setEnabled(true);
		bloquearObjetos();
	}

	/**
	 * Metodo para generacion de ventanas emergentes, cada ventana depende una clave que indica que
	 * ventana debe de ejecutarse
	 *
	 * @param claveVentanaEmergente
	 */
	public static void mostrarJOptionPane(int claveVentanaEmergente) {
		// muestra ventanas dependiendo de la ocasion
		switch (claveVentanaEmergente) {
			case 0:
				JOptionPane.showMessageDialog(null, "Datos ingresados incorrectamente", "Datos Erroneos", 0);
				break;
		}
	}

	/**
	 * Boton salir
	 */
	public void salir() {
		System.exit(0);
	}

	/**
	 *
	 * @return
	 */
	public Controlador getControl() {
		return control;
	}

	/**
	 *
	 * @param control
	 */
	public void setControl(Controlador control) {
		this.control = control;
	}

	/**
	 *
	 * @return
	 */
	public PanelDatos getpData() {
		return pData;
	}

	/**
	 *
	 * @param pData
	 */
	public void setpData(PanelDatos pData) {
		this.pData = pData;
	}

	/**
	 *
	 * @return
	 */
	public PanelBotones getpBtn() {
		return pBtn;
	}

	/**
	 *
	 * @param pBtn
	 */
	public void setpBtn(PanelBotones pBtn) {
		this.pBtn = pBtn;
	}

	/**
	 *
	 * @return
	 */
	public PanelContador getpCont() {
		return pCont;
	}

	/**
	 *
	 * @param pCont
	 */
	public void setpCont(PanelContador pCont) {
		this.pCont = pCont;
	}

}
