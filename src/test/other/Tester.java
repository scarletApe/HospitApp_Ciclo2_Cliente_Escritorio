/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.other;

import com.multixsoft.hospitapp.utilities.FixedSizeAlphabeticalDocument;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author manuelmartinez
 */
public class Tester {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        
//        JTextField textfield = new JTextField();
//        textfield.setDocument(new FixedSizeNumberDocument(textfield,5));
//        f.add(textfield);
        
        JTextField textfield = new JTextField();
        textfield.setDocument(new FixedSizeAlphabeticalDocument(textfield,5));
        f.add(textfield);
        
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
