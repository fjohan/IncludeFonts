/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.lu.scriptlog;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TreeSet;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author johanf
 */
public class KeyLogger implements Logger {

    public KeyLogger(JTextPane jtp, final JTextArea jta) {

        final TreeSet keyCodeSet = new TreeSet();

        KeyListener keyL = new KeyAdapter() {
            
            @Override
            public void keyPressed(KeyEvent evt) {
                long now = getCurrentTime();
                if (keyCodeSet.add(evt.getKeyCode())) {
                    int keyCode = evt.getKeyCode();
                    jta.append(now + ": keyPressed\n");
                    //recordRecordable(new KeyPressedRecordable(207, now, keyCode));
                }
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                long now = getCurrentTime();
                if (keyCodeSet.remove(evt.getKeyCode())) {
                    int keyCode = evt.getKeyCode();
                    jta.append(now + ": keyReleased\n");
                    //recordRecordable(new KeyReleasedRecordable(208, now, keyCode));
                }
            }
        };

        jtp.addKeyListener(keyL);
    }
}
