/* 27/02/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC en donde se implementan sockets e hilos para hacer un chat que permita
concetar clientes con un servidor para enviar y recibir mensajes visibles para 
todos los clientres conectdos al igual que poder enviar mensjaes en privado 
(funcionalidad no completada)*/
package vistaCliente;

import controladorCliente.ControladorCliente;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase encargada de configurar la ventana del cliente que contiene todos los
 * paneles y objetos en ellos para la interaz de usuario
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class VentanaCliente extends JFrame {

    // objetos de la ventana
    private PanelChatGeneral pnlChatGeneral;
    private PanelClientesConectados pnlClientesConectados;
    private ControladorCliente controlC;

    /**
     * Contructor para inyectarle la ventana al hilo del cliente
     *
     * @param controlC
     */
    public VentanaCliente(ControladorCliente controlC) {
        // se crea canal de comunicacion con el controlador
        this.controlC = controlC;

        // se crea canal de comunicacion con los paneles
        this.pnlChatGeneral = new PanelChatGeneral(this);
        this.pnlClientesConectados = new PanelClientesConectados(this);

        // se configura el layout de la ventan y se agregan los paneles
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pnlChatGeneral, BorderLayout.CENTER);
        getContentPane().add(pnlClientesConectados, BorderLayout.WEST);

        //Fondo del panel del chat general y los clientes conectados
        pnlChatGeneral.setBackground(new Color(163, 228, 215));
        pnlClientesConectados.setBackground(new Color(163, 228, 215));
		
		// se configura la ventana
		setIconImage(new ImageIcon(getClass().getResource("/img/cliente.jpg")).getImage());
        setResizable(false);
        setTitle("Cliente: " + controlC.getNombre());
        setSize(650, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    /**
     * Metodo para generacion de ventanas emergentes, cada ventana depende una
     * clave que indica que ventana debe de ejecutarse
     *
     * @param claveVentanaEmergente
     */
    public static void mostrarJOptionPane(int claveVentanaEmergente, Exception e) {
        // muestra ventanas dependiendo de la ocasion
        switch (claveVentanaEmergente) {
            case 0:
                JOptionPane.showMessageDialog(null, "Error al establecer conexion con el socket y flujos\n" + e, "Error Socket", 2);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Error al encontrar la clase\n" + e, "Clase No Encontrada", 0);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Error\n" + e, "Error", 1);
                break;
        }
    }
	
	/**
	 * Crea una ventana de busqueda para bucar el archivo a enviar
	 *
	 * @param controlC
	 */
	public void buscarArchivoDeEnvio(ControladorCliente controlC) {
		JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
		fc.showOpenDialog(fc); // se muestra una ventana de busqueda
		controlC.setFileOrigen(fc.getSelectedFile()); // selecciona el archivo
	}
	
    // Setters y getters
    /**
     *
     * @return
     */
    public PanelChatGeneral getPnlChatGeneral() {
        return pnlChatGeneral;
    }

    /**
     *
     * @param pnlChatGeneral
     */
    public void setPnlChatGeneral(PanelChatGeneral pnlChatGeneral) {
        this.pnlChatGeneral = pnlChatGeneral;
    }

    /**
     *
     * @return
     */
    public PanelClientesConectados getPnlClientesConectados() {
        return pnlClientesConectados;
    }

    /**
     *
     * @param pnlClientesConectados
     */
    public void setPnlClientesConectados(PanelClientesConectados pnlClientesConectados) {
        this.pnlClientesConectados = pnlClientesConectados;
    }

    /**
     *
     * @return
     */
    public ControladorCliente getControlC() {
        return controlC;
    }

    /**
     *
     * @param controlC
     */
    public void setControlC(ControladorCliente controlC) {
        this.controlC = controlC;
    }

}
