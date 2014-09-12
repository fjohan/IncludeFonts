/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.lu.scriptlog.util.ui;

import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author johanf
 */
public class DesktopLocator {

    public DesktopLocator() {
    }

    public void maxHpercW(JInternalFrame jif, double perc) {
        maxHpercW(jif, perc, perc);
    }

    public void maxHpercW(JInternalFrame jif, double perc1, double perc2) {
        if (perc1 > 1 || perc1 < 0) {
            return;
        }
        if (perc2 > 1 || perc2 < 0) {
            return;
        }
        Dimension deskSize = jif.getParent().getSize();
        Double leftEdgeD = deskSize.width * (1 - perc1);
        int leftEdge = leftEdgeD.intValue();
        Double rightEdgeD = deskSize.width * perc2;
        int rightEdge = rightEdgeD.intValue();
        jif.setBounds(leftEdge, 0, rightEdge, deskSize.height);
    }

    public void centerOnDesktop(JInternalFrame jif) {
        Dimension frameSize = jif.getSize();
        Dimension deskSize = jif.getParent().getSize();
        if (deskSize.width < frameSize.width) {
            deskSize.width = frameSize.width;
        }
        if (deskSize.height < frameSize.height) {
            deskSize.height = frameSize.height;
        }
        jif.setLocation((deskSize.width - frameSize.width) / 2, (deskSize.height - frameSize.height) / 2);
    }
}
