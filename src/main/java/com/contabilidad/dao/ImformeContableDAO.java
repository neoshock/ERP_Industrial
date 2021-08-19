package com.contabilidad.dao;

import com.contabilidad.models.Asiento;
import com.contabilidad.models.BalanceGeneral;
import com.contabilidad.models.Libro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImformeContableDAO {

    private Conexion conexion = new Conexion();
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public List<Libro> getImformeLibroMayor() {
        String sql = String.format("select * from generateLibroMayor();");
        conexion.conectar();
        List<Libro> libros = new ArrayList<>();
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                libros.add(new Libro(resultSet.getString("Codigo"), resultSet.getString("SubCuenta"), resultSet.getString("Fecha"),
                        resultSet.getString("Asiento"), resultSet.getString("Descripcion"), resultSet.getDouble("Debe"), resultSet.getDouble("Haber")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return libros;
    }

    public List<Libro> filtrateLibroByDiario(int idiario) {
        String sql = String.format("select * from fillLibroMayor(%1$d);",idiario);
        conexion.conectar();
        List<Libro> libros = new ArrayList<>();
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                libros.add(new Libro(resultSet.getString("Codigo"), resultSet.getString("SubCuenta"), resultSet.getString("Fecha"),
                        resultSet.getString("Asiento"), resultSet.getString("Descripcion"), resultSet.getDouble("Debe"), resultSet.getDouble("Haber")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return libros;
    }
}
