package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

public class ScoreView extends Container implements Observer {
    private GameWorldProxyImpl gwProxy;
    private Label livesLabel;
    private Label clockLabel;
    private Label flagLabel;
    private Label foodLabel;
    private Label healthLabel;
    private Label soundLabel;

    public ScoreView(GameWorldProxyImpl gwProxyObj) {
        super(new BorderLayout());
        this.gwProxy = gwProxyObj;
        Container labelContainer = new Container(new FlowLayout(Component.CENTER));

        // Create the labels and add them to the container
        livesLabel = new Label("Lives left: 3");
        livesLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
        clockLabel = new Label("Time: 000");
        clockLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
        flagLabel = new Label("Last flag reached: 000");
        flagLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
        foodLabel = new Label("Food level: 000");
        foodLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
        healthLabel = new Label("Health level: 000");
        healthLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
        soundLabel = new Label("Sound: OFF");
        soundLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
        labelContainer.add(livesLabel);
        labelContainer.add(clockLabel);
        labelContainer.add(flagLabel);
        labelContainer.add(foodLabel);
        labelContainer.add(healthLabel);
        labelContainer.add(soundLabel);
        labelContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
        this.add(BorderLayout.NORTH, labelContainer);
    }

    @Override
    public void update(Observable observable, Object data) {
        this.display();
    }

    /**
     * Update label texts for each game object
     */
    public void display() {
        // Loop through the game object collection to find the Ant object and update its attributes in the labels
        IIterator<GameObject> iterator = gwProxy.getGameObjectsIterator();
        while (iterator.hasNext()) {
            GameObject obj = iterator.getNext();
            if (obj instanceof Ant) {
                Ant aObj = (Ant) obj;
                livesLabel.setText("Lives left: " + gwProxy.getAntLivesLeft());
                livesLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
                clockLabel.setText("Time: " + gwProxy.getGameClock());
                clockLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
                flagLabel.setText("Last flag reached: " + aObj.getLastFlagReached());
                flagLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
                foodLabel.setText("Food level:" + aObj.getFoodLevel());
                foodLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
                healthLabel.setText("Health level: " + aObj.getHealthLevel());
                healthLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
                soundLabel.setText("Sound: " + gwProxy.getSound());
                soundLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
            }
        }
    }
}
