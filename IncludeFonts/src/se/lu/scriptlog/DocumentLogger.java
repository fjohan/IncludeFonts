/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.lu.scriptlog;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author johanf
 */
public class DocumentLogger implements ScriptLogLogger {

    public DocumentLogger(JTextPane jtp, final JTextArea jta) {
        DocumentFilter docF = new DocumentFilter() {
            
            String tmpString;
            
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String str, AttributeSet attr) throws BadLocationException {
                long now = getCurrentTime();
                //recordRecordable(new InsertStringRecordable(101, now, offset, str));
                tmpString = String.join(" ", "<insertString>", now + "", offset + "", str);
                System.out.println(tmpString);
                //jta.append(String.join(" ", "<insertString>", now + "", offset + "", str) + "\n");
                //toFile(null, String.join(" ", "<insertString>", now + "", offset + "", str));
                fb.insertString(offset, str, attr);
                //super.insertString(fb, offset, str, attr);
            }

            @Override
            public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
                long now = getCurrentTime();
                //recordRecordable(new RemoveRecordable(102, now, offset, length));
                tmpString = String.join(" ", "<remove>", now + "", offset + "", length + "");
                System.out.println(tmpString);
                //jta.append(String.join(" ", "<remove>", now + "", offset + "", length + "") + "\n");
                fb.remove(offset, length);
                //super.remove(fb, offset, length);
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String str, AttributeSet attr) throws BadLocationException {
                long now = getCurrentTime();
                tmpString = String.join(" ", "<replace>", now + "", offset + "", length + "", str);
                System.out.println(tmpString);
                //jta.append(String.join(" ", "<replace>", now + "", offset + "", length + "", str) + "\n");
//                if ("bcdfghjklmnpqrstvwxzaeiouyåäö".contains(str)) {
//                    //if ("aeiouyåäö".matches(".*"+str+".*")) {
//                    str = "x";
////                    str = str + str;
//                }

//            if (isDoubleVowels()) {
//                if ("aeiouyåäö".contains(str)) {
//                    //if ("aeiouyåäö".matches(".*"+str+".*")) {
//                    str = str + str;
//                }
//            }
//            if (isDoubleConsonants()) {
//                if ("bcdfghjklmnpqrstvwxz".contains(str)) {
//                    //if ("aeiouyåäö".matches(".*"+str+".*")) {
//                    str = str + str;
//                }
//            }
//            /*if ("$".contains(str)) {
//                str = "Money, money, money! ";
//            }*/

                //recordRecordable(new ReplaceRecordable(103, now, offset, length, str));
                fb.replace(offset, length, str, attr);

                // for debugging word gaze
                // TODO: remove when working
                //Rectangle2D bounds = metrics.getStringBounds(str, null);
                //System.out.println("Bounds: " + str + " " + bounds.toString());

                //super.replace(fb, offset, length, str, attr);
            }
        };
        ((AbstractDocument) jtp.getDocument()).setDocumentFilter(docF);
    }
}
