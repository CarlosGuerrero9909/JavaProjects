package control;

// importaciones necesarias para el funcionamiento de todos los recursos usados en la clase
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Persona;
import vista.Ventana;

/**
 * Esta clase se encarga de toda la logica del programa, haciendole peticiones a
 * las demas clases y enviando datos, sin esta clase el programa no podria
 * funcionar correctamente
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 */
public class Controlador implements ActionListener {

    // atributo de la ventana principal
    private Ventana vtn;
    //atributo persona en el cual se guardaran todos los datos de la persona ingresada
    private Persona nea;
    // arraylist en el que se guardaran todos las personas guardadas
    private ArrayList<Persona> listaPersonas;
    // atributo auxiliar para manejar si una persona fue guardada anteriormente
    boolean auxPersonaGuardada = false;

    /**
     * Metodo constructor de la clase Gestor, encargado de iniciar los objetos y
     * principales acciones necesarias para el control y gestion de la logica
     * del programa. Para la instanciacion de este le debe llegar una ventana
     * principal
     *
     * @param vtnPrin
     */
    public Controlador(Ventana vtn) {
        this.vtn = vtn;
        // instanciacion de arraylist donde se guardaran todos las personas guarddas
        listaPersonas = new ArrayList<>();
    }

    /**
     * Metodo sobreescrito de la Clase ActionListener, donde con el parametro se
     * capturara el comando respectivo a cada jBtn para ejecutar las respectivas
     * acciones
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // en este atributo se guardara el comando que entra
        String comando = e.getActionCommand();

        // configuracion del boton nuevo calculo del panel botones de la ventana
        if (comando.equals("Nuevo Calculo")) {
            vtn.nuevoCalculoInterfaz();
            auxPersonaGuardada = false;
            // configuracion del boton calcular imc del panel botones de la ventana
        } else if (comando.equals("Calcular IMC")) {
            // manejo de excepcion si las casillas no se llenan
            if ((vtn.getpData().getTxtAltura().getText().length() == 0) || (vtn.getpData().getTxtPeso().getText().length() == 0)) {
                Ventana.mostrarJOptionPane(0);
            } else {
                try {
                    // atributo que guardara el resultado de la operacion
                    double IMC = 0;
                    // se guarda el retorno de la funcion calcularimc en la variable imc
                    IMC = calcularIMC(Double.parseDouble(vtn.getpData().getTxtPeso().getText()), Double.parseDouble(vtn.getpData().getTxtAltura().getText())); //IMC toma el valor de la funcion calcularIMC
                    // muestra el resultado en el panel resultado
                    vtn.getpRes().getTxtResultado().setText(String.valueOf(IMC));
                    // control de ventanas emergentes segun resultado de imc
                    if (IMC < 18.5) {
                        vtn.mostrarJOptionPane(3);
                    } else if (IMC >= 18.5 && IMC < 24.9) {
                        vtn.mostrarJOptionPane(4);
                    } else if (IMC >= 24.9 && IMC < 29.9) {
                        vtn.mostrarJOptionPane(5);
                    } else if (IMC >= 29.9) {
                        vtn.mostrarJOptionPane(6);
                    }
                    // ejecucion del metodo para bloquear y desbloquear casillas necesarias
                    vtn.calcularImcInterfaz();
                } catch (NumberFormatException nfe) {
                    Ventana.mostrarJOptionPane(8);
                }
            }
            // configuracion del boton guardar imc del panel botones de la ventana
        } else if (comando.equals("Guardar IMC")) {
            // control de excepcion si ya se guardo la persona anteriormente
            if (auxPersonaGuardada == false) {
                // ejecucion de metodo para solicitar datos de persona
                vtn.solicitarDatos(this);
                // ventana emergente correspondiente a Guardado Exitoso de persona
                Ventana.mostrarJOptionPane(2);
                auxPersonaGuardada = true;
            } else if (auxPersonaGuardada == true) { // si la persona ya fue guardad anteriormente no deja guardar
                Ventana.mostrarJOptionPane(7); // ventana emergente correspondiente a Persona Duplicada
            }
        } else if (comando.equals("Salir")) {
            vtn.mostrarListaPersonas(listaPersonas);
            System.exit(0);
        }
    }

    /**
     * Metodo para calcular el imc
     *
     * @param peso
     * @param estatura
     * @return
     */
    public double calcularIMC(double peso, double estatura) {
        double IMC = 0;
        estatura = estatura / 100;
        IMC = peso / Math.pow(estatura, 2);
        IMC = Math.round(IMC * 10) / 10.0;
        return IMC;
    }

    /**
     * Metodo para agregar persona al arraylist
     *
     * @param nombre
     * @param apellido
     * @param cedula
     * @param imc
     */
    public void agregarPersona(String nombre, String apellido, String cedula, String imc) {
        nea = new Persona(nombre, apellido, cedula, imc);
        listaPersonas.add(nea);
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
     * Metodo getter para obtener la Nea
     *
     * @return
     */
    public Persona getNea() {
        return nea;
    }

    /**
     * Metodo getter para editar la Nea
     *
     * @param nea
     */
    public void setNea(Persona nea) {
        this.nea = nea;
    }

    /**
     * Metodo getter para obtener el arraylist
     *
     * @return
     */
    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

}
