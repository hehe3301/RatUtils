package ratgui;

import jdk.net.SocketFlow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RatWindow extends JFrame {
    private JPanel PanelHolder;
    private JPanel StatusPanel;
    private JPanel SystemScroll;
    private JPanel ButtonMaster;

    private JPanel jpanels[] = { new JPanel(), new JPanel(), new JPanel(), new JPanel() };

    public RatWindow() {
        for ( int i = 0; i < jpanels.length; i++ ) {
            jpanels[i] = new JPanel();
        }
    }

    public void initAPanel(JPanel panel, Color color) {
        panel.setBackground(color);
        panel.setSize(250, 350);

        this.add(panel);


    }
    public void init() {

        this.setSize(1000,900);

        int counter = 0;

        for( JPanel jpanel : jpanels ) {
            counter++;
            System.out.println(counter);
            if ( counter % 2 == 0 ) {
                initAPanel(jpanel, Color.CYAN);
            } else {
                initAPanel(jpanel, Color.BLACK);
            }
        }

        this.add(new Button("hello world"));

        this.setVisible(true);
    }

    public static void main(String[] args) {
        RatWindow myRatWindow = new RatWindow();
        myRatWindow.init();
    }
}
