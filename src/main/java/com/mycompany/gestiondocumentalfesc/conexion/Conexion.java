
package com.mycompany.gestiondocumentalfesc.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    public Connection conectar=null;
    
    public Connection conectar() {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           
           conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_gestiondocumental","root","");
           
           System.out.println("\nConexion establecida");
       
       } catch (ClassNotFoundException | SQLException e){
           
           System.err.println("No se establecio la conexion");
       }
       
       return conectar;
   }
}
