
package com.contabilidad.models;

public class Cuenta {
    private int idcuenta, idsubgrupo;
    private String codigo, nombre;

    public Cuenta(int idcuenta, int idsubgrupo, String codigo, String nombre) {
        this.idcuenta = idcuenta;
        this.idsubgrupo = idsubgrupo;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    
    public Cuenta() {
    }

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public int getIdsubgrupo() {
        return idsubgrupo;
    }

    public void setIdsubgrupo(int idsubgrupo) {
        this.idsubgrupo = idsubgrupo;
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

    @Override
    public String toString() {
        return "Cuenta{" + "idcuenta=" + idcuenta + ", idsubgrupo=" + idsubgrupo + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    
}
