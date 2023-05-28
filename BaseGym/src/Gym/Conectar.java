/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Conectar {
   Connection cn;
   Statement st;
      
    public Connection Conexion(){
      //localhost:1433;databaseName=Gym;
//      //localhost:3306/zapateria"
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://" + CfgPrm.direccionIP + "/" + CfgPrm.nombreBD, CfgPrm.usuarioBD, CfgPrm.pwsBD);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return cn;
    }
    }


//jdbc:sqlserver://localhost:1433;databaseName=Gym;integratedSecurity=true
