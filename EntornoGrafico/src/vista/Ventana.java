package vista;

import control.Controlador;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Persona;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Diaz
 */
public class Ventana extends JFrame {

    // se crea comunicacion con los paneles y con el controlador
    private PanelDatos pData;
    private PanelBotones pBtn;
    private PanelResultado pRes;
    private Controlador control;

    /**
     * Constructor de ventana
     */
    public Ventana() {
        // se crea canal de comunicacion con el controlador
        this.control = new Controlador(this);

        // se crea canal de comunicacion con los paneleslador
        pData = new PanelDatos(this);
        pBtn = new PanelBotones(this);
        pRes = new PanelResultado(this);

        // se configura el layout de la ventan y se agregan los paneles
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pBtn, BorderLayout.NORTH);
        getContentPane().add(pData, BorderLayout.CENTER);
        getContentPane().add(pRes, BorderLayout.SOUTH);

        // se configura la ventana
        setIconImage(new ImageIcon(getClass().getResource("/img/hospital.png")).getImage());
        setResizable(false);
        setTitle("Indice de masa corporal");
        setSize(430, 370);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // se bloquean objetos que deben estr bloqueados antes de dejar visible la ventana
        bloquearObjetos();

        setVisible(true);

    }

    /**
     * Metodo que bloquea objetos
     */
    public void bloquearObjetos() {
        pBtn.getBtnNuevoC().setEnabled(true);
        pBtn.getBtnGuardar().setEnabled(false);
        pBtn.getBtnCalcular().setEnabled(false);
        pData.getTxtAltura().setEditable(false);
        pData.getTxtPeso().setEditable(false);
        pRes.getTxtResultado().setEditable(false);

    }

    /**
     * Metodo para configurar objetos de la ventana para un nuevo calculo
     */
    public void nuevoCalculoInterfaz() {
        pBtn.getBtnNuevoC().setEnabled(false);
        pBtn.getBtnCalcular().setEnabled(true);
        pBtn.getBtnGuardar().setEnabled(false);
        pData.getTxtAltura().setEditable(true);
        pData.getTxtPeso().setEditable(true);
        pData.getTxtAltura().setText("");
        pData.getTxtPeso().setText("");
        pRes.getTxtResultado().setText("");
    }

    /**
     * Metodo para configurar objetos de la ventana luego de calcular un nuevo
     * imc
     */
    public void calcularImcInterfaz() {
        bloquearObjetos();
        pBtn.getBtnGuardar().setEnabled(true);
    }

    /**
     * Metodo para generacion de ventanas emergentes, cada ventana depende una
     * clave que indica que ventana debe de ejecutarse
     *
     * @param claveVentanaEmergente
     */
    public static void mostrarJOptionPane(int claveVentanaEmergente) {
        // muestra ventanas dependiendo de la ocasion
        switch (claveVentanaEmergente) {
            case 0:
                JOptionPane.showMessageDialog(null, "No se ingresaron todos los datos", "Datos Incompletos", 2);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Datos ingresados incorrectamente", "Datos Erroneos", 0);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Se guardaron correctamente los datos", "Guardado Exitoso", 1);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Usted se encuentra dentro del rango de PESO INSUFICIENTE", "Calculo Exitoso", 1);
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Usted se encuentra dentro del rango de PESO SALUDABLE", "Calculo Exitoso", 1);
                break;
            case 5:
                JOptionPane.showMessageDialog(null, "Usted se encuentra dentro del rango de SOBREPESO", "Calculo Exitoso", 1);
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Usted se encuentra dentro del rango de OBESIDAD", "Calculo Exitoso", 1);
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "Ya se han guardado estos datos", "Datos Duplicados", 0);
                break;
            case 8:
                JOptionPane.showMessageDialog(null, "Error al ingresar datos, vuelva a intentar", "Datos Erroneos", 0);
                break;
        }

    }

    /**
     * Metodo para ejecutar ventanas emergentes pidiendo datos de la persona
     * nueva y envia datos para agregar persona al arraylist
     *
     * @param control
     */
    public void solicitarDatos(Controlador control) {
        JOptionPane.showMessageDialog(null, "A continuacion ingrese informacion de la persona para guardarla.", "Informacion Persona", 3);
        String nombre = JOptionPane.showInputDialog(null, "Nombre: ", "Informacion Persona", JOptionPane.QUESTION_MESSAGE);
        String apellido = JOptionPane.showInputDialog(null, "Apellido: ", "Informacion Persona", JOptionPane.QUESTION_MESSAGE);
        String cedula = JOptionPane.showInputDialog(null, "Cedula: ", "Informacion Persona", JOptionPane.QUESTION_MESSAGE);
        String imc = pRes.getTxtResultado().getText();
        control.agregarPersona(nombre, apellido, cedula, imc);

    }

    /**
     * Metodo para imprimir personas del arraylist
     */
    public void mostrarListaPersonas(ArrayList<Persona> listaPersonas) {
        int contador = 0;
        for (Persona persona : listaPersonas) {
            contador = contador + 1;
            System.out.println("Datos persona " + contador + ": ");
            System.out.println("\tNombre: " + persona.getNombre());
            System.out.println("\tApellido: " + persona.getApellido());
            System.out.println("\tCedula: " + persona.getCedula());
            System.out.println("\tIMC: " + persona.getImc() + "\n");
        }
    }

    /**
     *
     * @return
     */
    public Controlador getControl() {
        return control;
    }

    /**
     *
     * @param control
     */
    public void setControl(Controlador control) {
        this.control = control;
    }

    /**
     *
     * @return
     */
    public PanelDatos getpData() {
        return pData;
    }

    /**
     *
     * @param pData
     */
    public void setpData(PanelDatos pData) {
        this.pData = pData;
    }

    /**
     *
     * @return
     */
    public PanelBotones getpBtn() {
        return pBtn;
    }

    /**
     *
     * @param pBtn
     */
    public void setpBtn(PanelBotones pBtn) {
        this.pBtn = pBtn;
    }

    /**
     *
     * @return
     */
    public PanelResultado getpRes() {
        return pRes;
    }

    /**
     *
     * @param pRes
     */
    public void setpRes(PanelResultado pRes) {
        this.pRes = pRes;
    }

}
