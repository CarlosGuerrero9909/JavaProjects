/* 13/03/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC como segundo parcial en donde se implementa interfaz grafica, base de 
datos, sql, sockets e hilos para realizar un speech de frases ingresadas por
distintos clientes conectados a un servidor el cual es el encargado de leer las 
frases enviadas 
*/
package control.Cliente;

import java.io.IOException;
import java.net.Socket;
import vista.VentanaCliente;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class Cliente {

    private Socket sckCliente;
    private ControladorCliente hiloCliente;
    private String nombre;
    private String contraseña;
    private String IPServidor;
    private int puerto;

    public Cliente() {
        // iniciacion de variables
        nombre = "";
        contraseña = "";
        IPServidor = "";
        puerto = 0;

        // do para que se repita el ingreso de credenciales cuando son incorrectas
        do { // ingreso de ip y puerto
            IPServidor = VentanaCliente.pedirIPServidor();
            puerto = VentanaCliente.pedirPuerto();
            if (IPServidor.equals("") || (puerto == 0)) {
                // mostrar ventana emergente de no se se escibio alguna credencial
                VentanaCliente.mostrarJOptionPane(5);
            }
        } while (IPServidor.equals("") || (puerto == 0));

        do { // ingreso de nombre y contraseña
            nombre = VentanaCliente.pedirNombre();
            contraseña = VentanaCliente.pedirContraseña();
            if (nombre.equals("") || contraseña.equals("")) {
                // mostrar ventana emergente de no se se escibio alguna credencial
                VentanaCliente.mostrarJOptionPane(0);
            }
        } while (nombre.equals("") || contraseña.equals(""));

        // conectar al servidor
        try {
            // iniciar sckCliente con el host y puerto del servidor
            sckCliente = new Socket(IPServidor, puerto);
            System.out.println("Conectado a " + sckCliente.getInetAddress().getHostName());
            // creacion de hilo cliente
            hiloCliente = new ControladorCliente(sckCliente, nombre, contraseña);
            hiloCliente.start();
            System.out.println("Hilo cliente creado, esperando confirmacion de credenciales");
        } catch (IOException ioe) {
            System.out.println("No fue posible establecer la conexion con el servidor");
        } catch (IllegalArgumentException iae) {
            System.out.println("Puerto fuera de rango");
        }

    }

}
