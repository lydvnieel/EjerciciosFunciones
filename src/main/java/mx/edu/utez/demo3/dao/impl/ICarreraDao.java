package mx.edu.utez.demo3.dao.impl;

import java.sql.SQLException;
import java.util.List;

import mx.edu.utez.demo3.model.Carrera;

public interface ICarreraDao {
    List<Carrera> findAll() throws SQLException;
    Carrera findById(int id) throws SQLException;
    void create(Carrera carrera) throws SQLException;
    void update(Carrera carrera) throws SQLException;
    void delete(int id) throws SQLException;

}
