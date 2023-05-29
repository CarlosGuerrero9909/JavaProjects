/* 27/02/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC en donde se implementan sockets e hilos para hacer un chat que permita
concetar clientes con un servidor para enviar y recibir mensajes visibles para 
todos los clientres conectdos al igual que poder enviar mensjaes en privado 
(funcionalidad no completada)*/
package controladorServidor;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import vistaServidor.VentanaServidor;

/**
 * Clase encargada de aceptar peticiones y lanzar el hilos del servidor para
 * atender las peticiones de los clientes
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class Servidor {

    //Atributos del servidor necesarios para establecer la conexion
    private ServerSocket sckServer;
    private ControladorServidor controlS;
    private int PUERTO;
    private VentanaServidor vtnS;

    /**
     * Constructor del servidor que genera el socket del servidor y
     *
     * @param PUERTO
     */
    public Servidor(int PUERTO) {
        //definimos nuestro puerto de comunicacion e iniciamos el servidor
        this.PUERTO = PUERTO;
        try {

            // iniciamos el sckServer por el puerto por el que se establecera la conexion
            sckServer = new ServerSocket(this.PUERTO);
            // creacion de la ventana del servidor
            vtnS = new VentanaServidor(controlS);
            // imprime mensaje de confirmacion de conexion
            mensajeriaServidor("*.:Servidor Con Conexion:.*");

            // acepta socketclientes contantemente cada vez que llegue alguno
            while (true) {
                // acepta cliente
                Socket sckCliente = sckServer.accept(); //se pasan responsabilidades al sckCliente
                // imprime mensaje de ocnfirmacion
                mensajeriaServidor("Cliente" + " conectado desde la direccion: " + sckCliente);

                // creacion de flujo de entrada de datos
                DataInputStream entrada = new DataInputStream(sckCliente.getInputStream()); //se establece canal de entrada al servidor

                //se crea y comienza un nuevo hiloServidor para cada cliente, llamando a contructor de la clase ControladorServidor
                controlS = new ControladorServidor(sckCliente, entrada.readUTF(), this);
                // se inicia el hilo
                controlS.start();
            }
        } catch (Exception e) {
            // mensaje Error al establecer conexion con el socket y flujos
            VentanaServidor.mostrarJOptionPane(0, e);
        }

    }

    /**
     * Metodo gestor de la mensajeria en la ventana del servidor
     *
     * @param msg
     */
    public void mensajeriaServidor(String msg) {
        vtnS.getPnlInfoGeneral().getjTxaInfoGeneral().append(" " + msg + "\n");
    }

}
