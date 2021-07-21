/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.controllers;

import com.contabilidad.models.Libro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class LibroManagedBean implements Serializable {
    
    private List<Libro> libros = new ArrayList<>();
    
    @PostConstruct
    public void mainLibroMayor(){
        llenarLibro();
    }
    
    private void llenarLibro(){
        libros.add(new Libro("1.1.1.1 Cuentas por cobrar","17/06/2021","ASC-0001","Venta de productos","$0.00","$0.00","$0.00"));
        libros.add(new Libro("1.1.1.1 Cuentas por cobrar","17/06/2021","ASC-0001","Venta de productos","$0.00","$0.00","$0.00"));
        libros.add(new Libro("1.1.1.1 Cuentas por cobrar","17/06/2021","ASC-0001","Venta de productos","$0.00","$0.00","$0.00"));
        libros.add(new Libro("1.1.1.2 Caja","17/06/2021","ASC-0001","Venta de productos","$0.00","$0.00","$0.00"));
        libros.add(new Libro("1.1.1.2 Caja","17/06/2021","ASC-0001","Venta de productos","$0.00","$0.00","$0.00"));
        libros.add(new Libro("1.1.1.2 Caja","17/06/2021","ASC-0001","Venta de productos","$0.00","$0.00","$0.00"));
        libros.add(new Libro("1.1.1.3 Inversiones financieras","17/06/2021","ASC-0001","Venta de productos","$0.00","$0.00","$0.00"));
        libros.add(new Libro("1.1.1.4 Cuentas por cobrar comerciales","17/06/2021","ASC-0001","Venta de productos","$0.00","$0.00","$0.00"));
        libros.add(new Libro("1.1.1.4 Cuentas por cobrar comerciales","17/06/2021","ASC-0001","Venta de productos","$0.00","$0.00","$0.00"));
        libros.add(new Libro("1.1.1.4 Cuentas por cobrar comerciales","17/06/2021","ASC-0001","Venta de productos","$0.00","$0.00","$0.00"));
    }

    public List<Libro> getLibros() {
        return libros;
    }
    
    
}
