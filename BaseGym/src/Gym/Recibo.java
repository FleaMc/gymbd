/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Gym;

import static Gym.EscrituraTexto.Archivo;
import java.util.Scanner;
import java.io.Console;

/**
 *
 * @author Michael
 */
public class Recibo {

    static String cliente = "";
    static int pago = 0;
    static int cant = 0;
    static String fechas = "";

    public void setFechas(String fechas) {
        Recibo.fechas = fechas;
    }
    
    public void setCant(int cant) {
        Recibo.cant = cant;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public static void main(String[] args) {

     

    }
    public void datos(){
        String Pago = "";
        pago=cant*250;
        Pago += "************  \n";
        Pago += "************  \n";
        Pago += "************  \n";
        Pago += "Cliente: " + cliente +"\n";
        Pago += "Importe: " + pago;
        Pago += "\n";
        Pago += fechas+ "\n" ;
        Pago += "************  \n";
        Pago += "************  \n";
        Pago += "************  \n";
        Archivo(Pago);
        
        
    }
}
