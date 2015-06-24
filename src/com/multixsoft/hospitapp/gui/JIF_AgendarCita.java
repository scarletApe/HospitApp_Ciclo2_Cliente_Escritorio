/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.gui;

import com.multixsoft.hospitapp.connector.ConectorScheduleManager;
import com.multixsoft.hospitapp.connector.ConectorServicio;
import com.multixsoft.hospitapp.entities.Appointment;
import com.multixsoft.hospitapp.entities.Doctor;
import com.multixsoft.hospitapp.entities.Patient;
import com.multixsoft.hospitapp.entities.Schedule;
import com.multixsoft.hospitapp.utilities.Date;
import com.multixsoft.hospitapp.utilities.IntervalFilter;
import datechooser.events.SelectionChangedEvent;
import datechooser.events.SelectionChangedListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author manuelmartinez
 */
public class JIF_AgendarCita extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIF_AgendarCita
     */
    public JIF_AgendarCita() {
        initComponents();

        jLabelNoHayDoctor.setForeground(Color.red);
        jLabelNoHayDoctor.setText(" ");
        
        jButtonSoliciarCita.setEnabled(false);

        actualizarListaPacientes();

        dateChooserCombo1.addSelectionChangedListener(new SelectionChangedListener() {

            @Override
            public void onSelectionChange(SelectionChangedEvent sce) {
                //obtenemos la fecha actual del chooser
                Calendar selectedDate = dateChooserCombo1.getSelectedDate();

                //la fecha sacamos sus componentes
                int sYear = selectedDate.get(Calendar.YEAR);
                int sMonth = selectedDate.get(Calendar.MONTH);
                int sDay = selectedDate.get(Calendar.DAY_OF_MONTH);

                //obtenemos el paciente seleccionado
                DefaultListModel modelo = (DefaultListModel) jListPacientes.getModel();
                int indice = jListPacientes.getSelectedIndex();
                if (indice != -1) {
                    Patient cSel = (Patient) modelo.getElementAt(indice);

                    //obtenemos la lista de horas del medico para la fecha solicitada
                    List<String> hours = getHoursForDate(new String[]{sDay + "", (sMonth + 1) + "", sYear + ""}, cSel);
                    if (hours == null) {
                        jLabelNoHayDoctor.setText("El Médico no tiene horas para esta fecha.");
                    } else {
                        //si tiene horas el medico

                        //Combo box de Carreras en el panel de materias
                        jComboBoxHorarios.addActionListener(new ManejadorComboHoras());
                        DefaultComboBoxModel comboModCar = new DefaultComboBoxModel();
                        for (String c : hours) {
                            comboModCar.addElement(c);
                        }
                        jComboBoxHorarios.setModel(comboModCar);

                    }
                }

            }
        });
    }

    private void actualizarListaPacientes() {
        //Lista de pacientes
        ConectorServicio servidor = ConectorServicio.getInstance();
        jListPacientes.addListSelectionListener(new ManejadorListaPacientes());
        List<Patient> pacientes = servidor.obtenerListaPatient();
        DefaultListModel modelo = new DefaultListModel();
        for (Patient c : pacientes) {
            modelo.addElement(c);
        }
        jListPacientes.setModel(modelo);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPacientes = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDoctor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxHorarios = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jButtonSoliciarCita = new javax.swing.JButton();
        jLabelNoHayDoctor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agendar Cita");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane1.setViewportView(jListPacientes);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Médico:");

        jTextFieldDoctor.setEditable(false);

        jLabel2.setText("Horarios Disponibles:");

        jLabel3.setText("Elegir Fecha:");

        jButtonSoliciarCita.setText("Solicitar Cita");
        jButtonSoliciarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSoliciarCitaActionPerformed(evt);
            }
        });

        jLabelNoHayDoctor.setText("Paciente no tiene un Médico asignado.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSoliciarCita))
                    .addComponent(jTextFieldDoctor)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxHorarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabelNoHayDoctor)
                            .addComponent(jLabel2))
                        .addGap(0, 86, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNoHayDoctor)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSoliciarCita)
                .addContainerGap())
        );

        jLabel4.setText("Pacientes:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
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

    private void jButtonSoliciarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSoliciarCitaActionPerformed
        DefaultListModel modelo = (DefaultListModel) jListPacientes.getModel();
        int indice = jListPacientes.getSelectedIndex();
        if (indice != -1) {
            Patient cSel = (Patient) modelo.getElementAt(indice);

            DefaultComboBoxModel dcmMateria = (DefaultComboBoxModel) jComboBoxHorarios.getModel();
            String hour = (String) dcmMateria.getSelectedItem();
//            String hour = listSchedule.getItemAtPosition(globalPosition).toString().substring(0, 2);
            if (hour.endsWith(":")) {
                hour = hour.substring(0, 1);
            }

            //obtenemos la fecha actual del chooser
            Calendar selectedDate = dateChooserCombo1.getSelectedDate();

            //la fecha sacamos sus componentes
//                int sYear = selectedDate.get(Calendar.YEAR);
            int sMonth = selectedDate.get(Calendar.MONTH);
            int sDay = selectedDate.get(Calendar.DAY_OF_MONTH);

            Long answer = agendarCita(new String[]{hour, sDay + "", sMonth + ""}, cSel);

            if (answer == -1L) {
                errorPane("La fecha seleccionada debe ser posterior a la fecha actual");
//                btnScheduleApp.setVisibility(Button.INVISIBLE);
            } else if (answer == -2L) {
                errorPane("No puede agendar más de una cita el mismo día");
//                btnScheduleApp.setVisibility(Button.INVISIBLE);

            } else {
//                lblFechaAppointment.setText(fechaAppointment);
//                lblHoraAppointment.setText(horaAppointment);
                msgPane("La cita se ha registrado con éxito");
            }
        }

    }//GEN-LAST:event_jButtonSoliciarCitaActionPerformed

    private void errorPane(String s) {
        JOptionPane.showMessageDialog(null, s, "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
    }

    private void msgPane(String s) {
        JOptionPane.showMessageDialog(null, s, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    private class ManejadorListaPacientes implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting() == false) {
                int indice = jListPacientes.getSelectedIndex();
                if (indice == -1) {
//                    jButtonEliminarPaciente.setEnabled(false);
//                    jButtonModificarPaciente.setEnabled(false);
                    jButtonSoliciarCita.setEnabled(false);
                    dateChooserCombo1.setEnabled(false);
                } else {
//                    jButtonEliminarPaciente.setEnabled(true);
//                    jButtonModificarPaciente.setEnabled(true);

                    ListModel modelo = jListPacientes.getModel();
                    Patient cSel = (Patient) modelo.getElementAt(indice);
//                    selectedPatient = cSel;

                    Doctor doc = cSel.getDoctorUsername();

                    if (doc == null) {
                        jLabelNoHayDoctor.setText("El paciente no tiene un médico asignado.");
                        jButtonSoliciarCita.setEnabled(false);
                        dateChooserCombo1.setEnabled(false);
                        return;
                    }

                    dateChooserCombo1.setEnabled(true);

                    jLabelNoHayDoctor.setText(" ");
                    jTextFieldDoctor.setText(cSel.getDoctorUsername().getFirstName());

                }
            }
        }
    }

    protected List<String> getHoursForDate(String params[], Patient patient) {
        List<String> horas = new ArrayList<String>();
        Doctor doctor = patient.getDoctorUsername();
//            System.out.println("Doctor is null", doctor.getUsername());

        ConectorScheduleManager conectorScheduleManager = ConectorScheduleManager.getInstance();
        Schedule doctorSchedule = conectorScheduleManager.getAvailableSchedule(doctor, false);
//            Log.e("--DoctorSchedule null?", "--"+(doctorSchedule == null));
            /*Log.e("--DoctorSchedule null?", "--"+(doctorSchedule.getMonday()));
         Log.e("--DoctorSchedule null?", "--"+(doctorSchedule.getTuesday()));
         Log.e("--DoctorSchedule null?", "--"+(doctorSchedule.getWednesday()));
         Log.e("--DoctorSchedule null?", "--"+(doctorSchedule.getThursday()));
         Log.e("--DoctorSchedule null?", "--"+(doctorSchedule.getFriday()));*/
        Date appointmentDate = new Date(Integer.parseInt(params[0]), Integer.parseInt(params[1]), Integer.parseInt(params[2]));
//            Log.e("FECHA OBTENIDA", (appointmentDate.toString())+"");
        String intervalosTime = "";

        int dayWeek = appointmentDate.getDayOfWeek();
//            Log.e("DAY WEEK",dayWeek+"");

        if ((doctorSchedule == null) == false && (doctorSchedule.getMonday().trim().length() > 0) && dayWeek == 2) {
            intervalosTime = doctorSchedule.getMonday();

        } else if ((doctorSchedule == null) == false && (doctorSchedule.getTuesday().trim().length() > 0) && dayWeek == 3) {
            intervalosTime = doctorSchedule.getTuesday();

        } else if ((doctorSchedule == null) == false && (doctorSchedule.getWednesday().trim().length() > 0) && dayWeek == 4) {
            intervalosTime = doctorSchedule.getWednesday();
        } else if ((doctorSchedule == null) == false && (doctorSchedule.getThursday().trim().length() > 0) && dayWeek == 5) {
            intervalosTime = doctorSchedule.getThursday();
        } else if ((doctorSchedule == null) == false && (doctorSchedule.getFriday().trim().length() > 0) && dayWeek == 6) {
            intervalosTime = doctorSchedule.getFriday();
        } else {
            return null;
        }
        IntervalFilter intervalFilter = new IntervalFilter();
//            Log.e("Intervalo verdadero",intervalosTime);

        String hoursCadena = intervalFilter.getHours(intervalosTime);
//            Log.e("HORAS DE CADENA", hoursCadena);

        String[] hoursForAppointment = hoursCadena.split(",");

        for (String hour : hoursForAppointment) {
            horas.add(hour + ":00");
        }

        return horas;
    }

    public class ManejadorComboHoras implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jButtonSoliciarCita.setEnabled(true);
//            DefaultComboBoxModel dcmMateria = (DefaultComboBoxModel) jComboBoxHorarios.getModel();
//            String mat = (String) dcmMateria.getSelectedItem();
//            String claveCarrera = mat.getClaveCarrera();
//            
//            DefaultComboBoxModel dcmCarrera = (DefaultComboBoxModel) comboCarreraEnCarga.getModel();
//            for (int i = 0; i < dcmCarrera.getSize(); i++) {
//                        Carrera c = (Carrera) dcmCarrera.getElementAt(i);
//                        if (c.getClaveCarrera().equalsIgnoreCase( claveCarrera )) {
//                            comboCarreraEnCarga.setSelectedIndex(i);
//                        }
//                    }
        }

    }

    protected Long agendarCita(String params[], Patient patient) {
//            Log.e("ENTRO A REGISTRAR CITA","btnREgistrarCita");
        ConectorScheduleManager conectorScheduleManager
                = new ConectorScheduleManager().getInstance();
        List<Appointment> appointments = conectorScheduleManager.getNextAppointment(patient);

        Appointment appointment = new Appointment();
        String hour = params[0];
        int day = Integer.parseInt(params[1]);
        int month = Integer.parseInt(params[2]);
        int year = 2015;
//            Log.e("DAY--",day+"");
//            Log.e("MONTH--",month+"");
//            Log.e("HOUR",hour);
        Date appointmentDate = new Date(day, month + 1, year);

        if (appointmentDate.isBefore(new Date())) {

            return -1L;
        }

        for (Appointment app : appointments) {
            if (app.getDate().equals(appointmentDate) && app.getIscanceled() == false) {
                return -2L;
            }
        }
//        fechaAppointment = appointmentDate.toString();
//        horaAppointment = hour + ":00";
        appointment.setDate(appointmentDate);
        appointment.setPatientNss(patient);
        appointment.setDoctorUsername(patient.getDoctorUsername());
        appointment.setTime(hour);
        appointment.setIscanceled(false);
        appointment.setIsFinished(false);
        appointment.setIdAppointment(455656l);
        long isConfirmed = conectorScheduleManager.scheduleAppointment(appointment);
//            Log.e("ID DE LA NEW", isConfirmed+"");
        return isConfirmed;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton jButtonSoliciarCita;
    private javax.swing.JComboBox jComboBoxHorarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelNoHayDoctor;
    private javax.swing.JList jListPacientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldDoctor;
    // End of variables declaration//GEN-END:variables
}
