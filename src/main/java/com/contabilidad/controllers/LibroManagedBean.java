/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contabilidad.controllers;

import com.contabilidad.dao.DiarioDAO;
import com.contabilidad.dao.ImformeContableDAO;
import com.contabilidad.models.Diario;
import com.contabilidad.models.Libro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class LibroManagedBean implements Serializable {

    private List<Libro> libros = new ArrayList<>();
    private ImformeContableDAO imformes = new ImformeContableDAO();
    private DiarioDAO diarioDAO = new DiarioDAO();

    private double totalSaldoDebe;
    private double totalSaldoHaber;
    private double saldoTotal;

    private Diario onSelectedDiario;
    private List<Diario> diarios;

    @PostConstruct
    public void mainLibroMayor() {
        llenarLibro();
        loadDiarios();
    }

    public void loadDiarios() {
        onSelectedDiario = new Diario();
        diarios = diarioDAO.getDiariosContables();
    }

    private void llenarLibro() {
        libros = imformes.getImformeLibroMayor();
        saldoTotal = getSaldoTotal(libros);
    }

    public double calculateSaldoCuenta(String codigo) {
        double saldoDeudor = 0;
        double saldoAcreedor = 0;
        for (Libro item : libros) {
            if (item.getCodigo().equals(codigo)) {
                saldoDeudor += item.getDebe();
                saldoAcreedor += -item.getHaber();
            }
        }
        return saldoDeudor + saldoAcreedor;
    }

    public double getSaldoTotal(List<Libro> libro) {
        totalSaldoDebe = 0;
        totalSaldoHaber = 0;
        saldoTotal = 0;
        libros.forEach((l) -> {
            totalSaldoDebe += l.getDebe();
            totalSaldoHaber += l.getHaber();
            l.setSaldo(l.getDebe() + l.getHaber());
        });
        return totalSaldoDebe - totalSaldoHaber;
    }

    public Date getDateNow() {
        Date fecha = new Date();
        return fecha;
    }

    public void filtrateLibroMayor() {
        if (onSelectedDiario.getIdDiario() != 0) {
            libros = imformes.filtrateLibroByDiario(onSelectedDiario.getIdDiario());
            saldoTotal = getSaldoTotal(libros);
        }else{
            llenarLibro();
        }
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

    public Diario getOnSelectedDiario() {
        return onSelectedDiario;
    }

    public void setOnSelectedDiario(Diario onSelectedDiario) {
        this.onSelectedDiario = onSelectedDiario;
    }

    public List<Diario> getDiarios() {
        return diarios;
    }

    public void setDiarios(List<Diario> diarios) {
        this.diarios = diarios;
    }

}
