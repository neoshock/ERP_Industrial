/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author elect
 */
public class Cuotas {

    public Cuotas(int Numero, String Proveedor, String Descripcion, LocalDate Fecha, float Interes, float Cuota, float SaldoCapital) {
        this.Numero = Numero;
        this.Proveedor = Proveedor;
        this.Descripcion = Descripcion;
        this.Fecha = Fecha;
        this.Interes = Interes;
        this.Cuota = Cuota;
        this.SaldoCapital = SaldoCapital;
    }
    private int Numero;
    private String Proveedor;
    private String Descripcion;
    private LocalDate Fecha;
    private float Interes;
    private float Cuota;
    private float SaldoCapital;

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }

    public float getInteres() {
        return Interes;
    }

    public void setInteres(float Interes) {
        this.Interes = Interes;
    }

    public float getCuota() {
        return Cuota;
    }

    public void setCuota(float Cuota) {
        this.Cuota = Cuota;
    }

    public float getSaldoCapital() {
        return SaldoCapital;
    }

    public void setSaldoCapital(float SaldoCapital) {
        this.SaldoCapital = SaldoCapital;
    }
}
