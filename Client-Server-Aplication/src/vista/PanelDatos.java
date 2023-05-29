/* 13/03/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC como segundo parcial en donde se implementa interfaz grafica, base de 
datos, sql, sockets e hilos para realizar un speech de frases ingresadas por
distintos clientes conectados a un servidor el cual es el encargado de leer las 
frases enviadas 
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class PanelDatos extends JPanel {

    private JLabel labFrase;
    private JTextArea txtFrase;
    private VentanaCliente ventana;

    public PanelDatos(VentanaCliente ven) {
        this.ventana = ven;
		//confihuracion del panel
        setLayout(new GridLayout());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(24, 74, 102), 1), "Texto a Leer",
                TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, new Font("Times New Roman", Font.BOLD, 14), new Color(24, 74, 102)));
        
        //elementos del panel
		labFrase = new JLabel("Palabra/Frase:", JLabel.CENTER);
        labFrase.setFont(new Font("Times New Roman",1,14));
        add(labFrase);
		
		txtFrase = new JTextArea();
        txtFrase.setFont(new Font("Times New Roman",0,14));
        txtFrase.setLineWrap(true);
        txtFrase.setWrapStyleWord(true);
        add(txtFrase);

    }
	
	/**
	 * 
	 * @return 
	 */
    public boolean verificarCampo() {
        if ("".equals(txtFrase.getText())) {
            return true;
        }

        return false;
    }
	
	/**
	 * 
	 */
    public void limpiarCampo() {
        txtFrase.setText("");
    }
	
	/**
	 * 
	 * @return 
	 */
    public JTextArea getTxtFrase() {
        return txtFrase;
    }
	
	/**
	 * 
	 * @param txtFrase 
	 */
    public void setTxtFrase(JTextArea txtFrase) {
        this.txtFrase = txtFrase;
    }

}
