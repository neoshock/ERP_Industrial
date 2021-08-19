/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataView.PeriodosActivosFijosDAO;
import Model.ListaPeriodosActivosFijos;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import net.sf.jasperreports.engine.JRException;
import org.primefaces.PrimeFaces;

/**
 *
 * @author desta
 */
@ManagedBean(name = "periodosactivosfijosMB")
@ViewScoped
public class PeriodosActivosFijosMB implements Serializable {
    
    ListaPeriodosActivosFijos ListaPeriodosActivosFijos= new ListaPeriodosActivosFijos();
    PeriodosActivosFijosDAO periodosactivosfijosdao =new PeriodosActivosFijosDAO();

    public PeriodosActivosFijosMB() {
    }

    
    public ListaPeriodosActivosFijos getListaPeriodosActivosFijos() {
        return ListaPeriodosActivosFijos;
    }

    public void setListaPeriodosActivosFijos(ListaPeriodosActivosFijos ListaPeriodosActivosFijos) {
        this.ListaPeriodosActivosFijos = ListaPeriodosActivosFijos;
    }

    public PeriodosActivosFijosDAO getPeriodosactivosfijosdao() {
        return periodosactivosfijosdao;
    }

    public void setPeriodosactivosfijosdao(PeriodosActivosFijosDAO periodosactivosfijosdao) {
        this.periodosactivosfijosdao = periodosactivosfijosdao;
    }
    
    
        // Metodo funcional para exportar pdf
    public void exportpdf(int anio) throws IOException, JRException {

        //RequestContext requestContext = RequestContext.getCurrentInstance();
        //requestContext.execute("window.print();");
        PrimeFaces.current().executeScript("reportebalanceactivosfijos("+anio+");");
    }
    
    
}
