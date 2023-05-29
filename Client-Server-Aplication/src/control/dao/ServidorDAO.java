/* 13/03/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC como segundo parcial en donde se implementa interfaz grafica, base de 
datos, sql, sockets e hilos para realizar un speech de frases ingresadas por
distintos clientes conectados a un servidor el cual es el encargado de leer las 
frases enviadas 
*/
package control.dao;

import control.conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import modelo.ClienteVO;
import vista.VentanaCliente;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class ServidorDAO {

    // conexion
    private Connection con;
    // donde se guardara las instrucciones sql
    private Statement st;
    // donde se van a guardar las respuestas
    private ResultSet rs;

    /**
     * Contructor que deja todas las variables como null
     */
    public ServidorDAO() {
        con = null;
        st = null;
        rs = null;
    }

    /**
     * Metodo que se encarga de pedir todos los datos de clientes de la base de
     * datos y retornarlos en un arreglo de clientes
     *
     * @return
     */
    public ClienteVO recuperarClienteDeBaseDeDatos(String nombre, String contraseña) {
        // instanciacion del cliente en el que se aljaran todos los datos del cliente que cumpla con la busqueda de la base de datos
        ClienteVO clienteVo = null;

        // Instruccion en sql que pide todos los registros de la base de datos 
        String consulta = "SELECT * FROM Clientes where nombre='" + nombre + "' and contraseña='" + contraseña + "'";
        try {
            // pedimos una conexion
            con = Conexion.getConexion();
            // crea una consulta
            st = con.createStatement();
            // guarda lo que retorna la consultta
            rs = st.executeQuery(consulta);

            // mientras haya mas registros en la BD sigue ejecutando el bloque de codifo
            while (rs.next()) {
                // se instancia un clienteVo nuevo
                clienteVo = new ClienteVO();

                // pedimos datos del registro y se lo asignamos a cada variable de nuestro cliente instanciado anteriomente
                clienteVo.setNombre(rs.getString("nombre"));
                clienteVo.setContraseña(rs.getString("contraseña"));
            }

            // cierra el stamenten porque ya se realizo la consulta
            st.close();
            // desconecta la DB
            Conexion.desconectar();
        } catch (SQLException ex) {
            // ventana emergente en caso de errores que comunica que "No se pudo realizar la consulta de la Base de Datos."
            VentanaCliente.mostrarJOptionPane(4);
            // en caso en que  haya un error al cargar la base de datos cerrara el programa
            System.exit(0);
        }
        return clienteVo;
    }
}
