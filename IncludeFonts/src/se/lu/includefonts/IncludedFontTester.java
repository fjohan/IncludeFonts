/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.lu.includefonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.GraphicsEnvironment;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.AttributedString;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.Style;
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
        font1 = null;

        InputStream fontStream = getClass().getResourceAsStream("fonts/arial.ttf");
        //InputStream fontStream = getClass().getResourceAsStream("fonts/HARNGTON.TTF");
        try {
            font1 = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        } catch (FontFormatException ex) {
            Logger.getLogger(IncludedFontTester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IncludedFontTester.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            font1 = font1.deriveFont(Font.PLAIN, 12);
            fontStream.close();
        } catch (IOException ex) {
            Logger.getLogger(IncludedFontTester.class.getName()).log(Level.SEVERE, null, ex);
        }

        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font1);
        //GlyphVector gv = font1.createGlyphVector(fontRenderContext, "m");


        StyleContext context = new StyleContext();
        StyledDocument document = jTextPane1.getStyledDocument();
        Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
        StyleConstants.setLineSpacing(style, 1.5f);
        StyleConstants.setFontFamily(style, font1.getFamily());
        StyleConstants.setFontSize(style, 12);
        int len = document.getLength();
        document.setParagraphAttributes(0, len, style, false);

        // get the font
        font2 = document.getFont(jTextPane1.getParagraphAttributes());
        AttributedString attributedString = new AttributedString("m");
        attributedString.addAttribute(TextAttribute.FONT, font2, 0, "m".length());
        FontRenderContext fontRenderContext = new FontRenderContext(null, false, false);
        TextLayout layout = new TextLayout(attributedString.getIterator(), fontRenderContext);
        Shape shape = layout.getOutline(null);
        toMessage("m " + shape.getBounds().toString() + "\n");

        metrics1 = new FontMetrics(font1) {
        };
        metrics2 = new FontMetrics(font2) {
        };

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


                AttributedString attributedString = new AttributedString(str);
                attributedString.addAttribute(TextAttribute.FONT, font2, 0, str.length());
                FontRenderContext fontRenderContext = new FontRenderContext(null, false, false);
                TextLayout layout = new TextLayout(attributedString.getIterator(), fontRenderContext);
                Shape shape = layout.getOutline(null);
                toMessage("Shape: " + str + " " + shape.getBounds().toString() + "\n");

                BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
                FontMetrics fm = img.getGraphics().getFontMetrics(font2);
                int width = fm.stringWidth(str);
                toMessage("Image: " + str + " " + width + "\n");


                Rectangle2D bounds1 = metrics1.getStringBounds(str, null);
                toMessage("Bounds1: " + str + " " + bounds1.toString() + "\n");
                Rectangle2D bounds2 = metrics2.getStringBounds(str, null);
                toMessage("Bounds2: " + str + " " + bounds2.toString() + "\n");
                //toMessage("Font1: " + font1.getFamily() + "\n");
                toMessage("Font2: " + font2.getFamily() + "\n");

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
