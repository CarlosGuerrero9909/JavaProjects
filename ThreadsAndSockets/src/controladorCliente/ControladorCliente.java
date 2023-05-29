/* 27/02/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC en donde se implementan sockets e hilos para hacer un chat que permita
concetar clientes con un servidor para enviar y recibir mensajes visibles para 
todos los clientres conectdos al igual que poder enviar mensjaes en privado 
(funcionalidad no completada)*/
package controladorCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vistaCliente.VentanaCliente;
import vistaClientePrivado.VentanaClientePrivado;

/**
 * Clase que contiene la informacion del cliente y envia sus mensajes al sevidor
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class ControladorCliente extends Thread implements ActionListener {

	// socket 
	private Socket sckCliente;

	// flujos de comunicacion
	private DataInputStream entrada;
	private DataOutputStream salida;
	private ObjectInputStream entradaObjeto;

	private Cliente cliente;
	private VentanaCliente vtnC;

	// nombre del cliente
	private String nombre;
	// atributos para el manejo de archivos
	private File fileOrigen;
	private boolean vaUnArchivo = false;

	/**
	 * Constructor del hilo cliente al cual se le ingresara el socket y se le iyectara el cliente
	 * que lanzo el hilo
	 *
	 * @param SocketCliente
	 * @param cliente
	 * @throws IOException
	 */
	public ControladorCliente(Socket SocketCliente, Cliente cliente) throws IOException {
		this.sckCliente = SocketCliente;
		this.cliente = cliente;
		// flujo de salida de datos
		salida = new DataOutputStream(sckCliente.getOutputStream());

		// do para control de no ingreso de nombre del cliente
		do {
			nombre = String.valueOf(JOptionPane.showInputDialog(null, new JLabel("Ingrese su nombre", JLabel.CENTER), "Nombre", JOptionPane.PLAIN_MESSAGE));
			if (nombre.equals("")) {
				JOptionPane.showMessageDialog(null, "No se escibio un nombre, vuelva a intentar", "Ingreso de Nombre Incompleto", 2);
			}
		} while (nombre.equals(""));

		// envia el nombre al servidor
		salida.writeUTF(nombre);

		// instancia su ventana dejandolaa visible
		this.vtnC = new VentanaCliente(this);

	}

	/**
	 * Metodo run que sera el metodo que se ejecutara al iniciar el hilo y que sera el encargado de
	 * enviar y resivir datos constantemente del servidor
	 */
	@Override
	public void run() {
		while (true) {
			try {
				// flujo de entrada de datos
				DataInputStream entrada = new DataInputStream(sckCliente.getInputStream());
				// muestra entrada de datos en la interfaz
				mensajeriaCliente(entrada.readUTF());
				
				/**
				 * Este bloque se encuentra en proceso por dificultades
				 */
				/*if (vaUnArchivo == true) {
				// RECIBIR ARCHIVO	
					// Se crea un flujo de salida, este flujo nos sirve para 
					// indicar donde guardaremos el archivo
					String nomArchivo = "C:\\Users\\Usuario\\Documents\\archivoDeltaller6.txt";
					fileDestino = new File(nomArchivo);
					//fileDestino.setReadable(true);
					//fileDestino.setWritable(true);
					FileOutputStream fos = new FileOutputStream(nomArchivo);

					//se crean los flujose de entrada y salida
					//el flujo de salida escribe en el archivo
					DataOutputStream outCliente = new DataOutputStream(fos);
					//el flujo de entrada lee desde el canal
					//entrada = new DataInputStream(sckCliente.getInputStream());
				// RECIBIR PAQUETES
					System.out.println("ClienteRecibir >> Empieza la recepcion del archivo");
					// Se crea el array de bytes para leer los datos del archivo
					byte[] buffer = new byte[2048]; //8x256
					int paq = 1;
					int bytesRead;
					while ((bytesRead = entrada.read(buffer)) > 0) {
						outCliente.write(buffer, 0, bytesRead);
						System.out.println("ClienteRecibir >> Paquete: " + paq + " --> Bytes recibidos: " + bytesRead);
						paq++;
						bytesRead = 0;
					}
					System.out.println("ClienteRecibir >> Termino la Recepcion del Archivo");
					
					vaUnArchivo = false;
				}*/
				
				entradaObjeto = new ObjectInputStream(sckCliente.getInputStream());
				// actualiza lista de clientes en la einterfaz
				actualizarLista((DefaultListModel) entradaObjeto.readObject());

			} catch (ClassNotFoundException ex) {
				// Mensaje Error al encontrar la clase
				VentanaCliente.mostrarJOptionPane(1, ex);
				System.exit(0);
				break;
			} catch (IOException ex) {
				// Mensaje Error 
				VentanaCliente.mostrarJOptionPane(2, ex);
				System.exit(0);
				break;
			}
		}
	}

	/**
	 * Metodo que se encarga de mostrar en ventana mensjes
	 *
	 * @param msg
	 */
	public void mensajeriaCliente(String msg) {
		vtnC.getPnlChatGeneral().getjTxaChatGeneral().append(" " + msg + "\n");
	}

	/**
	 * metodo encargado de actuaizar la lista de clientes de la ventana
	 *
	 * @param modelo
	 */
	public void actualizarLista(DefaultListModel modelo) {
		vtnC.getPnlClientesConectados().getjTxaClientesConectados().setModel(modelo);
	}

	/**
	 * Metodo encargado de escuchar eventos dados por los botones de la interzar y ejecutar
	 * funcionalidades de cada uno
	 *
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// en esta variable se guardara el comando que entra
		String comando = e.getActionCommand();

		// acion de boton enviar
		if (comando.equals("Enviar")) {
			// if apra control de que no se escriba ningun mensaje
			if (!vtnC.getPnlChatGeneral().getPnlEscritura().getjTxfCampoEntrada().getText().equals("")) {
				try {
					// genera un nuevo flujo de salida de datos
					salida = new DataOutputStream(sckCliente.getOutputStream());
					// envia el mensaje escrito
					salida.writeUTF(nombre + " : " + vtnC.getPnlChatGeneral().getPnlEscritura().getjTxfCampoEntrada().getText());
					// reinicia el campo de texto al enviar el mensaje escrito
					vtnC.getPnlChatGeneral().getPnlEscritura().getjTxfCampoEntrada().setText("");
				} catch (IOException ex) {
					VentanaCliente.mostrarJOptionPane(2, ex);
					java.util.logging.Logger.getLogger(ControladorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
				}
			} else {
				// Mensaje al no escribir nada para enviar
				JOptionPane.showMessageDialog(null, "No escribir nada para enviar, escriba un mensaje", "No Hay Nada Para Enviar", 1);
			}
		}

		// accion de boton privado
		if (comando.equals("Privado")) {
			if (vtnC.getPnlClientesConectados().getjTxaClientesConectados().isSelectionEmpty()) {
				System.out.println("No ha seleccionado ningun cliente para un chat privado");
			}else{
				System.out.println("chat seleccionado: "+vtnC.getPnlClientesConectados().getjTxaClientesConectados().getSelectedValue());
				VentanaClientePrivado vtnCP = new VentanaClientePrivado(this);
			}

		}

		// accion de boton adjuntar
		// esta funcionalidad no se pudo completar del todo por lo que solo permite leer de un archivo
		// texto plano o similar para mostrar en la ventana del chat de los clientes
		if (comando.equals("Adjuntar")) {
			try {
				conectarParaEnvioArchivo();
				enviarPaquetes();
			} catch (IOException exep) {
				VentanaCliente.mostrarJOptionPane(2, exep);
				java.util.logging.Logger.getLogger(ControladorCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, exep);
			}
		}
	}

	/**
	 * CONECTANDO ENVIO DEL ARCHIVO
	 */
	public void conectarParaEnvioArchivo() throws FileNotFoundException, IOException {
		// buscar el archivo con una ventana de busqueda
		vtnC.buscarArchivoDeEnvio(this);
		// se crea un flujo de entrada
		FileInputStream fis = new FileInputStream(fileOrigen);
		//tamano del archivo
		int tamanoArchivo = (int) fileOrigen.length();
		System.out.println("ClienteEnviar >> Archivo a Enviar: " + fileOrigen.getName());
		System.out.println("ClienteEnviar >> Tamano del Archivo a enviar: " + tamanoArchivo);
		// Se crea el flujo de salida ya creado, este tipo de flujo  permite 
		// hacer la escritura de diferentes tipos de datos tales como
		// Strings, boolean, caracteres y la familia de enteros, etc.
		DataOutputStream dos = new DataOutputStream(sckCliente.getOutputStream());
		// Enviamos el nombre del archivo 
		dos.writeUTF(nombre + ": " + fileOrigen.getName());
		// Enviamos el tamano del archivo
		dos.writeInt(tamanoArchivo);
		System.out.println(fileOrigen.getName());
		//crear el flujo de entrada y salida
		//el flujo de entrada lee desde el archivo
		entrada = new DataInputStream(fis);
		//el flujo de salida escribe al canal
		salida = new DataOutputStream(sckCliente.getOutputStream());
	}

	/**
	 * ENVIAR PAQUETES
	 */
	public void enviarPaquetes() throws IOException {
		// Se crea un array de tipo byte con el tamano del archivo 
		byte[] buffer = new byte[2048]; //8x256
		int paq = 0;
		int bytesRead;
		while ((bytesRead = entrada.read(buffer)) > 0) {
			salida.write(buffer, 0, bytesRead);
			paq++;
			System.out.println("ClienteEnviar >> Paquete: " + paq + " Bytes enviados: " + bytesRead);
			bytesRead = 0;
		}
		System.out.println("ClienteEnviar >> Termino el envio del Archivo: " + fileOrigen.getName());
		vaUnArchivo = true;
	}
	
	/**
	 * RECIBIR ARCHIVO
	 */
	
	/**
	 * RECIBIR PAQUETES
	 */

	// GETTERS Y SETTERS
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
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 *
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 *
	 * @return
	 */
	public ObjectInputStream getEntradaObjeto() {
		return entradaObjeto;
	}

	/**
	 *
	 * @param entradaObjeto
	 */
	public void setEntradaObjeto(ObjectInputStream entradaObjeto) {
		this.entradaObjeto = entradaObjeto;
	}

	/**
	 *
	 * @return
	 */
	public VentanaCliente getVtnC() {
		return vtnC;
	}

	/**
	 *
	 * @param vtnC
	 */
	public void setVtnC(VentanaCliente vtnC) {
		this.vtnC = vtnC;
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
	public File getFileOrigen() {
		return fileOrigen;
	}

	/**
	 *
	 * @param fileOrigen
	 */
	public void setFileOrigen(File fileOrigen) {
		this.fileOrigen = fileOrigen;
	}

}
