/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataView.AgotableDAO;
import DataView.NoDepreciableDAO;
import DataView.TangibleDAO;
import Model.ActivoAgotable;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import Model.ActivosFijos;
import Model.ActivoDepreciable;
import Model.ActivoNoDepreciable;
import Model.ListaAgotable;
import Model.ListaDepreciable;
import Model.ListaNoDepreciable;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author desta
 */
@ManagedBean(name = "activosFijosMB")
@ViewScoped
public class ActivosFijosMB implements Serializable {

    ActivosFijos activosFijos = new ActivosFijos();
    ActivoDepreciable activodepreciable = new ActivoDepreciable();
    ActivoNoDepreciable activoNoDepreciable = new ActivoNoDepreciable();
    ActivoAgotable activosagotables = new ActivoAgotable();
    TangibleDAO tangibleDAO = new TangibleDAO();
    NoDepreciableDAO nodepreciabledao = new NoDepreciableDAO();
    AgotableDAO agotablesdao = new AgotableDAO();
    ListaDepreciable listadepreciable = new ListaDepreciable();
    ListaNoDepreciable listanodepreciable = new ListaNoDepreciable();
    ListaAgotable listaragotables = new ListaAgotable();
    int idactivofijo;

    public ListaAgotable getListaragotables() {
        return listaragotables;
    }

    public void setListaragotables(ListaAgotable listaragotables) {
        this.listaragotables = listaragotables;
    }

    public AgotableDAO getAgotablesdao() {
        return agotablesdao;
    }

    public void setAgotablesdao(AgotableDAO agotablesdao) {
        this.agotablesdao = agotablesdao;
    }

    public ActivoAgotable getActivosagotables() {
        return activosagotables;
    }

    public void setActivosagotables(ActivoAgotable activosagotables) {
        this.activosagotables = activosagotables;
    }

    public NoDepreciableDAO getNodepreciabledao() {
        return nodepreciabledao;
    }

    public ListaNoDepreciable getListanodepreciable() {
        return listanodepreciable;
    }

    public void setListanodepreciable(ListaNoDepreciable listanodepreciable) {
        this.listanodepreciable = listanodepreciable;
    }

    public void setNodepreciabledao(NoDepreciableDAO nodepreciabledao) {
        this.nodepreciabledao = nodepreciabledao;
    }

    public ActivosFijos getActivos() {
        return activosFijos;
    }

    public ListaDepreciable getListadepreciable() {
        return listadepreciable;
    }

    public void setListadepreciable(ListaDepreciable listadepreciable) {
        this.listadepreciable = listadepreciable;
    }

    public TangibleDAO getTangibleDAO() {
        return tangibleDAO;
    }

    public void setTangibleDAO(TangibleDAO tangibleDAO) {
        this.tangibleDAO = tangibleDAO;
    }

    public ActivoNoDepreciable getActivoNoDepreciable() {
        return activoNoDepreciable;
    }

    public ActivoDepreciable getActivodepreciable() {
        return activodepreciable;
    }

    public void setActivoNoDepreciable(ActivoNoDepreciable activoNoDepreciable) {
        this.activoNoDepreciable = activoNoDepreciable;
    }

    public void setActivodepreciable(ActivoDepreciable activodepreciable) {
        this.activodepreciable = activodepreciable;
    }

    public void setActivos(ActivosFijos activos) {
        this.activosFijos = activos;
    }

    public String setRegistrar() {
        String data = "";
        TangibleDAO tangibledao = new TangibleDAO();
        try {
            tangibledao.guardar(activosFijos, activodepreciable);
            System.out.println("Registrado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosTangibles.xhtml";
    }

    public String setEditar() {
        String data = "";
        TangibleDAO tangibledao = new TangibleDAO();
        try {
            listadepreciable.setId_activo_fijo(idactivofijo);
            tangibledao.editar(listadepreciable);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosTangibles.xhtml";
    }

    public String setEditar1() {
        String data = "";
        NoDepreciableDAO nodepreciabledao = new NoDepreciableDAO();
        try {
            activoNoDepreciable.setId_activo_fijo(idactivofijo);
            nodepreciabledao.editar1(listanodepreciable);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosTangibles.xhtml";
    }

    public String setEditar2() {
        String data = "";
        AgotableDAO agotablesdao = new AgotableDAO();
        try {
            activosagotables.setId_activo_fijo(idactivofijo);
            agotablesdao.editar2(listaragotables);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosTangibles.xhtml";
    }

    public String setEliminar() {
        String data = "";
        TangibleDAO tangibledao = new TangibleDAO();
        try {
            listadepreciable.setId_activo_fijo(idactivofijo);
            tangibledao.eliminar(listadepreciable);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosTangibles.xhtml";
    }

    public String regresar() {
        return "ActivosTangibles.xhtml";
    }

    public void obtenerdatos(ListaDepreciable lista) {
        this.listadepreciable = lista;
        idactivofijo = lista.getId_activo_fijo();
        System.out.println("Id obtenido de activo: " + lista.getId_activo_fijo());
        System.out.println("Id obtenido de empresa: " + lista.getId_empresa());

    }

    public void obtenerdatosNodepreciables(ListaNoDepreciable listanp) {
        this.listanodepreciable = listanp;
        idactivofijo = listanp.getId_activo_fijo();
        System.out.println("Id obtenido de activo: " + listanp.getId_activo_fijo());
        System.out.println("Id obtenido de empresa: " + listanp.getId_empresa());

    }

    public void obtenerdatosAgotables(ListaAgotable listaago) {
        this.listaragotables = listaago;
        idactivofijo = listaago.getId_activo_fijo();
        System.out.println("Id obtenido de activo: " + listaago.getId_activo_fijo());
        System.out.println("Id obtenido de empresa: " + listaago.getId_empresa());

    }

    public String setRegistrarNoDepreciable() {
        String data = "";
        NoDepreciableDAO nodepreciable = new NoDepreciableDAO();
        try {
            nodepreciable.guardar1(activosFijos, activoNoDepreciable);
            System.out.println("Registrado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data + "se ingreso no depreciable");
        return "ActivosTangibles.xhtml";
    }

    public String setRegistrarAgotables() {
        String data = "";
        AgotableDAO tangibleDAO = new AgotableDAO();
        try {
            agotablesdao.guardar2(activosFijos, activosagotables);
            System.out.println("Registrado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data + "se ingreso no depreciable");
        return "ActivosTangibles.xhtml";
    }

    public String setDeshabilitarintangible() {
        String data = "";
        TangibleDAO tangibleDAO = new TangibleDAO();
        try {
            activodepreciable.setId_activo_fijo(idactivofijo);
            tangibleDAO.deshabilitartangible(listadepreciable);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosTangibles.xhtml";
    }
    
    public String setDeshabilitarnodepreciable() {
        String data = "";
        NoDepreciableDAO nodepreciabledao = new NoDepreciableDAO();
        try {
            activoNoDepreciable.setId_activo_fijo(idactivofijo);
            nodepreciabledao.deshabilitarnoDepreciable(listanodepreciable);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosTangibles.xhtml";
    }
        public String setDeshabilitaragotable() {
        String data = "";
        try {
            activosagotables.setId_activo_fijo(idactivofijo);
            agotablesdao.deshabilitarnoagotable(listaragotables);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosTangibles.xhtml";
    }
    

    public String setHabilitarintangible(int id) {
        String data = "";

        try {
            activodepreciable.setId_activo_fijo(id);
            tangibleDAO.habilitardepreciable(activodepreciable);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosTangibles.xhtml";
    }
    public String setHabilitarintangibleNoDepreciable(int id) {
        String data = "";
       
        try {
            activoNoDepreciable.setId_activo_fijo(id);
            nodepreciabledao.habilitarnoDepreciable(activoNoDepreciable);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosTangibles.xhtml";
    }
    public String setHabilitarintangibleAgotables(int id) {
        String data = "";
       
        try {
            activosagotables.setId_activo_fijo(id);
            agotablesdao.habilitarnoAgotable(activosagotables);
            System.out.println("Actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(data);
        return "ActivosTangibles.xhtml";
    }
}
