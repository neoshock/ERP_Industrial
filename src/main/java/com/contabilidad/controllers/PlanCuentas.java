package com.contabilidad.controllers;

import com.contabilidad.dao.PlanContableDAO;
import com.contabilidad.models.Cuenta;
import com.contabilidad.models.CuentaContable;
import com.contabilidad.models.Grupo;
import com.contabilidad.models.SubCuenta;
import com.contabilidad.models.SubGrupo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class PlanCuentas implements Serializable {

    private List<CuentaContable> cuentasContables;
    private List<Grupo> grupos;
    private List<SubGrupo> subgrupos;
    private List<Cuenta> cuentas;
    private CuentaContable cuenta;

    private String onSeletedGrupo;
    private String onSeletedSubgrupo;
    private String onSeletedCuenta;
    private String onSeletedSaldo;

    private SubGrupo subGrupo;
    private SubCuenta subCuenta;
    private PlanContableDAO contableDAO;
    private String codigo;

    public PlanCuentas() {
        cuentasContables = new ArrayList<>();
        grupos = new ArrayList<>();
        subgrupos = new ArrayList<>();
        cuentas = new ArrayList<>();
        contableDAO = new PlanContableDAO();
        subCuenta = new SubCuenta();
    }

    @PostConstruct
    public void init() {
        cuentasContables = contableDAO.getSubCuentas();
        grupos = contableDAO.getGrupos();
        subCuenta = new SubCuenta();
    }

    public void onGrupoChange() {
        if (onSeletedGrupo != null) {
            codigo = onSeletedGrupo;
            subgrupos = contableDAO.getSubGrupos(codigo);
        } else {
            codigo = "0";
        }
    }

    public void onSubGrupoChange() {
        if (onSeletedSubgrupo != null) {
            codigo = onSeletedSubgrupo;
            cuentas = contableDAO.getCuentas(codigo.substring(2));
        } else {
            codigo = "0";
        }
    }

    public void onCuentaChange() {
        if (onSeletedCuenta != null) {
            codigo = onSeletedCuenta.trim();
            int plus = contableDAO.getCountSubCuentas(codigo.substring(4)) + 1;
            codigo = codigo + "." + plus;
            //cuentas = contableDAO.getCuentas(codigo.substring(2));
        } else {
            codigo = "0";
        }
    }

    public void registrarSubCuenta() {
        if (!subCuenta.getNombre().isEmpty() && !subCuenta.getTipo().isEmpty()) {
            String cuentaCodigo = onSeletedCuenta.trim().substring(4);
            subCuenta.setCodigo(codigo);
            subCuenta.setCuenta(Integer.parseInt(cuentaCodigo));
            contableDAO.insertSubCuenta(subCuenta);
            subCuenta = new SubCuenta();
            codigo = "";
            onSeletedGrupo = "";
            subgrupos = new ArrayList<>();
            cuentas = new ArrayList<>();
            cuentasContables = contableDAO.getSubCuentas();
            showInfo("Se ha registrado la cuenta");
        } else {
            showWarn("Faltan rellenar campos");
        }
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo(String message) {
        addMessage(FacesMessage.SEVERITY_INFO, "Exito", message);
    }

    public void showWarn(String message) {
        addMessage(FacesMessage.SEVERITY_WARN, "Advertencia", message);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<CuentaContable> getCuentasContables() {
        return cuentasContables;
    }

    public void setCuentasContables(List<CuentaContable> cuentasContables) {
        this.cuentasContables = cuentasContables;
    }

    public CuentaContable getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaContable cuenta) {
        this.cuenta = cuenta;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public String getOnSeletedGrupo() {
        return onSeletedGrupo;
    }

    public void setOnSeletedGrupo(String onSeletedGrupo) {
        this.onSeletedGrupo = onSeletedGrupo;
    }

    public List<SubGrupo> getSubgrupos() {
        return subgrupos;
    }

    public void setSubgrupos(List<SubGrupo> subgrupos) {
        this.subgrupos = subgrupos;
    }

    public SubGrupo getSubGrupo() {
        return subGrupo;
    }

    public void setSubGrupo(SubGrupo subGrupo) {
        this.subGrupo = subGrupo;
    }

    public String getOnSeletedSubgrupo() {
        return onSeletedSubgrupo;
    }

    public void setOnSeletedSubgrupo(String onSeletedSubgrupo) {
        this.onSeletedSubgrupo = onSeletedSubgrupo;
    }

    public String getOnSeletedCuenta() {
        return onSeletedCuenta;
    }

    public void setOnSeletedCuenta(String onSeletedCuenta) {
        this.onSeletedCuenta = onSeletedCuenta;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public String getOnSeletedSaldo() {
        return onSeletedSaldo;
    }

    public void setOnSeletedSaldo(String onSeletedSaldo) {
        this.onSeletedSaldo = onSeletedSaldo;
    }

    public SubCuenta getSubCuenta() {
        return subCuenta;
    }

    public void setSubCuenta(SubCuenta subCuenta) {
        this.subCuenta = subCuenta;
    }

}
