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
    private int id;
    private String codigo, grupo, subgrupo, cuenta, subcuenta, tiposaldo;

    public CuentaContable() {
    }

    public CuentaContable(String codigo, String grupo, String subgrupo, String cuenta, String subcuenta) {
        this.codigo = codigo;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.cuenta = cuenta;
        this.subcuenta = subcuenta;
    }

    public CuentaContable(int id, String codigo, String grupo, String subgrupo, String cuenta, String subcuenta) {
        this.id = id;
        this.codigo = codigo;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.cuenta = cuenta;
        this.subcuenta = subcuenta;
    }

    public CuentaContable(int id, String codigo, String grupo, String subgrupo, String cuenta, String subcuenta, String tiposaldo) {
        this.id = id;
        this.codigo = codigo;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.cuenta = cuenta;
        this.subcuenta = subcuenta;
        this.tiposaldo = tiposaldo;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTiposaldo() {
        return tiposaldo;
    }

    public void setTiposaldo(String tiposaldo) {
        this.tiposaldo = tiposaldo;
    }

    @Override
    public String toString() {
        return "CuentaContable{" + "id=" + id + ", codigo=" + codigo + ", grupo=" + grupo + ", subgrupo=" + subgrupo + ", cuenta=" + cuenta + ", subcuenta=" + subcuenta + ", tiposaldo=" + tiposaldo + '}';
    }

    
}
