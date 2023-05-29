/* 27/02/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC en donde se implementan sockets e hilos para hacer un chat que permita
concetar clientes con un servidor para enviar y recibir mensajes visibles para 
todos los clientres conectdos al igual que poder enviar mensjaes en privado 
(funcionalidad no completada)*/
package vistaServidor;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * Clase encargada de configurar el panal de informacion general que pertenece a
 * la ventana del servidor
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class PanelInfoGeneral extends JPanel {

    // objetos del panel
    private JTextArea jTxaInfoGeneral;
    private VentanaServidor vtnS;

    /**
     * COntructor para inyectar el panel a la ventana servidor
     *
     * @param vtnS
     */
    public PanelInfoGeneral(VentanaServidor vtnS) {
        // creacion de canal de comunicacion con la ventana
        this.vtnS = vtnS;

        // creacion y configuracion del panel
        setLayout(new GridLayout(1, 1, 5, 5)); //filas, columnas, espacio libre entre filas, espacio libre entre columnas
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1), "Información del servidor",
                TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, new Font("Times New Roman", Font.BOLD, 14), new Color(0, 0, 0)));

        //configuracion TextField
        jTxaInfoGeneral = new JTextArea();
        jTxaInfoGeneral.setEditable(false);
		jTxaInfoGeneral.setBackground(new Color(240, 240, 240));

        //Modificaciones del TextArea de la info general del servidor
        jTxaInfoGeneral.setFont(new Font("Times New Roman", 0, 14));
        add(new JScrollPane(jTxaInfoGeneral));

    }

    // Setters y getters
    /**
     *
     * @return
     */
    public JTextArea getjTxaInfoGeneral() {
        return jTxaInfoGeneral;
    }

    /**
     *
     * @param jTxaInfoGeneral
     */
    public void setjTxaInfoGeneral(JTextArea jTxaInfoGeneral) {
        this.jTxaInfoGeneral = jTxaInfoGeneral;
    }

    /**
     *
     * @return
     */
    public VentanaServidor getVtnS() {
        return vtnS;
    }

    /**
     *
     * @param vtnS
     */
    public void setVtnS(VentanaServidor vtnS) {
        this.vtnS = vtnS;
    }

}
