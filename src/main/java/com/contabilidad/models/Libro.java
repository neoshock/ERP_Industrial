package com.contabilidad.models;

public class Libro {
    
    private String cuenta;
    private String Fecha;
    private String Asiento;
    private String Descripcion;
    private String debe;
    private String haber;
    private String saldo;

    public Libro(String cuenta, String Fecha, String Asiento, String Descripcion, String debe, String haber, String saldo) {
        this.cuenta = cuenta;
        this.Fecha = Fecha;
        this.Asiento = Asiento;
        this.Descripcion = Descripcion;
        this.debe = debe;
        this.haber = haber;
        this.saldo = saldo;
    }

    public Libro() {
    }
    
    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getAsiento() {
        return Asiento;
    }

    public void setAsiento(String Asiento) {
        this.Asiento = Asiento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getDebe() {
        return debe;
    }

    public void setDebe(String debe) {
        this.debe = debe;
    }

    public String getHaber() {
        return haber;
    }

    public void setHaber(String haber) {
        this.haber = haber;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

}
