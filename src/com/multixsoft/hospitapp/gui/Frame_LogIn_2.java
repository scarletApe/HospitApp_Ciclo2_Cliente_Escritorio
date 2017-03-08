/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.gui;

/**
 *
 * @author manuelmartinez
 */
import com.jhlabs.image.BrushedMetalFilter;
import com.multixsoft.hospitapp.connector.ConectorPrivacyControl;
import com.multixsoft.hospitapp.connector.ConectorServicio;
import com.multixsoft.hospitapp.entities.Doctor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.*;

public class Frame_LogIn_2 {

    public static void main(String[] args) throws IOException {

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
//                if ("Metal".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    changedLook = true;
//                    break;
//                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Frame_LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // Starting the Swing GUI in the EDT, learn about it
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Ingrese a HospitApp Escritorio");

                // set frame size as Demo perposes, otherwise not recommended
                frame.setSize(new Dimension(500, 300));

                frame.add(new MainContainer(frame));

                Toolkit aKit = frame.getToolkit();
                Dimension windowSize = aKit.getScreenSize();
                frame.setBounds((windowSize.width / 2) - (frame.getWidth() / 2),
                        (windowSize.height / 2) - (frame.getHeight() / 2),
                        frame.getWidth(), frame.getHeight());

                frame.setResizable(false);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }
        });
    }
}

/**
 * creating the MainContainer panel with custom look *
 */
// custom painting to with paintComponent(Graphics g) and paint(Graphics g)
class MainContainer extends JPanel {

    public BufferedImage gradientImage = null;
    private final JFrame papa;

    public MainContainer(final JFrame pap) {

        this.papa = pap;

        setBorder(new EmptyBorder(50, 50, 50, 50)); // setting the insets 
        // learn about GridBagLayout from the linked page about LayoutManager
        setLayout(new GridBagLayout());

        final JLabel JTextFieldUsername = new JLabel("User Name");
        changeCompFont(JTextFieldUsername);

        final JTextField usrNameFeild = new JTextField();
//        changeCompFont(usrNameFeild);

//         create compund border for text and password feild with left padding 5 px
//        Border compundBorder = BorderFactory.createCompoundBorder(
//                                            new LineBorder(Color.white, 2), 
//                                            new EmptyBorder(2, 5, 2, 2));
//        usrNameFeild.setBorder(compundBorder);
//        usrNameFeild.setOpaque(false);
        JTextFieldUsername.setLabelFor(usrNameFeild);

        JLabel passwordLabel = new JLabel("Password");
        changeCompFont(passwordLabel);

        final JPasswordField jPasswordField = new JPasswordField();
//        changeCompFont(passFeild);
//        passFeild.setBorder(compundBorder);

//        passFeild.setOpaque(false);
        passwordLabel.setLabelFor(jPasswordField);

        // working with GridBagConstraints, please check out the linked online tutorial 
        GridBagConstraints labCnst = new GridBagConstraints();
        GridBagConstraints txtCnst = new GridBagConstraints();

        labCnst.insets = new Insets(0, 0, 5, 10);
        txtCnst.insets = new Insets(0, 0, 5, 10);

        labCnst.ipady = txtCnst.ipady = 10;
        txtCnst.fill = labCnst.fill = GridBagConstraints.HORIZONTAL;

        labCnst.gridx = 0;
        txtCnst.gridx = 1;

        labCnst.gridwidth = 1;
        txtCnst.gridwidth = 2;

        labCnst.weightx = 0.3;
        txtCnst.weightx = 0.7;

        txtCnst.gridy = labCnst.gridy = 0;
        add(JTextFieldUsername, labCnst);
        add(usrNameFeild, txtCnst);

        txtCnst.gridy = labCnst.gridy = 1;
        add(passwordLabel, labCnst);
        add(jPasswordField, txtCnst);

        labCnst.gridx = 2;
        labCnst.gridy = 2;
        labCnst.ipady = 13;
        labCnst.insets = new Insets(0, 0, 0, 150);

        final Container f = this.getParent();
        JButton submitButt = new JButton("Log In");
        add(submitButt, labCnst);

        labCnst.insets = new Insets(0, 0, 5, 10);
        labCnst.gridx = 2;
        labCnst.gridy = 3;
        labCnst.ipady = 13;
        final JLabel jLabelIncorrectMessage = new JLabel("");
        add(jLabelIncorrectMessage, labCnst);

        submitButt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usrNameFeild.getText();
                String pass = new String(jPasswordField.getPassword());
                String ip ;//= "192.168.137.1";//jTextFieldIPServidor.getText();
                ip = "192.168.137.1";

                if (username != null && pass != null && ip != null) {
                    if (!username.isEmpty() && !pass.isEmpty() && !ip.isEmpty()) {

                        if (contieneCharacteresInvalidos(username)) {
                            jLabelIncorrectMessage.setText("?\\#%! El username contiene caracteres inválidos. ");
                            jLabelIncorrectMessage.setForeground(Color.red);
                            return;
                        }

//                        String url = "http://" + ip + ":8080/HospitAppServerCiclo1/webresources/";
//
//                        ConectorServicio.URL_BASE = url;

                        ConectorServicio conectorServicio = ConectorServicio.getInstance();
                        ConectorPrivacyControl conectorPrivacy = ConectorPrivacyControl.getInstance();
                        int access = conectorPrivacy.accessAsAdminOrDoctor(username, pass);
//        System.err.println("Codigo: " + access);
                        if (access == 2) {
                            Frame_Administrador mf = new Frame_Administrador();
                            mf.setVisible(true);

                            papa.setVisible(false);
                            papa.dispose();

                        } else if (access == 1) {
//            System.err.print(username);
                            Doctor doctor = conectorServicio.obtenerDoctor(username);

                            Frame_Doctor doctorFrame = new Frame_Doctor(doctor);
                            doctorFrame.setVisible(true);

                            papa.setVisible(false);
                            papa.dispose();
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
            }
        });

//        this.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }

    public void changeCompFont(JComponent comp) {
        comp.setForeground(Color.WHITE);
        comp.setFont(getFont().deriveFont(Font.BOLD, 18));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

        BufferedImage backgroundImg = new BufferedImage(this.getWidth(),
                this.getHeight(), BufferedImage.TYPE_INT_ARGB);

        BrushedMetalFilter bmf = new BrushedMetalFilter();
        bmf.filter(backgroundImg, backgroundImg);

//        backgroundImg = BorderBackImage.createGradientImg(this.getWidth(), this.getHeight());
        g.drawImage(backgroundImg, 0, 0, null);
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
}
