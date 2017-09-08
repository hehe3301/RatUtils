package ratgui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {

    }

    public void init() {
        this.setSize( 600, 600 );
        this.setUndecorated(false);
        this.setBackground(Color.BLACK);


        this.setLayout( new FlowLayout(FlowLayout.CENTER, 0, 0) );

    }

    public void render() {
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.init();

        MissionStatusPanel panels[] = {
                new MissionStatusPanel(),
                new MissionStatusPanel(),
                new MissionStatusPanel()
        };

        for ( MissionStatusPanel ratPanel : panels ) {
            ratPanel.init();
            ratPanel.addMission(new MissionStatusLabel("Erik Benscoter", "m1"));
            ratPanel.addMission(new MissionStatusLabel("Meeko", "m2"));
            ratPanel.setPreferredSize(new Dimension(200, window.getHeight()));
            ratPanel.setBorder(BorderFactory.createEmptyBorder());
            ratPanel.reRender();
            window.add(ratPanel);
        }

        window.render();

    }
}
