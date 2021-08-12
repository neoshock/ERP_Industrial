
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
        listaSubgrupo = new ArrayList<>();
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
    
    public int getProximoCodigo(int idGrupo) {
        result = conexion.consultar("select getproximocodigosubgrupo("+idGrupo+")");
        try {
            if (result.next()) {
                return result.getInt("getproximocodigosubgrupo");
            }
        } catch (SQLException ex) {
            System.out.println("Error getgrupocuenta: " + ex.getMessage());
        }
        return -1;
    }
    
    public boolean store(SubGrupo subGrupo) {
        try {
            String sql = String.format("select insertsubgrupo('%1$d', '%2$s', '%3$s')",
                    subGrupo.getGrupo(), subGrupo.getCodigo(), subGrupo.getNombre());
            result = conexion.ejecutar(sql);
            return result.next();
        } catch (SQLException e) {
            System.out.println("Error insertar Grupo" + e.getMessage());
        }
        return false;
    }
    
    public SubGrupo getGrupoById(int id) {
        SubGrupo g = null;
        result = conexion.consultar("select getsubgrupobyid("+id+")");
        try {
            if (result.next()) {
                String cadenaJSON = result.getString("getsubgrupobyid");
                g = gson.fromJson(cadenaJSON, SubGrupo.class);
            }
        } catch (SQLException ex) {
            System.out.println("Error getsubgrupobyid: " + ex.getMessage());
        }
        return g;
    }
    
    public boolean update(SubGrupo subGrupo) {
        try {
            String obj = gson.toJson(subGrupo);
            String sql = String.format("select updatesubgrupo('%1$s')", obj);
            result = conexion.ejecutar(sql);
            if (result.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error update SubGrupo" + e.getMessage());
        }
        return false;
    }
    
    public boolean delete(int id) {
        String sql = String.format("delete from subgrupo where idsubgrupo = '%1$d'", id);
        return conexion.eliminar(sql) != -1;
    }
}
