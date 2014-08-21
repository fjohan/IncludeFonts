/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.lu.includefonts;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

/**
 *
 * @author johanf
 */
public class PaintTextPane extends JTextPane {

    int rx = 0;
    int ry = 0;
    int gx = 0;
    int gy = 0;
    int dot = 0;
    private final CaretListener caretL;
    private JTextComponent jtc;
    private final ScheduledExecutorService executorService;

    public PaintTextPane() {
        super();

        jtc = (JTextComponent) this;

        caretL = new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                dot = e.getDot();
            }
        };

        addCaretListener(caretL);


        executorService = Executors.newSingleThreadScheduledExecutor();

        long timeBase = 100;

        executorService.scheduleAtFixedRate(new Runnable() {
            
            Rectangle r;
            @Override
            public void run() {
                try {
                    r = jtc.modelToView(dot);
                    rx = r.x;
                    ry = r.y;
                } catch (BadLocationException ex) {
                    Logger.getLogger(PaintTextPane.class.getName()).log(Level.SEVERE, null, ex);
                }
                gx = rx + randInt(-5, 5);
                gy = ry + randInt(-5, 5);
                repaint();
            }
        }, timeBase, timeBase, TimeUnit.MILLISECONDS);



    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.RED);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawOval(rx - 6, ry - 6, 12, 12);

        g2d.setPaint(Color.GREEN);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawOval(gx - 6, gy - 6, 12, 12);

    }

    public static int randInt(int min, int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
