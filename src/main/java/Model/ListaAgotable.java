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
public class ListaAgotable {

    private int id_activo_fijo;
    private String detalle_de_activo = "";
    private int valor_adquisicion = 0;
    private LocalDate fecha_adquisicion = LocalDate.now();
    private int id_empresa = 0;
    private int stock = 0;
    private String proveedor = "";
    private String numero_factura = "001-001-000000000";

    public ListaAgotable() {
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

    public ListaAgotable(int id_activo_fijo, String detalle_de_activo, int valor_adquisicion, LocalDate fecha_adquisicion, int id_empresa, int stock, String proveedor, String numero_factura) {
        this.id_activo_fijo = id_activo_fijo;
        this.detalle_de_activo = detalle_de_activo;
        this.valor_adquisicion = valor_adquisicion;
        this.fecha_adquisicion = fecha_adquisicion;
        this.id_empresa = id_empresa;
        this.stock = stock;
        this.proveedor = proveedor;
        this.numero_factura = numero_factura;

    }

    public int getId_activo_fijo() {
        return id_activo_fijo;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
