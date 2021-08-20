
import com.contabilidad.dao.AsientoDAO;
import com.contabilidad.dao.BalanceGeneralDAO;
import com.contabilidad.dao.Conexion;
import com.contabilidad.dao.PlanContableDAO;
import com.contabilidad.models.BalanceGeneral;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;

public class Main {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.conectar();
        AsientoDAO asientoDAO = new AsientoDAO();
        asientoDAO.getAsientosContables().forEach(a -> System.out.println(a.getNumero()));
                
    }

}
