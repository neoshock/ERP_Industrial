/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataView;

import Model.ListaPeriodosActivosFijos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author desta
 */
public class PeriodosActivosFijosDAO {
    
    
    public List<ListaPeriodosActivosFijos> listarperiodosactivofijo() throws Exception {
        List<ListaPeriodosActivosFijos> listperiodo = new ArrayList<>();
        Conexion conexion = new Conexion();
        System.out.println("Conectado a la db");
        try {
            conexion.abrirConexion();
            // Consulta.
            PreparedStatement st = conexion.conex.prepareStatement(
                    "select CAST (periodos.anio AS INT),\n" +
"(select sum (valor_adquisicion) from activos_fijos where date_part('year',fecha_adquisicion) =periodos.anio) as monto_total,\n" +
"concat('01-01-',periodos.anio) as inicio, concat('31-12-',periodos.anio ) as fin \n" +
"from (select distinct date_part('year',fecha_adquisicion) as anio from activos_fijos  where estado='habilitado'\n" +
"	  order by anio) as periodos;");
            // Ejecución
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ListaPeriodosActivosFijos listarperiodosactivosfijos = new ListaPeriodosActivosFijos(
                        rs.getInt("anio"),
                        rs.getInt("monto_total"),
                        rs.getString("inicio"),
                        rs.getString("fin")
                );
                listperiodo.add(listarperiodosactivosfijos);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            conexion.cerrarConexion();
        }

        return listperiodo;
    }
    
}
