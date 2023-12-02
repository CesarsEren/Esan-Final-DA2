/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTIL;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author xhesm
 */
public class NumberOnlyDocument extends PlainDocument {

    int MAX_LENGTH = 0;

    public NumberOnlyDocument(int size) {
        this.MAX_LENGTH = size;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        // Verificar si la cadena contiene solo dígitos
        if (str != null && str.matches("[0-9]+") && getLength() + str.length() <= MAX_LENGTH) {
            super.insertString(offset, str, attr);
        }
        // Ignorar la entrada que no son números
    }
}
