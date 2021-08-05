
package com.contabilidad.models;

public class SubGrupo {
    private int id, grupo;
    private String codigo, nombre;

    public SubGrupo(int id, int grupo, String codigo, String nombre) {
        this.id = id;
        this.grupo = grupo;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public SubGrupo() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
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
        return "SubGrupo{" + "id=" + id + ", grupo=" + grupo + ", codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    
}
