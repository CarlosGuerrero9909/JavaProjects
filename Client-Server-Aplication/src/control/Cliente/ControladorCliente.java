/* 13/03/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC como segundo parcial en donde se implementa interfaz grafica, base de 
datos, sql, sockets e hilos para realizar un speech de frases ingresadas por
distintos clientes conectados a un servidor el cual es el encargado de leer las 
frases enviadas 
*/
package control.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import modelo.ClienteVO;
import vista.VentanaCliente;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class ControladorCliente extends Thread implements ActionListener {

    private Socket sckCliente;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private VentanaCliente vtnC;
    private ClienteVO clienteVo;
    private String mensaje;

    public ControladorCliente(Socket sckCliente, String nombre, String contraseña) {
        this.sckCliente = sckCliente;

        // se instancia un cliente al cual se le envian el nombre y contraseña ingresada´por el usuario
        clienteVo = new ClienteVO(nombre, contraseña);

        // genera la ventana del cliente pero la deja no visible hasta que se verifique que el usuario si está registrado
        this.vtnC = new VentanaCliente(this);
        
        // se le agregan actionlistener a los botones para realizar acciones al ser presionados
        this.vtnC.getBotones().getBtnLeer().addActionListener(this);
        this.vtnC.getBotones().getBtnLimpiar().addActionListener(this);
        this.vtnC.getBotones().getBtnSalir().addActionListener(this);

    }

    /**
     * Metodo que se correra al crear el hilo y enviara mensajes al servidor
     */
    @Override
    public void run() {
        try {
            /*-----Obtener los flujos de entrada y salida-----*/
            // establecer flujo de salida para los objetos
            salida = new ObjectOutputStream(sckCliente.getOutputStream());
            salida.flush(); // vacíar búfer de salida
            // establecer flujo de entrada para los objetos
            entrada = new ObjectInputStream(sckCliente.getInputStream());
            System.out.println("Se establecieron los flujos de E/S");

            // Envio de credenciales para su verificacion
            mensaje = clienteVo.getNombre(); // atrapar los problemas que pueden ocurrir al leer del servidor
            enviarDatos(mensaje);
            mensaje = clienteVo.getContraseña();
            enviarDatos(mensaje);
            System.out.println("Se envian credenciales para verificacion, esperando respuesta del servidor.");

            /*-----Procesar la conexion-----*/
			    // leer respuesta de verificacion de credenciales
            while (true) { //procesar mensajes enviados del servidor
                int aux = 0;
				// leer mensaje y mostrarlo en pantalla
                try {
                    mensaje = (String) entrada.readObject();
                    System.out.println(mensaje);
                    
                    if (mensaje.equals("Servidor >> El cliente no está registrado")){
						aux = 1;
                        VentanaCliente.mostrarJOptionPane(6);
						System.out.println("El cliente NO esta registrado");
                    }
                    if (mensaje.equals("Servidor >> Conexion recibida de:localhost")){
                        VentanaCliente.mostrarJOptionPane(7);
						System.out.println("El cliente esta registrado");
                    }
                    
                    // si se envio un cliente correcto y no hay respuesta negativa del servidor se deja ver la ventana
                    if((!mensaje.equals("Servidor >> bye") && (aux==0))){
                        vtnC.setVisible(true);
                    }
                } // atrapar los problemas que pueden ocurrir al leer del servidor
                catch (ClassNotFoundException excepcionClaseNoEncontrada) {
                    System.out.println("Se recibió un objeto de tipo desconocido");
                }
            }
        } // el servidor cerró la conexión
        catch (EOFException excepcionEOF) {
            System.err.println("El cliente termino la conexión");
        } // procesar los problemas que pueden ocurrir al comunicarse con el servidor
        catch (IOException excepcionES) {
            excepcionES.printStackTrace();
        } /*-----Cerrar la conexion-----*/ finally {
            System.out.println("Cerrando conexión");
            try {
                salida.close();
                entrada.close();
                sckCliente.close();
            } catch (IOException excepcionES) {
                excepcionES.printStackTrace();
            }
        }
    }

    @Override
    // conectarse al servidor y procesar mensajes del servidor
    public void actionPerformed(ActionEvent evento) {
        if (vtnC.getDatos().verificarCampo() == false) {
            if (evento.getActionCommand().equals("Leer")) {
                enviarDatos(vtnC.getDatos().getTxtFrase().getText());

            }
        }
        if (evento.getActionCommand().equals("Limpiar")) {
            vtnC.getDatos().limpiarCampo();
        }
        if (evento.getActionCommand().equals("Salir")) {
			enviarDatos("cliente saliendo");
			vtnC.mostrarJOptionPane(8);
            System.exit(0);
        }
    }

    // enviar mensaje al servidor
    private void enviarDatos(String mensaje) {
        // enviar objeto al servidor
        try {
            salida.writeObject(mensaje);
            salida.flush();
            //System.out.println("Cliente >> "+mensaje);
        } // procesar los problemas que pueden ocurrir al enviar el objeto
        catch (IOException excepcionES) {
            System.out.println("Error al escribir");
        }
    }

    public String getMensaje() {
        return mensaje;
    }


}
