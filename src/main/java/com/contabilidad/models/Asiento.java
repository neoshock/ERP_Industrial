package com.contabilidad.models;

import java.util.Date;
import java.util.List;

public class Asiento {
    int idAsiento;
    int idDiario;
    String documento;
    String detalle;
    String estado;
    Date fechaCreacion;
    Date fechaCierre;
    String numero;
    String total;
    List<Movimiento> movimientos;

    public Asiento(int idAsiento, int idDiario, String documento, String detalle, String estado, Date fechaCreacion, Date fechaCierre, String numero, String total) {
        this.idAsiento = idAsiento;
        this.idDiario = idDiario;
        this.documento = documento;
        this.detalle = detalle;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
        this.numero = numero;
        this.total = total;
    }

    public Asiento() {
    }
    
    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public int getIdDiario() {
        return idDiario;
    }

    public void setIdDiario(int idDiario) {
        this.idDiario = idDiario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    
    
}
