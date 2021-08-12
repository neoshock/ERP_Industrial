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
        result = conexion.consultar("select * from public.getsubcuentas()");
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
        result = conexion.consultar("select * from public.grupocuenta;");
        try {
            //(String codigo, String grupo, String subgrupo, String cuenta, String subcuenta)
            while (result.next()) {
                grupos.add(new Grupo(
                        result.getInt("idgrupo"),
                        result.getString("codigo"),
                        result.getString("nombre")
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
        result = conexion.consultar("select * from public.subgrupo where idgrupo = "+codigo+"");
        try {
            while (result.next()) {
                subgrupos.add(new SubGrupo(
                        result.getInt("idsubgrupo"),
                        result.getInt("idgrupo"),
                        result.getString("codigo"),
                        result.getString("nombre")
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
        result = conexion.consultar("select * from public.cuenta where idsubgrupo = "+codigo+"");
        try {
            // int id, int subgrupo, String codigo, String nombre
            while (result.next()) {
                cuentas.add(new Cuenta(
                        result.getInt("idcuenta"),
                        result.getInt("idsubgrupo"),
                        result.getString("codigo"),
                        result.getString("nombre")
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
        System.out.println("####################################" + codigo);
        try {
            result = conexion.consultar("select count(*) from public.subcuenta where idcuenta = "+codigo+"");
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
            String sql = String.format("select insertsubcuenta('%1$d', '%2$s', '%3$s', '%4$s')",
                    subcuenta.getCuenta(), subcuenta.getCodigo(), subcuenta.getNombre(), subcuenta.getTipo());
            conexion.ejecutar(sql);
            return 1;
        } catch (Exception e) {
            System.out.println("Error al isert subcuenta: " + e.getMessage());
        }
        return -1;
    }

    public int insertGrupo(Grupo grupo) {
        try {
            String sql = String.format("select insertgrupo('%1$s', '%2$s')",
                    grupo.getCodigo(), grupo.getNombre());
            result = conexion.ejecutar(sql);
            result.next();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error insertar Grupo" + e.getMessage());
        }
        return -1;
    }

    public int insertSubGrupo(SubGrupo subGrupo) {
        try {
            String sql = String.format("select insertsubgrupo('%1$d', '%2$s', '%3$s')",
                    subGrupo.getGrupo(), subGrupo.getCodigo(), subGrupo.getNombre());
            result = conexion.ejecutar(sql);
            result.next();
            return 1;
        } catch (Exception e) {
            System.out.println("Error insertar Subgrupo: " + e.getMessage());
        }
        return -1;
    }
    
    public int insertCuenta(Cuenta cuenta) {
        try {
            String sql = String.format("select insertcuenta('%1$d', '%2$s', '%3$s')",
                    cuenta.getIdsubgrupo(), cuenta.getCodigo(), cuenta.getNombre());
            result = conexion.ejecutar(sql);
            result.next();
            return 1;
        } catch (Exception e) {
            System.out.println("Error insertar Subgrupo: " + e.getMessage());
        }
        return -1;
    }
}
