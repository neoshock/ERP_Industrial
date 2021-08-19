/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author desta
 */
public class TangibleDepreciable {
    private int id_activo_fijo;
    private Date vida_util;
    private double cuota_depresiacion;
    private double depreciacion_acumulada;
    private double valor_neto_libros;
    private Date fecha_depreciacion;
    
    public TangibleDepreciable(){}
    
    public TangibleDepreciable(int id_activo_fijo,Date vida_util,double cuota_depresiacion,
    double depreciacion_acumulada,double valor_neto_libros,Date fecha_depreciacion){
        this.id_activo_fijo=id_activo_fijo;
        this.vida_util=vida_util;
        this.cuota_depresiacion=cuota_depresiacion;
        this.depreciacion_acumulada=depreciacion_acumulada;
        this.valor_neto_libros=valor_neto_libros;
        this.fecha_depreciacion=fecha_depreciacion;
 
    }

    public int getId_activo_fijo() {
        return id_activo_fijo;
    }

    public void setId_activo_fijo(int id_activo_fijo) {
        this.id_activo_fijo = id_activo_fijo;
    }

    public Date getVida_util() {
        return vida_util;
    }

    public void setVida_util(Date vida_util) {
        this.vida_util = vida_util;
    }

    public double getCuota_depresiacion() {
        return cuota_depresiacion;
    }

    public void setCuota_depresiacion(double cuota_depresiacion) {
        this.cuota_depresiacion = cuota_depresiacion;
    }

    public double getDepreciacion_acumulada() {
        return depreciacion_acumulada;
    }

    public void setDepreciacion_acumulada(double depreciacion_acumulada) {
        this.depreciacion_acumulada = depreciacion_acumulada;
    }

    public double getValor_neto_libros() {
        return valor_neto_libros;
    }

    public void setValor_neto_libros(double valor_neto_libros) {
        this.valor_neto_libros = valor_neto_libros;
    }

    public Date getFecha_depreciacion() {
        return fecha_depreciacion;
    }

    public void setFecha_depreciacion(Date fecha_depreciacion) {
        this.fecha_depreciacion = fecha_depreciacion;
    }
    
    
}
