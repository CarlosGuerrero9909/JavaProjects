/* 13/03/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC como segundo parcial en donde se implementa interfaz grafica, base de 
datos, sql, sockets e hilos para realizar un speech de frases ingresadas por
distintos clientes conectados a un servidor el cual es el encargado de leer las 
frases enviadas 
*/
package control.Servidor;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class Servidor {

    private ServerSocket sckServer;
    private Socket sckCliente;
    private ControladorServidor hiloServidor;

    public Servidor() {
        try {
            // inializacion del sckServer en el puerto donde estara a la escucha
            sckServer = new ServerSocket(12345);
            System.out.println("Servidor >> Esperando una conexión");
            // sckServer a la espera de peticiones de sckCliente para procesar su solicitud
            while (true) {
                // se inicia sckCliente aceptandolo y asignandole responsabilidades
                sckCliente = sckServer.accept();
                System.out.println("Cliente conectado: " + sckCliente);

                // se crea e inicia un nuevo hilo servidor para atender a cada cliente conectado mediante su respectivo sckCliente
                hiloServidor = new ControladorServidor(sckCliente);
                hiloServidor.start();
                System.out.println("Hilo de procesamiento para el cliente iniciado");
            }

        } catch (Exception e) {
            System.out.println("No fue posible establecer la conexion con el cliente");
        }

    }

}
