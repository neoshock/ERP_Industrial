
package com.contabilidad.controllers;

import com.contabilidad.dao.BalanceGeneralDAO;
import com.contabilidad.models.BalanceGeneral;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@Named(value = "balanceGeneralMB")
@SessionScoped
public class BalanceGeneralManagedBean implements Serializable {
    private List<BalanceGeneral> balanceGeneral;
    private BalanceGeneralDAO balanceGeneralDAO;
    
    
    public BalanceGeneralManagedBean() {
        balanceGeneral = new ArrayList<>();
        balanceGeneralDAO = new BalanceGeneralDAO();
    }
    
    @PostConstruct
    public void init() {
        balanceGeneral = balanceGeneralDAO.generateBalanceGeneral();
    }
    
    public boolean getBold(String cuenta) {
        return cuenta.split(" ")[0].length() <= 5;
    }
    
    public double sumaPasivoPatrimonio() {
        return balanceGeneralDAO.sumaPasivoPatrimonio();
    }

    public List<BalanceGeneral> getBalanceGeneral() {
        return balanceGeneral;
    }

    public void setBalanceGeneral(List<BalanceGeneral> balanceGeneral) {
        this.balanceGeneral = balanceGeneral;
    }
    
    
}
