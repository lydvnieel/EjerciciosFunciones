package mx.edu.utez.demo3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mx.edu.utez.demo3.config.DBConnection;
import mx.edu.utez.demo3.dao.IUsuarioDao;

public class UsuarioDaoImpl implements IUsuarioDao {
    @Override
    public boolean login(String correo, String pass) throws SQLException {
        String sql="SELECT ID,CORREO,PASS FROM USUARIO WHERE CORREO=? AND PASS=?";
       try {
           Connection con = DBConnection.getConnection();//Establcer conexion
           PreparedStatement ps = con.prepareStatement(sql); //Prepara la consulta para evitar inyeccion sql
           ps.setString(1,correo);//Sustitucion de ?  por el valor de correo
           ps.setString(2,pass); //Sistitucion de ? por el valor de pass
           ResultSet resultSet = ps.executeQuery();//Se ejecuta la consulta
           if(resultSet.next()){
               return true;
           }else{
               return false;
           }

       } catch (Exception e) {
           throw new RuntimeException(e);
       }

    }

    public static void main(String[] args) {
        UsuarioDaoImpl dao= new UsuarioDaoImpl();
        try{
            System.out.println(dao.login("20243ds183","123"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
