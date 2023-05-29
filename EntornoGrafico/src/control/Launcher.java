package control;

import vista.Ventana;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Dí­az
 */
public class Launcher {

    /**
     * Metodo principal, encargado de lanzar el programa y la ventana principal
     *
     * @param args
     */
    public static void main(String[] args) {
        Ventana vtn = new Ventana();
        Controlador control = new Controlador(vtn);
    }

}
