/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gym;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Michael
 */
public class EscrituraTexto {
    public static void main(String args[])
    {
        
    

   } 
    
public static void Archivo(String Libro){    
      
    
       File f = new File("Pagos.txt");  
        try{
           
        FileWriter fw = new FileWriter(f,true); //si append es false, sobreeescribe, si es true entonce agrega
        PrintWriter out = new PrintWriter(fw);
    
            out.println(Libro);
        
        out.flush();
        out.close();
        
        }catch(IOException e)
        {
            e.printStackTrace();
        }
          
          
      }
      
              

}

