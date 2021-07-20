/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperClasses;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Srdjan
 */
public class Limiter extends PlainDocument {

    private int max = 0;

    public Limiter(int max) {
        this.max = max;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (getLength()+ str.length() > max) {
            str = str.substring(0, max - getLength());
        }
        super.insertString(offs, str, a);
    }
    
}
