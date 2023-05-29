/* 27/02/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC en donde se implementan sockets e hilos para hacer un chat que permita
concetar clientes con un servidor para enviar y recibir mensajes visibles para 
todos los clientres conectdos al igual que poder enviar mensjaes en privado 
(funcionalidad no completada)*/
package controladorCliente;

/**
 * Clase encargada de lanzar al cliente
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class LauncherCliente {

    public static void main(String[] args) {
        int PUERTO = 1000;
        Cliente cliente = new Cliente(PUERTO);
    }
}
