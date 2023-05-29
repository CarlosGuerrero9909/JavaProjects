package control.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import control.conexion.ConnectDB;
import models.TipoDetalle;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.conexion.ConnectDB;
import models.EmpleadoVO;

public class TipoDetalleDAO {
    private Connection con;
	private Statement st; //Para realizar consultas y enviar de la BD
	private ResultSet rs; //Para traer de la BD a partir de una consulta
    private ArrayList<TipoDetalle> listaTipoDetalle;

    public void TipoDetalleDAO(){
        con = null;
        st = null;
        rs = null;
    }

    //Metodo para traer todos los registros de la tabla TipoDetalle
    public ArrayList<TipoDetalle> getTipoDetalle(){
        listaTipoDetalle = new ArrayList<TipoDetalle>();
        String consulta = "SELECT * FROM tipodetalle";
        try {
			con = ConnectDB.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(consulta); // las consultas van con Query
			while (rs.next()) {
				TipoDetalle tipoDetalle = new TipoDetalle();
                tipoDetalle.setIdTipoDetalle(rs.getInt("idtipodetalle"));
                tipoDetalle.setDescTipoDetalle(rs.getString("desctipodetalle"));
                listaTipoDetalle.add(tipoDetalle);
			}
			st.close();
			ConnectDB.dissconect();
		} catch (SQLException ex) {
			System.out.println("No se pudo realizar la consulta");
			ex.printStackTrace();
		}
        return listaTipoDetalle;
    }

}
