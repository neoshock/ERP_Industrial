package com.contabilidad.models;

public class Libro {
    
    private String codigo;
    private String nombre;
    private String Fecha;
    private String Asiento;
    private String Descripcion;
    private double debe;
    private double haber;
    private double saldo;

    public Libro(String codigo, String nombre, String Fecha, String Asiento, String Descripcion, double debe, double haber) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.Fecha = Fecha;
        this.Asiento = Asiento;
        this.Descripcion = Descripcion;
        this.debe = debe;
        this.haber = haber;
    }

    public Libro() {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
