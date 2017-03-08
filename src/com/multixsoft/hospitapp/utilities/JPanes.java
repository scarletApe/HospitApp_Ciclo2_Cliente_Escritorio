/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.utilities;

import com.multixsoft.hospitapp.connector.ConectorDoctorManager;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author manuelmartinez
 */
public class JPanes {
    
    private static final JPanes INSTANCE = 
            new JPanes();
    
    public static JPanes getInstance() {
        return INSTANCE;
    }
    
    public  void errorPane(String s) {
        Icon i = new ImageIcon(getClass().getResource("/com/multixsoft/hospitapp/imagenes/icon-warning.png"));
        JOptionPane.showMessageDialog(null, s, "Mensaje de Error", JOptionPane.ERROR_MESSAGE,i);
    }

    public  void msgPane(String s) {
        Icon i = new ImageIcon(getClass().getResource("/com/multixsoft/hospitapp/imagenes/icon-like.png"));
        JOptionPane.showMessageDialog(null, s, "Mensaje", JOptionPane.INFORMATION_MESSAGE,i);
    }
    
    public  void mailMsgPane(String s) {
        Icon i = new ImageIcon(getClass().getResource("/com/multixsoft/hospitapp/imagenes/icon-mail.png"));
        JOptionPane.showMessageDialog(null, s, "Mensaje", JOptionPane.INFORMATION_MESSAGE,i);
    }
}
