package vista;

import java.awt.*;    
import javax.swing.*;

import control.logica.Controlador;

public class Ventana extends JFrame{
    private Controlador ctrl;
    private RegistroEmp pnlReg;
    private ConsultaClie pnlCon;
    private Ensamble pnlEnsamble;
    private Terminar pnlTerminar;

    public Ventana(Controlador ctrl){
        this.ctrl = ctrl;
        
        pnlReg = new RegistroEmp(this);
        pnlCon = new ConsultaClie(this);
        pnlEnsamble = new Ensamble(this);
        pnlTerminar = new Terminar(this);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(pnlReg,BorderLayout.CENTER);
        
        this.setTitle("Modulo");
        this.setBounds(0,0,600,600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setIconImage(new ImageIcon(getClass().getResource("/imgs/icono.jpg")).getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    public Controlador getCtrl() {
        return ctrl;
    }

    public RegistroEmp getPnlReg() {
        return pnlReg;
    }

    public ConsultaClie getPnlCon() {
        return pnlCon;
    }

    public Ensamble getPnlEnsamble() {
        return pnlEnsamble;
    }

    public Terminar getPnlTerminar() {
        return pnlTerminar;
    }
    public void renderPnlReg(){
        this.getContentPane().setVisible(false);
        this.setContentPane(pnlReg);
        this.getContentPane().setVisible(true);
    }
    public void renderConsulta(){
        this.getContentPane().setVisible(false);
        this.setContentPane(pnlCon);
        this.getContentPane().setVisible(true);
    }

    public void renderEnsamble(){
        this.getContentPane().setVisible(false);
        this.setContentPane(pnlEnsamble);
        this.getContentPane().setVisible(true);
    }

    public void renderTerminar(){
        this.getContentPane().setVisible(false);
        this.setContentPane(pnlTerminar);
        this.getContentPane().setVisible(true);
    }

    public void mostrarJoptionPane(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    
}
