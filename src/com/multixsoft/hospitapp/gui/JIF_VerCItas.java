/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.multixsoft.hospitapp.connector.ConectorScheduleManager;
import com.multixsoft.hospitapp.connector.ConectorServicio;
import com.multixsoft.hospitapp.entities.Appointment;
import com.multixsoft.hospitapp.entities.Doctor;
import com.multixsoft.hospitapp.utilities.Date;
import javax.swing.JDesktopPane;

/**
 *
 * @author Vane
 */
public class JIF_VerCItas extends javax.swing.JInternalFrame {

    private HistorialClinico historial;
    private ConectorScheduleManager sm;
    private ConectorScheduleManager con;
    private ConectorServicio conectorServicio;
    private JDesktopPane papaPane;
    private Doctor doctor;

    // private GUIDoctorHospitApp hospitapp;
    /**
     * Creates new form JInternalFrameVerCItas
     */
    /*public JInternalFrameVerCItas() {
     initComponents();
     //   hospitapp=new GUIDoctorHospitApp();
     historial=new HistorialClinico();
     jButton_VerHistorial.addActionListener(new JInternalFrameVerCItas.ManejadorBotonesCitas());
     jButtonTerminarCita.addActionListener(new JInternalFrameVerCItas.ManejadorBotonesCitas());
     jTable1.getSelectionModel().addListSelectionListener(new JInternalFrameVerCItas.ManejadorTabla());
     GUIDoctorHospitApp.jDesktopPane1.add(historial);
     cargarDatosTabla();
     }*/
    /**
     * Creates new form JInternalFrameVerCItas
     *
     * @param doctor
     */
    public JIF_VerCItas(Doctor doctor, JDesktopPane papaPane) {
        initComponents();
        //   hospitapp=new GUIDoctorHospitApp();
        historial = new HistorialClinico();
        jButton_VerHistorial.addActionListener(new JIF_VerCItas.ManejadorBotonesCitas());
        jButtonTerminarCita.addActionListener(new JIF_VerCItas.ManejadorBotonesCitas());
        jTable1.getSelectionModel().addListSelectionListener(new JIF_VerCItas.ManejadorTabla());

        this.doctor = doctor;
        this.papaPane = papaPane;
        papaPane.add(historial);
        cargarDatosTabla(doctor);

        this.setName("citasDelDia");
        this.setTitle("Citas del Día de " + doctor.toString());
    }

    private void cargarDatosTabla(Doctor doctor) {
        //Obtener datos de citas
        con = ConectorScheduleManager.getInstance();
        List<Appointment> listaCitas = con.getAllAppointmentsFor(doctor, new Date());
        System.err.println(listaCitas.toString());
        int sizeListaCitas = listaCitas.size();
        String[] titulosColumnas = {"ID", "NSS", "NOMBRE", "APELLIDO PATERNO", "FECHA"};
        Object[][] tempJTable = new Object[sizeListaCitas][titulosColumnas.length];

        int i = 0;
        if (sizeListaCitas != 0) {
            for (Appointment appointment : listaCitas) {
                if (!appointment.getIscanceled()) {
                    if (!appointment.getIsFinished()) {
                        tempJTable[i][0] = appointment.getIdAppointment();
                        tempJTable[i][1] = appointment.getPatientNss();
                        tempJTable[i][2] = appointment.getPatientNss().getFirstName();
                        tempJTable[i][3] = appointment.getPatientNss().getLastName();
                        tempJTable[i][4] = appointment.getDate();
                        i++;
                    }
                }
            }
        }

        DefaultTableModel tableModel = new DefaultTableModel(tempJTable, titulosColumnas);

        jTable1.setModel(tableModel);
        //  sorter = new TableRowSorter<TableModel>(tableModel);
        //jTable1.setRowSorter(sorter);

        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public class ManejadorBotonesCitas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int fila;
            fila = jTable1.getSelectedRow();
            TableModel modelo = jTable1.getModel();
            String textBoton = ae.getActionCommand();
            if (textBoton.equalsIgnoreCase("Ver Historial")) {
                historial.show();
            } else if (textBoton.equalsIgnoreCase("Finalizar Cita")) {
                if (fila != -1) {
                    System.out.println("--------" + modelo.getValueAt(fila, fila));
                    conectorServicio = ConectorServicio.getInstance();
                    sm = ConectorScheduleManager.getInstance();
                    appointment = conectorServicio.obtenerAppointment(Long.parseLong(modelo.getValueAt(fila, fila).toString()));
                    //con.
                    System.err.println("APPOINTMENT " + appointment.toString());
                    boolean getAppointmentFinish = sm.setAppointmentFinish(appointment);
                    if (getAppointmentFinish) {
                        JOptionPane.showMessageDialog(jButtonTerminarCita, "Cita finalizada con éxito");
                    } else {
                        JOptionPane.showMessageDialog(jButtonTerminarCita, "No se pudo finalizar la cita");
                    }

                } else {
                    System.out.println("Por favor selecciona el paciente atendido.");
                }
                cargarDatosTabla(doctor);
            }
        }
    }

    private class ManejadorTabla implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting() == false) {
                int indice = jTable1.getSelectedRow();
                if (indice == -1) {
                    jButtonTerminarCita.setEnabled(false);

                } else {
                    jButtonTerminarCita.setEnabled(true);
                }
            }
        }

        private void cargarDatosTabla(Doctor doctor) {
            //Obtener datos de citas
            con = ConectorScheduleManager.getInstance();
            List<Appointment> listaCitas = con.getAllAppointmentsFor(doctor, new Date());
            System.err.println(listaCitas.toString());
            int sizeListaCitas = listaCitas.size();
            String[] titulosColumnas = {"ID", "NSS", "NOMBRE", "APELLIDO PATERNO", "FECHA"};
            Object[][] tempJTable = new Object[sizeListaCitas][titulosColumnas.length];

            int i = 0;
            if (sizeListaCitas != 0) {
                for (Appointment appointment : listaCitas) {
                    tempJTable[i][0] = appointment.getIdAppointment();
                    tempJTable[i][1] = appointment.getPatientNss();
                    tempJTable[i][2] = appointment.getPatientNss().getFirstName();
                    tempJTable[i][3] = appointment.getPatientNss().getLastName();
                    tempJTable[i][4] = appointment.getDate();
                    i++;
                }
            }

            DefaultTableModel tableModel = new DefaultTableModel(tempJTable, titulosColumnas);
            jTable1.setModel(tableModel);
            //  sorter = new TableRowSorter<TableModel>(tableModel);
            //jTable1.setRowSorter(sorter);
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        }

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
        jPanel2 = new javax.swing.JPanel();
        jButton_VerHistorial = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonTerminarCita = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pacientes"));

        jButton_VerHistorial.setText("Ver Historial");
        jButton_VerHistorial.setEnabled(false);
        jButton_VerHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VerHistorialActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NSS", "NOMBRE", "APELLIDO PATERNO", "FECHA"
            }
        ));
        jTable1.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        jButtonTerminarCita.setText("Finalizar Cita");
        jButtonTerminarCita.setEnabled(false);
        jButtonTerminarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminarCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonTerminarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_VerHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonTerminarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_VerHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_VerHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VerHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_VerHistorialActionPerformed

    private void jButtonTerminarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminarCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTerminarCitaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonTerminarCita;
    private javax.swing.JButton jButton_VerHistorial;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
   private Appointment appointment;

}
