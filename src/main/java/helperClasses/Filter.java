/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperClasses;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Srdjan
 */
public class Filter extends DocumentFilter {

    private int max = 0;
    
    public Filter(int max){
        this.max = max;
    }
    
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));
        sb.insert(offset, string);

        if (check(sb.toString())) {
            if (doc.getLength() + string.length() > max) {
            string = string.substring(0, max - doc.getLength());
            }
            super.insertString(fb, offset, string, attr);       
        } else {

        }
    }

    public boolean check(String string) {
        if(string.equalsIgnoreCase("")){
            return true;
        }
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {

        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));
        sb.replace(offset, offset + length, string);

        if (check(sb.toString())) {
            if (doc.getLength() + string.length() > max) {
            string = string.substring(0, max - doc.getLength());
            }
            super.replace(fb, offset, length, string, attrs);
        } else {
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        Document doc = fb.getDocument();
        StringBuilder sb = new StringBuilder();
        sb.append(doc.getText(0, doc.getLength()));
        sb.delete(offset, offset + length);

        if (check(sb.toString())) {
            super.remove(fb, offset, length);
        } else {
        }
    }

}
