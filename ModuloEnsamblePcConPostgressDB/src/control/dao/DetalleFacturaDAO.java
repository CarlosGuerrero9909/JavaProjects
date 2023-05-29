package control.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import control.conexion.ConnectDB;
import models.DetalleFactura;

public class DetalleFacturaDAO {
    private Connection con;
	private Statement st; //Para realizar consultas y enviar de la BD
	private ResultSet rs; //Para traer de la BD a partir de una consulta
    
    public void DetalleFacturaDAO(){
        con = null;
        st = null;
        rs = null;
    }

    public ArrayList<DetalleFactura> obtenerDetalleFactura(){
        ArrayList<DetalleFactura> detalleFactura = new ArrayList<DetalleFactura>();
        String consulta = "select * from detallefactura;";
        try {
            con = ConnectDB.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(consulta); // las consultas van con Query
            while (rs.next()) {
                DetalleFactura detalle = new DetalleFactura();
                detalle.setItem(rs.getInt("item"));
                detalle.setnFacturaFk(rs.getInt("nFacturaFk"));
                detalle.setIdTipoDetalleFk(rs.getString("idTipoDetalleFk"));
                detalle.setConseccfk(rs.getInt("conseccfk"));
                detalle.setIdrefefk(rs.getInt("idrefefk"));
                detalle.setNoinventariofk(rs.getInt("noinventariofk"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecio(rs.getInt("precio"));
                detalleFactura.add(detalle);
            }
            st.close();
            ConnectDB.dissconect();
        } catch (Exception ex) {
            System.out.println("No se pudo realizar la consulta");
            ex.printStackTrace();
        }
        return detalleFactura;
    }

    //insertar detalle factura
    public void insertarDetalleFactura(DetalleFactura detalle){
        String consulta = "insert into detallefactura values ("+
        detalle.getItem()+","+detalle.getnFacturaFk()+",'"+
        detalle.getIdTipoDetalleFk()+"',"+detalle.getConseccfk()+","
        +detalle.getIdrefefk()+","+detalle.getNoinventariofk()+","+
        detalle.getCantidad()+","+detalle.getPrecio()+");";
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

    //obtener ultimo item
    public int obtenerUltimoItem(){
        int ultimoItem = 0;
        String consulta = "select max(item) as ultimoItem from detallefactura;";
        try {
            con = ConnectDB.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(consulta); // las consultas van con Query
            while (rs.next()) {
                ultimoItem = rs.getInt("ultimoItem");
            }
            st.close();
            ConnectDB.dissconect();
        } catch (Exception ex) {
            System.out.println("No se pudo realizar la consulta");
            ex.printStackTrace();
        }
        return ultimoItem;
    }
}
