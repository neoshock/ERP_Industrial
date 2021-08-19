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
public class ActivoAgotable {
    private int id_activo_fijo;
    private int stock=0;

    public ActivoAgotable() {
    }

    public ActivoAgotable(int id_activo_fijo, int stock) {
        this.id_activo_fijo = id_activo_fijo;
        this.stock = stock;
    }

    public int getId_activo_fijo() {
        return id_activo_fijo;
    }

    public void setId_activo_fijo(int id_activo_fijo) {
        this.id_activo_fijo = id_activo_fijo;
    }

 

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
