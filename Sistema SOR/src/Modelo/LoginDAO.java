/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Toshiba
 */
public class LoginDAO implements ConsultaLogin {

    @Override
    public ArrayList<UsuarioVO> login(String usr, String contra) {
        Conexion c = new Conexion();
        ArrayList<UsuarioVO> datos = new ArrayList<>();

        try {
            String query = "SELECT u.usr, u.contrasena, u.tipo_usuario "
                    + "FROM usuario u "
                    + "WHERE u.usr = '" + usr + "' " + " AND u.contrasena = '"
                    + contra + "';";
            ResultSet rs = c.consultaDatos(query);
            while (rs.next()) {
                UsuarioVO uvo = new UsuarioVO();
                uvo.setUsername(rs.getString(1));
                uvo.setContrasena(rs.getString(2));
                uvo.setTipo_usuario(rs.getString(3));
                datos.add(uvo);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error[MLOG]:" + e.getMessage());
        }

        return datos;
    }

}
