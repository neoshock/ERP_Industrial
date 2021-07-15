/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.controllers;

import com.contabilidad.models.Asiento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class AsientoManagedBean implements Serializable {
    private List<Asiento> asientos;
    private Asiento asiento;
    
    @PostConstruct
    public void main(){
        asientos = new ArrayList<>();
        asientos.add(new Asiento("14/07/2021","ASC-0002","DOC-0002","INV-DIA-0001","432.64","Pendiente"));
        asientos.add(new Asiento("14/07/2021","ASC-0002","DOC-0002","INV-DIA-0001","432.64","Pendiente"));
        asientos.add(new Asiento("14/07/2021","ASC-0002","DOC-0002","INV-DIA-0001","432.64","Publicado"));
        asientos.add(new Asiento("14/07/2021","ASC-0002","DOC-0002","INV-DIA-0001","432.64","Deshabilitado"));
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
    
    
}
