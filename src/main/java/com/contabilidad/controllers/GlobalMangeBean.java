package com.contabilidad.controllers;

import com.contabilidad.dao.MovimientoDAO;
import com.contabilidad.models.Movimiento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;

@Named
@SessionScoped
public class GlobalMangeBean implements Serializable {

    private MovimientoDAO movimientoDAO;
    private List<Movimiento> movimientos;
    private LineChartModel lineasTendencia;

    @PostConstruct
    public void mainGlobalInitial() {
        movimientoDAO = new MovimientoDAO();
        generateCharMovimiento();
    }

    public void generateCharMovimiento() {
        
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public LineChartModel getLineasTendencia() {
        return lineasTendencia;
    }

    public void setLineasTendencia(LineChartModel lineasTendencia) {
        this.lineasTendencia = lineasTendencia;
    }

}
