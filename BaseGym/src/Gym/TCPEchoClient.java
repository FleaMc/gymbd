package Gym;

import java.net.Socket;
import java.net.SocketException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TCPEchoClient {
private static String cadena;

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public static void main(String args[]) throws IOException {
      
        if ((args.length < 2) || (args.length > 3)) //Prueba por el # correcto de argumentos
        {
            throw new IllegalArgumentException("Parametros(s): <Server> <Word> [<Port>]");
        }

        String server = "127.0.0.1"; //Nombre del servidor o direccion IP
        
        //Convertir el argumento de tipo String a bytes usnado la codificacion de caracteres por defecto.
        byte[] data = cadena.getBytes();
        //Evalua si hay numero de puerto sino, establece el puerto 7
        int servPort = 1234;
        //Crea un socket que se conecta a un servidor en un puerto específico
        Socket socket = new Socket(server, servPort);
        System.out.println("Conectado al servidor... enviando cadena para echo");
        
        //Obtener el canal de entrada del socket (para lectura de informacion)
        InputStream in = socket.getInputStream();
        //Obtener el canal de salida del socket (para escritura de informacion)
        OutputStream out = socket.getOutputStream();
        
        out.write(data); //Se envía la cadena codificada al servidor
        
        //Recibir la misma cadena que viene de vuelta desde el servidor
        int totalBytesRcvd = 0; //Total de bytes recibidos hasta el momento
        int bytesRcvd;           // Bytes recibidos en la ultima lectura
        while(totalBytesRcvd < data.length){
            if((bytesRcvd = in.read(data,totalBytesRcvd,data.length-totalBytesRcvd))== -1){
                throw new SocketException("Conexion cerrada prematuramente");
            }
            totalBytesRcvd += bytesRcvd;
        } //Al finalizar el while, el arreglo está lleno
        System.out.println("Recibido: " + new String(data));
        socket.close(); //Cerrar el socket y sus streams asociados.
    }

}
