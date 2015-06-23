/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.gui;


import com.multixsoft.hospitapp.connector.ConectorScheduleManager;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.multixsoft.hospitapp.connector.ConectorServicio;
import com.multixsoft.hospitapp.entities.Appointment;
import com.multixsoft.hospitapp.entities.Doctor;
import com.multixsoft.hospitapp.utilities.Date;

/**
 *
 * @author Vane
 */
public class JInternalFrameProximasCitas extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameVerCItas
     */
    
    TableRowSorter sorter;
    ConectorServicio conectorServicio;
    private ConectorScheduleManager con;
    public JInternalFrameProximasCitas(Doctor doctor) {
        initComponents();
        
        
    /**
     * Creates new form ProximasCitas
     */
    
        conectorServicio = ConectorServicio.getInstance();
        cargarDatosTabla(doctor);
        jText_busqueda.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent de) {
               filtrarBusqueda();
            }
            

            @Override
            public void removeUpdate(DocumentEvent de) {
                filtrarBusqueda();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
               filtrarBusqueda();
            }

           
                     
        });
    }
    
    private void filtrarBusqueda(){
        RowFilter<TableModel,Object> filtro = null;
        int indiceColumnaTabla = 0;
        
        switch(jComboBox_opciones.getSelectedIndex()){
            case 0:
                indiceColumnaTabla = 1;
                break;
            case 1:
                indiceColumnaTabla = 2;
                break;
            case 2:
                indiceColumnaTabla = 3;                
                break;
            case 3:
                indiceColumnaTabla=4;
                break;
            case 4:
                indiceColumnaTabla=5;
                break;
        }
        
        try{
            filtro = RowFilter.regexFilter(jText_busqueda.getText(), indiceColumnaTabla);
        
        }catch(java.util.regex.PatternSyntaxException e){
            e.printStackTrace();
        }
        sorter.setRowFilter(filtro);
    }
    
    private void cargarDatosTabla(Doctor doctor){
         //Obtener datos de citas
//        conectorServicio = ConectorServicio.getInstance();
        con = ConectorScheduleManager.getInstance();
//        List<Appointment> listaCitas = conectorServicio.obtenerListaAppointment();
        List<Appointment> listaCitas = con.getAllAppointmentsFor(doctor);
        System.err.println(listaCitas.toString());
        
        int sizeListaCitas = listaCitas.size();
        String[] titulosColumnas = {"ID","NSS","NOMBRE","APELLIDO PATERNO","FECHA"};
        Object[][] tempJTable = new Object[sizeListaCitas][titulosColumnas.length];
        
        int i = 0;
        if(sizeListaCitas !=0 ){
            for(Appointment appointment : listaCitas){
                tempJTable[i][0]= appointment.getIdAppointment();
                tempJTable[i][1]= appointment.getPatientNss().getNss();
                tempJTable[i][2]=appointment.getPatientNss().getFirstName();
                tempJTable[i][3]=appointment.getPatientNss().getLastName();
                tempJTable[i][4]= appointment.getDate();
                i++;
            }
        }
        
        DefaultTableModel tableModel = new DefaultTableModel(tempJTable, titulosColumnas);

        jTable1.setModel(tableModel);
         sorter = new TableRowSorter<TableModel>(tableModel);
        jTable1.setRowSorter(sorter);

        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
//    private void cargarDatosTabla(){
//         //Obtener datos de citas
//        conectorServicio = ConectorServicio.getInstance();
//        List<Appointment> listaCitas = conectorServicio.obtenerListaAppointment();
//        int sizeListaCitas = listaCitas.size();
//        String[] titulosColumnas = {"ID","NSS","NOMBRE","APELLIDO PATERNO","FECHA"};
//        Object[][] tempJTable = new Object[sizeListaCitas][titulosColumnas.length];
//        
//        int i = 0;
////        if(sizeListaCitas !=0 ){
////            for(Appointment appointment : listaCitas){
////                tempJTable[i][0]= appointment.getPatientNss().getNss();
////                tempJTable[i][1]=appointment.getPatientNss().getFirstName();
////                tempJTable[i][2]=appointment.getPatientNss().getLastName();
////                tempJTable[i][3]= appointment.getDate();
////                i++;
////            }
//        
//        if(sizeListaCitas !=0 ){
//            for(Appointment appointment : listaCitas){
//                tempJTable[i][0]= appointment.getIdAppointment();
//                tempJTable[i][1]= appointment.getPatientNss();
//                tempJTable[i][2]=appointment.getPatientNss().getFirstName();
//                tempJTable[i][3]=appointment.getPatientNss().getLastName();
//                tempJTable[i][4]= appointment.getDate();
//                i++;
//            }
//        }
//        
//        
//       /* tempJTable[1][0]= "525252";
//        tempJTable[1][1]="Vanessa";
//        tempJTable[1][2]= "Alcalá";
//        tempJTable[1][3]="12/10/2015";
//        
//        tempJTable[2][0]= "7878";
//        tempJTable[2][1]="Alejandra";
//        tempJTable[2][2]= "Alcalá";
//        tempJTable[2][3]="12/10/2016";
//        
//        tempJTable[3][0]= "1414";
//        tempJTable[3][1]="susy";
//        tempJTable[3][2]= "Rodriguez";
//        tempJTable[3][3]="15/02/2015";
//        */
//        DefaultTableModel tableModel = new DefaultTableModel(tempJTable, titulosColumnas);
//        jTable1.setModel(tableModel);
//         sorter = new TableRowSorter<TableModel>(tableModel);
//        jTable1.setRowSorter(sorter);
//        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        
//    }
//    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_opciones = new javax.swing.JComboBox();
        jText_busqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/multixsoft/hospitapp/resources/cal.png"))); // NOI18N

        jComboBox_opciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox_opciones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NSS", "NOMBRE", "APELLIDO PATERNO", "FECHA" }));

        jLabel2.setFont(new java.awt.Font("Droid Sans Mono", 0, 14)); // NOI18N
        jLabel2.setText("Buscar por:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NSS", "Nombre", "Apellido Paterno", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 42, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jText_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox_opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jText_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox_opciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jText_busqueda;
    // End of variables declaration//GEN-END:variables
}
