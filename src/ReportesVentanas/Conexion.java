/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportesVentanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author janus
 */
public class Conexion {
      String url = "jdbc:mysql://localhost:3306/Ferreteria";
    String user= "root";
    String pass= "luis1234";

    public Conexion() {
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
    
     public Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
