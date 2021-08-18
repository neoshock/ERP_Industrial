package com.contabilidad.models;

public class BalanceGeneral {
    private String nombre;
    private String subcuenta;
    private double saldo;

    public BalanceGeneral(String nombre, String subcuenta, double saldo) {
        this.nombre = nombre;
        this.subcuenta = subcuenta;
        this.saldo = saldo;
    }

    public BalanceGeneral() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSubcuenta() {
        return subcuenta;
    }

    public void setSubcuenta(String subcuenta) {
        this.subcuenta = subcuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}
