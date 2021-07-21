/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Binds;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author elect
 */
@Named(value = "bindGenerarCalendario")
@RequestScoped
public class bindGenerarCalendario {

    private String opcionSeleccionada;
    private boolean  todosProveedores;
    private LocalDate local;

    public LocalDate getLocal() {
        return local;
    }

    public void setLocal(LocalDate local) {
        this.local = local;
    }
    
    
    
    public boolean isTodosProveedores() {
        return todosProveedores;
    }

    public void setTodosProveedores(boolean todosProveedores) {
        this.todosProveedores = todosProveedores;
    }
    public String getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    public void setOpcionSeleccionada(String opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }
    
    public bindGenerarCalendario() {
    }
    
    public String ShowInfo() {
        System.out.println("Binds.bindGenerarCalendario.ShowInfo()");
        System.out.println(this.opcionSeleccionada);
        System.out.println(this.todosProveedores);
        System.out.println(this.opcionSeleccionada);
        return "index";
    }
    
    @PostConstruct
    public void init() {
   
        
    }
    
}
