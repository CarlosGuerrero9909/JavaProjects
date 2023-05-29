package control.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import control.conexion.ConnectDB;
import models.ClienteVO;

public class ClienteDAO {
    private Connection con;
	private Statement st; //Para realizar consultas y enviar de la BD
	private ResultSet rs; //Para traer de la BD a partir de una consulta

    public void ClienteDAO(){
        con = null;
        st = null;
        rs = null;
    }

    public ArrayList<ClienteVO> obtenerClientes(){
		ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
		String consulta = "select p.idtipopersonafk, p.idpersona cod_cliente, p.nompersona||' '||p.apellpersona cliente, p.idenpersona cedula\n"+
			"from persona p, tipoidentificacion ti, tipopersona tp\n"+
			"where tp.idtipopersona = p.idtipopersonafk and\n"+ 
				"ti.tipoidenti = p.tipoidentifk;";
		try {
			con = ConnectDB.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(consulta); // las consultas van con Query
			while (rs.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setCodCliente(rs.getString("cod_cliente"));
				cliente.setNombreApell(rs.getString("cliente"));
				cliente.setIdTipoPersonaFk(rs.getString("idtipopersonafk"));
				cliente.setCedula(rs.getString("cedula"));
				clientes.add(cliente);
			}
			st.close();
			ConnectDB.dissconect();
		} catch (SQLException ex) {
			System.out.println("No se pudo realizar la consulta");
			ex.printStackTrace();
		}
		return clientes;
	}
    
}
