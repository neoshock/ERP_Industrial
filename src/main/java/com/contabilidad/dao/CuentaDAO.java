package com.contabilidad.dao;

import com.contabilidad.models.Cuenta;
import com.contabilidad.models.Grupo;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {

    private Conexion conexion;
    private List<Cuenta> listaCuenta;
    private ResultSet result;
    private Gson gson;

    public CuentaDAO() {
        conexion = new Conexion();
        listaCuenta = new ArrayList<>();
        gson = new Gson();
    }

    public List<Cuenta> getCuentas() {
        listaCuenta = new ArrayList<>();
        result = conexion.consultar("select getcuentas()");
        try {
            while (result.next()) {
                //System.out.println(result.getString("getgrupocuenta"));
                String cadenaJSON = result.getString("getcuentas");
                Cuenta g = gson.fromJson(cadenaJSON, Cuenta.class);
                listaCuenta.add(g);
            }
            return listaCuenta;
        } catch (SQLException ex) {
            System.out.println("Error getCuentas: " + ex.getMessage());
            return null;
        }
    }

    public Cuenta getCuentaById(int id) {
        Cuenta cuenta = new Cuenta();
        result = conexion.consultar(String.format("select getCuenta('%1$d')", id));
        try {
            if (result.next()) {
                String cadenaJSON = result.getString("getgrupocuentabyid");
                cuenta = gson.fromJson(cadenaJSON, Cuenta.class);
                cuenta.setCodigo(cuenta.getCodigo().trim());
            }
        } catch (SQLException ex) {
            System.out.println("Error getgrupocuenta: " + ex.getMessage());
        }
        return cuenta;
    }

    public boolean insert(Cuenta cuenta) {
        try {
            String sql = String.format("select insertcuenta('%1$d', '%2$s', '%3$s')",
                    cuenta.getIdsubgrupo(), cuenta.getCodigo(), cuenta.getNombre());
            result = conexion.ejecutar(sql);
            result.next();
            return true;
        } catch (Exception e) {
            System.out.println("Error insertar Cuenta: " + e.getMessage());
            return false;
        }
    }

    public boolean update(Cuenta cuenta) {
        try {
            String sql = String.format("select updateCuenta('%1$d','%2$s')", cuenta.getIdcuenta(), cuenta.getNombre());
            result = conexion.ejecutar(sql);
            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error update Grupo" + e.getMessage());
        }
        return false;
    }

    public boolean delete(int id) {
        String sql = String.format("delete from cuenta where idcuenta = '%1$d'", id);
        return conexion.eliminar(sql) != -1;
    }
}
