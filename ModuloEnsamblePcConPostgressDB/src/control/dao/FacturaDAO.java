package control.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import control.conexion.ConnectDB;
import models.Factura;

public class FacturaDAO {
    private Connection con;
	private Statement st; //Para realizar consultas y enviar de la BD
	private ResultSet rs; //Para traer de la BD a partir de una consulta
    
    public void FacturaDAO(){
        con = null;
        st = null;
        rs = null;
    }

    public ArrayList<Factura> obtenerFacturas(){
        ArrayList<Factura> facturas = new ArrayList<Factura>();
        String consulta = "select f.nfactura, f.idformapagofk, f.idtipopersonafk, f.idpersonafk, f.idtipofacturafk, f.codempleadofk, f.fechafactura, f.valorfactura\n"+
            "from factura f;";
        try {
            con = ConnectDB.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(consulta); // las consultas van con Query
            while (rs.next()) {
                Factura factura = new Factura();
                factura.setnFactura(rs.getInt("nfactura"));
                factura.setIdFormaPagoFk(rs.getString("idformapagofk"));
                factura.setIdTipoPersonaFk(rs.getString("idtipopersonafk"));
                factura.setIdPersonaFk(rs.getString("idpersonafk"));
                factura.setIdTipoFacturaFk(rs.getString("idtipofacturafk"));
                factura.setCodEmpleadoFk(rs.getString("codempleadofk"));
                factura.setFechaFactura(rs.getDate("fechafactura"));
                factura.setValorFactura(rs.getDouble("valorfactura"));
                facturas.add(factura);
            }
            st.close();
            ConnectDB.dissconect();
        } catch (Exception ex) {
            System.out.println("No se pudo realizar la consulta");
            ex.printStackTrace();
        }
        return facturas;
    }

    //obtener ultima factura
    public int obtenerUltimaFactura(){
        int ultimaFactura = 0;
        String consulta = "select max(nfactura) nfactura from factura;";
        try {
            con = ConnectDB.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(consulta); // las consultas van con Query
            while (rs.next()) {
                ultimaFactura = rs.getInt("nfactura");
            }
            st.close();
            ConnectDB.dissconect();
        } catch (Exception ex) {
            System.out.println("No se pudo realizar la consulta");
            ex.printStackTrace();
        }
        return ultimaFactura;
    }

    // insertar factura
    public void insertarFactura(Factura factura){
        String consulta = "insert into factura values ("+factura.getnFactura()+
            ", '"+factura.getIdFormaPagoFk()+"', '"+factura.getIdTipoPersonaFk()+
            "', '"+factura.getIdPersonaFk()+"', '"+factura.getIdTipoFacturaFk()+
            "', '"+factura.getCodEmpleadoFk()+"', '"+factura.getFechaFactura()+
            "', "+factura.getValorFactura()+");";
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
