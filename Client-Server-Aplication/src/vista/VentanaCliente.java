/* 13/03/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC como segundo parcial en donde se implementa interfaz grafica, base de 
datos, sql, sockets e hilos para realizar un speech de frases ingresadas por
distintos clientes conectados a un servidor el cual es el encargado de leer las 
frases enviadas 
 */
package vista;

import control.Cliente.ControladorCliente;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class VentanaCliente extends JFrame {

    private PanelDatos datos;
    private PanelBotones botones;
    private PanelImagen imagen;
    private ControladorCliente controlC;

    public VentanaCliente(ControladorCliente controlC) {
        // se crea canal de comunicacion con el controlador
        this.controlC = controlC;
		
		// adicion de los paneles 
		imagen = new PanelImagen(this);
        imagen.setBackground(new Color(114, 204, 230));
        add(imagen, BorderLayout.NORTH);
		
		datos = new PanelDatos(this);
        datos.setBackground(new Color(124, 214, 240));
        add(datos, "Center");

        botones = new PanelBotones(this);
        botones.setBackground(new Color(124, 214, 240));
        add(botones, "South");

        // configuracion de la ventana
		setIconImage(new ImageIcon(getClass().getResource("/data/cliente.jpg")).getImage());
        setTitle("Segundo Parcial PA");
        setSize(500, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
    }

    /**
     * Metodo para generacion de ventanas emergentes, cada ventana depende una
     * clave que indica que ventana debe de ejecutarse
     *
     * @param claveVentanaEmergente
     */
    public static void mostrarJOptionPane(int claveVentanaEmergente) {
        // muestra ventanas dependiendo de la ocasion
        switch (claveVentanaEmergente) {
            case 0:
                JOptionPane.showMessageDialog(null, "No se escibio un nombre o contraseña, vuelva a\nintentar", "Ingreso de Credenciales Incompleto", 2);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Servidor >> Cliente NO existe", "Usuario No Encontrado", 2);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Servidor >> Conexion recibida de:" + "localhost", "Ingreso de Credenciales Correcto", 1);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "No se encontro ususarios registrados en la base de datos", "Sin Usuarios Registrados", 0);
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta de la Base de Datos.", "Error al Conectar Base de Datos", 0);
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "No se escibio un IP o puerto, vuelva a\nintentar", "Ingreso de IP y Puerto Incorrecto", 2);
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "El cliente NO está registrado", "Cliente No Registrado", 2);
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "El cliente está registrado", "Ingreso de Credenciales Correcto", 1);
                break;
            case 8:
                JOptionPane.showMessageDialog(null, "Cerrando conexión", "Desconectando", 1);
                break;
        }
    }
	
	/**
	 * 
	 * @return 
	 */
    public static String pedirIPServidor() {
        String IPServidor = String.valueOf(JOptionPane.showInputDialog(null, new JLabel("Ingrese direccion del servidor: ", JLabel.CENTER), "Ingreso de Direccion del Servidor", JOptionPane.PLAIN_MESSAGE));
        return IPServidor;
    }
	
	/**
	 * 
	 * @return 
	 */
    public static int pedirPuerto() {
        int puerto = Integer.parseInt(JOptionPane.showInputDialog(null, new JLabel("Ingrese puerto: ", JLabel.CENTER), "Ingreso de Puerto", JOptionPane.PLAIN_MESSAGE));
        return puerto;
    }
	
	/**
	 * 
	 * @return 
	 */
    public static String pedirNombre() {
        String nombre = String.valueOf(JOptionPane.showInputDialog(null, new JLabel("Ingrese nombre: ", JLabel.CENTER), "Ingreso de Nombre", JOptionPane.PLAIN_MESSAGE));
        return nombre;
    }
	
	/**
	 * 
	 * @return 
	 */
    public static String pedirContraseña() {
        String contraseña = String.valueOf(JOptionPane.showInputDialog(null, new JLabel("Ingrese contraseña: ", JLabel.CENTER), "Ingreso de Contraseña", JOptionPane.PLAIN_MESSAGE));
        return contraseña;
    }
	
	/**
	 * 
	 * @return 
	 */
    public PanelDatos getDatos() {
        return datos;
    }
	
	/**
	 * 
	 * @param datos 
	 */
    public void setDatos(PanelDatos datos) {
        this.datos = datos;
    }
	
	/**
	 * 
	 * @return 
	 */
    public PanelBotones getBotones() {
        return botones;
    }
	
	/**
	 * 
	 * @param botones 
	 */
    public void setBotones(PanelBotones botones) {
        this.botones = botones;
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
