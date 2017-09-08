package ratgui;

import javax.swing.*;
import java.awt.*;

public class MissionStatusLabel extends JLabel {

    private String name;
    private String mission;

    public MissionStatusLabel( String name, String mission ) {
        super( getColoredString(name, mission) );
        this.name = name;
        this.mission = mission;
        this.setFont(new Font( "Courier New", Font.BOLD, 16) );
    }

    public void addNamePadding(int numCharsForName) {

        int numPaddingCharsToAdd = numCharsForName - this.name.length();

        if ( numPaddingCharsToAdd <= 0 ) {
            return;
        }

        this.setText( getColoredString(this.name, this.mission, numPaddingCharsToAdd ) );
    }

    public static String getColoredString(String name, String mission, int paddingCharsToAdd ) {

        String htmlBegin = "<html><pre>";
        String htmlEnd = "</pre></html>";
        String padding = "";

        for( int i = 0; i < paddingCharsToAdd; i++ ) {
            padding += " ";
        }
        System.out.println(name);
        System.out.println("padding = " + (padding.length()));

        String coloredName = "<font color='white'>"  + name + padding + " : </font>";
        String coloredMission = "<font color='red'>"+ mission +"</font>";

        return htmlBegin + coloredName + coloredMission + htmlEnd;
    }
    public static String getColoredString(String name, String mission) {
        return getColoredString( name, mission, 0);
    }

    public static void main( String[] args ) {
        MissionStatusLabel label = new MissionStatusLabel( "Erik Benscoter", "thing" );

        JFrame myFrame = new JFrame();
        myFrame.setSize(600,600 );
        myFrame.add(label);
        myFrame.setVisible(true);

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
