/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.gui;


import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.multixsoft.hospitapp.connector.ConectorScheduleManager;
import com.multixsoft.hospitapp.connector.ConectorServicio;
import com.multixsoft.hospitapp.entities.Appointment;
import com.multixsoft.hospitapp.entities.Doctor;
import com.multixsoft.hospitapp.utilities.Date;

/**
 *
 * @author manuelmartinez
 */
public class JIF_CancelarCita extends javax.swing.JInternalFrame {

    /**
     * Creates new form CancelarCitaJInternalFrame
     */
    public JIF_CancelarCita() {
        initComponents();
        this.setResizable(false);
        jButtonCancelarCita.setEnabled(false);

        //Lista de Doctores
        ConectorServicio servidor = ConectorServicio.getInstance();
        List<Doctor> doctores = servidor.obtenerListaDoctor();
        DefaultListModel modelo = new DefaultListModel();
        for (Doctor c : doctores) {
            modelo.addElement(c);
        }
        jListDoctores.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePacientes = new javax.swing.JTable();
        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDoctores = new javax.swing.JList();
        jButtonConsultar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonCancelarCita = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListCitas = new javax.swing.JList();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();

        jButton3.setText("Aceptar");

        jTablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NSS", "Nombre", "Ap. Paterno", "Fecha"
            }
        ));
        jScrollPane2.setViewportView(jTablePacientes);

        setClosable(true);
        setIconifiable(true);
        setTitle("Cancelar Citas");

        jLabel1.setText("Doctores");

        jScrollPane1.setViewportView(jListDoctores);

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jLabel2.setText("Citas del Doctor Consultado");

        jButtonCancelarCita.setText("Cancelar Cita");
        jButtonCancelarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarCitaActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha:");

        jScrollPane3.setViewportView(jListCitas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(142, 142, 142))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(270, 270, 270))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCancelarCita)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jButtonCancelarCita)
                        .addComponent(jButtonConsultar))
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        ListModel modelo = jListDoctores.getModel();
        int indice = jListDoctores.getSelectedIndex();

        if (indice != -1) {
            Doctor doc = (Doctor) modelo.getElementAt(indice);
            Calendar calendar = dateChooserCombo1.getSelectedDate();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH)+1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
		

            ConectorScheduleManager conectorScheduleManager = ConectorScheduleManager.getInstance();
            
            jListCitas.addListSelectionListener(new ManejadorListaCitas());
            List<Appointment> allAppointments = conectorScheduleManager.getAllAppointmentsFor(doc, new Date(day,month,year));
            DefaultListModel modelo2 = new DefaultListModel();
            for (Appointment c : allAppointments) {
                modelo2.addElement(c);
            }
            jListCitas.setModel(modelo2);


        }
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonCancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarCitaActionPerformed
        ListModel modelo = jListCitas.getModel();
        int indice = jListCitas.getSelectedIndex();

        if (indice != -1) {
            Appointment appo = (Appointment) modelo.getElementAt(indice);
            ConectorScheduleManager sm = ConectorScheduleManager.getInstance();
            boolean cancelAppointment = sm.cancelAppointment(appo);
            
            if(cancelAppointment){
                JOptionPane.showMessageDialog(this, "Se canceló la cita.");
            }else{
                JOptionPane.showMessageDialog(this, "No se pudo cancelar la cita.");
            }
            
            Doctor doc = appo.getDoctorUsername();
            //para referescar la lista de las citas
            Calendar calendar = dateChooserCombo1.getSelectedDate();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH)+1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            
            jListCitas.addListSelectionListener(new ManejadorListaCitas());
            List<Appointment> allAppointments = sm.getAllAppointmentsFor(doc, new Date(day,month,year));
            DefaultListModel modelo2 = new DefaultListModel();
            for (Appointment c : allAppointments) {
                modelo2.addElement(c);
            }
            jListCitas.setModel(modelo2);
        }
    }//GEN-LAST:event_jButtonCancelarCitaActionPerformed

    private class ManejadorListaCitas implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting() == false) {
                int indice = jListCitas.getSelectedIndex();
                if (indice == -1) {
                    jButtonCancelarCita.setEnabled(false);

                } else {
                    jButtonCancelarCita.setEnabled(true);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonCancelarCita;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jListCitas;
    private javax.swing.JList jListDoctores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTablePacientes;
    // End of variables declaration//GEN-END:variables
}
