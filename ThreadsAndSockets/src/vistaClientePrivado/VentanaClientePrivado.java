/* 27/02/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC en donde se implementan sockets e hilos para hacer un chat que permita
concetar clientes con un servidor para enviar y recibir mensajes visibles para 
todos los clientres conectdos al igual que poder enviar mensjaes en privado 
(funcionalidad no completada)*/
package vistaClientePrivado;

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
public class VentanaClientePrivado extends JFrame {

    // objetos de la ventana
    private PanelChatPrivado pnlChatPrivado;
    private ControladorCliente controlC;

    /**
     * Contructor para inyectarle la ventana al hilo del cliente
     *
     * @param controlC
     */
    public VentanaClientePrivado(ControladorCliente controlC) {
        // se crea canal de comunicacion con el controlador
        this.controlC = controlC;

        // se crea canal de comunicacion con los paneles
        this.pnlChatPrivado = new PanelChatPrivado(this);
        

        // se configura el layout de la ventan y se agregan los paneles
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pnlChatPrivado, BorderLayout.CENTER);

        //Fondo del panel del chat general y los clientes conectados
        pnlChatPrivado.setBackground(new Color(163, 228, 215));
		
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

	public PanelChatPrivado getPnlChatPrivado() {
		return pnlChatPrivado;
	}

	public void setPnlChatPrivado(PanelChatPrivado pnlChatPrivado) {
		this.pnlChatPrivado = pnlChatPrivado;
	}

	public ControladorCliente getControlC() {
		return controlC;
	}

	public void setControlC(ControladorCliente controlC) {
		this.controlC = controlC;
	}
    

}
