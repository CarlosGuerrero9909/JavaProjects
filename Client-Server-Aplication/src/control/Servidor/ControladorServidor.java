/* 13/03/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC como segundo parcial en donde se implementa interfaz grafica, base de 
datos, sql, sockets e hilos para realizar un speech de frases ingresadas por
distintos clientes conectados a un servidor el cual es el encargado de leer las 
frases enviadas 
*/
package control.Servidor;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import control.dao.ServidorDAO;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import modelo.ClienteVO;
import vista.VentanaCliente;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class ControladorServidor extends Thread {

    private Socket sckCliente;
    private ServidorDAO servidorDao;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private String mensaje;
    private String nombreCliente;
    private String contraseñaCliente;

    public ControladorServidor(Socket sckCliente) {
        this.sckCliente = sckCliente;
    }

    @Override
    public void run() {
        try {

            /*----Verificacion de Credenciales de Cliente----*/
            // establecer flujo de entrada para los objetos
            entrada = new ObjectInputStream(sckCliente.getInputStream());
            // establecer flujo de salida para los objetos y enviar conexion exitosa
            salida = new ObjectOutputStream(sckCliente.getOutputStream());
            System.out.println("Flujos de entrada y salida obtenidos");

            // lee credenciales y las verifica con la base de datos
            try {
                mensaje = (String) entrada.readObject();
                System.out.println("nombre " + mensaje);
                nombreCliente = mensaje;
                mensaje = (String) entrada.readObject();
                System.out.println("contraseña " + mensaje);
                contraseñaCliente = mensaje;

                System.out.println(" --> Verificando credenciales");

                // varible auxiliar que guardara el retorno del metodo de verificar el cliente ingresado
                Boolean auxVerificacion = false;

                // verifica existencia de usuario ingresado con el arraylist de la base de datos 
                auxVerificacion = verificarCliente();

                // si no existe el cliente cierra flujos y socket
                if (auxVerificacion == false) {

                    // mostrar ventana emergente sobre la incapacidad de hallar el usuario encontrado
                    VentanaCliente.mostrarJOptionPane(1);

                    mensaje = "El cliente no está registrado";

                    salida.writeObject("Servidor >> " + mensaje);
                    salida.flush(); // limpiar flujo de salida
                    salida.writeObject("Servidor >> bye");
                    salida.flush(); // limpiar flujo de salida
                    System.out.println("Servidor >> " + mensaje);

                    System.out.println("Finalizando conexión");

                    // cierra flujos y socket
                    try {
                        salida.close();
                        entrada.close();
                        sckCliente.close();
                    } catch (IOException excepcionES) {
                        excepcionES.printStackTrace();
                    }

                    // si sí existe el cliente da confirmacion
                } else {

                    // mostrar ventana emergente de confirmacion de usuario encontrado
                    VentanaCliente.mostrarJOptionPane(2);
                    mensaje = "Conexion recibida de:localhost";

                    salida.writeObject("Servidor >> " + mensaje);
                    salida.flush(); // limpiar flujo de salida
                    System.out.println("Servidor >> " + mensaje);

                    reproducirMensaje("Hello there, " + nombreCliente);
                    mensaje = "Hello there, " + nombreCliente;
                    salida.writeObject("Servidor >> " + mensaje);
                    salida.flush(); // limpiar flujo de salida

                }

            } // atrapar problemas que pueden ocurrir al tratar de leer del cliente
            catch (ClassNotFoundException excepcionClaseNoEncontrada) {
                System.out.println("Se recibio un objeto de tipo desconocido");
            }

            mensaje = "Conexión exitosa";
            try {

                salida.writeObject("Servidor >> " + mensaje);
                salida.flush(); // limpiar flujo de salida
                System.out.println("" + mensaje);

                /*----Procesar la conexión.----*/
                do { // procesar los mensajes enviados por el cliente
                    // leer el mensaje y mostrarlo en pantalla
                    try {
                        mensaje = (String) entrada.readObject();
                        if (mensaje.equals("cliente saliendo")) {
                            mensaje = "See you later " + nombreCliente;
                            salida.writeObject("Servidor >> " + mensaje);
                            salida.flush(); // limpiar flujo de salida
                            reproducirMensaje("See you later " + nombreCliente);
                        } else {
                            System.out.println("Cliente " + nombreCliente + " >> " + mensaje);
                            reproducirMensaje(mensaje);
                        }

                    } catch (SocketException se) {

                    } // atrapar problemas que pueden ocurrir al tratar de leer del cliente
                    catch (ClassNotFoundException excepcionClaseNoEncontrada) {
                        System.out.println("Se recibio un objeto de tipo desconocido");
                    }
                } while (true);

            } // procesar excepción EOFException cuando el cliente cierre la conexión 
            catch (EOFException excepcionEOF) {
                System.err.println("El servidor terminó la conexión");
            } catch (SocketException sexp) {
                System.out.println("Interrupción en el socket");
            } /*-----Cerrar la conexion-----*/ finally {
                System.out.println("Finalizando conexión");
                try {
                    salida.close();
                    entrada.close();
                    sckCliente.close();
                } catch (IOException excepcionES) {
                    System.out.println("No fue posible la conexion");
                }
            }
        } // procesar problemas con E/S
        catch (IOException excepcionES) {
            excepcionES.printStackTrace();
        }
    }

    /**
     * Verifica si el cliente ingresado existe en la base de datos
     *
     * @return
     */
    public boolean verificarCliente() {
        servidorDao = new ServidorDAO();

        ClienteVO clienteAux = null;

        clienteAux = servidorDao.recuperarClienteDeBaseDeDatos(nombreCliente, contraseñaCliente);

        if (clienteAux != null) {
            return true;
        }

        return false;
    }

    /**
     * reproduce sonido
     *
     * @param mensaje
     */
    public void reproducirMensaje(String mensaje) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");

        //print all voices
        /*Voice[] voicelist = VoiceManager.getInstance().getVoices();
        for (int i = 0; i < voicelist.length; i++) {
            System.out.println("Voice" + voicelist[i].getName());
        }*/
        if (voice != null) {
            voice.allocate();
            //System.out.println("Voice rate: " + voice.getRate());
            //System.out.println("Voice Pitch: " + voice.getPitch());
            //System.out.println("Voice volume: " + voice.getVolume());
            boolean status = voice.speak(mensaje);
            //System.out.println("Status:" + status);
            voice.deallocate();
        } else {
            System.out.println("Error in getting voices");
        }
    }

}
