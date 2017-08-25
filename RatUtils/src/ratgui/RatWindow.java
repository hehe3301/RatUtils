package ratgui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RatWindow extends JFrame {
    private JPanel PanelHolder;
    private JPanel StatusPanel;
    private JPanel SystemScroll;
    private JPanel ButtonMaster;

    public void init() {

        PanelHolder.setLayout(new BorderLayout());

        StatusPanel.setBackground(Color.BLACK);
        StatusPanel.setSize(200,200);
        StatusPanel.setVisible(true);

        StatusPanel.add(new Button());

        PanelHolder.add(StatusPanel, BorderLayout.CENTER);
        PanelHolder.setVisible(true);

        this.add(PanelHolder);
        this.setSize(200,200);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        RatWindow myRatWindow = new RatWindow();
        myRatWindow.init();
    }
}
