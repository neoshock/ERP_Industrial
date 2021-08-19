/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataView.IntangibleDAO;
import Model.ActivoIntangible;
import Model.ActivosFijos;
import Model.ListarIntangible;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author desta
 */
@ManagedBean(name = "activosintangilesMB")
@ViewScoped
public class ActivosInTangiblesMB implements Serializable {

    IntangibleDAO intangibledao = new IntangibleDAO();
    ListarIntangible listaintangible = new ListarIntangible();
    ActivoIntangible activoingantible = new ActivoIntangible();
    ActivosFijos activosFijos = new ActivosFijos();
    int idactivofijo;

    public ActivosInTangiblesMB() {
    }

    public ActivosFijos getActivosFijos() {
        return activosFijos;
    }

    public void setActivosFijos(ActivosFijos activosFijos) {
        this.activosFijos = activosFijos;
    }

    public ActivoIntangible getActivoingantible() {
        return activoingantible;
    }

    public void setActivoingantible(ActivoIntangible activoingantible) {
        this.activoingantible = activoingantible;
    }

    public IntangibleDAO getIntangibledao() {
        return intangibledao;
    }

    public void setIntangibledao(IntangibleDAO intangibledao) {
        this.intangibledao = intangibledao;
    }

    public ListarIntangible getListaintangible() {
        return listaintangible;
    }

    public void setListaintangible(ListarIntangible listaintangible) {
        this.listaintangible = listaintangible;
    }

    public String setRegistrar3() {
        String data = "";
        IntangibleDAO intangibledao = new IntangibleDAO();
        try {
            intangibledao.guardar3(activosFijos, activoingantible);
            System.out.println("Registrado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosIntangibles.xhtml";
    }

    public void obtenerdatosIntangibles(ListarIntangible listaIntan) {
        this.listaintangible = listaIntan;
        idactivofijo = listaIntan.getId_activo_fijo();
        System.out.println("Id obtenido de activo: " + listaIntan.getId_activo_fijo());
        System.out.println("Id obtenido de empresa: " + listaIntan.getId_empresa());

    }
    public String setEditar3() {
        String data = "";
        try {
            activoingantible.setId_activo_fijo(idactivofijo);
            intangibledao.editar2(listaintangible);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosIntangibles.xhtml";
    }
    public String setDeshabilitarintangible() {
        String data = "";
        IntangibleDAO intangibledao = new IntangibleDAO();
        try {
            activoingantible.setId_activo_fijo(idactivofijo);
            intangibledao.deshabilitarintangible(listaintangible);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosIntangibles.xhtml";
    }
    public String setHabilitarintangible(int id) {
        String data = "";
        try {
            activoingantible.setId_activo_fijo(id);
            intangibledao.habilitarintangible(activoingantible);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosIntangibles.xhtml";
    }
}
