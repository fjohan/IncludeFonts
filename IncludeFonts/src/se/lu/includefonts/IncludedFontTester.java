/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.lu.includefonts;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author ling-jfr
 */
public class IncludedFontTester extends javax.swing.JInternalFrame {

    Font font1;
    Font font2;
    FontMetrics metrics1;
    FontMetrics metrics2;
    JTextArea jta;

    public IncludedFontTester(JTextArea jta) {
        initComponents();

        this.jta = jta;
//        font1 = null;

//        InputStream fontStream = getClass().getResourceAsStream("fonts/arial.ttf");
//        //InputStream fontStream = getClass().getResourceAsStream("fonts/HARNGTON.TTF");
//        try {
//            font1 = Font.createFont(Font.TRUETYPE_FONT, fontStream);
//        } catch (FontFormatException ex) {
//            Logger.getLogger(IncludedFontTester.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(IncludedFontTester.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        try {
//            font1 = font1.deriveFont(Font.PLAIN, 12);
//            fontStream.close();
//        } catch (IOException ex) {
//            Logger.getLogger(IncludedFontTester.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font1);
//        //GlyphVector gv = font1.createGlyphVector(fontRenderContext, "m");

        StyleContext context = new StyleContext();
        final StyledDocument document = jTextPane1.getStyledDocument();
        //Style style = context.getStyle(StyleContext.DEFAULT_STYLE);

        int size = 17;
        final SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(style, 1.5f);
        StyleConstants.setFontFamily(style, "Arial");
        StyleConstants.setFontSize(style, size);
        int len = document.getLength();
        document.setParagraphAttributes(0, len, style, false);

        final SimpleAttributeSet styleBold = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(styleBold, 1.5f);
        StyleConstants.setFontFamily(styleBold, "Arial");
        StyleConstants.setFontSize(styleBold, size);
        StyleConstants.setBold(styleBold, true);

        final SimpleAttributeSet styleItalic = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(styleItalic, 1.5f);
        StyleConstants.setFontFamily(styleItalic, "Arial");
        StyleConstants.setFontSize(styleItalic, size);
        StyleConstants.setItalic(styleItalic, true);

//        class DynamicIcon implements Icon {
//
//            @Override
//            public int getIconWidth() {
//                return 5;
//            }
//
//            @Override
//            public int getIconHeight() {
//                return 12;
//            }
//
//            @Override
//            public void paintIcon(Component c, Graphics g, int x, int y) {
//                System.out.println(x + ", " + y);
//                g.fill3DRect(x, y, getIconWidth(), getIconHeight(), true);
//                g.drawString("m", x, y);
//            }
//        };
//        
//        Icon icon = new DynamicIcon();



        final SimpleAttributeSet styleIB = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(styleIB, 1.5f);
        StyleConstants.setFontFamily(styleIB, "Arial");
        StyleConstants.setFontSize(styleIB, size);
        //StyleConstants.setSubscript(styleIB, true);
        StyleConstants.setBold(styleIB, true);
        StyleConstants.setItalic(styleIB, true);
//        StyleConstants.setIcon(styleIB, icon);






        try {
            document.insertString(0, "abcdefghijklmnopqrstuvwxyzåäö\n", style);
            len = document.getLength();
            document.insertString(len, "abcdefghijklmnopqrstuvwxyzåäö\n", style);
            document.setCharacterAttributes(len + 10, 10, styleBold, true);
            len = document.getLength();
            document.insertString(len, "abcdefghijklmnopqrstuvwxyzåäö\n", style);
            document.setCharacterAttributes(len + 10, 10, styleItalic, false);
            len = document.getLength();
            document.insertString(len, "abcdefghijklmnopqrstuvwxyzåäö\n", style);
            document.setCharacterAttributes(len + 10, 10, styleIB, false);
        } catch (BadLocationException ex) {
            Logger.getLogger(IncludedFontTester.class.getName()).log(Level.SEVERE, null, ex);
        }


//        final SimpleAttributeSet style12 = new SimpleAttributeSet();
//        StyleConstants.setLineSpacing(style12, 1.5f);
//        StyleConstants.setFontFamily(style12, font1.getFamily());
//        StyleConstants.setFontSize(style12, 12);
//        
//        final SimpleAttributeSet style13 = new SimpleAttributeSet();
//        StyleConstants.setLineSpacing(style13, 0.1f);
//        StyleConstants.setFontFamily(style13, font1.getFamily());
//        StyleConstants.setFontSize(style13, 13);
//
//        final SimpleAttributeSet style10 = new SimpleAttributeSet();
//        StyleConstants.setLineSpacing(style10, 0.1f);
//        StyleConstants.setFontFamily(style10, font1.getFamily());
//        StyleConstants.setFontSize(style10, 10);

//        try {
//            document.insertString(0, "Hello", style12);
//            document.insertString(document.getLength(), "Hello", style13);
//
//            String s = "v";
//            for (int i = 9; i < 16; i++) {
//                StyleConstants.setFontSize(style, i);
//                StyleConstants.setItalic(style, true);
//                len = document.getLength();
//                document.setParagraphAttributes(0, len, style, false);
//                font2 = document.getFont(jTextPane1.getParagraphAttributes());
//                metrics2 = new FontMetrics(font2) {
//                };
//                Rectangle2D bounds2 = metrics2.getStringBounds(s, null);
//                toMessage("Bounds2: " + s + " " + bounds2.toString() + "\n");
//            }
//        } catch (BadLocationException ex) {
//            Logger.getLogger(IncludedFontTester.class.getName()).log(Level.SEVERE, null, ex);
//        }

        Font f = new Font("Arial", Font.PLAIN, size);
        FontMetrics fontMetrics = new FontMetrics(f) {
        };
        Font fb = new Font("Arial", Font.BOLD, size);
        FontMetrics fontMetricsb = new FontMetrics(fb) {
        };
        Font f10 = new Font("Arial", Font.PLAIN, 15);
        FontMetrics fontMetrics10 = new FontMetrics(f10) {
        };
        Font f11 = new Font("Arial", Font.PLAIN, 16);
        FontMetrics fontMetrics11 = new FontMetrics(f11) {
        };

        double[] refValues12win = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 3.0, 4.0, 7.0, 7.0, 11.0, 8.0, 2.0, 4.0, 4.0, 5.0, 7.0, 3.0, 4.0, 3.0, 3.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 3.0, 3.0, 7.0, 7.0, 7.0, 7.0, 12.0, 7.0, 8.0, 9.0, 9.0, 8.0, 7.0, 9.0, 9.0, 3.0, 6.0, 8.0, 7.0, 9.0, 9.0, 9.0, 8.0, 9.0, 9.0, 8.0, 7.0, 9.0, 7.0, 11.0, 7.0, 7.0, 7.0, 3.0, 3.0, 3.0, 5.0, 7.0, 4.0, 7.0, 7.0, 6.0, 7.0, 7.0, 3.0, 7.0, 7.0, 3.0, 3.0, 6.0, 3.0, 11.0, 7.0, 7.0, 7.0, 7.0, 4.0, 7.0, 3.0, 7.0, 5.0, 9.0, 5.0, 5.0, 5.0, 4.0, 3.0, 4.0, 7.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 3.0, 7.0, 7.0, 7.0, 7.0, 3.0, 7.0, 4.0, 9.0, 4.0, 7.0, 7.0, 4.0, 9.0, 7.0, 5.0, 7.0, 4.0, 4.0, 4.0, 7.0, 6.0, 4.0, 4.0, 4.0, 4.0, 7.0, 10.0, 10.0, 10.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 12.0, 9.0, 8.0, 8.0, 8.0, 8.0, 3.0, 3.0, 3.0, 3.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 7.0, 9.0, 9.0, 9.0, 9.0, 9.0, 7.0, 8.0, 8.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 11.0, 6.0, 7.0, 7.0, 7.0, 7.0, 3.0, 3.0, 3.0, 3.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 5.0, 7.0, 5.0};


        double[] refValues12uni = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 3.0, 4.0, 7.0, 7.0, 11.0, 8.0, 2.0, 4.0, 4.0, 5.0, 7.0, 3.0, 4.0, 3.0, 3.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 3.0, 3.0, 7.0, 7.0, 7.0, 7.0, 12.0, 7.0, 8.0, 9.0, 9.0, 8.0, 7.0, 9.0, 9.0, 3.0, 6.0, 8.0, 7.0, 9.0, 9.0, 9.0, 8.0, 9.0, 9.0, 8.0, 7.0, 9.0, 7.0, 11.0, 7.0, 7.0, 7.0, 3.0, 3.0, 3.0, 5.0, 7.0, 4.0, 7.0, 7.0, 6.0, 7.0, 7.0, 3.0, 7.0, 7.0, 3.0, 3.0, 6.0, 3.0, 11.0, 7.0, 7.0, 7.0, 7.0, 4.0, 7.0, 3.0, 7.0, 5.0, 9.0, 5.0, 5.0, 5.0, 4.0, 3.0, 4.0, 7.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 3.0, 3.0, 7.0, 7.0, 7.0, 7.0, 3.0, 7.0, 4.0, 9.0, 4.0, 7.0, 7.0, 4.0, 9.0, 7.0, 5.0, 7.0, 4.0, 4.0, 4.0, 7.0, 6.0, 3.0, 4.0, 4.0, 4.0, 7.0, 10.0, 10.0, 10.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 12.0, 9.0, 8.0, 8.0, 8.0, 8.0, 3.0, 3.0, 3.0, 3.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 7.0, 9.0, 9.0, 9.0, 9.0, 9.0, 7.0, 8.0, 8.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 11.0, 6.0, 7.0, 7.0, 7.0, 7.0, 3.0, 3.0, 3.0, 3.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 7.0, 5.0, 7.0, 5.0};

        double[] refValues17win = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 5.0, 5.0, 6.0, 9.0, 9.0, 15.0, 11.0, 3.0, 6.0, 6.0, 7.0, 10.0, 5.0, 6.0, 5.0, 5.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 5.0, 5.0, 10.0, 10.0, 10.0, 9.0, 17.0, 11.0, 11.0, 12.0, 12.0, 11.0, 10.0, 12.0, 11.0, 5.0, 9.0, 11.0, 9.0, 13.0, 11.0, 12.0, 11.0, 12.0, 11.0, 11.0, 9.0, 11.0, 11.0, 17.0, 11.0, 11.0, 9.0, 5.0, 5.0, 5.0, 7.0, 9.0, 6.0, 9.0, 9.0, 9.0, 9.0, 9.0, 5.0, 9.0, 9.0, 4.0, 3.0, 8.0, 3.0, 13.0, 9.0, 9.0, 9.0, 9.0, 6.0, 8.0, 4.0, 9.0, 7.0, 11.0, 7.0, 9.0, 8.0, 6.0, 5.0, 6.0, 10.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 5.0, 5.0, 9.0, 9.0, 9.0, 9.0, 5.0, 9.0, 6.0, 13.0, 5.0, 9.0, 10.0, 6.0, 13.0, 9.0, 7.0, 9.0, 6.0, 6.0, 6.0, 9.0, 9.0, 6.0, 6.0, 6.0, 5.0, 9.0, 14.0, 14.0, 14.0, 10.0, 11.0, 11.0, 11.0, 11.0, 11.0, 11.0, 17.0, 12.0, 11.0, 11.0, 11.0, 11.0, 5.0, 5.0, 5.0, 5.0, 12.0, 11.0, 12.0, 12.0, 12.0, 12.0, 12.0, 10.0, 13.0, 11.0, 11.0, 11.0, 11.0, 11.0, 11.0, 10.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 15.0, 9.0, 9.0, 9.0, 9.0, 9.0, 5.0, 5.0, 5.0, 5.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0};

        double[] refValues17uni = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 5.0, 5.0, 6.0, 9.0, 9.0, 15.0, 11.0, 3.0, 6.0, 6.0, 7.0, 10.0, 5.0, 6.0, 5.0, 5.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 5.0, 5.0, 10.0, 10.0, 10.0, 9.0, 17.0, 11.0, 11.0, 12.0, 12.0, 11.0, 10.0, 12.0, 11.0, 5.0, 9.0, 11.0, 9.0, 13.0, 11.0, 12.0, 11.0, 12.0, 11.0, 11.0, 9.0, 11.0, 11.0, 17.0, 11.0, 11.0, 9.0, 5.0, 5.0, 5.0, 7.0, 9.0, 6.0, 9.0, 9.0, 9.0, 9.0, 9.0, 5.0, 9.0, 9.0, 4.0, 3.0, 8.0, 3.0, 13.0, 9.0, 9.0, 9.0, 9.0, 6.0, 8.0, 4.0, 9.0, 7.0, 11.0, 7.0, 9.0, 8.0, 6.0, 5.0, 6.0, 10.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 5.0, 5.0, 9.0, 9.0, 9.0, 9.0, 5.0, 9.0, 6.0, 13.0, 5.0, 9.0, 10.0, 6.0, 13.0, 9.0, 7.0, 9.0, 6.0, 6.0, 6.0, 9.0, 9.0, 5.0, 6.0, 6.0, 5.0, 9.0, 14.0, 14.0, 14.0, 10.0, 11.0, 11.0, 11.0, 11.0, 11.0, 11.0, 17.0, 12.0, 11.0, 11.0, 11.0, 11.0, 5.0, 5.0, 5.0, 5.0, 12.0, 11.0, 12.0, 12.0, 12.0, 12.0, 12.0, 10.0, 13.0, 11.0, 11.0, 11.0, 11.0, 11.0, 11.0, 10.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 15.0, 9.0, 9.0, 9.0, 9.0, 9.0, 5.0, 5.0, 5.0, 5.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0, 9.0};

//        for (int i = 0; i < 256; i++) {
//            if (refValues17win[i] == refValues17uni[i]) {
//                //System.out.println(i + " PASS");
//            } else {
//                System.out.println(i + " FAIL");
//            }
//        }


        String s;
        for (char i = 0; i < 256; i++) {
            if (i < 32) {
                //System.out.print("0.0, ");
                continue;
            }
            if (i > 126 && i < 160) {
                //System.out.print("0.0, ");
                continue;
            }
            s = new String(new char[]{i});
            Rectangle2D bounds = fontMetrics.getStringBounds(s, null);
            Rectangle2D boundsb = fontMetricsb.getStringBounds(s, null);
            Rectangle2D bounds10 = fontMetrics10.getStringBounds(s, null);
            Rectangle2D bounds11 = fontMetrics11.getStringBounds(s, null);
            String result12 = "------FAIL------";
            if (boundsb.getWidth() == refValues17win[i]) {
                result12 = "BOLD";
            }
            if (bounds10.getWidth() == refValues17win[i]) {
                result12 = "P--15";
            }
            if (bounds11.getWidth() == refValues17win[i]) {
                result12 = "P--16";
            }
            if (bounds.getWidth() == refValues17win[i]) {
                result12 = "PLAIN";
            }

            toMessage((int) i + " " + s
                    + " " + bounds.getWidth()
                    + " " + boundsb.getWidth()
                    //                    + " " + boundsi.getWidth()
                    //                    + " " + boundsib.getWidth()
                    + " " + bounds10.getWidth()
                    + " " + bounds11.getWidth()
                    + " " + result12
                    + "\n");
            //System.out.print(bounds.getWidth() + ", ");
        }


        metrics1 = new FontMetrics(font1) {
        };
        metrics2 = new FontMetrics(font2) {
        };

//        for (int i = 9; i < 16; i++) {
//            StyleConstants.setFontSize(style, i);
//            len = document.getLength();
//            document.setParagraphAttributes(0, len, style, false);
//            font2 = document.getFont(jTextPane1.getParagraphAttributes());
//            AttributedString attributedString = new AttributedString("m");
//            attributedString.addAttribute(TextAttribute.FONT, font2, 0, "m".length());
//            FontRenderContext fontRenderContext = new FontRenderContext(null, false, false);
//            TextLayout layout = new TextLayout(attributedString.getIterator(), fontRenderContext);
//            Shape shape = layout.getOutline(null);
//            toMessage(i + " m " + shape.getBounds().toString() + "\n");
//        }



        DocumentFilter docF = new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String str, AttributeSet attr) throws BadLocationException {
                fb.insertString(offset, str, attr);
            }

            @Override
            public void remove(DocumentFilter.FilterBypass fb, int offset, int length) throws BadLocationException {
                fb.remove(offset, length);
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String str, AttributeSet attr) throws BadLocationException {
                fb.replace(offset, length, str, attr);

//                if (str.startsWith("m") || str.startsWith("s")) {
//                    fb.replace(offset, length, str, style13);
//                } else if (str.startsWith("v")) {
//                    fb.replace(offset, length, str, style10);
//                } else {
//                    fb.replace(offset, length, str, style12);
//                }
//                fb.replace(offset, length, str, style12);
                //fb.replace(offset, length, str, style);
//                for (int i = 9; i < 16; i++) {
//                    StyleConstants.setFontSize(style, i);
//                    int myLen = document.getLength();
//                    document.setParagraphAttributes(0, myLen, style, false);
//                    font2 = document.getFont(jTextPane1.getParagraphAttributes());
//                    AttributedString attributedString = new AttributedString(str);
//                    attributedString.addAttribute(TextAttribute.FONT, font2, 0, str.length());
//                    FontRenderContext fontRenderContext = new FontRenderContext(null, false, false);
//                    TextLayout layout = new TextLayout(attributedString.getIterator(), fontRenderContext);
//                    Shape shape = layout.getOutline(null);
//                    toMessage(i + " " + str + " " + shape.getBounds().toString() + "\n");
//                }
//                AttributedString attributedString = new AttributedString(str);
//                attributedString.addAttribute(TextAttribute.FONT, font2, 0, str.length());
//                FontRenderContext fontRenderContext = new FontRenderContext(null, false, false);
//                TextLayout layout = new TextLayout(attributedString.getIterator(), fontRenderContext);
//                Shape shape = layout.getOutline(null);
//                toMessage("Shape: " + str + " " + shape.getBounds().toString() + "\n");
//
//                BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
//                FontMetrics fm = img.getGraphics().getFontMetrics(font2);
//                int width = fm.stringWidth(str);
//                toMessage("Image: " + str + " " + width + "\n");
//
//
//                Rectangle2D bounds1 = metrics1.getStringBounds(str, null);
//                toMessage("Bounds1: " + str + " " + bounds1.toString() + "\n");
//                Rectangle2D bounds2 = metrics2.getStringBounds(str, null);
//                toMessage("Bounds2: " + str + " " + bounds2.toString() + "\n");
//                //toMessage("Font1: " + font1.getFamily() + "\n");
//                toMessage("Font2: " + font2.getFamily() + "\n");
                //System.out.println("Bounds: " + str + " " + bounds.toString());
                //super.replace(fb, offset, length, str, attr);
            }
        };

        ((AbstractDocument) jTextPane1.getDocument()).setDocumentFilter(docF);


//        try {
//            Font registerFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResource("bin/register.ttf").openStream());
//        } catch (FontFormatException ex) {
//            Logger.getLogger(IncludedFontTester.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(IncludedFontTester.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setTitle("IncludedFontTester");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    private void toMessage(String string) {
        jta.append(string);
    }
}
