/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.Date;
/**
 *
 * @author PAOLA
 */
public class Pago {
    private int idPago;
    private int idProveedor;
    private int idTipoPago;
    private int Referencia;
    private int Banco;
    private int Importe;
    private Date fechaPago;
    private int periodo;
    private int resgitrado;

    

    public Pago() {
    }
    
    public Pago(int idPago, int idProveedor, int idTipoPago, int Referencia, int Banco, int Importe, Date fechaPago, int periodo, int resgitrado) {
        this.idPago = idPago;
        this.idProveedor = idProveedor;
        this.idTipoPago = idTipoPago;
        this.Referencia = Referencia;
        this.Banco = Banco;
        this.Importe = Importe;
        this.fechaPago = fechaPago;
        this.periodo = periodo;
        this.resgitrado = resgitrado;
    }
   
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public int getReferencia() {
        return Referencia;
    }

    public void setReferencia(int Referencia) {
        this.Referencia = Referencia;
    }

    public int getBanco() {
        return Banco;
    }

    public void setBanco(int Banco) {
        this.Banco = Banco;
    }

    public int getImporte() {
        return Importe;
    }

    public void setImporte(int Importe) {
        this.Importe = Importe;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getResgitrado() {
        return resgitrado;
    }

    public void setResgitrado(int resgitrado) {
        this.resgitrado = resgitrado;
    }
    
    
}
