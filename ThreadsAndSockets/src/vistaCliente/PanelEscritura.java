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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Clase encargada de configurar el panal de escritura que pertenece a la
 * ventana del cliente
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class PanelEscritura extends JPanel {

    // objetos del panel
    private JTextField jTxfCampoEntrada;
    private JButton jBtnEnviar;
    private JButton jBtnAdjuntar;
    private PanelChatGeneral pnlChatGeneral;

    // imagenes que se usaran
    ImageIcon envibtn = new ImageIcon("src/img/envi.png");
    ImageIcon adjubtn = new ImageIcon("src/img/adju.png");

    /**
     * Constructor que se le pasa como paraemetro el panel general, esto para
     * hacer una inyeccion de este panel en el de caht genral
     *
     * @param pnlChatGeneral
     */
    public PanelEscritura(PanelChatGeneral pnlChatGeneral) {
        // creacion de canal de comunicacion con la ventana
        this.pnlChatGeneral = pnlChatGeneral;

        // creacion y configuracion del panel
        setLayout(new GridLayout(1, 2, 5, 5)); //filas, columnas, espacio libre entre filas, espacio libre entre columnas
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1), "Escribir mensaje",
                TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, new Font("Times New Roman", Font.BOLD, 14), new Color(0, 0, 0)));

        //configuracion TextField
        jTxfCampoEntrada = new JTextField();
        jTxfCampoEntrada.setActionCommand("Enviar");
        jTxfCampoEntrada.addActionListener(this.pnlChatGeneral.getVtnC().getControlC()); // revisar lo del Action listener si se quita
		jTxfCampoEntrada.setBackground(new Color(240, 240, 240));
        //Modificaciones en la letra del textarea del campo de escritura
        jTxfCampoEntrada.setFont(new Font("Times New Roman", 0, 14));
        add(new JScrollPane(jTxfCampoEntrada));

        //configuracion JButton
        jBtnEnviar = new JButton("");
        jBtnEnviar.setPreferredSize(new Dimension(150, 30));
        jBtnEnviar.setActionCommand("Enviar");
        jBtnEnviar.addActionListener(this.pnlChatGeneral.getVtnC().getControlC());
		jBtnEnviar.setBackground(new Color(180, 180, 180));

        //Asignación del icono al boton
        jBtnEnviar.setIcon(envibtn);
        jBtnEnviar.setIconTextGap(1);
        jBtnEnviar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBtnEnviar.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        add(jBtnEnviar);

        //configuracion JButton
        jBtnAdjuntar = new JButton("");
        jBtnAdjuntar.setPreferredSize(new Dimension(150, 30));
        jBtnAdjuntar.setActionCommand("Adjuntar");
        jBtnAdjuntar.addActionListener(this.pnlChatGeneral.getVtnC().getControlC());
		jBtnAdjuntar.setBackground(new Color(180, 180, 180));

        //Asignación del icono al boton
        jBtnAdjuntar.setIcon(adjubtn);
        jBtnAdjuntar.setIconTextGap(0);
        jBtnAdjuntar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBtnAdjuntar.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        add(jBtnAdjuntar);

    }

    // getters and setters
    /**
     *
     * @return
     */
    public JTextField getjTxfCampoEntrada() {
        return jTxfCampoEntrada;
    }

    /**
     *
     * @param jTxfCampoEntrada
     */
    public void setjTxfCampoEntrada(JTextField jTxfCampoEntrada) {
        this.jTxfCampoEntrada = jTxfCampoEntrada;
    }

    /**
     *
     * @return
     */
    public JButton getjBtnEnviar() {
        return jBtnEnviar;
    }

    /**
     *
     * @param jBtnEnviar
     */
    public void setjBtnEnviar(JButton jBtnEnviar) {
        this.jBtnEnviar = jBtnEnviar;
    }

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

}
