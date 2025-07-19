package mx.edu.utez.demo3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.edu.utez.demo3.config.DBConnection;
import mx.edu.utez.demo3.model.Alumno;
import mx.edu.utez.demo3.model.Carrera;

public class CarreraImplDao implements ICarreraDao {

    @Override
    public List<Carrera> findAll() throws SQLException {
        String query = "SELECT * FROM ADMIN.CARRERA";
        List<Carrera> carreras = new ArrayList<>();
        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Carrera carrera = new Carrera();
                carrera.setId(rs.getInt("ID"));
                carrera.setNombre(rs.getString("NOMBRE"));
                carrera.setDescripcion(rs.getString("DESCRIPCION"));
                carrera.setAlumnos(getAlumnosByCarrera(carrera.getId()));
                carreras.add(carrera);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return carreras;
    }

    @Override
    public Carrera findById(int id) throws SQLException {
        String query = "SELECT * FROM ADMIN.CARRERA WHERE ID=?";
        Carrera carrera = new Carrera();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                carrera.setId(rs.getInt("ID"));
                carrera.setNombre(rs.getString("NOMBRE"));
                carrera.setDescripcion(rs.getString("DESCRIPCION"));
                carrera.setAlumnos(getAlumnosByCarrera(carrera.getId()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return carrera;
    }

    @Override
    public void create(Carrera carrera) throws SQLException {
        String query = "INSERT INTO ADMIN.CARRERA (NOMBRE, DESCRIPCION) VALUES (?, ?)";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, carrera.getNombre());
            ps.setString(2, carrera.getDescripcion());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Creado con exito");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Carrera carrera) throws SQLException {
        String query = "UPDATE ADMIN.CARRERA SET NOMBRE=?, DESCRIPCION=? WHERE ID=?";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, carrera.getNombre());
            ps.setString(2, carrera.getDescripcion());
            ps.setInt(3, carrera.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM ADMIN.CARRERA WHERE ID=?";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Alumno> getAlumnosByCarrera(int id) {
        String query = "SELECT a.* FROM ADMIN.ALUMNO a " +
                "JOIN ADMIN.CARRERA c ON a.ID_CARRERA = c.ID WHERE c.ID = ?";
        List<Alumno> alumnos = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno alumno = new Alumno();
                alumno.setId(rs.getInt("ID_ALUMNO"));
                alumno.setNombre(rs.getString("NOMBRE"));
                alumno.setApellidos(rs.getString("APELLIDOS"));
                alumno.setCorreo(rs.getString("CORREO"));
                alumno.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
                alumno.setIdCarrera(rs.getInt("ID_CARRERA"));
                alumnos.add(alumno);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: ");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return alumnos;
    }

    public static void main(String[] args) {
        CarreraImplDao dao = new CarreraImplDao();
        try {
            List<Carrera> carreras = dao.findAll();
            System.out.println("Cantidad de carreras: " + carreras.size());
            for (Carrera c : carreras) {
                System.out.println(c.getNombre());
                System.out.println(c.getDescripcion());

                for (Alumno alumno : c.getAlumnos()) {
                    System.out.println(" - " + alumno.getNombre());
                }
                System.out.println("----------------");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
