package com.contabilidad.dao;

import com.contabilidad.models.Asiento;
import com.contabilidad.models.Diario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DiarioDAO {

    private Conexion conexion = new Conexion();
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public List<Diario> getDiariosContables() {
        conexion.conectar();
        List<Diario> diarios = new ArrayList<>();
        String sql = String.format("select * from getDiariosContables();");
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                diarios.add(new Diario(resultSet.getInt("iddiario"), resultSet.getString("nombre"),
                        resultSet.getDate("fechaApertura"), resultSet.getDate("fechaCierre"), resultSet.getString("descripcion")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return diarios;
    }

    public Diario getDiarioById(int id) {
        conexion.conectar();
        Diario diario = new Diario();
        String sql = String.format("SELECT * FROM public.diariocontable where iddiario = '%1$d'", id);
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                diario = new Diario(resultSet.getInt("iddiario"), resultSet.getString("nombre"),
                        resultSet.getDate("fechaApertura"), resultSet.getDate("fechaCierre"), resultSet.getString("descripcion"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return diario;
    }

    public Diario findDiarioByNombre(String nombre) {
        conexion.conectar();
        Diario diario = new Diario();
        String sql = String.format("SELECT * FROM public.diariocontable where nombre = '%1$s'", nombre);
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                diario = new Diario(resultSet.getInt("iddiario"), resultSet.getString("nombre"),
                        resultSet.getDate("fechaApertura"), resultSet.getDate("fechaCierre"), resultSet.getString("descripcion"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return diario;
    }

    public boolean addNewDiario(Diario diario) {
        conexion.conectar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String sql = String.format("select addNewDiario('%1$s','%2$s','%3$s','%4$s')", diario.getNombre(),
                dateFormat.format(diario.getFechaApertura()), dateFormat.format(diario.getFechaCierre()), diario.getDescripcion());
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateDiario(Diario diario) {
        conexion.conectar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String sql = String.format("select updateDiarioContable('%5$d','%1$s','%2$s','%3$s','%4$s')", diario.getNombre(),
                dateFormat.format(diario.getFechaApertura()), dateFormat.format(diario.getFechaCierre()), diario.getDescripcion(), diario.getIdDiario());
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
