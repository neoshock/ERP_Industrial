package com.contabilidad.dao;

import com.contabilidad.models.Asiento;
import com.contabilidad.models.Movimiento;
import com.contabilidad.models.SubCuenta;
import com.contabilidad.dao.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AsientoDAO {
    
    private Conexion conexion = new Conexion();
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private List<Asiento> asientos = new ArrayList<>();

    //Funcion encargada de retornar toda la lista de los asientos contables de la
    //base de datos.
    public List<Asiento> getAsientosContables() {
        String sql = String.format("select * from getAsientosContables();");
        conexion.conectar();
        asientos = new ArrayList<>();
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                asientos.add(new Asiento(resultSet.getInt("idAsiento"), resultSet.getInt("idDiario"), resultSet.getString("documento"),
                        resultSet.getString("detalle"), resultSet.getString("estado"), resultSet.getDate("FechaCreacion"),
                        resultSet.getDate("FechaCierre"), resultSet.getString("numero"), resultSet.getString("total")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return asientos;
    }

    public int getCountAsientos() {
        String sql = String.format("select count(numero) from public.asiento");
        int numero = 0;
        conexion.conectar();
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                numero = resultSet.getInt("count");
            }
        } catch (Exception e) {
            numero = -1;
            return numero;
        }
        return numero;
    }

    //Obtener un asiento contable en base a su identificador.
    public Asiento getAsientoById(int id) {
        Asiento asientoAux = new Asiento();
        String sql = String.format("select * from getAsientoContableById('%1$d');", id);
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                asientoAux = new Asiento(resultSet.getInt("idasi"),resultSet.getInt("iddiario"), 
                        resultSet.getString("documento"),resultSet.getString("detalle"), resultSet.getString("estado"), 
                        resultSet.getDate("fechacreacion"), resultSet.getDate("fechacierre"), resultSet.getString("numero"), resultSet.getString("total"));
            }
            return asientoAux;
        } catch (Exception e) {
            asientoAux = new Asiento();
            asientoAux.setNumero("ERROR");
            //asientoAux.setObservaciones(e.getMessage());
            return asientoAux;
        }
    }
    
    public SubCuenta getCuentaByID(int idSubCuenta) {
        String sql = String.format("SELECT * FROM public.subcuenta where idsubcuenta = '%1$d';", idSubCuenta);
        SubCuenta subCuentaRef = new SubCuenta();
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                subCuentaRef = new SubCuenta(resultSet.getInt("idSubcuenta"), resultSet.getInt("idCuenta"), resultSet.getInt("idImpuesto"),
                        resultSet.getString("codigo"), resultSet.getString("nombre"), resultSet.getString("tipoSaldo"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return subCuentaRef;
    }

    public List<SubCuenta> getCuentasContables() {
        conexion.conectar();
        String sql = "SELECT * FROM public.subcuenta;";
        List<SubCuenta> subCuentas = new ArrayList<>();
        try {
            connection = conexion.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //Llena la lista de los datos
            while (resultSet.next()) {
                subCuentas.add(new SubCuenta(resultSet.getInt("idSubcuenta"), resultSet.getInt("idCuenta"), resultSet.getInt("idImpuesto"),
                        resultSet.getString("codigo"), resultSet.getString("nombre"), resultSet.getString("tipoSaldo")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return subCuentas;
    }

    //Agrega un nuevo asiento contable a la base de datos
    public boolean addAsientoContable(Asiento asiento) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String sql = String.format("select addAsientoContable('%1$s','%2$d','%8$s','%3$s','%4$s','%5$s','%6$s','%7$s');",
                asiento.getNumero(), asiento.getIdDiario(), asiento.getDocumento(), asiento.getDetalle(), dateFormat.format(asiento.getFechaCreacion()),
                dateFormat.format(asiento.getFechaCierre()), asiento.getEstado(), asiento.getTotal());
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

    //Edita el asiento contable por su id 
    //Se editara los valores del asiento contable.
    public boolean editAsientoContable(Asiento asiento, int id) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String sql = String.format("select editAsientoContable('%1$s','%2$s','%3$d','%4$s','%5$s','%6$s','%7$s','%8$s','%9$s');", id, asiento.getNumero(), asiento.getIdDiario(),
                asiento.getTotal(), asiento.getDocumento(), asiento.getDetalle(), dateFormat.format(asiento.getFechaCreacion()),
                dateFormat.format(asiento.getFechaCierre()), asiento.getEstado());
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
