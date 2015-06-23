/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.multixsoft.hospitapp.utilities;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

/**
 *
 * @author manuelmartinez
 */
public class FixedSizeEmailDocument extends PlainDocument {

    private final JTextComponent owner;
    private final int fixedSize;

    public FixedSizeEmailDocument(JTextComponent owner, int fixedSize) {
        this.owner = owner;
        this.fixedSize = fixedSize;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException {
        if (getLength() + str.length() > fixedSize) {
            str = str.substring(0, fixedSize - getLength());
            this.owner.getToolkit().beep();
        }

        if (containsForbidenCharacters(str)) {
            this.owner.getToolkit().beep();
            return;
        }

        super.insertString(offs, str, a);
    }

    private boolean containsForbidenCharacters(String s) {
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!Character.isDigit(c) && !Character.isAlphabetic(c) 
                    && c != '_' && c != '@' && c != '.' && c!='_') {
                return true;
            }
        }
        return false;
    }
}
