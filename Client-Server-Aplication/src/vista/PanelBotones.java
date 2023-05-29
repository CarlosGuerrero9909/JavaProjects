/* 13/03/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC como segundo parcial en donde se implementa interfaz grafica, base de 
datos, sql, sockets e hilos para realizar un speech de frases ingresadas por
distintos clientes conectados a un servidor el cual es el encargado de leer las 
frases enviadas 
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
public class PanelBotones extends JPanel {

    private JButton btnLeer, btnSalir, btnLimpiar;
    private VentanaCliente ventana;

    public PanelBotones(VentanaCliente ven) {
        this.ventana = ven;
		
		//confihuracion del panel
		setLayout(new FlowLayout());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(24, 74, 102), 1), "Opciones",
                TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, new Font("Times New Roman", Font.BOLD, 14), new Color(24, 74, 102)));

        btnLeer = new JButton("");
        btnLeer.setFont(new Font("Times New Roman",Font.BOLD,14));
        btnLeer.setActionCommand("Leer");
		btnLeer.setPreferredSize(new Dimension(100, 70)); 
        // asignando imagenes
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/data/leer.jpg"));
        Icon icon1 = new ImageIcon(imagen1.getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
        btnLeer.setIcon(icon1);
		add(btnLeer);

        btnLimpiar = new JButton("");
        btnLimpiar.setFont(new Font("Times New Roman",Font.BOLD,14));
        btnLimpiar.setActionCommand("Limpiar");
		btnLimpiar.setPreferredSize(new Dimension(100, 70)); 
        // asignando imagenes
        ImageIcon imagen2 = new ImageIcon(getClass().getResource("/data/borrar.png"));
        Icon icon2 = new ImageIcon(imagen2.getImage().getScaledInstance(90, 70, Image.SCALE_DEFAULT));
        btnLimpiar.setIcon(icon2);
		add(btnLimpiar);
		
        btnSalir = new JButton("");
        btnSalir.setFont(new Font("Times New Roman",Font.BOLD,14));
        btnSalir.setActionCommand("Salir");
		btnSalir.setPreferredSize(new Dimension(100, 70)); 
        // asignando imagenes
        ImageIcon imagen3 = new ImageIcon(getClass().getResource("/data/salir.png"));
        Icon icon3 = new ImageIcon(imagen3.getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT));
        btnSalir.setIcon(icon3);
		add(btnSalir);
        
    }
	
	/**
	 * 
	 * @return 
	 */
    public JButton getBtnLeer() {
        return btnLeer;
    }
	
	/**
	 * 
	 * @param btnLeer 
	 */
    public void setBtnLeer(JButton btnLeer) {
        this.btnLeer = btnLeer;
    }
	
	/**
	 * 
	 * @return 
	 */
    public JButton getBtnSalir() {
        return btnSalir;
    }
	
	/**
	 * 
	 * @param btnSalir 
	 */
    public void setBtnSalir(JButton btnSalir) {
        this.btnSalir = btnSalir;
    }
	
	/**
	 * 
	 * @return 
	 */
    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }
	
	/**
	 * 
	 * @param btnLimpiar 
	 */
    public void setBtnLimpiar(JButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }
	
	/**
	 * 
	 * @return 
	 */
    public VentanaCliente getVentana() {
        return ventana;
    }
	
	/**
	 * 
	 * @param ventana 
	 */
    public void setVentana(VentanaCliente ventana) {
        this.ventana = ventana;
    }

}
