/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataView;

import Model.ActivoIntangible;
import Model.ActivosFijos;
import Model.ListarIntangible;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author desta
 */
public class IntangibleDAO {

        public boolean guardar3(ActivosFijos activosFijos, ActivoIntangible activointangible) throws SQLException {

        Conexion conexion = new Conexion();
       String consulta = String.format("INSERT INTO activos_fijos(\n"
                + "	detalle_de_activo,  valor_adquisicion, fecha_adquisicion,proveedor,numero_factura,estado)\n"
                + "	VALUES ('%s', '%s', '%s', '%s', '%s','habilitado')returning id_activo_fijo;", activosFijos.getDetalle_de_activo(),
                activosFijos.getValor_adquisicion(), activosFijos.getFecha_adquisicion(), activosFijos.getProveedor(), activosFijos.getNumero_factura());
        String idactivofijo = conexion.obtenerValor(consulta, 1);
        String consulta2 = String.format("INSERT INTO public.fijo_intangible(\n"
                + "	 id_activo_fijo)\n"
                + "	VALUES ('%s');", idactivofijo);
        conexion.ejecutar(consulta2);
        System.out.println(consulta + "\n" + consulta2);
        return true;
    }

    public List<ListarIntangible> listaragotables() throws Exception {
        List<ListarIntangible> listInta = new ArrayList<>();
        Conexion conexion = new Conexion();
        System.out.println("Conectado a la db");
        try {
            conexion.abrirConexion();
            // Consulta.
            PreparedStatement st = conexion.conex.prepareStatement(
                    "Select *from activos_fijos inner join fijo_intangible \n"
                    + "on fijo_intangible.id_activo_fijo = activos_fijos.id_activo_fijo where estado='habilitado';");
            // Ejecución
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ListarIntangible listaintangible = new ListarIntangible(
                        rs.getInt("id_activo_fijo"),
                        rs.getString("detalle_de_activo"),
                        rs.getInt("valor_adquisicion"),
                        rs.getObject("fecha_adquisicion", LocalDate.class),
                        rs.getInt("id_empresa"),
                        rs.getInt("id_intangible"),
                        rs.getString("proveedor"),
                        rs.getString("numero_factura")
                );
                listInta.add(listaintangible);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            conexion.cerrarConexion();
        }

        return listInta;
    }

    public List<ListarIntangible> listaragotablesdeshabilitados() throws Exception {
        List<ListarIntangible> listInta = new ArrayList<>();
        Conexion conexion = new Conexion();
        System.out.println("Conectado a la db");
        try {
            conexion.abrirConexion();
            // Consulta.
            PreparedStatement st = conexion.conex.prepareStatement(
                    "Select *from activos_fijos inner join fijo_intangible \n"
                    + "on fijo_intangible.id_activo_fijo = activos_fijos.id_activo_fijo where estado='deshabilitado';");
            // Ejecución
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ListarIntangible listaintangible = new ListarIntangible(
                        rs.getInt("id_activo_fijo"),
                        rs.getString("detalle_de_activo"),
                        rs.getInt("valor_adquisicion"),
                        rs.getObject("fecha_adquisicion", LocalDate.class),
                        rs.getInt("id_empresa"),
                        rs.getInt("id_intangible"),
                        rs.getString("proveedor"),
                        rs.getString("numero_factura")
                );
                listInta.add(listaintangible);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            conexion.cerrarConexion();
        }

        return listInta;
    }

    public boolean editar2(ListarIntangible li) throws SQLException {

        Conexion conexion = new Conexion();
        String consulta = String.format("UPDATE public.activos_fijos\n"
                + "	SET detalle_de_activo='%s', valor_adquisicion='%s', fecha_adquisicion='%s',   proveedor='%s', numero_factura='%s'\n"
                + "	WHERE id_activo_fijo='%s';", li.getDetalle_de_activo(), li.getValor_adquisicion(),
                li.getFecha_adquisicion(), li.getProveedor(), li.getNumero_factura(), li.getId_activo_fijo());
        //String idactivofijo = conexion.obtenerValor(consulta, 1);
        conexion.ejecutar(consulta);
        System.out.println("update 1: " + consulta);
        return true;
    }

    public boolean deshabilitarintangible(ListarIntangible li) throws SQLException {

        Conexion conexion = new Conexion();
        String consulta = String.format("UPDATE public.activos_fijos\n"
                + "	SET  estado='deshabilitado'\n"
                + "	WHERE id_activo_fijo='%s';", li.getId_activo_fijo());
        //String idactivofijo = conexion.obtenerValor(consulta, 1);
        conexion.ejecutar(consulta);
        System.out.println("update 1: " + consulta);
        return true;
    }

    public boolean habilitarintangible(ActivoIntangible li) throws SQLException {

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
