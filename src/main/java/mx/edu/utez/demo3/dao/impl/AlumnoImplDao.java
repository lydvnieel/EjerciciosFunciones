package mx.edu.utez.demo3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.edu.utez.demo3.config.DBConnection;
import mx.edu.utez.demo3.dao.IAlumnoDao;
import mx.edu.utez.demo3.model.Alumno;

public class AlumnoImplDao implements IAlumnoDao{

    @Override
    public void create(Alumno alumno) throws SQLException {
        String sql = "INSERT INTO ADMIN.ALUMNO (Nombre, Apellidos, Correo, Fecha_Nacimiento, Id_Carrera) VALUES (?, ?, ?, ?, ?)";
    
    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {
        ps.setString(1, alumno.getNombre());
        ps.setString(2, alumno.getApellidos());
        ps.setString(3, alumno.getCorreo());
        ps.setDate(4, java.sql.Date.valueOf(alumno.getFechaNacimiento()));
        ps.setInt(5, alumno.getIdCarrera());

        int rowsInserted = ps.executeUpdate();

        if (rowsInserted == 0) {
            throw new SQLException("No se pudo insertar ningun alumno");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
        
    }

    @Override
    public void delete(int id) throws SQLException {
      
        
    }

    @Override
    public List<Alumno> findAll() throws SQLException {
        String sql="SELECT * FROM ADMIN.ALUMNO";
        List<Alumno> alumnos = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno alumno = new Alumno(); 
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setApellidos(rs.getString("Apellidos"));
                alumno.setCorreo(rs.getString("Correo"));
                alumno.setFechaNacimiento(rs.getDate("Fecha_Nacimiento").toLocalDate());
                alumno.setIdCarrera(rs.getInt("Id_Carrera"));
                alumno.setId(rs.getInt("Id_Alumno"));
                alumnos.add(alumno);

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return alumnos;
    }

    @Override
    public Alumno findAlumnoById(int id) throws SQLException {
        
        return null;
    }

    @Override
    public void update(Alumno alumno) throws SQLException {
    
        
    }
     
    public static void main(String[] args) {
        AlumnoImplDao dao = new AlumnoImplDao();

        try {
           List<Alumno> alumnos = dao.findAll();
           for(Alumno a : alumnos){
            System.out.println(a.getNombre());
           }
            
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
       
    }
   
}
