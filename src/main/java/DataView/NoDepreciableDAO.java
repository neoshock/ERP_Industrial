/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataView;

import java.sql.SQLException;
import Model.ActivosFijos;
import Model.ActivoNoDepreciable;
import Model.ListaDepreciable;
import Model.ListaNoDepreciable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author desta
 */
public class NoDepreciableDAO {

    public boolean guardar1(ActivosFijos activosFijos, ActivoNoDepreciable activoNoDepreciable) throws SQLException {

        Conexion conexion = new Conexion();
        String consulta = String.format("INSERT INTO activos_fijos(\n"
                + "	detalle_de_activo,  valor_adquisicion, fecha_adquisicion,proveedor,numero_factura,estado)\n"
                + "	VALUES ('%s', '%s', '%s', '%s', '%s','habilitado')returning id_activo_fijo;", activosFijos.getDetalle_de_activo(),
                activosFijos.getValor_adquisicion(), activosFijos.getFecha_adquisicion(), activosFijos.getProveedor(), activosFijos.getNumero_factura());
        String idactivofijo = conexion.obtenerValor(consulta, 1);
        String consulta2 = String.format("INSERT INTO public.fijo_tanginle_no_depreciable(\n"
                + "	 id_activo_fijo,    plusvalia)"
                + "VALUES ( '%s', '%s');", idactivofijo, activoNoDepreciable.getPlusvalia());
        conexion.ejecutar(consulta2);
        String consulta3 = String.format("select *from listarnodepreciables();");
        conexion.ejecutar(consulta3);
        System.out.println(consulta + "\n" + consulta2 + "\n funcion : " + consulta3);
        return true;
    }

    public List<ListaNoDepreciable> ListarNodepreciable() throws Exception {
        List<ListaNoDepreciable> listaNP = new ArrayList<>();
        Conexion conexion = new Conexion();
        System.out.println("Conectado a la db");
        try {
            conexion.abrirConexion();
            // Consulta.
            PreparedStatement st = conexion.conex.prepareStatement(
                    "select *from activos_fijos inner join fijo_tanginle_no_depreciable \n"
                    + "on activos_fijos.id_activo_fijo=fijo_tanginle_no_depreciable.id_activo_fijo where estado='habilitado';");
            // Ejecución
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ListaNoDepreciable listaNoDepreciable = new ListaNoDepreciable(
                        rs.getInt("id_activo_fijo"),
                        rs.getString("detalle_de_activo"),
                        rs.getInt("valor_adquisicion"),
                        rs.getObject("fecha_adquisicion", LocalDate.class),
                        rs.getInt("id_empresa"),
                        rs.getInt("tiempo_amortizacion"),
                        rs.getDouble("porcentaje_amortizacion"),
                        rs.getInt("capitalizacion_meses"),
                        rs.getDouble("revalorizar"),
                        rs.getDouble("plusvalia"),
                        rs.getString("proveedor"),
                        rs.getString("numero_factura")
                );
                listaNP.add(listaNoDepreciable);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            conexion.cerrarConexion();
        }

        return listaNP;
    }

    public List<ListaNoDepreciable> ListarNodepreciableDeshabilitados() throws Exception {
        List<ListaNoDepreciable> listaNP = new ArrayList<>();
        Conexion conexion = new Conexion();
        System.out.println("Conectado a la db");
        try {
            conexion.abrirConexion();
            // Consulta.
            PreparedStatement st = conexion.conex.prepareStatement(
                    "select *from activos_fijos inner join fijo_tanginle_no_depreciable \n"
                    + "on activos_fijos.id_activo_fijo=fijo_tanginle_no_depreciable.id_activo_fijo where estado='deshabilitado';");
            // Ejecución
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ListaNoDepreciable listaNoDepreciable = new ListaNoDepreciable(
                        rs.getInt("id_activo_fijo"),
                        rs.getString("detalle_de_activo"),
                        rs.getInt("valor_adquisicion"),
                        rs.getObject("fecha_adquisicion", LocalDate.class),
                        rs.getInt("id_empresa"),
                        rs.getInt("tiempo_amortizacion"),
                        rs.getDouble("porcentaje_amortizacion"),
                        rs.getInt("capitalizacion_meses"),
                        rs.getDouble("revalorizar"),
                        rs.getDouble("plusvalia"),
                        rs.getString("proveedor"),
                        rs.getString("numero_factura")
                );
                listaNP.add(listaNoDepreciable);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            conexion.cerrarConexion();
        }

        return listaNP;
    }

    public boolean editar1(ListaNoDepreciable li) throws SQLException {

        Conexion conexion = new Conexion();
        String consulta = String.format("UPDATE public.activos_fijos\n"
                + "	SET detalle_de_activo='%s', valor_adquisicion='%s', fecha_adquisicion='%s',   proveedor='%s', numero_factura='%s'\n"
                + "	WHERE id_activo_fijo='%s';", li.getDetalle_de_activo(), li.getValor_adquisicion(),
                li.getFecha_adquisicion(), li.getProveedor(), li.getNumero_factura(), li.getId_activo_fijo());
        //String idactivofijo = conexion.obtenerValor(consulta, 1);
        conexion.ejecutar(consulta);
        String consulta2 = String.format("UPDATE public.fijo_tanginle_no_depreciable\n"
                + "	SET  plusvalia='%s'\n"
                + "	WHERE id_activo_fijo='%s' ;", li.getPlusvalia(), li.getId_activo_fijo());
        conexion.ejecutar(consulta2);
        String consulta3 = String.format("select *from listarnodepreciables();");
        conexion.ejecutar(consulta3);
        System.out.println("update 1: " + consulta + "\n update 2: " + consulta2 + "\n funcion : " + consulta3);
        return true;
    }

    public boolean deshabilitarnoDepreciable(ListaNoDepreciable li) throws SQLException {

        Conexion conexion = new Conexion();
        String consulta = String.format("UPDATE public.activos_fijos\n"
                + "	SET  estado='deshabilitado'\n"
                + "	WHERE id_activo_fijo='%s';", li.getId_activo_fijo());
        //String idactivofijo = conexion.obtenerValor(consulta, 1);
        conexion.ejecutar(consulta);
        System.out.println("update 1: " + consulta);
        return true;
    }
    public boolean habilitarnoDepreciable(ActivoNoDepreciable li) throws SQLException {

        Conexion conexion = new Conexion();
        String consulta = String.format("UPDATE public.activos_fijos\n"
                + "	SET  estado='habilitado'\n"
                + "	WHERE id_activo_fijo='%s';", li.getId_activo_fijo());
        //String idactivofijo = conexion.obtenerValor(consulta, 1);
        conexion.ejecutar(consulta);
        System.out.println("update 1: " + consulta);
        return true;
    }
}
