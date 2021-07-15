package com.contabilidad.models;

public class Asiento {
    private String fecha;
    private String numero;
    private String referencia;
    private String diario;
    private String total;
    private String estado;

    public Asiento() {
        
    }

    public Asiento(String fecha, String numero, String referencia, String diario, String total, String estado) {
        this.fecha = fecha;
        this.numero = numero;
        this.referencia = referencia;
        this.diario = diario;
        this.total = total;
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDiario() {
        return diario;
    }

    public void setDiario(String diario) {
        this.diario = diario;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
