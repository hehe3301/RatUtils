package ratgui;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class RatTextPane extends JTextPane {

    public RatTextPane() {

    }

    public void init() {
        this.removeAll();
    }

    public void reRender() {


//        StyledDocument doc = this.getStyledDocument();
//
//        Style style = this.addStyle("I'm a Style", null);
//        StyleConstants.setForeground(style, Color.red);
//
//        try { doc.insertString(doc.getLength(), "BLAH ",style); }
//        catch (BadLocationException e){}
//
//        StyleConstants.setForeground(style, Color.white);
//
//        try { doc.insertString(doc.getLength(), "BLEH",style); }
//        catch (BadLocationException e){}

        this.setEditable(false);
        this.setBackground(Color.DARK_GRAY);
        this.setFont(new Font( "Courier New", Font.BOLD, 16) );
    }

    public static void main( String[] args ) {
        RatTextPane textPane = new RatTextPane();
        textPane.init();
        textPane.reRender();

        JFrame frame = new JFrame("Test");
        frame.getContentPane().add(new JScrollPane(textPane));
        frame.pack();
        frame.setVisible(true);

    }

    public void addMessage(String message) {
        Style style = this.addStyle("red", null);
        StyleConstants.setForeground(style, Color.white);

        try {
            this.getStyledDocument().insertString(this.getStyledDocument().getLength(), message + "\n", style);
            this.repaint();
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
