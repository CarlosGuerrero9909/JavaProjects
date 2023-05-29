package control.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import control.conexion.ConnectDB;
import models.ItemEnsamble;

public class ItemEnsambleDao {
    private Connection con;
	private Statement st; //Para realizar consultas y enviar de la BD
	private ResultSet rs; //Para traer de la BD a partir de una consulta
    private ArrayList<ItemEnsamble> listaItemEnsamble;

    public void ItemEnsambleDao(){
        con = null;
        st = null;
        rs = null;
    }

    //Metodo para traer todos los registros de la tabla ItemEnsamble
    public ArrayList<ItemEnsamble> getItemEnsamble(int idEnsamble){
        listaItemEnsamble = new ArrayList<ItemEnsamble>();
        String consulta = "select de.itemensamble, i.valor, re.obsref, tc.desctipocarac, "+
        " rc.valorrefcara, te.destipoelemen, i.noinventario, rc.idrefefk " +
        " from detalleensamble de, inventario i, " +
        " referenciaelemento re, referenciacaracteristica rc, " +
        " tipocaracteristica tc, tipoelemento te " +
        " where de.conseccfk = "+idEnsamble+" and " +
        " de.noinventariofk = i.noinventario and " +
        " de.idrefefk = i.idrefefk and " +
        " i.idrefefk = re.idrefe and " +
        " re.idtipoelemenfk = te.idtipoelemen and " +
        " rc.idrefefk = re.idrefe and " +
        " rc.idtipocaracfk = tc.idtipocarac;";

        /*select de.itemensamble, i.valor, re.obsref, tc.desctipocarac, 
rc. valorrefcara, te.destipoelemen
from detalleensamble de, inventario i,
referenciaelemento re, referenciacaracteristica rc, 
tipocaracteristica tc, tipoelemento te
where de.conseccfk = 1 and --ensamble a traer
de.noinventariofk = i.noinventario and
de.idrefefk = i.idrefefk and
i.idrefefk = re.idrefe and
re.idtipoelemenfk = te.idtipoelemen and
rc.idrefefk = re.idrefe and
rc.idtipocaracfk = tc.idtipocarac; */

        try {
            con = ConnectDB.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(consulta); // las consultas van con Query
            while (rs.next()) {
                ItemEnsamble itemEnsamble = new ItemEnsamble();
                itemEnsamble.setIdItemEnsamble(rs.getInt("itemensamble"));
                itemEnsamble.setValor(rs.getDouble("valor"));
                itemEnsamble.setObsRefencia(rs.getString("obsref"));
                itemEnsamble.setDescTipoCarac(rs.getString("desctipocarac"));
                itemEnsamble.setValorRefCarac(rs.getString("valorrefcara"));
                itemEnsamble.setDescTipoElemen(rs.getString("destipoelemen"));
                itemEnsamble.setNoinventario(rs.getInt("noinventario"));
                itemEnsamble.setIdrefefk(rs.getInt("idrefefk"));
                listaItemEnsamble.add(itemEnsamble);
            }
            st.close();
            ConnectDB.dissconect();
        } catch (Exception ex) {
            System.out.println("No se pudo realizar la consulta");
            ex.printStackTrace();
        }
        return listaItemEnsamble;
    }
}
