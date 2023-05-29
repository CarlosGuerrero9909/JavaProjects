/* 13/03/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC como segundo parcial en donde se implementa interfaz grafica, base de 
datos, sql, sockets e hilos para realizar un speech de frases ingresadas por
distintos clientes conectados a un servidor el cual es el encargado de leer las 
frases enviadas 
*/
package modelo;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class ClienteVO {
	// atributos
    private String nombre;
    private String contraseña;

    public ClienteVO() {

    }
	
	/**
	 * 
	 * @param nombre
	 * @param contraseña 
	 */
    public ClienteVO(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
	
	/**
	 * 
	 * @return 
	 */
    public String getNombre() {
        return nombre;
    }
	
	/**
	 * 
	 * @param nombre 
	 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	
	/**
	 * 
	 * @return 
	 */
    public String getContraseña() {
        return contraseña;
    }
	
	/**
	 * 
	 * @param contraseña 
	 */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
