package com.contabilidad.controllers;

import com.contabilidad.dao.AsientoDAO;
import com.contabilidad.dao.DiarioDAO;
import com.contabilidad.models.Asiento;
import com.contabilidad.models.Diario;
import com.contabilidad.models.Movimiento;
import com.contabilidad.models.SubCuenta;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

@Named
@SessionScoped
public class AsientoManagedBean implements Serializable {

    private List<Asiento> asientos;
    private Asiento currentAsiento;
    private AsientoDAO asientoDAO = new AsientoDAO();
    private Date fechaCreacion;
    private Date fechaCierre;
    private List<SubCuenta> subCuentas = new ArrayList<>();
    private DiarioDAO diarioAccess = new DiarioDAO();
    private Movimiento selectedMovimiento;
    private double totalDebe;
    private double totalHaber;
    List<Diario> diarios = new ArrayList<>();

    @PostConstruct
    public void main() {
        asientos = new ArrayList<>();
        currentAsiento = new Asiento();
        asientos = asientoDAO.getAsientosContables();
        subCuentas = asientoDAO.getCuentasContables();
        openNewAsiento();
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void setMovimientos() {
        currentAsiento.setMovimientos(asientoDAO.getMovimientoByAsiento(0));
    }

    public void showInfo(String message) {
        addMessage(FacesMessage.SEVERITY_INFO, "Exito", message);
    }

    public void showWarn(String message) {
        addMessage(FacesMessage.SEVERITY_ERROR, "Advertencia", message);
    }

    public void newAsientoContable() {
        if (currentAsiento.getIdAsiento() == 0) {
            if (!currentAsiento.getDocumento().isEmpty() && !currentAsiento.getDetalle().isEmpty()
                    && currentAsiento.getFechaCreacion() != null && currentAsiento.getFechaCierre() != null
                    && currentAsiento.getMovimientos().size() > 0) {
                if (totalDebe == totalHaber && totalDebe != 0 && totalHaber != 0) {
                    currentAsiento.setTotal(Double.toString(totalDebe));
                    asientoDAO.addAsientoContable(currentAsiento);
                    currentAsiento = new Asiento();
                    fechaCreacion = new Date();
                    fechaCierre = new Date();
                    asientos = asientoDAO.getAsientosContables();
                    showInfo("Se ha registrado un nuevo Asiento");
                    openNewAsiento();
                }else {
                    showWarn("Los valores del debe y el haber deben coincidir, y ser diferentes a cero");
                }

            } else {
                showWarn("Uno o mas datos no han sido registrados");
            }
        } else {
            if (totalDebe == totalHaber) {
                currentAsiento.setTotal(Double.toString(totalDebe));
                asientoDAO.editAsientoContable(currentAsiento, currentAsiento.getIdAsiento());
                showInfo("Cambios Realizados Correctamente");
                openNewAsiento();
            } else {
                showWarn("Los valores totales deben Coincidir");
            }
        }
    }

    public String nombreCuenta(Movimiento movimiento) {
        SubCuenta cuenta = asientoDAO.getCuentaByID(movimiento.getIdSubcuenta());
        String codigo = cuenta.getCodigo();
        String nombre = cuenta.getNombre();
        return codigo + " " + nombre;
    }

    public void openNewAsiento() {
        currentAsiento = new Asiento();
        String numero = "ASC-0" + (asientoDAO.getCountAsientos() + 1);
        currentAsiento.setNumero(numero);
        currentAsiento.setMovimientos(new ArrayList<>());
        diarios = diarioAccess.getDiariosContables();
        totalDebe = 0;
        totalHaber = 0;
    }

    public void onFechaCreacionSelected(SelectEvent<Date> event) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String date = format.format(event.getObject());
        try {
            Date fechaCre = format.parse(date);
            this.currentAsiento.setFechaCreacion(fechaCre);
        } catch (Exception e) {

        }
    }

    public void onFechaCierreSelected(SelectEvent<Date> event) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String date = format.format(event.getObject());
        try {
            Date fechaCierr = format.parse(date);
            this.currentAsiento.setFechaCierre(fechaCierr);
        } catch (Exception e) {

        }
    }

    public void updateTotalDebe() {
        double td = 0;
        for (int i = 0; i < currentAsiento.getMovimientos().size(); i++) {
            td += currentAsiento.getMovimientos().get(i).getDebe();
        }
        totalDebe = td;
    }

    public void updateTotalHaber() {
        double th = 0;
        for (int i = 0; i < currentAsiento.getMovimientos().size(); i++) {
            th += currentAsiento.getMovimientos().get(i).getHaber();
        }
        totalHaber = th;
    }

    public void cleanNotChangeAsientos() {
        currentAsiento.getMovimientos().forEach((m) -> {
            if (m.getIdMovimiento() == 0) {
                currentAsiento.getMovimientos().remove(m);
            }
        });
    }

    public void addNewFila() {
        Movimiento movimiento = new Movimiento();
        movimiento.setIdMovimiento(0);
        currentAsiento.getMovimientos().add(movimiento);
        updateTotalDebe();
        updateTotalHaber();
    }

    public void deleteFila() {
        currentAsiento.getMovimientos().remove(this.selectedMovimiento);
        updateTotalDebe();
        updateTotalHaber();
    }

    public void calculateTotal() {
        updateTotalDebe();
        updateTotalHaber();
    }

    public void onLineaEdit(RowEditEvent<Movimiento> event) {

    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public Asiento getCurrentAsiento() {
        return currentAsiento;
    }

    public void setCurrentAsiento(Asiento currentAsiento) {
        this.currentAsiento = currentAsiento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public List<SubCuenta> getSubCuentas() {
        return subCuentas;
    }

    public void setSubCuentas(List<SubCuenta> subCuentas) {
        this.subCuentas = subCuentas;
    }

    public double getTotalDebe() {
        return totalDebe;
    }

    public void setTotalDebe(double totalDebe) {
        this.totalDebe = totalDebe;
    }

    public double getTotalHaber() {
        return totalHaber;
    }

    public void setTotalHaber(double totalHaber) {
        this.totalHaber = totalHaber;
    }

    public Movimiento getSelectedMovimiento() {
        return selectedMovimiento;
    }

    public void setSelectedMovimiento(Movimiento selectedMovimiento) {
        this.selectedMovimiento = selectedMovimiento;
    }

    public List<Diario> getDiarios() {
        return diarios;
    }

    public void setDiarios(List<Diario> diarios) {
        this.diarios = diarios;
    }
}
