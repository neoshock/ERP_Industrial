
package com.contabilidad.controllers;

import com.contabilidad.models.Cuenta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PlanCuentas implements Serializable {
    private List<Cuenta> cuentas;
    private Cuenta cuenta;

    public PlanCuentas() {
        cuentas = new ArrayList<>();
    }
    
    @PostConstruct
    public void init() {
        cuentas.add(new Cuenta(
                "1.1.1.1", "Activo", "Activos corrientes", 
                "Efectivo y sus equivalentes", "Caja"));
        cuentas.add(new Cuenta(
                "1.1.1.2", "Activo", "Activos corrientes", 
                "Efectivo y sus equivalentes", "Caja chica"));
        cuentas.add(new Cuenta(
                "1.1.1.3", "Activo", "Activos corrientes", 
                "Efectivo y sus equivalentes", "Bancos"));
        cuentas.add(new Cuenta(
                "1.1.2.1", "Activo", "Activos corrientes", 
                "Activos Financieros", "Inversiones financieras corto plazo"));
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
