/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataView;

import Model.Pago;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PAOLA
 */
public class PagoDAO {

    private Pago pago;
    private List<Pago> listaPago;

    public PagoDAO() {
        listaPago= new ArrayList<>();
    }

    public PagoDAO(Pago pago, List<Pago> listaPago) {
        this.pago = pago;
        this.listaPago = listaPago;
    }

    public List<Pago> llenar(List<Pago> lista) {
        int cantLista= lista.size();
        for(int i=0; cantLista<i;i++) {
            listaPago.add(new Pago(pago.getIdPago(),pago.getIdProveedor(),
                    pago.getIdTipoPago(),pago.getReferencia(),
                    pago.getBanco(),pago.getImporte(),pago.getFechaPago(),
                    pago.getPeriodo(),pago.getResgitrado()));
        }
        return listaPago;
    }
}
