/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.models;

/**
 *
 * @author LUIS ALFREDO
 */
public class CuentaContable {
    private String codigo, grupo, subgrupo, cuenta, subcuenta;

    public CuentaContable(String codigo, String grupo, String subgrupo, String cuenta, String subcuenta) {
        this.codigo = codigo;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.cuenta = cuenta;
        this.subcuenta = subcuenta;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getSubcuenta() {
        return subcuenta;
    }

    public void setSubcuenta(String subcuenta) {
        this.subcuenta = subcuenta;
    }
    
    
}
