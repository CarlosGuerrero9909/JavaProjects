/* 27/02/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC en donde se implementan sockets e hilos para hacer un chat que permita
concetar clientes con un servidor para enviar y recibir mensajes visibles para 
todos los clientres conectdos al igual que poder enviar mensjaes en privado 
(funcionalidad no completada)*/
package vistaCliente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

/**
 * Clase encargada de configurar el panal de clientes conectados que pertenece a
 * la ventana del cliente
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class PanelClientesConectados extends JPanel {

    private JList jTxaClientesConectados;
    private JButton jBtnPrivado;
    private VentanaCliente vtnC;
    ImageIcon privbtn = new ImageIcon("src/img/priv.png");

    public PanelClientesConectados(VentanaCliente vtnC) {
        // creacion de canal de comunicacion con la ventana
        this.vtnC = vtnC;

        // creacion y configuracion del panel
        setLayout(new GridLayout(2, 1, 5, 5)); //filas, columnas, espacio libre entre filas, espacio libre entre columnas
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1), "Lista de clientes conectados",
                TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, new Font("Times New Roman", Font.BOLD, 14), new Color(0, 0, 0)));

        //configuracion JButton
        jBtnPrivado = new JButton("");
        jBtnPrivado.setPreferredSize(new Dimension(30, 30));
        jBtnPrivado.setActionCommand("Privado");
        jBtnPrivado.addActionListener((ActionListener) this.vtnC.getControlC());

        //Agregar el icono a el boton
        jBtnPrivado.setIcon(privbtn);
        jBtnPrivado.setIconTextGap(1);
        jBtnPrivado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBtnPrivado.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
		jBtnPrivado.setBackground(new Color(180, 180, 180));
        add(jBtnPrivado);

        //configuracion TextField
        jTxaClientesConectados = new JList();
        //Modificaciones de la letra del textarea de Clientes conextados
        jTxaClientesConectados.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		jTxaClientesConectados.setBackground(new Color(240, 240, 240));
        add(new JScrollPane(jTxaClientesConectados));

    }

    // settter y getters
    /**
     *
     * @return
     */
    public JList getjTxaClientesConectados() {
        return jTxaClientesConectados;
    }

    /**
     *
     * @param jTxaClientesConectados
     */
    public void setjTxaClientesConectados(JList jTxaClientesConectados) {
        this.jTxaClientesConectados = jTxaClientesConectados;
    }

    /**
     *
     * @return
     */
    public JButton getjBtnPrivado() {
        return jBtnPrivado;
    }

    /**
     *
     * @param jBtnPrivado
     */
    public void setjBtnPrivado(JButton jBtnPrivado) {
        this.jBtnPrivado = jBtnPrivado;
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
