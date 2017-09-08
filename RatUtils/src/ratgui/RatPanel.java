package ratgui;

import javax.swing.*;

public abstract class RatPanel extends JPanel {

    public RatPanel() {
        super();
    }

    public abstract void init();
    public abstract void reRender();

}
