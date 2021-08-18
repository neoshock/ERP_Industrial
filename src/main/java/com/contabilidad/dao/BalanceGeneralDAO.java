package com.contabilidad.dao;

import com.contabilidad.models.BalanceGeneral;
import com.contabilidad.models.Grupo;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BalanceGeneralDAO {

    private Conexion conexion;
    private ResultSet result;
    private Gson gson;

    public BalanceGeneralDAO() {
        conexion = new Conexion();
        gson = new Gson();
    }

    private List<BalanceGeneral> getCalculoGrupo() {
        String sql = "select getcalculogrupobg()";
        List<BalanceGeneral> listaCalculosGrupo = new ArrayList<>();
        result = conexion.consultar(sql);
        try {
            while (result.next()) {
                String cadenaJSON = result.getString("getcalculogrupobg");
                BalanceGeneral balanceGeneral = gson.fromJson(cadenaJSON, BalanceGeneral.class);
                listaCalculosGrupo.add(balanceGeneral);
            }
            return listaCalculosGrupo;
        } catch (SQLException ex) {
            System.out.println("Error getCalculoGrupo: " + ex.getMessage());
            return null;
        }
    }

    private List<BalanceGeneral> getCalculoSubGrupo() {
        String sql = "select getcalculosubgrupobg()";
        List<BalanceGeneral> listaCalculosSubGrupo = new ArrayList<>();
        result = conexion.consultar(sql);
        try {
            while (result.next()) {
                String cadenaJSON = result.getString("getcalculosubgrupobg");
                BalanceGeneral balanceGeneral = gson.fromJson(cadenaJSON, BalanceGeneral.class);
                listaCalculosSubGrupo.add(balanceGeneral);
            }
            return listaCalculosSubGrupo;
        } catch (SQLException ex) {
            System.out.println("Error getCalculoGrupo: " + ex.getMessage());
            return null;
        }
    }

    private List<BalanceGeneral> getCalculoCuenta() {
        String sql = "select getcalculocuentabg()";
        List<BalanceGeneral> listaCalculosCuenta = new ArrayList<>();
        result = conexion.consultar(sql);
        try {
            while (result.next()) {
                String cadenaJSON = result.getString("getcalculocuentabg");
                BalanceGeneral balanceGeneral = gson.fromJson(cadenaJSON, BalanceGeneral.class);
                listaCalculosCuenta.add(balanceGeneral);
            }
            return listaCalculosCuenta;
        } catch (SQLException ex) {
            System.out.println("Error getcalculocuentabg: " + ex.getMessage());
            return null;
        }
    }

    private List<BalanceGeneral> getCalculoSubCuenta() {
        String sql = "select getcalculosubcuentabg()";
        List<BalanceGeneral> listaCalculosSubCuenta = new ArrayList<>();
        result = conexion.consultar(sql);
        try {
            while (result.next()) {
                String cadenaJSON = result.getString("getcalculosubcuentabg");
                BalanceGeneral balanceGeneral = gson.fromJson(cadenaJSON, BalanceGeneral.class);
                listaCalculosSubCuenta.add(balanceGeneral);
            }
            return listaCalculosSubCuenta;
        } catch (SQLException ex) {
            System.out.println("Error getcalculosubcuentabg: " + ex.getMessage());
            return null;
        }
    }

    public List<BalanceGeneral> generateBalanceGeneral() {
        List<BalanceGeneral> balanceGeneral = new ArrayList<>();

        getCalculoGrupo().forEach(g -> {
            balanceGeneral.add(g);
            getCalculoSubGrupo().forEach(sg -> {
                if (sg.getParent() == g.getId()) {
                    balanceGeneral.add(sg);

                    getCalculoCuenta().forEach(c -> {
                        if (c.getParent() == sg.getId()) {
                            balanceGeneral.add(c);

                            getCalculoSubCuenta().forEach(sc -> {
                                if (sc.getParent() == c.getId()) {
                                    balanceGeneral.add(sc);
                                }
                            });
                        }
                    });
                }
            });
        });
        
        return balanceGeneral;
    }
}
