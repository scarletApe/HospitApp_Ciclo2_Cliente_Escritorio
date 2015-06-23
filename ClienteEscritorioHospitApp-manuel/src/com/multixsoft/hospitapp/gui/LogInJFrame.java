/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import com.multixsoft.hospitapp.connector.ConectorPrivacyControl;
import com.multixsoft.hospitapp.connector.ConectorServicio;
import com.multixsoft.hospitapp.entities.Doctor;
import java.awt.Graphics;
import javax.swing.UIManager;

/**
 *
 * @author maritza
 */
public class LogInJFrame extends javax.swing.JFrame {

    /**
     * Creates new form LogInJFrame
     */
    public LogInJFrame() {

        initComponents();

//        jPanel1.setBackground(Color.white);
        //center the frame in the center of the screen
        Toolkit aKit = this.getToolkit();
        Dimension windowSize = aKit.getScreenSize();
        this.setBounds((windowSize.width / 2) - (this.getWidth() / 2),
                (windowSize.height / 2) - (this.getHeight() / 2),
                this.getWidth(), this.getHeight());

        this.setResizable(false);
        
        jTextFieldIPServidor.setText("192.168.137.1");
        jTextFieldIPServidor.setEnabled(false);

    }

//    @Override
//    public void paint(Graphics g){
//        super.paint(g);
//        g.setColor(Color.white);
//        g.fillRect(0, 0, this.getWidth(), this.getHeight());
//        
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        JTextFieldUsername = new javax.swing.JTextField();
        jLabelIncorrectMessage = new javax.swing.JLabel();
        jTextFieldIPServidor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese como Administrador o como Médico"));

        jLabel1.setText("Nombre de Usuario:");
        jLabel1.setName(""); // NOI18N

        jLabel2.setText("Password:");

        jButton1.setText("Ingresar");
        jButton1.setName("btnIngresar"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPasswordField.setName("JFieldPassword"); // NOI18N

        JTextFieldUsername.setName("JTextFieldUsername"); // NOI18N

        jLabelIncorrectMessage.setName("jLabelIncorrectLogin"); // NOI18N

        jLabel4.setText("IP del Servidor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIPServidor)
                            .addComponent(jPasswordField)
                            .addComponent(JTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelIncorrectMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIPServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIncorrectMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username = JTextFieldUsername.getText();
        String pass = new String(jPasswordField.getPassword());
        String ip = jTextFieldIPServidor.getText();

        if (username != null && pass != null && ip != null) {
            if (!username.isEmpty() && !pass.isEmpty() && !ip.isEmpty()) {

                if (contieneCharacteresInvalidos(username)) {
                    jLabelIncorrectMessage.setText("?\\#%! El username contiene caracteres inválidos. ");
                    jLabelIncorrectMessage.setForeground(Color.red);
                    return;
                }

                String url = "http://" + ip + ":8080/HospitAppServer/webresources/";

                ConectorServicio.URL_BASE = url;

                ConectorServicio conectorServicio = ConectorServicio.getInstance();
                ConectorPrivacyControl conectorPrivacy = ConectorPrivacyControl.getInstance();
                int access = conectorPrivacy.accessAsAdminOrDoctor(username, pass);
//        System.err.println("Codigo: " + access);
                if (access == 2) {
                    MainFrame mf = new MainFrame();
                    mf.setVisible(true);

                    this.setVisible(false);
                    this.dispose();

                } else if (access == 1) {
//            System.err.print(username);
                    Doctor doctor = conectorServicio.obtenerDoctor(username);

                    GUIDoctorHospitApp doctorFrame = new GUIDoctorHospitApp(doctor);
                    doctorFrame.setVisible(true);

                    this.setVisible(false);
                    this.dispose();
                } else {
                    jLabelIncorrectMessage.setText("Username o Password incorrecta!");
                    jLabelIncorrectMessage.setForeground(Color.red);
                }
            } else {
                jLabelIncorrectMessage.setText("Favor de proporcionar datos válidos");
                jLabelIncorrectMessage.setForeground(Color.red);
            }
        } else {
            jLabelIncorrectMessage.setText("Favor de proporcionar datos válidos");
            jLabelIncorrectMessage.setForeground(Color.red);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        boolean changedLook = false;
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Mac OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    changedLook = true;
                    break;
                }
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    changedLook = true;
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        if (!changedLook) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Metal".equals(info.getName())) {

                        javax.swing.UIManager.setLookAndFeel(info.getClassName());

                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(LogInJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(LogInJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(LogInJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(LogInJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInJFrame().setVisible(true);
            }
        });
    }

    private boolean contieneCharacteresInvalidos(String s) {
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '?' || c == '\\' || c == '#' || c == '%') {
                return true;
            }
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldUsername;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelIncorrectMessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldIPServidor;
    // End of variables declaration//GEN-END:variables
}