package modelo;

/**
 * Clase encargada de generar objetos tipo tiempo que contiene las variables del tiempo (horas,
 * minutos y segundos)
 *
 * @author Carlos Guerrero
 * @author Nicolas Diaz
 */
public class Tiempo {

	private int horas;
	private int minutos;
	private int segundos;

	/**
	 * Contructor de la clase para cuando se instancia un objeto tipo tiempo sin variables exactas
	 */
	public Tiempo() {
		horas = 0;
		minutos = 0;
		segundos = 0;
	}

	/**
	 * Contructor 2 para cuando se instancia un objeto con variables exactas
	 *
	 * @param horas
	 * @param minutos
	 * @param segundos
	 */
	public Tiempo(int horas, int minutos, int segundos) {
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}

	/**
	 *
	 * @return
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 *
	 * @param horas
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 *
	 * @return
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 *
	 * @param minutos
	 */
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	/**
	 *
	 * @return
	 */
	public int getSegundos() {
		return segundos;
	}

	/**
	 *
	 * @param segundos
	 */
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return "" + horas + ":" + minutos + ":" + segundos;
	}

}
