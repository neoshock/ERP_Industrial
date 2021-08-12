
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
}
