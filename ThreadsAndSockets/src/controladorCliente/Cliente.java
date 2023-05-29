/* 27/02/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC en donde se implementan sockets e hilos para hacer un chat que permita
concetar clientes con un servidor para enviar y recibir mensajes visibles para 
todos los clientres conectdos al igual que poder enviar mensjaes en privado 
(funcionalidad no completada)*/
package controladorCliente;

import java.io.DataOutputStream;
import java.net.Socket;
import vistaCliente.VentanaCliente;

/**
 * Esta clase se encarga de crear los sockets y canales de comunicacion y lanzar
 * el hilo cliente
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class Cliente {

    // variables
    private Socket sckCliente;
    private DataOutputStream salida; // flujo de salida
    private ControladorCliente controlC; // objeto tipo hilo de cliente
    private String host = "127.0.0.1"; // ip
    private int PUERTO; // puerto por el que se ocmunicara con el sevidor
    private VentanaCliente vtnC; // ventana para el cliente

    public Cliente(int PUERTO) {
        this.PUERTO = PUERTO;
        try {
            // se crea el puerto
            sckCliente = new Socket(host, this.PUERTO);
            // se crea el flujo de salida con el socket
            salida = new DataOutputStream(sckCliente.getOutputStream());
            // se crea el hilo cliente
            ControladorCliente clienteHilo = new ControladorCliente(sckCliente, this);
            // se inicia el metodo run del cliente
            clienteHilo.start();
        } catch (Exception e) {
            // Mensaje error al establecer conexion con el socket y flujos
            VentanaCliente.mostrarJOptionPane(0, e);
        }
    }
}
