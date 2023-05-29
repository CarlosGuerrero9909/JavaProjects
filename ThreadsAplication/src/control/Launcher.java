/**
 * Este programa implementa principios de diseño de clases, paquetes y MVC para manejar hilos en la creacion de un reloj digital
 * 4/02/2022
 * Programacion Avanzada
 * Universidad Distrital Francisco Jose de Caldas
 * Carlos Alberto Guerrero - Miguel Nicolas Diaz Vargas
 */
package control;

import vista.Ventana;

/**
 * Clase encargada de lanzar el programa
 *
 * @author Carlos Guerrero
 * @author Nicolas Dí­az
 */
public class Launcher {

	/**
	 * Metodo principal, encargado de lanzar el programa y la ventana principal
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Ventana vtn = new Ventana();
		Controlador control = new Controlador(vtn);
	}
}
