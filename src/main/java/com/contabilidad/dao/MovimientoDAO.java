package com.contabilidad.dao;

import com.contabilidad.models.Asiento;
import com.contabilidad.models.Movimiento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovimientoDAO {

    private Conexion conexion = new Conexion();
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public MovimientoDAO() {
        conexion.conectar();
    }

    //Obtener lista de movimientos en base al codigo del asiento contable
    public List<Movimiento> getMovimientoByAsiento(int idAsiento) {
        List<Movimiento> movimientos = new ArrayList<>();
        String sql = String.format("select * from getMovimientos('%1$d');", idAsiento);
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                movimientos.add(new Movimiento(resultSet.getInt("idMovimiento"), resultSet.getString("detalle"),
                        resultSet.getDouble("debe"), resultSet.getDouble("haber"), resultSet.getInt("idAsient"),
                        resultSet.getInt("idSubcuenta")));
            }
            return movimientos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Movimiento> getAllMovimientos() {
        List<Movimiento> movimientos = new ArrayList<>();
        String sql = String.format("select * from movimiento;");
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                movimientos.add(new Movimiento(resultSet.getInt("idMovimiento"), resultSet.getString("detalle"),
                        resultSet.getDouble("debe"), resultSet.getDouble("haber"), resultSet.getInt("idasiento"),
                        resultSet.getInt("idSubcuenta")));
            }
            return movimientos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public int setMovimientoDefault() {
        String queryOne = "select idAsiento from public.asiento order by idAsiento desc limit 1;";
        Asiento asientoRef = new Asiento();
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryOne);
            //Llena la lista de los datos
            while (resultSet.next()) {
                asientoRef.setIdAsiento(resultSet.getInt("idAsiento"));
            }
            return asientoRef.getIdAsiento();
            //registrarMovimiento(asientoRef.getIdAsiento());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return -1;
        }
    }

    //Actualiza movimientos cuado se edita un asiento contable.
    public void updateMovimientos(Movimiento movimiento, int idAsiento) {
        String sql;
        if (movimiento.getIdMovimiento() == 0) {
            sql = String.format("select addmovimiento('%1$d','%2$d','%3$s','%4$s','%5$s')", movimiento.getIdSubcuenta(),
                    idAsiento, Double.toString(movimiento.getDebe()), Double.toString(movimiento.getHaber()), movimiento.getTipoMovimiento());
        } else {
            sql = String.format("UPDATE public.movimiento SET idsubcuenta= '%1$d', "
                    + "tipo= '%2$s', debe= %3$s , haber= %4$s, detalle= '%5$s' "
                    + "WHERE idmovimiento = '%6$d' and idasiento = '%7$d'", movimiento.getIdSubcuenta(),
                    "Factura", Double.toString(movimiento.getDebe()), Double.toString(movimiento.getHaber()),
                    movimiento.getTipoMovimiento(), movimiento.getIdMovimiento(), idAsiento);
        }
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
        } catch (Exception e) {
            System.out.println("Error Previsto: " + e.getMessage());
        }
    }
}
