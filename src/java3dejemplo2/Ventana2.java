
package java3dejemplo2;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.LinkedList;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.j3d.Transform3D;
import javax.vecmath.Vector3f;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class Ventana2 extends javax.swing.JFrame  {
    //objetos para el control de arduino
     PanamaHitek_Arduino arduinoRobot;
    String mensaje;
    LinkedList cola;
    //Objetos para java
    CuboCanvas3D cubo;
    Timer timer;
    ModeloCinematico modeloCinematico;

    public Ventana2() {
        initComponents();
        //inicializacion de objetos
        cola = new LinkedList();
        arduinoRobot = new PanamaHitek_Arduino();
        System.out.println("Puertos Disponibles " + arduinoRobot.getSerialPorts() );//mensaje consola de usuario
        //Verificacion puerto
        try {
            arduinoRobot.arduinoRXTX("COM3", 9600, evento);
            System.out.println("Puerto Conectado");
            
        } catch (ArduinoException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("NO SE CONECTO");
        }
        //Iniacilizacion java
        cubo = new CuboCanvas3D(jPanel1);
        timer = new Timer();
        modeloCinematico = new ModeloCinematico(cubo);
        timer.schedule(modeloCinematico, 1000, 100);
        Transform3D actual = new Transform3D();
         

    }
//atributo para utilizar arduino
    SerialPortEventListener evento = new SerialPortEventListener() {
        @Override
        public void serialEvent(SerialPortEvent arg0) {//metodo para utilizar arduino, recibe datos
           //excepciones
            try {
                if (arduinoRobot.isMessageAvailable()) {
                    mensaje = arduinoRobot.printMessage();
                   // System.out.println("Mensaje recibido :" + mensaje);
                    cola.add(mensaje);
                                    }
            } catch (SerialPortException | ArduinoException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
};
      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        jLabel3.setFont(new java.awt.Font("Vivaldi", 3, 36)); // NOI18N
        jLabel3.setText("Sumo Bluetooth");

        jButton1.setBackground(new java.awt.Color(102, 0, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jRadioButton4.setBackground(new java.awt.Color(51, 102, 255));
        jRadioButton4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jRadioButton4.setText("Atras");

        jRadioButton2.setBackground(new java.awt.Color(51, 102, 255));
        jRadioButton2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jRadioButton2.setText("Izquierda");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(51, 102, 255));
        jRadioButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jRadioButton1.setText("Adelante");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(51, 102, 255));
        jRadioButton3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jRadioButton3.setText("Derecha");

        jRadioButton5.setBackground(new java.awt.Color(51, 102, 255));
        jRadioButton5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jRadioButton5.setText("Stop");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jRadioButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton2)
                                .addGap(13, 13, 13)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton4)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jRadioButton5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                        .addComponent(jRadioButton3))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButton1)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton5))
                .addGap(10, 10, 10)
                .addComponent(jRadioButton4)
                .addGap(43, 43, 43)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // cubo.setRotarY(Math.toRadians(Double.parseDouble(jTextField1.getText()))); 
        //cubo.setTransladarY(Float.parseFloat(jTextField1.getText())); 
        //declaración e incialización de variables para el envio de datos al arduino
       
        String enviar = null;
        
           /* modeloCinematico.setWr(Float.parseFloat(jTextField1.getText()));// TODO add your handling code here:
            modeloCinematico.setWl(Float.parseFloat(jTextField2.getText()));*/
        
        System.out.println(modeloCinematico.getTheta());
        System.out.println("xf: "+modeloCinematico.getXf()+" yf: "+modeloCinematico.getYf());
        try {/*dependiento de los valoresingresados en los jtextfield, el programa los lee y dependiendo
            las condiciones enviar un String por bluetoot, el cual esta oreviamente declarado en el arduino */
            
            if(jRadioButton1.isSelected()) {//adelante
                modeloCinematico.setWr(Float.parseFloat("1"));// TODO add your handling code here:
                modeloCinematico.setWl(Float.parseFloat("1"));
                jRadioButton1.setSelected(false);
                enviar="a";
           
            } else if(jRadioButton2.isSelected()) {// izquierda
                modeloCinematico.setWr(Float.parseFloat("0"));// TODO add your handling code here:
                modeloCinematico.setWl(Float.parseFloat("1"));
                jRadioButton2.setSelected(false);
                enviar="b";
            }
            
            else if (jRadioButton3.isSelected()){// derecha
                modeloCinematico.setWr(Float.parseFloat("1"));// TODO add your handling code here:
                modeloCinematico.setWl(Float.parseFloat("0"));
                jRadioButton3.setSelected(false);
                    enviar="d"; 
                    }
            
            
            else if (jRadioButton4.isSelected()){//atras
                modeloCinematico.setWr(Float.parseFloat("-1"));// TODO add your handling code here:
                modeloCinematico.setWl(Float.parseFloat("-1"));
                jRadioButton4.setSelected(false);
                    enviar="e"; 
                    }
            
            else if (jRadioButton5.isSelected()) { //parar
                modeloCinematico.setWr(Float.parseFloat("0"));// TODO add your handling code here:
                modeloCinematico.setWl(Float.parseFloat("0"));
                jRadioButton5.setSelected(false);
                enviar="c";
            }
             
            arduinoRobot.sendData(enviar);//envio de datos hacia el arduino
            Thread.sleep(500);//tiempo de espera en el arduino
            
        } catch (ArduinoException | SerialPortException | InterruptedException ex) {//excepción
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println(cola);
        String data1 = (String) cola.peek();
        cola.poll();
        String data2 = (String)cola.peek();
        cola.poll();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        System.err.println("press");        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    // End of variables declaration//GEN-END:variables
}
