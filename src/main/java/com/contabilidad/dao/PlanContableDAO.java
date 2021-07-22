/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.dao;

import com.contabilidad.models.CuentaContable;
import com.contabilidad.models.Grupo;
import com.contabilidad.models.Cuenta;
import com.contabilidad.models.SubCuenta;
import com.contabilidad.models.SubGrupo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LUIS ALFREDO
 */
public class PlanContableDAO {

    private Conexion conexion = new Conexion();
    private List<CuentaContable> cuentasContables;
    private List<Grupo> grupos;
    private List<SubGrupo> subgrupos;
    private List<Cuenta> cuentas;
    
    private ResultSet result;

    public List<CuentaContable> getSubCuentas() {
        cuentasContables = new ArrayList<>();
        result = conexion.consultar("select * from contabilidad.getsubcuentas()");
        try {
            //(String codigo, String grupo, String subgrupo, String cuenta, String subcuenta)
            while (result.next()) {
                cuentasContables.add(new CuentaContable(
                        result.getString("codigo"),
                        result.getString("grupo"),
                        result.getString("subgrupo"),
                        result.getString("cuenta"),
                        result.getString("nombre")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema en getAllClientes: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        return cuentasContables;
    }

    public List<Grupo> getGrupos() {
        grupos = new ArrayList<>();
        result = conexion.consultar("select * from contabilidad.grupo;");
        try {
            //(String codigo, String grupo, String subgrupo, String cuenta, String subcuenta)
            while (result.next()) {
                grupos.add(new Grupo(
                        result.getInt("id_grupo"), 
                        result.getString("codigo_grupo"), 
                        result.getString("nombre_grupo")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema en getAllClientes: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        return grupos;
    }
    
    public List<SubGrupo> getSubGrupos(String codigo) {
        subgrupos = new ArrayList<>();
        result = conexion.consultar("select * from contabilidad.subgrupo where id_grupo = "+codigo+"");
        try {
            while (result.next()) {
                subgrupos.add(new SubGrupo(
                        result.getInt("id_subgrupo"), 
                        result.getInt("id_grupo"),
                        result.getString("codigo_subgrupo"), 
                        result.getString("nombre_subgrupo")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema en getAllClientes: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        return subgrupos;
    }
    
    public List<Cuenta> getCuentas(String codigo) {
        cuentas = new ArrayList<>();
        result = conexion.consultar("select * from contabilidad.cuenta where id_subgrupo = "+codigo+"");
        try {
            // int id, int subgrupo, String codigo, String nombre
            while (result.next()) {
                cuentas.add(new Cuenta(
                        result.getInt("id_cuenta"), 
                        result.getInt("id_subgrupo"),
                        result.getString("codigo_cuenta"), 
                        result.getString("nombre_cuenta")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema en getAllClientes: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        return cuentas;
    }
    
    public int getCountSubCuentas(String codigo) {
        int count = -1;
        System.out.println("####################################"+codigo);
        try {
            result = conexion.consultar("select count(*) from contabilidad.subcuenta where id_cuenta = "+codigo+"");
            while (result.next()) {
                count = result.getInt("count");
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema en getAllClientes: " + ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        return count;
    }
    
    public int insertSubCuenta(SubCuenta subcuenta) {
        try {
            String sql = String.format("select contabilidad.insertcuenta('%1$d', '%2$s', '%3$s', '%4$s')", 
                subcuenta.getCuenta(), subcuenta.getCodigo(), subcuenta.getNombre(), subcuenta.getTipo());
            conexion.insertar(sql);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return 1;
    }
}
