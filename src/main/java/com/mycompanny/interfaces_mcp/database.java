/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompanny.interfaces_mcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author elect
 */
// Patron de diseño singleton, para la conexión de la db
public class database {
    
    private static database instancia = null;
    private Connection connection;
    
    public database() { 
        String url = "jdbc:postgresql://localhost:5432/gobierno";        
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, "postgres", "123456");
        } catch(SQLException ex) {
            System.out.println("Error al connectar: " + ex.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe.getMessage());
        }
    }

    
    // Retornamos la instancia de database, si esta null, que lo instancie.
    public static database getInstancia() {
        if (instancia == null) {
            instancia = new database();
        }
        return instancia;
    }

    public void setInstancia(database instancia) {
        database.instancia = instancia;
    }
    
    public String getPersonas() {
        ResultSet rs = null;
        PreparedStatement pst = null;
        
        String consulString = "SELECT idpersona, nombre, apellido, email, password, profesion FROM public.\"Personas\" ";
        try {
            pst = this.connection.prepareStatement(consulString);
            pst.execute();
            rs = pst.getResultSet();
            
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return "ok, todo esta bien";
    }
    
    public String nombre() { return "Roberto"; }
}
