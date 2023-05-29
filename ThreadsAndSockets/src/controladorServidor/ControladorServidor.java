/* 27/02/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC en donde se implementan sockets e hilos para hacer un chat que permita
concetar clientes con un servidor para enviar y recibir mensajes visibles para 
todos los clientres conectdos al igual que poder enviar mensjaes en privado 
(funcionalidad no completada)*/
package controladorServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import javax.swing.DefaultListModel;
import vistaServidor.VentanaServidor;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class ControladorServidor extends Thread {

    // Atributos de la clase controladora de los flujos e hilos de conexion
    private DataInputStream entrada;
    private DataOutputStream salida;
    private Servidor server;
    private Socket sckCliente;
    // Vector que manejara dinamicamente los usuarios activos
    public static Vector<ControladorServidor> clientesActivos = new Vector();
    private String nombre;
    private ObjectOutputStream salidaObjeto;

    /**
     * Contructor encargado de iniciar los paramentros necesarios para la
     * ejecucion de cada nuevo hilo de conexion Cada que se llame este
     * contructor se agregara un cliente activo y su respectivo hilo de
     * ejecucion
     *
     * @param sckCliente
     * @param nombre
     * @param server
     * @throws Exception
     */
    public ControladorServidor(Socket sckCliente, String nombre, Servidor server) throws Exception {
        //inicializacion de los atributos del ciente que se conecta
        this.sckCliente = sckCliente;
        this.nombre = nombre;
        this.server = server;

        // se agrega al ventor el cliente conectado, que ahora sera un cliente activo
        clientesActivos.add(this);

        //gestiona el aviso de que un nuevo clienteActivo se ha conectado al servidor
        for (int i = 0; i < clientesActivos.size(); i++) {
            clientesActivos.get(i).envioMensajes(nombre + " se ha conectado");
        }
    }

    /**
     * Metodo run encargado de correr el hilo de ejecucion de cada cliente
     */
    @Override
    public void run() {
        //mensjaje que revibira el servidor
        String mensaje = " ";

        //Ciclo a la espera de nuevas entradas (mensajes) de los clientes que gestionara el servidor
        while (true) {
            try {
                //se establece el canal de entrada y se lee el mensaje que gestionara el servidor
                entrada = new DataInputStream(sckCliente.getInputStream());
                mensaje = entrada.readUTF();
                System.out.println("mensaje");
                //Se gestiona el envio de mensajes de los clientes activos guardados en el Vector
                for (int i = 0; i < clientesActivos.size(); i++) {
                    clientesActivos.get(i).envioMensajes(mensaje);
                    server.mensajeriaServidor("Mensaje de " + nombre + " enviado");
                }

            } catch (Exception e) {
                // Error al comunicarse con el cliente
                VentanaServidor.mostrarJOptionPane(1, e);
                break;
            }
        }

        //si el ciclo termina para alguno de los clientes activos es por que este se ha desconectado
        server.mensajeriaServidor("El usuario " + nombre + " se ha desconectado");
        clientesActivos.removeElement(this);

        // cerramos el sckCliente del cliente desconectado
        try {
            sckCliente.close();
        } catch (Exception e) {
            // Error al ccerrar socket
            VentanaServidor.mostrarJOptionPane(2, e);
        }
    }

    /**
     * Metodo que gestiona el envio de mensajes
     *
     * @param msg
     * @throws Exception
     */
    private void envioMensajes(String msg) throws Exception {
        salida = new DataOutputStream(sckCliente.getOutputStream());
        salida.writeUTF(msg);
        DefaultListModel modelo = new DefaultListModel();

        for (int i = 0; i < clientesActivos.size(); i++) {
            modelo.addElement(clientesActivos.get(i).nombre);
        }

        salidaObjeto = new ObjectOutputStream(sckCliente.getOutputStream());
        salidaObjeto.writeObject(modelo);

    }

    // Getters y seters
    /**
     *
     * @return
     */
    public DataInputStream getEntrada() {
        return entrada;
    }

    /**
     *
     * @param entrada
     */
    public void setEntrada(DataInputStream entrada) {
        this.entrada = entrada;
    }

    /**
     *
     * @return
     */
    public DataOutputStream getSalida() {
        return salida;
    }

    /**
     *
     * @param salida
     */
    public void setSalida(DataOutputStream salida) {
        this.salida = salida;
    }

    /**
     *
     * @return
     */
    public Servidor getServer() {
        return server;
    }

    /**
     *
     * @param server
     */
    public void setServer(Servidor server) {
        this.server = server;
    }

    /**
     *
     * @return
     */
    public Socket getSckCliente() {
        return sckCliente;
    }

    /**
     *
     * @param sckCliente
     */
    public void setSckCliente(Socket sckCliente) {
        this.sckCliente = sckCliente;
    }

    /**
     *
     * @return
     */
    public static Vector<ControladorServidor> getClientesActivos() {
        return clientesActivos;
    }

    /**
     *
     * @param clientesActivos
     */
    public static void setClientesActivos(Vector<ControladorServidor> clientesActivos) {
        ControladorServidor.clientesActivos = clientesActivos;
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
    public ObjectOutputStream getSalidaObjeto() {
        return salidaObjeto;
    }

    /**
     *
     * @param salidaObjeto
     */
    public void setSalidaObjeto(ObjectOutputStream salidaObjeto) {
        this.salidaObjeto = salidaObjeto;
    }

}
