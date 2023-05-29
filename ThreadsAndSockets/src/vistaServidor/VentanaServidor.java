/* 27/02/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC en donde se implementan sockets e hilos para hacer un chat que permita
concetar clientes con un servidor para enviar y recibir mensajes visibles para 
todos los clientres conectdos al igual que poder enviar mensjaes en privado 
(funcionalidad no completada)*/
package vistaServidor;

import controladorServidor.ControladorServidor;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase encargada de configurar la ventana del servidor con sus paneles
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class VentanaServidor extends JFrame {

    // objetos de la ventana
    private PanelInfoGeneral pnlInfoGeneral;
    private ControladorServidor controlS;

    /**
     * Contructor para inyectar la ventana al controlador
     *
     * @param controlS
     */
    public VentanaServidor(ControladorServidor controlS) {
        // se crea canal de comunicacion con el controlador
        this.controlS = controlS;

        // se crea canal de comunicacion con los paneles
        this.pnlInfoGeneral = new PanelInfoGeneral(this);
        //this.pnlEscritura = new PanelEscritura(this);

        // se configura el layout de la ventan y se agregan los paneles
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pnlInfoGeneral, BorderLayout.CENTER);

        pnlInfoGeneral.setBackground(new Color(163, 228, 215));
        
// se configura la ventana
		setIconImage(new ImageIcon(getClass().getResource("/img/servidor.png")).getImage());
        setResizable(false);
        setTitle("Servidor");
        setSize(400, 550);
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
                JOptionPane.showMessageDialog(null, "Error al comunicarse con el cliente", "Error Comunicacion", 0);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Error al cerrar socket", "Error Cierre de Socket", 1);
                break;
        }
    }

    // setters y getters
    /**
     *
     * @return
     */
    public PanelInfoGeneral getPnlInfoGeneral() {
        return pnlInfoGeneral;
    }

    /**
     *
     * @param pnlInfoGeneral
     */
    public void setPnlInfoGeneral(PanelInfoGeneral pnlInfoGeneral) {
        this.pnlInfoGeneral = pnlInfoGeneral;
    }

    /**
     *
     * @return
     */
    public ControladorServidor getControlS() {
        return controlS;
    }

    /**
     *
     * @param controlS
     */
    public void setControlS(ControladorServidor controlS) {
        this.controlS = controlS;
    }

}
