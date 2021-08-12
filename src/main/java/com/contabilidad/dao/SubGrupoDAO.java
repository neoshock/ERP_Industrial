
package com.contabilidad.dao;

import com.contabilidad.models.Grupo;
import com.contabilidad.models.SubGrupo;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubGrupoDAO {
    private Conexion conexion;
    private List<SubGrupo> listaSubgrupo;
    private ResultSet result;
    private Gson gson;
    
    public SubGrupoDAO() {
        conexion = new Conexion();
        listaSubgrupo = new ArrayList<>();
        gson = new Gson();
    }
    
    public List<SubGrupo> getSubGrupos() {
        result = conexion.consultar("select getsubgruposcuenta()");
        try {
            while (result.next()) {
                //System.out.println(result.getString("getgrupocuenta"));
                String cadenaJSON = result.getString("getsubgruposcuenta");
                SubGrupo g = gson.fromJson(cadenaJSON, SubGrupo.class);
                listaSubgrupo.add(g);
            }
            return listaSubgrupo;
        } catch (SQLException ex) {
            System.out.println("Error getSubGrupos: " + ex.getMessage());
            return null;
        }
    }
    
}
