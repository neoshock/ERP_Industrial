
import com.contabilidad.dao.BalanceGeneralDAO;
import com.contabilidad.dao.PlanContableDAO;
import com.contabilidad.models.BalanceGeneral;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;

public class Main {

    public static void main(String[] args) {
        PlanContableDAO contableDAO = new PlanContableDAO();
        
        contableDAO.getSubCuentas();
    }

}
