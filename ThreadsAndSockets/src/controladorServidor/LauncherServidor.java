/* 27/02/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC en donde se implementan sockets e hilos para hacer un chat que permita
concetar clientes con un servidor para enviar y recibir mensajes visibles para 
todos los clientres conectdos al igual que poder enviar mensjaes en privado 
(funcionalidad no completada)*/
package controladorServidor;

import java.io.IOException;

/**
 * Clase encargada de lanzar el sevidor
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class LauncherServidor {

    public static void main(String[] args) throws IOException {
        //Se define el puerto por el cual se dara la conexion y se crea una nueva instancia de 
        //la clase servidor
        int PUERTO = 1000;
        Servidor servidor = new Servidor(PUERTO);

    }
}
