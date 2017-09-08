package ratgui;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MissionStatusPanel extends RatPanel {

    private Vector<MissionStatusLabel> missions = new Vector<MissionStatusLabel>();

    public MissionStatusPanel() {
//        this.setPreferredSize(new Dimension(200,300) );
//        this.setSize(200,300);
        this.setBackground(Color.BLACK);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    public void init() {

    }

    public void reRender() {
        this.removeAll();

        int largestNameLength = 0;
        for ( MissionStatusLabel mission : missions ) {
            if ( mission.getName().length() >= largestNameLength ) {
                largestNameLength = mission.getName().length();
            }
        }
        for ( MissionStatusLabel mission : missions ) {
            mission.addNamePadding(largestNameLength);
            this.add(mission);
        }

    }

    public static void main( String[] args ) {
        MissionStatusPanel myMissionStatusPanel = new MissionStatusPanel();
        myMissionStatusPanel.addMission(new MissionStatusLabel("Erik Benscoter", "go get stuff" ) );
        myMissionStatusPanel.addMission(new MissionStatusLabel("Jess Schell", "go get other stuff" ) );
        myMissionStatusPanel.addMission(new MissionStatusLabel("Adam Clouthier", "go get other stuff" ) );
        myMissionStatusPanel.addMission(new MissionStatusLabel("Really Really Really Long Name", "go get other stuff" ) );
        myMissionStatusPanel.reRender();


        JFrame myFrame = new JFrame();
        myFrame.setSize(600,600 );
        myFrame.add(myMissionStatusPanel);
        myFrame.setVisible(true);

    }

    // SETTERS AND GETTERS


    public Vector<MissionStatusLabel> getMissions() {
        return missions;
    }

    public void setMissions(Vector<MissionStatusLabel> missions) {
        this.missions = missions;
    }

    public void addMission( MissionStatusLabel mission) {
        this.missions.add( mission );
    }
}
