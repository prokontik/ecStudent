/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ec.estudent.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import net.sourceforge.jtds.jdbc.Driver;  
import java.util.Properties;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
public class Database {
 
    
    private static String databaseurl = "";
    private static String jasperurl = "";
    
    
    public static String getDatabaseurl()
    {
    if (databaseurl=="")
            {
                
            try {    
            FacesContext context = FacesContext.getCurrentInstance();
ExternalContext externalContext = context.getExternalContext();
              //databaseurl = 
//ServletContext sc = (ServletContext)externalContext.getContext();
            
            
            Properties properties = new Properties();
            properties.load(externalContext.getResourceAsStream("/WEB-INF/app.properties"));     
            databaseurl = properties.getProperty("databaseurl");
            System.out.println("DatabaseURL: " + databaseurl);
            }
            catch (IOException ex) {
            System.out.println("Error in app.prop() -->" + ex.getMessage());
            }

    }            
        return databaseurl;

    }
    
     public static String getJasperurl()
    {
    if (jasperurl=="")
            {
                
            try {    
            FacesContext context = FacesContext.getCurrentInstance();
ExternalContext externalContext = context.getExternalContext();
              //databaseurl = 
//ServletContext sc = (ServletContext)externalContext.getContext();
            
            
            Properties properties = new Properties();
            properties.load(externalContext.getResourceAsStream("/WEB-INF/app.properties"));     
            jasperurl = properties.getProperty("jasperurl");
            System.out.println("JasperURL: " + jasperurl);
            }
            catch (IOException ex) {
            System.out.println("Error in app.prop() -->" + ex.getMessage());
            }

    }            
        return jasperurl;

    }  
    
          
//    public void setDatabaseurl (String databaseurl) {
//        this.databaseurl = databaseurl;
//    }
    
    
    
    
    
    public static Connection getConnection() {
      
            try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            
            
            FacesContext context = FacesContext.getCurrentInstance();
ExternalContext externalContext = context.getExternalContext();
//ServletContext sc = (ServletContext)externalContext.getContext();
            
            
            Properties properties = new Properties();

            properties.load(externalContext.getResourceAsStream("/WEB-INF/app.properties"));
  
            Connection con = DriverManager.getConnection(databaseurl,
                    "sa", "test");
            
//            Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1434/eStudent",
//                    "sa", "test");
            return con;

        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbname",
//                    "root", "dbpass");
//            return con;
//        } catch (Exception ex) {
//            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
//            return null;
//        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}