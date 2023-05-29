/* 13/03/2022 - Programa desarrollado para la clase de Programacion Avanzada en 
la UDFJDC como segundo parcial en donde se implementa interfaz grafica, base de 
datos, sql, sockets e hilos para realizar un speech de frases ingresadas por
distintos clientes conectados a un servidor el cual es el encargado de leer las 
frases enviadas 
*/
package control.conexion;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos Guerrero
 * @author Nicolas Di­az
 * @author Paola Cuellar
 */
public class Conexion {

    // creamos una conexion
    private static Connection cn = null;
    // definimos el driver (cliente de derby)
    private static Driver driver = new org.apache.derby.jdbc.ClientDriver();
    // forma en la que nos vamos a conectar
    private static String URLBD = "jdbc:derby://localhost:1527/CLIENTESIDIOMAS";
    // login de la base de datos
    private static String usuario = "clientesidiomas";
    private static String contrasena = "clientesidiomas";

    /**
     * Metodo encargado de registrar el driver y establecer la conexion con la
     * BD
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConexion() throws SQLException {
        DriverManager.registerDriver(driver);
        cn = DriverManager.getConnection(URLBD, usuario, contrasena);
        return cn;
    }

    /**
     * Metodo encargado de desconectar la conexion con la base de datos
     */
    public static void desconectar() {
        cn = null;
    }
}
