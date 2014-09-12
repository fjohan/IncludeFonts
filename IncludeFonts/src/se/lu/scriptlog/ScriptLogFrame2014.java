/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.lu.scriptlog;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author johanf
 */
public class ScriptLogFrame2014 extends javax.swing.JInternalFrame {

    private final JTextArea jta;
    private final DocumentLogger docLog;
    private final KeyLogger keyLog;
    //private MouseLogger mouseLog;
    //private CaretLogger caretLog;
    //private UndoableEditLogger undoEditLog;
    //private ViewLogger viewLog; <-- NEW
    

    /**
     * Creates new form ScriptLogFrame2014
     * @param jta
     */
    public ScriptLogFrame2014(final JTextArea jta) {
        initComponents();
        this.jta = jta;
        docLog = new DocumentLogger(jTextPane1, jta);
        keyLog = new KeyLogger(jTextPane1, jta);
        
        JViewport jv = jScrollPane1.getViewport();
        jv.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                jta.append(e.getSource() + "\n");
            }
        });
        
        
        
        
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        jTextPane1 = new JTextPane();

        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setViewportView(jTextPane1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JScrollPane jScrollPane1;
    private JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

}
