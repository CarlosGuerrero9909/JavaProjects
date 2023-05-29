/* 13/03/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC como segundo parcial en donde se implementa interfaz grafica, base de 
datos, sql, sockets e hilos para realizar un speech de frases ingresadas por
distintos clientes conectados a un servidor el cual es el encargado de leer las 
frases enviadas 
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;



/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */

public class PanelImagen extends JPanel {
	private JButton btnImg;
	private VentanaCliente ventana;

	public PanelImagen(VentanaCliente ven) {
		this.ventana = ven;
		
		// configuracion del panel
		setLayout(new GridLayout());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(24, 74, 102), 1), "Interprete-Segundo Corte",
                TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION, new Font("Times New Roman", 1, 16), new Color(24, 74, 102)));
		
        btnImg = new JButton("");
        btnImg.setPreferredSize(new Dimension(520, 150)); 
        // asignando imagenes
        ImageIcon imagen0 = new ImageIcon(getClass().getResource("/data/interpreter.PNG"));
        Icon icon0 = new ImageIcon(imagen0.getImage().getScaledInstance(480, 150, Image.SCALE_DEFAULT));
        btnImg.setIcon(icon0);
        add(btnImg);
	}
	
	
	
    
}