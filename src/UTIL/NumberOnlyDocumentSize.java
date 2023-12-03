/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTIL;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author xhesm
 */
public class NumberOnlyDocumentSize extends PlainDocument {

    int MAX_NUMBER = 0;

    public NumberOnlyDocumentSize(int maxNum) {

        this.MAX_NUMBER = maxNum;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        // Verificar si la cadena contiene solo dígitos y el número es menor o igual a 100
        if (str != null && str.matches("[0-9]+")) {
            int value = Integer.parseInt(getText(0, offset).trim() + str.trim() + getText(offset, getLength()).trim());
            //System.out.println("value "+value);
            if (value <= MAX_NUMBER) {
                super.insertString(offset, str, attr);
            }
        }
        // Ignorar la entrada que no son números o números mayores a 100
    }
}
