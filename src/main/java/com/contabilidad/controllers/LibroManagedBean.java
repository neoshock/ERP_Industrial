/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.controllers;

import com.contabilidad.dao.ImformeContableDAO;
import com.contabilidad.models.Libro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class LibroManagedBean implements Serializable {

    private List<Libro> libros = new ArrayList<>();
    private ImformeContableDAO imformes = new ImformeContableDAO();
    private double totalSaldoDebe;
    private double totalSaldoHaber;
    private double saldoTotal;

    @PostConstruct
    public void mainLibroMayor() {
        llenarLibro();
    }

    private void llenarLibro() {
        libros = imformes.getImformeLibroMayor();
        totalSaldoDebe = 0;
        totalSaldoHaber = 0;
        saldoTotal = 0;
        libros.forEach((l) -> {
            totalSaldoDebe += l.getDebe();
            totalSaldoHaber += l.getHaber();
            l.setSaldo(l.getDebe() + l.getHaber());
        });
        saldoTotal = totalSaldoDebe - totalSaldoHaber;
    }

    public Date getDateNow() {
        Date fecha = new Date();
        return fecha;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public double getTotalSaldoDebe() {
        return totalSaldoDebe;
    }

    public void setTotalSaldoDebe(double totalSaldoDebe) {
        this.totalSaldoDebe = totalSaldoDebe;
    }

    public double getTotalSaldoHaber() {
        return totalSaldoHaber;
    }

    public void setTotalSaldoHaber(double totalSaldoHaber) {
        this.totalSaldoHaber = totalSaldoHaber;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }
}
