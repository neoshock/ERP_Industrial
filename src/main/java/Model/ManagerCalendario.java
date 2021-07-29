/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elect
 */
public class ManagerCalendario {

    public ManagerCalendario() {
        this.listCuotas = new ArrayList<Cuotas>();
        listCuotas.add(new Cuotas(1, "Roberto", "sdlfkjs", LocalDate.now(), 255, 155, 1555));
        listCuotas.add(new Cuotas(2, "Daniel", "data mas data", LocalDate.now(), 255, 155, 1555));
    }
    private String titulo;
    private LocalDate fecha;
    // lista de las cuotas
    private List<Cuotas> listCuotas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Cuotas> getListCuotas() {
        return listCuotas;
    }

    public void setListCuotas(List<Cuotas> listCuotas) {
        this.listCuotas = listCuotas;
    }
    
    
}
