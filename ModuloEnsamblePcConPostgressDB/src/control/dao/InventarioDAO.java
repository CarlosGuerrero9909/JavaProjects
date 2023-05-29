package control.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import control.conexion.ConnectDB;
import models.Inventario;

public class InventarioDAO {
    private Connection con;
	private Statement st; //Para realizar consultas y enviar de la BD
	private ResultSet rs; //Para traer de la BD a partir de una consulta3
    private ArrayList<Inventario> listaInventario;

    public void InventarioDAO(){
        con = null;
        st = null;
        rs = null;
    }

    //Insertar un registro en la tabla Inventario
    public void insertarInventario(Inventario inventario){
        String consulta = "INSERT INTO inventario VALUES (" +
        inventario.getNoInventario() + ", " +
        inventario.getIdrefefk() + ", '" +
        inventario.getCodempleadofk() + "', " +
        inventario.getNfacturafk() + ", '" +
        inventario.getIdeventofk() + "', '" +
        inventario.getFechaevento() + "', " +
        inventario.getValor() + ")";
        try {
            con = ConnectDB.getConnection();
            st = con.createStatement();
            st.executeUpdate(consulta); 
            st.close();
            ConnectDB.dissconect();
        } catch (Exception ex) {
            System.out.println("No se pudo realizar la insercion");
            ex.printStackTrace();
        }
    }

    //Obtener ultimo inventario
    public int obtenerUltimoInventario(){
        int ultimoInventario = 0;
        String consulta = "select max(noinventario) noinventario from inventario;";
        try {
            con = ConnectDB.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(consulta); // las consultas van con Query
            while (rs.next()) {
                ultimoInventario = rs.getInt("noinventario");
            }
            st.close();
            ConnectDB.dissconect();
        } catch (Exception ex) {
            System.out.println("No se pudo realizar la consulta");
            ex.printStackTrace();
        }
        return ultimoInventario;
    }
    
}
