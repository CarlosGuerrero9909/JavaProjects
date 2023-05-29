package control;

// importaciones necesarias para el funcionamiento de todos los recursos usados en la clase
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Tiempo;
import vista.Ventana;

/**
 * Esta clase se encarga de toda la logica del programa, haciendole peticiones a las demas clases y
 * enviando datos, sin esta clase el programa no podria funcionar correctamente
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 */
public class Controlador extends Thread implements ActionListener {

	// instancia de la ventana principal
	private Ventana vtn;
	private Tiempo current;
	private Thread thread;
	private boolean hiloActivo;

	/**
	 * Metodo constructor de la clase Gestor, encargado de iniciar los objetos y principales
	 * acciones necesarias para el control y gestion de la logica del programa. Para la
	 * instanciacion de este se le debe enviar una ventana principal
	 *
	 * @param vtnPrin
	 */
	public Controlador(Ventana vtn) {
		this.vtn = vtn;

	}

	/**
	 * Este metodo es el metodo que se ejecuta al iniciar (metodo start) el hilo. Se encarga de
	 * actualizar el panel con los nuevos datos, en este caso se duerme durante 1 segundo para
	 * generar el contador de tiempo
	 */
	@Override
	public void run() {
		// mientras el hilo este activo, el hilo seguira ejecutandose
		while (hiloActivo) {
			try {
				// descansa de 1 segundo y luego se actualiza
				thread.sleep(1000);
				// luego de dormir 1 segundo actualiza el objeto de la clase Tiempo para aumentar 1 segundo
				current.setSegundos(current.getSegundos() + 1);
				// muestra las variables del objeto current en el jtextfield
				vtn.getpCont().getTxfContadorT().setText(current.toString());
				// si los segundos son mayores de 59, esta variable se reinicia a 0 y le suma 1 a minutos
				if (current.getSegundos() > 59) {
					current.setSegundos(0);
					current.setMinutos(current.getMinutos() + 1);
				}
				// si los minutos son mayores de 59, esta variable se reinicia a 0 y le suma 1 a horas
				if (current.getMinutos() > 59) {
					current.setSegundos(0);
					current.setMinutos(0);
					current.setHoras(current.getHoras() + 1);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Metodo sobreescrito de la Clase ActionListener, donde con el parametro se capturara el
	 * comando respectivo a cada jBtn para ejecutar las respectivas acciones
	 *
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// en este atributo se guardara el comando que entra
		String comando = e.getActionCommand();
		// configuracion del boton iniciar en 0 del panel botones de la ventana
		if (comando.equals("Iniciar en 0")) {
			// da via libre para que el hilo se active
			hiloActivo = true;
			// instancia hilo
			thread = new Thread(this);
			// Prepara (bloquea y activa) objetos de la ventana al presionar boton
			vtn.iniciarConteoInterfaz();
			// instancia objeto de la clase tiempo que guardara la hora, minuto y segundo actual.
			current = new Tiempo();
			// ejecuta el metodo run que da inicio al hilo
			thread.start();

			// configuracion del boton Cargar Valores del panel botones de la ventana
		} else if (comando.equals("Cargar valores")) { //No es cargar Valores  "V" es con "v" valores
			// desactiva el hilo
			hiloActivo = false;
			// Prepara (bloquea y activa) objetos de la ventana al presionar boton
			vtn.cargarValoresInterfaz();

			// configuracion del boton Iniciar del panel botones de la ventana
		} else if (comando.equals("Iniciar")) {
			// excepcion si se ingresan caracteres distintos de numeros
			try {
				// valida los datos ingresados, pasando los vacios a 0 y los datos mayores de 59, se le suma 1 a la unidad mas grande 
				validarDatosIngresados(vtn.getpData().getTxfHoras().getText(), vtn.getpData().getTxfMinutos().getText(), vtn.getpData().getTxfSegundos().getText());
				// activa el hilo
				hiloActivo = true;
				// instancia del hilo nuevo
				thread = new Thread(this);
				// Prepara (bloquea y activa) objetos de la ventana al presionar boton
				vtn.iniciarConteoInterfaz();
				// ejecuta el metodo run que da inicio al hilo
				thread.start();
			} catch (NumberFormatException nfe) {
				// muestra ventana emergente comunicando el error
				Ventana.mostrarJOptionPane(0);
			}

			// configuracion del boton Reiniciar del panel botones de la ventana
		} else if (comando.equals("Reiniciar")) {
			// restaura valores del objeto
			current.setHoras(0);
			current.setMinutos(0);
			current.setSegundos(-1);

			// desactiva el hilo
			hiloActivo = false;

			// Prepara (bloquea y activa) objetos de la ventana al presionar boton
			vtn.reiniciarInterfaz();
		} else if (comando.equals("Salir")) {
			// ejecuta metodo para matar programa
			vtn.salir();
		}
	}

	/**
	 * Metodo encargado de validar los datos y configurarlos para una correcta ejecucion del
	 * programa
	 *
	 * @param horas
	 * @param minutos
	 * @param segundos
	 */
	public void validarDatosIngresados(String horas, String minutos, String segundos) {
		// configura variables si hay vacios
		if (horas.equals("")) {
			horas = "0";
		}
		if (minutos.equals("")) {
			minutos = "0";
		}
		if (segundos.equals("")) {
			segundos = "0";
		}

		// variables para guardar datos alojados en el jtexfield
		int h = Integer.parseInt(horas);
		int m = Integer.parseInt(minutos);
		int s = Integer.parseInt(segundos);

		// configura si los valores superan 59, en casi verdadero, se le suma las unidades correspondientes a la unidad mmas grande
		if (s > 59) {
			if (s % 60 == 0) {
				m = m + (s / 60);
				s = 0;
			} else {
				m = m + (int) ((s / 60));
				s = s % 60;
			}
		}
		if (m > 59) {
			if (m % 60 == 0) {
				h = h + (m / 60);
				m = 0;
			} else {
				h = h + (int) ((m / 60));
				m = m % 60;
			}
		}

		// crea un objeto tipo Tiempo
		current = new Tiempo(h, m, s);
	}

	/**
	 * Metodo getter para obtener la ventana
	 *
	 * @return
	 */
	public Ventana getVtn() {
		return vtn;
	}

	/**
	 * Metodo getter para editar la ventana
	 *
	 * @param vtn
	 */
	public void setVtn(Ventana vtn) {
		this.vtn = vtn;
	}

	/**
	 *
	 * @return
	 */
	public Tiempo getCurrent() {
		return current;
	}

	/**
	 *
	 * @param current
	 */
	public void setCurrent(Tiempo current) {
		this.current = current;
	}

	/**
	 *
	 * @return
	 */
	public Thread getThread() {
		return thread;
	}

	/**
	 *
	 * @param thread
	 */
	public void setThread(Thread thread) {
		this.thread = thread;
	}

	/**
	 *
	 * @return
	 */
	public boolean isHiloActivo() {
		return hiloActivo;
	}

	/**
	 *
	 * @param hiloActivo
	 */
	public void setHiloActivo(boolean hiloActivo) {
		this.hiloActivo = hiloActivo;
	}

}
