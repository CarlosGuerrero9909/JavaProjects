/* 27/02/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC en donde se implementan sockets e hilos para hacer un chat que permita
concetar clientes con un servidor para enviar y recibir mensajes visibles para 
todos los clientres conectdos al igual que poder enviar mensjaes en privado 
(funcionalidad no completada)*/
package vistaCliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * Clase encargada de configurar el panal de chat general que pertenece a la
 * ventana del cliente
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class PanelChatGeneral extends JPanel {

    private JTextArea jTxaChatGeneral;
    private PanelEscritura pnlEscritura;
    private VentanaCliente vtnC;

    public PanelChatGeneral(VentanaCliente vtnC) {
        // creacion de canal de comunicacion con la ventana
        this.vtnC = vtnC;

        // creacion y configuracion del panel
        setLayout(new GridLayout(2, 1, 5, 5)); //filas, columnas, espacio libre entre filas, espacio libre entre columnas
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1), "Chat general",
                TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, new Font("Times New Roman", Font.BOLD, 14), new Color(0, 0, 0)));

        //configuracion TextField
        jTxaChatGeneral = new JTextArea();
        jTxaChatGeneral.setEditable(false);
        //Modificaciones de la letra del textarea del chat general
        jTxaChatGeneral.setFont(new Font("Times New Roman", 0, 14));
        add(new JScrollPane(jTxaChatGeneral));

        //configuracion del panel de escritura que estra dentro de este mismo panel
        this.pnlEscritura = new PanelEscritura(this);
        //Fondo del panel de escritura del chat general
        pnlEscritura.setBackground(new Color(163, 228, 215));
        add(pnlEscritura);
    }

    // Setters y getters
    /**
     *
     * @return
     */
    public JTextArea getjTxaChatGeneral() {
        return jTxaChatGeneral;
    }

    /**
     *
     * @param jTxaChatGeneral
     */
    public void setjTxaChatGeneral(JTextArea jTxaChatGeneral) {
        this.jTxaChatGeneral = jTxaChatGeneral;
    }

    /**
     *
     * @return
     */
    public PanelEscritura getPnlEscritura() {
        return pnlEscritura;
    }

    /**
     *
     * @param pnlEscritura
     */
    public void setPnlEscritura(PanelEscritura pnlEscritura) {
        this.pnlEscritura = pnlEscritura;
    }

    /**
     *
     * @return
     */
    public VentanaCliente getVtnC() {
        return vtnC;
    }

    /**
     *
     * @param vtnC
     */
    public void setVtnC(VentanaCliente vtnC) {
        this.vtnC = vtnC;
    }

}
