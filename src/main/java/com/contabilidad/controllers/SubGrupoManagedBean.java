
package com.contabilidad.controllers;

import com.contabilidad.dao.GrupoDAO;
import com.contabilidad.dao.SubGrupoDAO;
import com.contabilidad.models.Grupo;
import com.contabilidad.models.SubGrupo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.PrimeFaces;

@Named(value = "subGrupoMB")
@RequestScoped
public class SubGrupoManagedBean {
    private SubGrupoDAO subGrupoDAO;
    private List<SubGrupo> listaSubGrupos;
    private SubGrupo subGrupo;
    private String action;
    
    private GrupoDAO grupoDAO;
    private List<Grupo> listaGrupos;

    public SubGrupoManagedBean() {
        subGrupoDAO = new SubGrupoDAO();
        listaSubGrupos = new ArrayList<>();
        subGrupo = new SubGrupo();
    }
    
    @PostConstruct
    public void init() {
        listaSubGrupos = subGrupoDAO.getSubGrupos();
    }

    public List<SubGrupo> getListaSubGrupos() {
        return listaSubGrupos;
    }

    public void setListaSubGrupos(List<SubGrupo> listaSubGrupos) {
        this.listaSubGrupos = listaSubGrupos;
    }
    
    public void form(boolean editable) {
        if (!editable) {
            subGrupo = new SubGrupo();
//            int codigo = subGrupoDAO.getUltimoCodigo();
//            if (codigo > 0) {
//                subGrupo.setCodigo(""+(codigo + 1));
//            }
        }
        PrimeFaces.current().executeScript("PF('dialogFormSubGrupo').show();");
    }

    public SubGrupo getSubGrupo() {
        return subGrupo;
    }

    public void setSubGrupo(SubGrupo subGrupo) {
        this.subGrupo = subGrupo;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
