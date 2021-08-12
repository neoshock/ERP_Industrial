
package com.contabilidad.controllers;

import com.contabilidad.dao.CuentaDAO;
import com.contabilidad.models.Cuenta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named(value = "cuentaMB")
@RequestScoped
public class CuentaManagedBean {
    private CuentaDAO cuentaDAO;
    private List<Cuenta> listaCuentas;
            
    public CuentaManagedBean() {
        cuentaDAO = new CuentaDAO();
        listaCuentas = new ArrayList<>();
    }
    
    @PostConstruct
    public void init() {
        listaCuentas = cuentaDAO.getCuentas();
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
    
    public void form() {
        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", false);
        PrimeFaces.current().dialog().openDynamic("dialogAgregarCuenta", options, null);
    }
}
