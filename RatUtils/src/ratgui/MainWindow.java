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

        MissionStatusPanel missionStatusPanel = new MissionStatusPanel();
        missionStatusPanel.init();
        missionStatusPanel.addMission(new MissionStatusLabel("Erik Benscoter", "m1"));
        missionStatusPanel.addMission(new MissionStatusLabel("Meeko", "really long mission name"));
        missionStatusPanel.setPreferredSize(new Dimension(500, window.getHeight()));
        missionStatusPanel.setBorder(BorderFactory.createEmptyBorder());
        missionStatusPanel.reRender();
        window.add(missionStatusPanel);

        RatTextPane textPane = new RatTextPane();
        textPane.init();
        textPane.reRender();
        textPane.setPreferredSize(new Dimension(800, window.getHeight()));
        window.add(new JScrollPane(textPane));
        String messages[] = {
                "hello 1",
                "hello 2",
                "hello 3",
                "hello 4",
                "hello 5",
                "hello 6"
        };
        for ( String message : messages ) {
            textPane.addMessage(message);
        }


        window.render();

    }
}
