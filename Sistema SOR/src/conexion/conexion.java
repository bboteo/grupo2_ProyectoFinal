/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Toshiba
 */
public class Conexion {
    private String driver = "com.mysql.jdbc.Driver";
    private String host = "grupo2-2022.mysql.database.azure.com";
    private String user = "grupo2@grupo2-2022.mysql.database.azure.com";
    private String pass = "Intecap2022";
    private String db = "dbogrupo2";
    private String cadena;
    
    
    public Connection connection;
    Statement statement;

    public Conexion() {
    }
    
    public void conectar() {
        this.cadena = "jdbc:mysql://" + this.host + "/" + this.db;
        try {
            Class.forName(this.driver).newInstance();
            this.connection = DriverManager.getConnection(this.cadena, this.user, this.pass);
        } catch (Exception e) {
                System.err.println("Error[MCon]: " + e.getMessage());
        }
    }
    
    public void desconectar(){
        try {
            this.connection.close();
        } catch (Exception e) {
            System.err.println("Error[MDes]: " + e.getMessage());
        }
    }
}
