
package DataView;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.swing.table.DefaultTableModel;

public class Conexion {
    ResultSet result;
    String consulta = "nada";
    public Connection conex;
    private java.sql.Statement st;
    private ResultSet lector;
    private boolean estado;
    private String mensaje;
    private FacesMessage.Severity tipoMensaje;
    DefaultTableModel dataModel;
        ResultSetMetaData rsmd;
    /*
"INFO", WARN", "ERROR", "FATAL";
     */
    private String url = "jdbc:postgresql://localhost:5432/ActivosFijos";
    private String usuario = "postgres";
    private String clave = "123456789";
    private String classForName = "org.postgresql.Driver";
     
    //private String url = "jdbc:sqlserver://localhost\\WIN-J31JOLHOPG2\\SQLEXPRESS01:3128;databaseName=VisorPdf";
    /*private String url = "jdbc:sqlserver://localhost\\.:1433;databaseName=VisorPdf";
    private String usuario = "tresp";
    private String clave = "sinClave";
    private String classForName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    */
    public Conexion() {
        estado = true;
    }

    public Conexion(String user, String pass, String url) {
        usuario = user;
        clave = pass;
        this.url = url;
        estado = true;
    }

    public boolean abrirConexion() {
        try {
            if (conex == null || !(conex.isClosed())) {
                Class.forName(classForName);
                conex = DriverManager.getConnection(url, usuario, clave);
                st = conex.createStatement();
                estado = true;
            }
        } catch (ClassNotFoundException | SQLException exSQL) {
            mensaje = exSQL.getMessage();
            System.out.println(mensaje);
            tipoMensaje = FacesMessage.SEVERITY_FATAL;
            return false;
        }
        return true;
    }

    public void cerrarConexion() {
        try {
            if (conex != null && !conex.isClosed()) {
                conex.close();
                conex = null;
            }
            if (st != null && !st.isClosed()) {
                st.close();
                st = null;
            }
            if (lector != null && !lector.isClosed()) {
                lector.close();
                lector = null;
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
            tipoMensaje = FacesMessage.SEVERITY_FATAL;
            System.out.println("ERROR: " + mensaje);
        }
    }

    public ResultSet ejecutarConsulta(String sql) {
        try {
            if (abrirConexion()) {
                lector = st.executeQuery(sql);
            }
        } catch (SQLException exc) {
            System.out.println(sql);
            mensaje = exc.getMessage();
            tipoMensaje = FacesMessage.SEVERITY_FATAL;
            System.out.println(mensaje);
            cerrarConexion();
        }
        return lector;

    }

    public int ejecutar(String consulta) {
        int retorno = -1;
        try {
            if (abrirConexion()) {
                retorno = st.executeUpdate(consulta);
                mensaje = "Se guardó correctamente : ";
                tipoMensaje = FacesMessage.SEVERITY_INFO;
            }
        } catch (SQLException exc) {
            System.out.println(consulta);
            mensaje = exc.getMessage();
            tipoMensaje = FacesMessage.SEVERITY_FATAL;
            System.out.println(mensaje);
        } finally {
            cerrarConexion();
        }
        return retorno;
    }

    public int insertar(String sql) {
        int retorno = -1;
        try {
            if (abrirConexion()) {
                retorno = st.executeUpdate(sql);
                mensaje = "Se insertó correctamente : ";
                tipoMensaje = FacesMessage.SEVERITY_INFO;
            }
        } catch (SQLException exc) {
            System.out.println(sql);
            mensaje = exc.getMessage();
            tipoMensaje = FacesMessage.SEVERITY_FATAL;
            System.out.println(mensaje);
        } finally {
            cerrarConexion();
        }
        return retorno;
    }

    public int insertar(String tabla, String[] campos, String[] valores) {
        String fields = "", values = "";
        int retorno = -1;
        for (int i = 0; i < campos.length; i++) {
            fields += campos[i] + ", ";
            values += "'" + valores[i] + "', ";
        }
        fields = fields.substring(0, fields.length() - 2);
        values = values.substring(0, values.length() - 2);

        String sentencia = "INSERT INTO " + tabla + " (" + fields + ")\n"
                + "VALUES(" + values + ")";
        System.out.println(sentencia);
        try {
            if (abrirConexion()) {

                retorno = st.executeUpdate(sentencia);
                cerrarConexion();
                mensaje = "Se insertó correctamente : ";
                tipoMensaje = FacesMessage.SEVERITY_INFO;
            }
        } catch (SQLException exc) {
            System.out.println(sentencia);
            mensaje = exc.getMessage();
            tipoMensaje = FacesMessage.SEVERITY_FATAL;
            System.out.println(mensaje);

        } finally {
            cerrarConexion();
        }
        return retorno;
    }

    public int modificar(String tabla, String[] campos, String[] valores, String condicion) {
        String cadena = "";
        int retorno = -1;
        for (int i = 0; i < campos.length; i++) {
            cadena += campos[i] + " = '" + valores[i] + "', ";
        }
        cadena = cadena.substring(0, cadena.length() - 2);

        String sentencia = "UPDATE " + tabla + " \nSET " + cadena + "\nWHERE " + condicion;
        System.out.println(sentencia);
        try {
            if (abrirConexion()) {

                retorno = st.executeUpdate(sentencia);
                cerrarConexion();
                mensaje = "Se modificó correctamente: ";
                tipoMensaje = FacesMessage.SEVERITY_INFO;
            }
        } catch (SQLException exc) {
            System.out.println(cadena);
            mensaje = exc.getMessage();
            tipoMensaje = FacesMessage.SEVERITY_FATAL;
            System.out.println(mensaje);

        } finally {
            cerrarConexion();
        }
        return retorno;
    }

    public int modificar(String sql) {
        int retorno = -1;
        try {
            if (abrirConexion()) {
                retorno = st.executeUpdate(sql);
                cerrarConexion();
                mensaje = "Se insertó correctamente : ";
                tipoMensaje = FacesMessage.SEVERITY_INFO;
            }
        } catch (SQLException exc) {
            System.out.println(sql);
            mensaje = exc.getMessage();
            tipoMensaje = FacesMessage.SEVERITY_FATAL;
            System.out.println(mensaje);
        }
        return retorno;
    }

    public int eliminar(String sql) {
        int retorno = -1;
        try {
            if (abrirConexion()) {
                retorno = st.executeUpdate(sql);
                cerrarConexion();
                mensaje = "Se insertó correctamente : ";
                tipoMensaje = FacesMessage.SEVERITY_INFO;
            }
        } catch (SQLException exc) {
            System.out.println(sql);
            mensaje = exc.getMessage();
            tipoMensaje = FacesMessage.SEVERITY_FATAL;
            System.out.println(mensaje);
        } finally {
            cerrarConexion();
        }
        return retorno;
    }

    public String obtenerValor(String consulta, int indx) {
        String valor = "";
        try {
            if (abrirConexion()) {
                st = conex.createStatement();
                lector = st.executeQuery(consulta);
                if (lector.next()) {
                    valor = lector.getString(indx);
                }
                cerrarConexion();
                mensaje = "Se insertó correctamente : ";
                tipoMensaje = FacesMessage.SEVERITY_INFO;
            }
        } catch (SQLException exc) {
            System.out.println(consulta);
            mensaje = exc.getMessage();
            tipoMensaje = FacesMessage.SEVERITY_FATAL;
            System.out.println(mensaje);

        } finally {
            cerrarConexion();
        }
        return valor;
    }
     public boolean closeResulSet() {
        try {
            result.close();
        } catch (SQLException ex) {
            System.out.println("error in close resulset:" + ex.getMessage());
            return false;
        }
        return true;
    }
    public DefaultTableModel returnRecord(String sentecy) {
        dataModel = new DefaultTableModel();
        if (abrirConexion()) {
            try {
                st = conex.createStatement();
                result = st.executeQuery(sentecy);
                rsmd = result.getMetaData();
                int n = rsmd.getColumnCount();
                for (int i = 1; i <= n; i++) {
                    dataModel.addColumn(rsmd.getColumnName(i));
                }
                String[] row = new String[n];
                while (result.next()) {
                    for (int i = 0; i < n; i++) {
                        row[i] = (result.getString(rsmd.getColumnName(i + 1)) == null) ? "" : result.getString(rsmd.getColumnName(i + 1));
                    }
                    dataModel.addRow(row);
                }
            } catch (Exception exc) {
                System.out.println("Error return Record:" + exc.getMessage());
                dataModel = new DefaultTableModel();
            } finally {
                if (result != null) {
                    closeResulSet();
                }
            };
            cerrarConexion();
        }
        return dataModel;
    }

    public boolean existeRegistro(String consulta) {
        boolean valor = false;
        try {
            if (abrirConexion()) {
                st = conex.createStatement();
                lector = st.executeQuery(consulta);
                valor = lector.next();
            }
        } catch (SQLException exc) {
            System.out.println(consulta);
            mensaje = exc.getMessage();
            tipoMensaje = FacesMessage.SEVERITY_FATAL;
            System.out.println(mensaje);

        } finally {
            cerrarConexion();
        }
        return valor;
    }

    public boolean inyeccionSQL(String user, String pass) {
        return user.contains("'") || pass.contains("'") || user.contains(" or ") || pass.contains(" or ") || user.contains(" and ") || pass.contains(" and ");
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isEstado() {
        return estado;
    }

    public Connection getConexion() {
        return conex;
    }

    public ResultSet getLector() {
        return lector;
    }

    public FacesMessage.Severity getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(FacesMessage.Severity tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }
    public boolean testConection() {
        boolean test = abrirConexion();
        if (test) {
            try {
                conex.close();
            } catch (SQLException ex) {
                System.out.println("error test conection:" + ex.getMessage());
            }
        }
        System.out.println("test:" + test);
        return test;
    }
        public String fillString(String consulta) {
        String a = "";
        if (abrirConexion()) {
            try {
                st = conex.createStatement();
                result = st.executeQuery(consulta);
                while (result.next()) {
                    a = result.getString(1);
                }

            } catch (Exception exc) {
                System.out.println("Error fill string:" + exc.getMessage());
                return "";
            } finally {
                if (result != null) {
                    cerrarConexion();
                }
            };
            cerrarConexion();
        }
        return a == null ? "" : a;
    }
}
