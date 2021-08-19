/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author desta
 */
public class ListaDepreciable {

    private int id_activo_fijo;
    private String detalle_de_activo ="";
    private int valor_adquisicion =0;
    private LocalDate fecha_adquisicion = LocalDate.now();
    private int id_empresa ;
    private int depreciacion_meses =0;
    private double cuota_depresiacion ;
    private double porcentaje_depreciacion =0;
    private double valor_neto_libros ;
    private String proveedor ="";
    private String numero_factura ="001-001-000000000";

    public ListaDepreciable() {
    }

    public ListaDepreciable(int id_activo_fijo, String detalle_de_activo, int valor_adquisicion,LocalDate fecha_adquisicion, int id_empresa, int depreciacion_meses, double cuota_depresiacion, double porcentaje_depreciacion, double valor_neto_libros, String proveedor, String numero_factura) {
        this.id_activo_fijo = id_activo_fijo;
        this.detalle_de_activo = detalle_de_activo;
        this.valor_adquisicion = valor_adquisicion;
        this.fecha_adquisicion=fecha_adquisicion;
        this.id_empresa = id_empresa;
        this.depreciacion_meses = depreciacion_meses;
        this.cuota_depresiacion = cuota_depresiacion;
        this.porcentaje_depreciacion = porcentaje_depreciacion;
        this.valor_neto_libros = valor_neto_libros;
        this.proveedor = proveedor;
        this.numero_factura = numero_factura;
    }



    

    public int getId_activo_fijo() {
        return id_activo_fijo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }

    public void setId_activo_fijo(int id_activo_fijo) {
        this.id_activo_fijo = id_activo_fijo;
    }

    public String getDetalle_de_activo() {
        return detalle_de_activo;
    }

    public void setDetalle_de_activo(String detalle_de_activo) {
        this.detalle_de_activo = detalle_de_activo;
    }

    public int getValor_adquisicion() {
        return valor_adquisicion;
    }

    public void setValor_adquisicion(int valor_adquisicion) {
        this.valor_adquisicion = valor_adquisicion;
    }

    public LocalDate getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(LocalDate fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getDepreciacion_meses() {
        return depreciacion_meses;
    }

    public void setDepreciacion_meses(int depreciacion_meses) {
        this.depreciacion_meses = depreciacion_meses;
    }

    public double getCuota_depresiacion() {
        return cuota_depresiacion;
    }

    public void setCuota_depresiacion(double cuota_depresiacion) {
        this.cuota_depresiacion = cuota_depresiacion;
    }

    public double getPorcentaje_depreciacion() {
        return porcentaje_depreciacion;
    }

    public void setPorcentaje_depreciacion(double porcentaje_depreciacion) {
        this.porcentaje_depreciacion = porcentaje_depreciacion;
    }

    public double getValor_neto_libros() {
        return valor_neto_libros;
    }

    public void setValor_neto_libros(double valor_neto_libros) {
        this.valor_neto_libros = valor_neto_libros;
    }

}
