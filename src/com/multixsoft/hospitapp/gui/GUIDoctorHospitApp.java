/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.gui;

import com.multixsoft.hospitapp.entities.Doctor;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Vane
 */
public class GUIDoctorHospitApp extends javax.swing.JFrame {

    /**
     * Creates new form GUIDoctorHospitApp
     */
    public JInternalFrameProximasCitas proximasCitas;
    public JInternalFrameVerCItas verCitas;
    private static Doctor doctor;

    public GUIDoctorHospitApp() {
        initComponents();
//        this.setResizable(false);

        //center the frame in the center of the screen
        Toolkit aKit = this.getToolkit();
        Dimension windowSize = aKit.getScreenSize();
        this.setBounds((windowSize.width / 2) - (this.getWidth() / 2),
                (windowSize.height / 2) - (this.getHeight() / 2),
                this.getWidth(), this.getHeight());
        
        jDesktopPane1.setBorder(new BorderBackImage());

//        proximasCitas = new JInternalFrameProximasCitas();
//        jDesktopPane1.add(proximasCitas);
        
//        verCitas = new JInternalFrameVerCItas(doctor);
//        jDesktopPane1.add(verCitas);
    }

    public GUIDoctorHospitApp(Doctor d) {
        this();
        doctor = d;

        this.setTitle("Escritorio del Médico " + doctor.getFirstName() + " " + doctor.getLastName());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBarPacientes = new javax.swing.JToolBar();
        jButtonVerCitas = new javax.swing.JButton();
        jButtonProximasCitas = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBarPacientes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBarPacientes.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBarPacientes.setRollover(true);

        jButtonVerCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/multixsoft/hospitapp/resources/icon-people4.png"))); // NOI18N
        jButtonVerCitas.setText("          Ver Citas           ");
        jButtonVerCitas.setFocusable(false);
        jButtonVerCitas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonVerCitas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonVerCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerCitasActionPerformed(evt);
            }
        });
        jToolBarPacientes.add(jButtonVerCitas);

        jButtonProximasCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/multixsoft/hospitapp/resources/icon-write.png"))); // NOI18N
        jButtonProximasCitas.setText("  Citas Programadas ");
        jButtonProximasCitas.setFocusable(false);
        jButtonProximasCitas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonProximasCitas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonProximasCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximasCitasActionPerformed(evt);
            }
        });
        jToolBarPacientes.add(jButtonProximasCitas);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 842, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBarPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDesktopPane1)
                    .addComponent(jToolBarPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerCitasActionPerformed
        verCitas = new JInternalFrameVerCItas(doctor);
        jDesktopPane1.add(verCitas);
        
        verCitas.show();
        verCitas.moveToFront();
    }//GEN-LAST:event_jButtonVerCitasActionPerformed

    private void jButtonProximasCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximasCitasActionPerformed
        proximasCitas = new JInternalFrameProximasCitas(doctor);
        jDesktopPane1.add(proximasCitas);
        
        proximasCitas.show();
        proximasCitas.moveToFront();
    }//GEN-LAST:event_jButtonProximasCitasActionPerformed

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
                if ("Mac OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
//                if ("Metal".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIDoctorHospitApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIDoctorHospitApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIDoctorHospitApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIDoctorHospitApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIDoctorHospitApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonProximasCitas;
    private javax.swing.JButton jButtonVerCitas;
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBarPacientes;
    // End of variables declaration//GEN-END:variables
}