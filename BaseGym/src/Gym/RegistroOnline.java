/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym;

import static Gym.GymPOO.combo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Michael
 */
public class RegistroOnline extends javax.swing.JFrame {
 
  
    public RegistroOnline() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        bttnEnviar = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre");

        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });

        jLabel2.setText("Telefono");

        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        bttnEnviar.setText("Enviar");
        bttnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEnviarActionPerformed(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cross_Fit", "Karate", "Pesas", "Pilates" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTel)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bttnEnviar))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
    
    }//GEN-LAST:event_txtNomActionPerformed

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void bttnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEnviarActionPerformed
        String item = (String) combo.getSelectedItem();
        String cadena= txtNom.getText() +  "," + txtTel.getText() + ","+item;
      
       RegistroOnline p = new RegistroOnline();

        try {
            EnviarDatos(cadena);
        } catch (IOException ex) {
            Logger.getLogger(RegistroOnline.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_bttnEnviarActionPerformed

 public String EnviarDatos(String cadena) throws IOException{   
      String server = "127.0.0.1"; //Nombre del servidor o direccion IP

        byte[] data = cadena.getBytes();
        //Evalua si hay numero de puerto sino, establece el puerto 7
        int servPort = 1234;
        //Crea un socket que se conecta a un servidor en un puerto específico
        Socket socket = new Socket(server, servPort);
        System.out.println("Conectado al servidor... enviando cadena para echo");
        
        //Obtener el canal de entrada del socket (para lectura de informacion)
        InputStream in = socket.getInputStream();
        DataOutputStream in2 = new DataOutputStream(socket.getOutputStream());
        in2.writeUTF(cadena);
        OutputStream out = socket.getOutputStream();
        out.write(data); 
        
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
        
      return cadena; }

    public static void main(String args[]) throws IOException {
        
         

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroOnline().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnEnviar;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JTextField txtNom;
    public static javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}