/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author desta
 */
public class ListaPeriodosActivosFijos {
    private int anio;
    private int monto_total;
    private String inicio;
    private String fin;

    public ListaPeriodosActivosFijos() {
    }

    public ListaPeriodosActivosFijos(int anio, int monto_total, String inicio, String fin) {
        this.anio = anio;
        this.monto_total = monto_total;
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(int monto_total) {
        this.monto_total = monto_total;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    
    
}
