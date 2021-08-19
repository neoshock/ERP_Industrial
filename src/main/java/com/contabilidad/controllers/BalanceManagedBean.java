package com.contabilidad.controllers;

import com.contabilidad.dao.ImformeContableDAO;
import com.contabilidad.models.BalanceGeneral;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class BalanceManagedBean implements Serializable{
    
    private List<BalanceGeneral> balances;
    private ImformeContableDAO imformeContableDAO = new ImformeContableDAO();
    
    @PostConstruct
    public void mainBalanceSituacional() {
        //balances = imformeContableDAO.getInformeBalanceGeneral();
    }
    
    public double calculateSaldo(String nombre){ 
        double saldo = 0; 
        for(BalanceGeneral item : balances){
            if(item.getNombre().equals(nombre)){
                saldo += item.getSaldo();
            }
        }
        return saldo;
    }

    public List<BalanceGeneral> getBalances() {
        return balances;
    }

    public void setBalances(List<BalanceGeneral> balances) {
        this.balances = balances;
    }
    

}
