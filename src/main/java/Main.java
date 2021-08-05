
import com.contabilidad.dao.AsientoDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pideu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AsientoDAO asientos = new AsientoDAO();
        String nombre = asientos.getCuentasContables().get(0).getNombre();
        System.out.println(nombre);
    }
    
}
