package mx.edu.utez.demo3.dao;
import java.sql.SQLException;
import java.util.List;

import mx.edu.utez.demo3.model.Alumno;

public interface IAlumnoDao {

    List<Alumno> findAll() throws SQLException;
    Alumno findAlumnoById(int id) throws SQLException;
    void create(Alumno alumno) throws SQLException;
    void update(Alumno alumno) throws SQLException;
    void delete (int id) throws SQLException;
}

