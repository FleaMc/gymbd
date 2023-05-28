/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym;

import java.net.*; // para Socket, ServerSocket, and InetAddress
import java.io.*; // para IOException and Input/OutputStream
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TCPEchoServer {

    private static final int BUFSIZE = 56; // Tamanio del buffer recibido

    public static void main(String[] args) throws IOException {

        PreparedStatement pst;

        int servPort = 1234;

        // Crear el sockert para aceptar peticione de conexion de clientes
        ServerSocket servSock = new ServerSocket(servPort);
        int recvMsgSize;// Tamanio del mensaje recibido
        byte[] receiveBuf = new byte[BUFSIZE]; // Buffer para recepcion

        while (true) { // Ejecutar por siempre, aceptando y sirviendo conecciones
            Socket clntSock = servSock.accept();// Obtener la conexión con el cliente
            SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
            System.out.println("Manejando el cliente de  " + clientAddress);
            InputStream in = clntSock.getInputStream();
            DataInputStream rec = new DataInputStream(clntSock.getInputStream());
            String cadena = rec.readUTF();
            System.out.println(cadena);
            LocalDate fecha = LocalDate.now();
            String[] split = cadena.split(",");
            for (int j = 0; j < split.length; j++) {

                String nombre = split[0];
                String tel = split[1];
                String ent = split[2];
          
                int telefono = Integer.parseInt(tel);
                Connect();
                try {
                    pst = con.prepareStatement("insert into Clientes(Nombre,Telefono,FechaIngreso,Entrenamiento)values(?,?,?,?)");
                    pst.setString(1, nombre);
                    pst.setString(2, "" + telefono);
                    pst.setString(3, "" + fecha);
                    pst.setString(4, "" + ent);
                    int k = pst.executeUpdate();

                    if (k == 1) {
                        System.out.println("Registro recibido");

                    } else {
                        System.out.println("Registro no recibido");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(GymPOO.class.getName()).log(Level.SEVERE, null, ex);
                }

                OutputStream out = clntSock.getOutputStream();

                while ((recvMsgSize = in.read(receiveBuf)) != -1) {

                    out.write(receiveBuf, 0, recvMsgSize);
                    JOptionPane.showMessageDialog(null, "Datos enviados al servidor");

                }
                clntSock.close();

            }
            /* CODIGO NO ALCANZABLE */

        }
    }
    static Connection con;

    public static void Connect() {

        String connection = "jdbc:sqlserver://localhost:1433;databaseName=Gym;integratedSecurity=true";

        try {
            con = DriverManager.getConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(GymPOO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
