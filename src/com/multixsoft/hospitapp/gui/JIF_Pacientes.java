/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.gui;

import com.multixsoft.hospitapp.connector.ConectorDoctorManager;
import com.multixsoft.hospitapp.connector.ConectorServicio;
import com.multixsoft.hospitapp.entities.Patient;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.multixsoft.hospitapp.connector.ConectorPatientManager;
import com.multixsoft.hospitapp.connector.ConectorPrivacyControl;
import com.multixsoft.hospitapp.entities.Doctor;
import com.multixsoft.hospitapp.utilities.FixedSizeAlphaNumericDocument;
import com.multixsoft.hospitapp.utilities.FixedSizeAlphabeticalDocument;
import com.multixsoft.hospitapp.utilities.FixedSizeEmailDocument;
import com.multixsoft.hospitapp.utilities.FixedSizeNumberDocument;
import com.multixsoft.hospitapp.utilities.JPanes;
import com.multixsoft.hospitapp.utilities.Validator;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author manuelmartinez
 */
public class JIF_Pacientes extends javax.swing.JInternalFrame {

    private Patient selectedPatient;

    /**
     * Creates new form VerPacientesJInternalFrame
     */
    public JIF_Pacientes() {
        initComponents();
//        this.setResizable(false);

//        jButtonEliminarPaciente.setEnabled(false);
        jButtonModificarPaciente.setEnabled(false);

        jTextFieldNombre.setDocument(new FixedSizeAlphabeticalDocument(jTextFieldNombre, 100));
        jTextFieldApellido.setDocument(new FixedSizeAlphabeticalDocument(jTextFieldApellido, 100));

        jTextFieldNSS.setDocument(new FixedSizeNumberDocument(jTextFieldNSS, 12));
        jPasswordField1.setDocument(new FixedSizeAlphaNumericDocument(jPasswordField1, 32));

        jTextFieldEmail.setDocument(new FixedSizeEmailDocument(jTextFieldEmail, 64));

        //Lista de pacientes
        actualizarListaPacientes();

        limpiarCampos();

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

    public void limpiarCampos() {

        jTextFieldNSS.setText("");
        jPasswordField1.setText("");
        jTextFieldNombre.setText("");
        jTextFieldApellido.setText("");
        jTextFieldEmail.setText("");
        jToggleButtonActividad.setSelected(false);
        jToggleButtonActividad.setText("Inactivo");
//        jButtonEliminarPaciente.setEnabled(false);
        jButtonModificarPaciente.setEnabled(false);
        jButtonGuardarPaciente.setEnabled(true);
        
        jTextFieldNSS.setEditable(true);

//        jLabelErrorMsg.setText(" ");
        jLabel_Error_Nombre.setText(" ");
        jLabel_Error_Apellido.setText(" ");
        jLabel_Error_Nss.setText(" ");
        jLabel_Error_Email.setText(" ");
        jLabel_Error_Password.setText(" ");

        jLabel_Error_Nombre.setForeground(Color.red);
        jLabel_Error_Apellido.setForeground(Color.red);
        jLabel_Error_Nss.setForeground(Color.red);
        jLabel_Error_Email.setForeground(Color.red);
        jLabel_Error_Password.setForeground(Color.red);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPacientes = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_Error_Password = new javax.swing.JLabel();
        jTextFieldNSS = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel_Error_Nss = new javax.swing.JLabel();
        jLabel_Error_Nombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Error_Apellido = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jToggleButtonActividad = new javax.swing.JToggleButton();
        jLabel_Error_Email = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonGuardarPaciente = new javax.swing.JButton();
        jButtonModificarPaciente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel10.setText("jLabel10");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Pacientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane1.setViewportView(jListPacientes);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Paciente"));

        jLabel4.setText("NSS:");

        jLabel5.setText("Actividad:");

        jLabel_Error_Password.setText(" ");

        jLabel6.setText("Password:");

        jLabel_Error_Nss.setText(" ");

        jLabel_Error_Nombre.setText(" ");

        jLabel1.setText("Nombre:");

        jLabel_Error_Apellido.setText(" ");

        jLabel2.setText("Apellido:");

        jLabel3.setText("Email:");

        jToggleButtonActividad.setText("Inactivo");
        jToggleButtonActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonActividadActionPerformed(evt);
            }
        });

        jLabel_Error_Email.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Error_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_Error_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldApellido)
                            .addComponent(jTextFieldEmail)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Error_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_Error_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 24, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButtonActividad)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNSS)
                            .addComponent(jTextFieldNombre)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel_Error_Nss, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Error_Nss, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Error_Nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Error_Apellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Error_Email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Error_Password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonActividad)
                    .addComponent(jLabel5)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButtonGuardarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/multixsoft/hospitapp/imagenes/ic_create.png"))); // NOI18N
        jButtonGuardarPaciente.setText("Crear");
        jButtonGuardarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarPacienteActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonGuardarPaciente);

        jButtonModificarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/multixsoft/hospitapp/imagenes/ic_save.png"))); // NOI18N
        jButtonModificarPaciente.setText("Actualizar");
        jButtonModificarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarPacienteActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonModificarPaciente);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/multixsoft/hospitapp/imagenes/ic_clear.png"))); // NOI18N
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarPacienteActionPerformed
        String nss = jTextFieldNSS.getText();
        String password = new String(jPasswordField1.getPassword());
        String firstName = jTextFieldNombre.getText();
        String lastName = jTextFieldApellido.getText();
        String address = jTextFieldEmail.getText();
        boolean isActive = jToggleButtonActividad.isSelected();

        boolean isValid_Nombre = false;
        boolean isValid_Apellido = false;
        boolean isValid_nss = false;
        boolean isValid_email = false;
        boolean isValid_password = false;

        if (nss != null
                && firstName != null
                && lastName != null
                && address != null) {

            if (!nss.isEmpty()
                    && !firstName.isEmpty()
                    && !lastName.isEmpty()
                    && !address.isEmpty()
                    && !password.isEmpty()) {

                Validator val = Validator.getInstance();

                if (existeNSS(nss)) {
                    JPanes.getInstance().msgPane("Verifica el NSS...");
                    return;
                }

                isValid_nss = val.isValidNss(nss);
                isValid_Nombre = val.isValidFirstName(firstName);
                isValid_Apellido = val.isValidLastName(lastName);
                isValid_email = val.isValidEmail(address);
                isValid_password = val.isValidPassword(password);

                if (isValid_Nombre
                        && isValid_Apellido
                        && isValid_nss
                        && isValid_email
                        && isValid_password) {

                    ConectorPrivacyControl pc = ConectorPrivacyControl.getInstance();
                    byte[] encrypted = pc.encrypt(password.getBytes(), pc.getKey());
                    String pass = pc.bytesToString(encrypted);

                    Patient patient = new Patient(nss, pass, firstName, lastName, address, isActive);
                    ConectorPatientManager conectorPatient = ConectorPatientManager.getInstance();
                    String saveNewPatient = conectorPatient.saveNewPatient(patient);

                    if (saveNewPatient != null) {
                        JPanes.getInstance().msgPane("El paciente fue creado exitosamente. ");
                        limpiarCampos();
                        actualizarListaPacientes();
                    } else {
                        JPanes.getInstance().errorPane("No se pudo crear el Paciente...");
                    }
                } else {
                    if (!isValid_Nombre) {
                        jLabel_Error_Nombre.setText("El nombre debe contener más de 2 caracteres y empezar con una mayúscula.");
                    } else {
                        jLabel_Error_Nombre.setText(" ");
                    }

                    if (!isValid_Apellido) {
                        jLabel_Error_Apellido.setText("El apellido debe contener más de 2 caracteres y empezar con una mayúscula.");
                    } else {
                        jLabel_Error_Apellido.setText(" ");
                    }

                    if (!isValid_nss) {
                        jLabel_Error_Nss.setText("El NSS debe tener 11 dígitos y opcionalmente un guión intermedio.");
                    } else {
                        jLabel_Error_Nss.setText(" ");
                    }

                    if (!isValid_email) {
                        jLabel_Error_Email.setText("El e-mail debe tener el siguiente formato 'correo@ejemplo.com'");
                    } else {
                        jLabel_Error_Email.setText(" ");
                    }

                    if (!isValid_password) {
                        jLabel_Error_Password.setText("La contraseña debe combinar mayúsculas, minúsculas y números.");
                        if (password.length() < 8) {
                            jLabel_Error_Password.setText("La contraseña debe tener mínimo 8 caracteres.");
                        }
                    } else {
                        jLabel_Error_Password.setText(" ");
                    }
                }

            } else {
                jLabel_Error_Nombre.setText("* Todo Campo debe de tener un dato.");
            }
        } else {
            jLabel_Error_Nombre.setText("* Todo Campo debe de tener un dato.");
        }
    }//GEN-LAST:event_jButtonGuardarPacienteActionPerformed

    private void jButtonModificarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarPacienteActionPerformed
        String nss = jTextFieldNSS.getText();

//        System.out.println(selectedPatient.getPassword());
        String password = new String(jPasswordField1.getPassword());
        if (password.isEmpty()) {
            password = selectedPatient.getPassword();
        } else {
            ConectorPrivacyControl pc = ConectorPrivacyControl.getInstance();
            byte[] encrypted = pc.encrypt(password.getBytes(), pc.getKey());
            password = pc.bytesToString(encrypted);
        }

        String firstName = jTextFieldNombre.getText();
        String lastName = jTextFieldApellido.getText();
        String address = jTextFieldEmail.getText();
        boolean isActive = jToggleButtonActividad.isSelected();

        if (nss != null
                && firstName != null
                && lastName != null
                && address != null) {

            if (!nss.isEmpty()
                    && !firstName.isEmpty()
                    && !lastName.isEmpty()
                    && !address.isEmpty()
                   ) {

                Patient p = new Patient(selectedPatient.getNss(), password, firstName, lastName, address, isActive);
                p.setDoctorUsername(selectedPatient.getDoctorUsername());
                ConectorServicio servidor = ConectorServicio.getInstance();
                servidor.updatePatient(p);
                //TODO

                limpiarCampos();
                actualizarListaPacientes();
            } else {
                jLabel_Error_Nombre.setText("* Todo Campo debe de tener un dato.");
                jLabel_Error_Nombre.setForeground(Color.red);
            }
        } else {
            jLabel_Error_Nombre.setText("* Todo Campo debe de tener un dato.");
            jLabel_Error_Nombre.setForeground(Color.red);
        }
    }//GEN-LAST:event_jButtonModificarPacienteActionPerformed

    private void jToggleButtonActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonActividadActionPerformed
        if (jToggleButtonActividad.isSelected()) {
            jToggleButtonActividad.setText("Activo");
        } else {
            jToggleButtonActividad.setText("Inactivo");
        }
    }//GEN-LAST:event_jToggleButtonActividadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private class ManejadorListaPacientes implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting() == false) {
                int indice = jListPacientes.getSelectedIndex();
                if (indice == -1) {
//                    jButtonEliminarPaciente.setEnabled(false);
                    jButtonModificarPaciente.setEnabled(false);
                    jButtonGuardarPaciente.setEnabled(true);
                    jTextFieldNSS.setEditable(true);
                } else {
//                    jButtonEliminarPaciente.setEnabled(true);
                    jButtonModificarPaciente.setEnabled(true);
                    jButtonGuardarPaciente.setEnabled(false);
                    jTextFieldNSS.setEditable(false);

                    ListModel modelo = jListPacientes.getModel();
                    Patient cSel = (Patient) modelo.getElementAt(indice);
                    selectedPatient = cSel;

                    jTextFieldNombre.setText(cSel.getFirstName());
                    jTextFieldApellido.setText(cSel.getLastName());
                    jTextFieldEmail.setText(cSel.getAddress());
                    jTextFieldNSS.setText(cSel.getNss());
                    jPasswordField1.setText(cSel.getPassword());
//                    System.out.println(cSel.getPassword());

                    if (cSel.getIsActive()) {
                        jToggleButtonActividad.setSelected(true);
                        jToggleButtonActividad.setText("Activo");
                    } else {
                        jToggleButtonActividad.setSelected(false);
                        jToggleButtonActividad.setText("Inactivo");
                    }
                }
            }
        }
    }

    private boolean existeNSS(String un) {
        ListModel modelo = jListPacientes.getModel();
        for (int i = 0; i < modelo.getSize(); i++) {
            Patient d = (Patient) modelo.getElementAt(i);
            if (d.getNss().equalsIgnoreCase(un)) {
                return true;
            }
        }
        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonGuardarPaciente;
    private javax.swing.JButton jButtonModificarPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Error_Apellido;
    private javax.swing.JLabel jLabel_Error_Email;
    private javax.swing.JLabel jLabel_Error_Nombre;
    private javax.swing.JLabel jLabel_Error_Nss;
    private javax.swing.JLabel jLabel_Error_Password;
    private javax.swing.JList jListPacientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNSS;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JToggleButton jToggleButtonActividad;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
