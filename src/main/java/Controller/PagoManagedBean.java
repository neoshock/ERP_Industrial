/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataView.PagoDAO;
import Model.Pago;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


/**
 *
 * @author PAOLA
 */
@ManagedBean(name = "pagoMB")
@ViewScoped
public class PagoManagedBean implements Serializable{
    private Pago pago;
    private PagoDAO pagoDAO;
    private List<Pago> pagos;
    
    public PagoManagedBean() {
        pago = new Pago();
        pagos = new ArrayList<>();
        pagoDAO = new PagoDAO();
     
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public PagoDAO getPagoDAO() {
        return pagoDAO;
    }

    public void setPagoDAO(PagoDAO pagoDAO) {
        this.pagoDAO = pagoDAO;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

}
