/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.gui;

import com.multixsoft.hospitapp.connector.ConectorDoctorManager;
import com.multixsoft.hospitapp.connector.ConectorScheduleManager;
import com.multixsoft.hospitapp.entities.Doctor;
import com.multixsoft.hospitapp.entities.Schedule;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import com.multixsoft.hospitapp.utilities.IntervalFilter;
import com.multixsoft.hospitapp.utilities.JPanes;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;

/**
 *
 * @author manuelmartinez
 */
public class Frame_Horarios extends javax.swing.JFrame {

    private Doctor doctor;
    private Schedule schedule;
    private final IntervalFilter interval = new IntervalFilter();
    private JToggleButton[] allButtons;

    /**
     * Creates new form HorariosJFrame
     */
    public Frame_Horarios() {
        initComponents();
        
        fillAllButtonArray();

        //center the frame in the center of the screen
        Toolkit aKit = this.getToolkit();
        Dimension windowSize = aKit.getScreenSize();
        this.setBounds((windowSize.width / 2) - (this.getWidth() / 2),
                (windowSize.height / 2) - (this.getHeight() / 2),
                this.getWidth(), this.getHeight());
    }

    public Frame_Horarios(Doctor d) {
        this();
        doctor = d;
        this.setTitle("Horario de " + d.getFirstName() + " " + d.getLastName());
        fillSchedule();
    }

    private void fillSchedule() {
        ConectorScheduleManager sm = ConectorScheduleManager.getInstance();
        schedule = sm.getAvailableSchedule(doctor, false);

        String monday = schedule.getMonday();
        String tuesday = schedule.getTuesday();
        String wednesday = schedule.getWednesday();
        String thursday = schedule.getThursday();
        String friday = schedule.getFriday();

        if (!monday.equals(" ")) {
            System.err.println(monday);
            JToggleButton botonesLunes[] = {jTBLun8, jTBLun9, jTBLun10, jTBLun11, jTBLun12,
                jTBLun13, jTBLun14, jTBLun15, jTBLun16, jTBLun17, jTBLun18, jTBLun19};
            activate(interval.getHours(monday), botonesLunes);
        }

        if (!tuesday.equals(" ")) {
            System.err.println(tuesday);
            //para el martes
            JToggleButton botonesMartes[] = {jTBMar8, jTBMar9, jTBMar10, jTBMar11, jTBMar12,
                jTBMar13, jTBMar14, jTBMar15, jTBMar16, jTBMar17, jTBMar18, jTBMar19};
            activate(interval.getHours(tuesday), botonesMartes);

        }

        if (!wednesday.equals(" ")) {
            System.err.println(wednesday);
            //para el wednesday
            JToggleButton botonesMiercoles[] = {jTBMie8, jTBMie9, jTBMie10, jTBMie11, jTBMie12,
                jTBMie13, jTBMie14, jTBMie15, jTBMie16, jTBMie17, jTBMie18, jTBMie19};
            activate(interval.getHours(wednesday), botonesMiercoles);

        }

        if (!thursday.equals(" ")) {
            System.err.println(thursday);
            //para el thursday
            JToggleButton botonesJueves[] = {jTBJue8, jTBJue9, jTBJue10, jTBJue11, jTBJue12,
                jTBJue13, jTBJue14, jTBJue15, jTBJue16, jTBJue17, jTBJue18, jTBJue19};
            activate(interval.getHours(thursday), botonesJueves);

        }

        if (!friday.equals(" ")) {
            System.err.println(friday);
            //para el Jueves
            JToggleButton botonesViernes[] = {jTBVie8, jTBVie9, jTBVie10, jTBVie11, jTBVie12,
                jTBVie13, jTBVie14, jTBVie15, jTBVie16, jTBVie17, jTBVie18, jTBVie19};
            activate(interval.getHours(friday), botonesViernes);

        }

    }

    private void activate(String dia, JToggleButton to[]) {

        String[] split = dia.split(",");
        for (int i = 0; i < split.length; i++) {
            int n = Integer.parseInt(split[i]);
            JToggleButton b = to[n - 8];
            b.setSelected(true);
        }
    }

    private void fillAllButtonArray() {
        JToggleButton[] todosBotones = {
            jTBLun8, jTBLun9, jTBLun10, jTBLun11, jTBLun12,
            jTBLun13, jTBLun14, jTBLun15, jTBLun16, jTBLun17, jTBLun18, jTBLun19,
            jTBMar8, jTBMar9, jTBMar10, jTBMar11, jTBMar12,
            jTBMar13, jTBMar14, jTBMar15, jTBMar16, jTBMar17, jTBMar18, jTBMar19,
            jTBMie8, jTBMie9, jTBMie10, jTBMie11, jTBMie12,
            jTBMie13, jTBMie14, jTBMie15, jTBMie16, jTBMie17, jTBMie18, jTBMie19,
            jTBJue8, jTBJue9, jTBJue10, jTBJue11, jTBJue12,
            jTBJue13, jTBJue14, jTBJue15, jTBJue16, jTBJue17, jTBJue18, jTBJue19,
            jTBVie8, jTBVie9, jTBVie10, jTBVie11, jTBVie12,
            jTBVie13, jTBVie14, jTBVie15, jTBVie16, jTBVie17, jTBVie18, jTBVie19
        };
        this.allButtons = todosBotones;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton70 = new javax.swing.JToggleButton();
        jToggleButton71 = new javax.swing.JToggleButton();
        jToggleButton72 = new javax.swing.JToggleButton();
        jToggleButton73 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTBLun8 = new javax.swing.JToggleButton();
        jTBLun9 = new javax.swing.JToggleButton();
        jTBLun10 = new javax.swing.JToggleButton();
        jTBLun11 = new javax.swing.JToggleButton();
        jTBLun12 = new javax.swing.JToggleButton();
        jTBLun13 = new javax.swing.JToggleButton();
        jTBLun14 = new javax.swing.JToggleButton();
        jTBLun15 = new javax.swing.JToggleButton();
        jTBLun16 = new javax.swing.JToggleButton();
        jTBLun17 = new javax.swing.JToggleButton();
        jTBLun18 = new javax.swing.JToggleButton();
        jTBLun19 = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jTBMar8 = new javax.swing.JToggleButton();
        jTBMar9 = new javax.swing.JToggleButton();
        jTBMar10 = new javax.swing.JToggleButton();
        jTBMar11 = new javax.swing.JToggleButton();
        jTBMar12 = new javax.swing.JToggleButton();
        jTBMar13 = new javax.swing.JToggleButton();
        jTBMar14 = new javax.swing.JToggleButton();
        jTBMar15 = new javax.swing.JToggleButton();
        jTBMar18 = new javax.swing.JToggleButton();
        jTBMar19 = new javax.swing.JToggleButton();
        jTBMar16 = new javax.swing.JToggleButton();
        jTBMar17 = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jTBMie8 = new javax.swing.JToggleButton();
        jTBMie9 = new javax.swing.JToggleButton();
        jTBMie10 = new javax.swing.JToggleButton();
        jTBMie11 = new javax.swing.JToggleButton();
        jTBMie12 = new javax.swing.JToggleButton();
        jTBMie13 = new javax.swing.JToggleButton();
        jTBMie14 = new javax.swing.JToggleButton();
        jTBMie15 = new javax.swing.JToggleButton();
        jTBMie18 = new javax.swing.JToggleButton();
        jTBMie19 = new javax.swing.JToggleButton();
        jTBMie16 = new javax.swing.JToggleButton();
        jTBMie17 = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jTBJue8 = new javax.swing.JToggleButton();
        jTBJue9 = new javax.swing.JToggleButton();
        jTBJue10 = new javax.swing.JToggleButton();
        jTBJue11 = new javax.swing.JToggleButton();
        jTBJue12 = new javax.swing.JToggleButton();
        jTBJue13 = new javax.swing.JToggleButton();
        jTBJue14 = new javax.swing.JToggleButton();
        jTBJue15 = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        jTBJue18 = new javax.swing.JToggleButton();
        jTBJue19 = new javax.swing.JToggleButton();
        jTBJue16 = new javax.swing.JToggleButton();
        jTBJue17 = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jTBVie8 = new javax.swing.JToggleButton();
        jTBVie9 = new javax.swing.JToggleButton();
        jTBVie10 = new javax.swing.JToggleButton();
        jTBVie11 = new javax.swing.JToggleButton();
        jTBVie12 = new javax.swing.JToggleButton();
        jTBVie13 = new javax.swing.JToggleButton();
        jTBVie14 = new javax.swing.JToggleButton();
        jTBVie15 = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        jTBVie18 = new javax.swing.JToggleButton();
        jTBVie19 = new javax.swing.JToggleButton();
        jTBVie16 = new javax.swing.JToggleButton();
        jTBVie17 = new javax.swing.JToggleButton();
        jButtonAceptar = new javax.swing.JButton();
        jButtonSelectAll = new javax.swing.JButton();
        jButtonUnselectAll = new javax.swing.JButton();

        jToggleButton5.setText("jToggleButton5");

        jToggleButton70.setText("18:00-19:00");

        jToggleButton71.setText("19:00-20:00");

        jToggleButton72.setText("16:00-17:00");

        jToggleButton73.setText("17:00-18:00");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Horarios");

        jLabel1.setText("Lunes");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTBLun8.setText("8:00-9:00");

        jTBLun9.setText("9:00-10:00");
        jTBLun9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBLun9ActionPerformed(evt);
            }
        });

        jTBLun10.setText("10:00-11:00");

        jTBLun11.setText("11:00-12:00");

        jTBLun12.setText("12:00-13:00");

        jTBLun13.setText("13:00-14:00");

        jTBLun14.setText("14:00-15:00");

        jTBLun15.setText("15:00-16:00");

        jTBLun16.setText("16:00-17:00");

        jTBLun17.setText("17:00-18:00");

        jTBLun18.setText("18:00-19:00");

        jTBLun19.setText("19:00-20:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTBLun11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBLun12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBLun13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBLun10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBLun14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBLun15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBLun9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBLun8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTBLun16)
                    .addComponent(jTBLun17)
                    .addComponent(jTBLun18)
                    .addComponent(jTBLun19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTBLun8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBLun9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBLun10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBLun11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBLun12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBLun13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBLun14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBLun15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBLun16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBLun17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBLun18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBLun19)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel6.setText("Martes");

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTBMar8.setText("8:00-9:00");

        jTBMar9.setText("9:00-10:00");
        jTBMar9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBMar9ActionPerformed(evt);
            }
        });

        jTBMar10.setText("10:00-11:00");

        jTBMar11.setText("11:00-12:00");

        jTBMar12.setText("12:00-13:00");

        jTBMar13.setText("13:00-14:00");

        jTBMar14.setText("14:00-15:00");

        jTBMar15.setText("15:00-16:00");

        jTBMar18.setText("18:00-19:00");

        jTBMar19.setText("19:00-20:00");

        jTBMar16.setText("16:00-17:00");

        jTBMar17.setText("17:00-18:00");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTBMar11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMar12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMar13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMar10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMar14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMar15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMar9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMar8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTBMar16)
                    .addComponent(jTBMar17)
                    .addComponent(jTBMar18)
                    .addComponent(jTBMar19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTBMar8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMar9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMar10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMar11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMar12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMar13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMar14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMar15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMar16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMar17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMar18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMar19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Miercoles");

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTBMie8.setText("8:00-9:00");

        jTBMie9.setText("9:00-10:00");
        jTBMie9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBMie9ActionPerformed(evt);
            }
        });

        jTBMie10.setText("10:00-11:00");

        jTBMie11.setText("11:00-12:00");

        jTBMie12.setText("12:00-13:00");

        jTBMie13.setText("13:00-14:00");

        jTBMie14.setText("14:00-15:00");

        jTBMie15.setText("15:00-16:00");

        jTBMie18.setText("18:00-19:00");

        jTBMie19.setText("19:00-20:00");

        jTBMie16.setText("16:00-17:00");

        jTBMie17.setText("17:00-18:00");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTBMie11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMie12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMie13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMie10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMie14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMie15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMie9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBMie8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTBMie16)
                    .addComponent(jTBMie17)
                    .addComponent(jTBMie18)
                    .addComponent(jTBMie19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTBMie8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMie9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMie10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMie11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMie12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMie13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMie14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMie15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMie16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMie17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMie18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBMie19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setText("Jueves");

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTBJue8.setText("8:00-9:00");

        jTBJue9.setText("9:00-10:00");
        jTBJue9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBJue9ActionPerformed(evt);
            }
        });

        jTBJue10.setText("10:00-11:00");

        jTBJue11.setText("11:00-12:00");

        jTBJue12.setText("12:00-13:00");

        jTBJue13.setText("13:00-14:00");

        jTBJue14.setText("14:00-15:00");

        jTBJue15.setText("15:00-16:00");

        jLabel9.setText("Lunes");

        jTBJue18.setText("18:00-19:00");

        jTBJue19.setText("19:00-20:00");

        jTBJue16.setText("16:00-17:00");

        jTBJue17.setText("17:00-18:00");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTBJue11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBJue12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBJue13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBJue10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBJue14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBJue15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBJue9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBJue8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTBJue16)
                    .addComponent(jTBJue17)
                    .addComponent(jTBJue18)
                    .addComponent(jTBJue19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTBJue8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBJue9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBJue10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBJue11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBJue12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBJue13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBJue14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBJue15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBJue16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBJue17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBJue18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBJue19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setText("Viernes");

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTBVie8.setText("8:00-9:00");

        jTBVie9.setText("9:00-10:00");
        jTBVie9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBVie9ActionPerformed(evt);
            }
        });

        jTBVie10.setText("10:00-11:00");

        jTBVie11.setText("11:00-12:00");

        jTBVie12.setText("12:00-13:00");

        jTBVie13.setText("13:00-14:00");

        jTBVie14.setText("14:00-15:00");

        jTBVie15.setText("15:00-16:00");

        jLabel11.setText("Lunes");

        jTBVie18.setText("18:00-19:00");

        jTBVie19.setText("19:00-20:00");

        jTBVie16.setText("16:00-17:00");

        jTBVie17.setText("17:00-18:00");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTBVie11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBVie12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBVie13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBVie10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBVie14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBVie15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBVie9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTBVie8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTBVie16)
                    .addComponent(jTBVie17)
                    .addComponent(jTBVie18)
                    .addComponent(jTBVie19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTBVie8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBVie9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBVie10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBVie11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBVie12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBVie13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBVie14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBVie15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBVie16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBVie17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBVie18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTBVie19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonSelectAll.setText("Seleccionar Todos");
        jButtonSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectAllActionPerformed(evt);
            }
        });

        jButtonUnselectAll.setText("Deseleccionar Todos");
        jButtonUnselectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnselectAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSelectAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUnselectAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonSelectAll)
                    .addComponent(jButtonUnselectAll))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTBLun9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBLun9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBLun9ActionPerformed

    private void jTBMar9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBMar9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBMar9ActionPerformed

    private void jTBMie9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBMie9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBMie9ActionPerformed

    private void jTBJue9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBJue9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBJue9ActionPerformed

    private void jTBVie9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBVie9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBVie9ActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        //para el Jueves
        JToggleButton botonesLunes[] = {jTBLun8, jTBLun9, jTBLun10, jTBLun11, jTBLun12,
            jTBLun13, jTBLun14, jTBLun15, jTBLun16, jTBLun17, jTBLun18, jTBLun19};
        String lunes = getStringData(botonesLunes);

        //para el Jueves
        JToggleButton botonesMartes[] = {jTBMar8, jTBMar9, jTBMar10, jTBMar11, jTBMar12,
            jTBMar13, jTBMar14, jTBMar15, jTBMar16, jTBMar17, jTBMar18, jTBMar19};
        String martes = getStringData(botonesMartes);

        //para el Jueves
        JToggleButton botonesMiercoles[] = {jTBMie8, jTBMie9, jTBMie10, jTBMie11, jTBMie12,
            jTBMie13, jTBMie14, jTBMie15, jTBMie16, jTBMie17, jTBMie18, jTBMie19};
        String miercoles = getStringData(botonesMiercoles);

        //para el Jueves
        JToggleButton botonesJueves[] = {jTBJue8, jTBJue9, jTBJue10, jTBJue11, jTBJue12,
            jTBJue13, jTBJue14, jTBJue15, jTBJue16, jTBJue17, jTBJue18, jTBJue19};
        String jueves = getStringData(botonesJueves);

        //para el Jueves
        JToggleButton botonesViernes[] = {jTBVie8, jTBVie9, jTBVie10, jTBVie11, jTBVie12,
            jTBVie13, jTBVie14, jTBVie15, jTBVie16, jTBVie17, jTBVie18, jTBVie19};
        String viernes = getStringData(botonesViernes);

//        long id = (long) (Math.random() * 100000);
        //Schedule sch = new Schedule(id, doctor.getUsername(),
        //      lunes, martes, miercoles, jueves, viernes);
        Schedule sch = new Schedule(schedule.getIdSchedule());
        sch.setDoctorUsername(doctor);
        sch.setMonday(lunes);
        sch.setTuesday(martes);
        sch.setWednesday(miercoles);
        sch.setThursday(jueves);
        sch.setFriday(viernes);

        ConectorDoctorManager dm = ConectorDoctorManager.getInstance();
        String setSchedule = dm.setSchedule(sch);
        if (setSchedule == null) {
            System.out.println("Error: set schedule failed");
            JPanes.getInstance().errorPane("No se pudo asignar el Horario...");
        } else {
            JPanes.getInstance().msgPane("El Horario del Médico fue actualizado con éxito.");
        }
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectAllActionPerformed
        JToggleButton b = null;
        for (int i = 0; i < allButtons.length; i++) {
            b = allButtons[i];
            b.setSelected(true);
        }
        repaint();
    }//GEN-LAST:event_jButtonSelectAllActionPerformed

    private void jButtonUnselectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnselectAllActionPerformed
        JToggleButton b = null;
        for (int i = 0; i < allButtons.length; i++) {
            b = allButtons[i];
            b.setSelected(false);
        }
        repaint();
    }//GEN-LAST:event_jButtonUnselectAllActionPerformed

    private String getStringData(JToggleButton[] l) {
        StringBuilder sb = new StringBuilder();
        int hoursIfSelected;
        for (int i = 0; i < l.length; i++) {
            hoursIfSelected = getHoursIfSelected(l[i], i + 8);
            if (hoursIfSelected != 0) {
                hoursIfSelected = i + 8;
                sb.append(hoursIfSelected).append(",");
            }
        }
        return sb.toString();
    }

    private int getHoursIfSelected(JToggleButton tb, int n) {
        if (tb.isSelected()) {
            return n;
        }
        return 0;
    }

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
            java.util.logging.Logger.getLogger(Frame_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Horarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonSelectAll;
    private javax.swing.JButton jButtonUnselectAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jTBJue10;
    private javax.swing.JToggleButton jTBJue11;
    private javax.swing.JToggleButton jTBJue12;
    private javax.swing.JToggleButton jTBJue13;
    private javax.swing.JToggleButton jTBJue14;
    private javax.swing.JToggleButton jTBJue15;
    private javax.swing.JToggleButton jTBJue16;
    private javax.swing.JToggleButton jTBJue17;
    private javax.swing.JToggleButton jTBJue18;
    private javax.swing.JToggleButton jTBJue19;
    private javax.swing.JToggleButton jTBJue8;
    private javax.swing.JToggleButton jTBJue9;
    private javax.swing.JToggleButton jTBLun10;
    private javax.swing.JToggleButton jTBLun11;
    private javax.swing.JToggleButton jTBLun12;
    private javax.swing.JToggleButton jTBLun13;
    private javax.swing.JToggleButton jTBLun14;
    private javax.swing.JToggleButton jTBLun15;
    private javax.swing.JToggleButton jTBLun16;
    private javax.swing.JToggleButton jTBLun17;
    private javax.swing.JToggleButton jTBLun18;
    private javax.swing.JToggleButton jTBLun19;
    private javax.swing.JToggleButton jTBLun8;
    private javax.swing.JToggleButton jTBLun9;
    private javax.swing.JToggleButton jTBMar10;
    private javax.swing.JToggleButton jTBMar11;
    private javax.swing.JToggleButton jTBMar12;
    private javax.swing.JToggleButton jTBMar13;
    private javax.swing.JToggleButton jTBMar14;
    private javax.swing.JToggleButton jTBMar15;
    private javax.swing.JToggleButton jTBMar16;
    private javax.swing.JToggleButton jTBMar17;
    private javax.swing.JToggleButton jTBMar18;
    private javax.swing.JToggleButton jTBMar19;
    private javax.swing.JToggleButton jTBMar8;
    private javax.swing.JToggleButton jTBMar9;
    private javax.swing.JToggleButton jTBMie10;
    private javax.swing.JToggleButton jTBMie11;
    private javax.swing.JToggleButton jTBMie12;
    private javax.swing.JToggleButton jTBMie13;
    private javax.swing.JToggleButton jTBMie14;
    private javax.swing.JToggleButton jTBMie15;
    private javax.swing.JToggleButton jTBMie16;
    private javax.swing.JToggleButton jTBMie17;
    private javax.swing.JToggleButton jTBMie18;
    private javax.swing.JToggleButton jTBMie19;
    private javax.swing.JToggleButton jTBMie8;
    private javax.swing.JToggleButton jTBMie9;
    private javax.swing.JToggleButton jTBVie10;
    private javax.swing.JToggleButton jTBVie11;
    private javax.swing.JToggleButton jTBVie12;
    private javax.swing.JToggleButton jTBVie13;
    private javax.swing.JToggleButton jTBVie14;
    private javax.swing.JToggleButton jTBVie15;
    private javax.swing.JToggleButton jTBVie16;
    private javax.swing.JToggleButton jTBVie17;
    private javax.swing.JToggleButton jTBVie18;
    private javax.swing.JToggleButton jTBVie19;
    private javax.swing.JToggleButton jTBVie8;
    private javax.swing.JToggleButton jTBVie9;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton70;
    private javax.swing.JToggleButton jToggleButton71;
    private javax.swing.JToggleButton jToggleButton72;
    private javax.swing.JToggleButton jToggleButton73;
    // End of variables declaration//GEN-END:variables
}
