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
public class ActivoNoDepreciable {
   
    private int id_activo_fijo=0;
    private double plusvalia =0;

    public ActivoNoDepreciable() {
    }

    public ActivoNoDepreciable(int id_activo_fijo, double plusvalia) {
        this.id_activo_fijo = id_activo_fijo;
        this.plusvalia = plusvalia;
    }

    public double getPlusvalia() {
        return plusvalia;
    }

    public void setPlusvalia(double plusvalia) {
        this.plusvalia = plusvalia;
    }





    public int getId_activo_fijo() {
        return id_activo_fijo;
    }

    public void setId_activo_fijo(int id_activo_fijo) {
        this.id_activo_fijo = id_activo_fijo;
    }


    
    
    
    
    
}
