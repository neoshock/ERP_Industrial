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
public class ActivoIntangible {
    private int id_intangible;
    private int id_activo_fijo;

    public ActivoIntangible() {
    }

    public ActivoIntangible(int id_intangible, int id_activo_fijo) {
        this.id_intangible = id_intangible;
        this.id_activo_fijo = id_activo_fijo;
    } 
    
    public int getId_intangible() {
        return id_intangible;
    }

    public void setId_intangible(int id_intangible) {
        this.id_intangible = id_intangible;
    }

    public int getId_activo_fijo() {
        return id_activo_fijo;
    }

    public void setId_activo_fijo(int id_activo_fijo) {
        this.id_activo_fijo = id_activo_fijo;
    }
    
    
    
}
