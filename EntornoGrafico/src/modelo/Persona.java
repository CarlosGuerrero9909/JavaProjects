package modelo;

/**
 * Esta clase crea objetos tipo persona
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 */
public class Persona {

	// atributo emplados para cada persona
	private String nombre;
	private String cedula;
	private String apellido;
	private String imc;

	/**
	 * Constructor 1 el cual permite crear objetos persoan sin necesidad de variables de entrada
	 */
	public Persona() {

	}

	/**
	 * Constructor 2 el cual requiere un parametro para cada atributo que posee la clase
	 *
	 * @param nombre
	 * @param cedula
	 * @param apellido
	 * @param imc
	 */
	public Persona(String nombre, String cedula, String apellido, String imc) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.apellido = apellido;
		this.imc = imc;
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
	public String getCedula() {
		return cedula;
	}

	/**
	 *
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 *
	 * @return
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 *
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 *
	 * @return
	 */
	public String getImc() {
		return imc;
	}

	/**
	 *
	 * @param imc
	 */
	public void setImc(String imc) {
		this.imc = imc;
	}

}
