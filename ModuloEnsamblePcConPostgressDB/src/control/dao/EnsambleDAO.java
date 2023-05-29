package control.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import control.conexion.ConnectDB;
import models.Ensamble;

public class EnsambleDAO {
    private Connection con;
    private Statement st; //Para realizar consultas y enviar de la BD
    private ResultSet rs; //Para traer de la BD a partir de una consulta
    private ArrayList<Ensamble> listaEnsamble;

    public void EnsambleDAO(){
        con = null;
        st = null;
        rs = null;
    }

    //Metodo para traer todos los registros de la tabla Ensamble
    public ArrayList<Ensamble> getEnsambleNoFacturado(){
        listaEnsamble = new ArrayList<Ensamble>();
        String consulta = "SELECT * FROM ensamble " +
        "WHERE facturado = false";
        try {
            con = ConnectDB.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(consulta); // las consultas van con Query
            while (rs.next()) {
                Ensamble ensamble = new Ensamble();
                ensamble.setConsecc(rs.getInt("consecc"));
                ensamble.setCodEmpleadofk(rs.getString("codEmpleadofk"));
                ensamble.setFechaEnsamble(rs.getString("fechaEnsamble"));
                ensamble.setFacturado(rs.getBoolean("facturado"));
                listaEnsamble.add(ensamble);
            }
            st.close();
            ConnectDB.dissconect();
        } catch (Exception ex) {
            System.out.println("No se pudo realizar la consulta");
            ex.printStackTrace();
        }
        return listaEnsamble;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public ArrayList<Ensamble> getListaEnsamble() {
        return listaEnsamble;
    }

    public void setListaEnsamble(ArrayList<Ensamble> listaEnsamble) {
        this.listaEnsamble = listaEnsamble;
    }
    //actualizar estado de ensamble
    public void actualizarEstadoEnsamble(int consecc){
        String consulta = "UPDATE ensamble SET facturado = true WHERE consecc = "+consecc;
        try {
            con = ConnectDB.getConnection();
            st = con.createStatement();
            st.executeUpdate(consulta); // las consultas van con Query
            st.close();
            ConnectDB.dissconect();
        } catch (Exception ex) {
            System.out.println("No se pudo realizar la consulta");
            ex.printStackTrace();
        }
    }
}
