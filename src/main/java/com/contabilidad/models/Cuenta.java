
package com.contabilidad.models;

public class Cuenta {
    private int id, subgrupo;
    private String codigo, nombre;

    public Cuenta(int id, int subgrupo, String codigo, String nombre) {
        this.id = id;
        this.subgrupo = subgrupo;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Cuenta() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(int subgrupo) {
        this.subgrupo = subgrupo;
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
        return "Cuenta{" + "id=" + id + ", subgrupo=" + subgrupo + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    
}
