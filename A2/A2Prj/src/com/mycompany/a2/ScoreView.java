package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;

public class ScoreView extends Container implements Observer {
    private GameWorldProxyImpl gwProxy;

    public ScoreView(GameWorldProxyImpl gwProxyObj) {
        super(new BorderLayout());
        this.gwProxy = gwProxyObj;
        Label timeLabel = new Label("Time: 0");
        Label antCountLabel = new Label("Ant Lives Left: 0");
        Label lastFlagReachedLabel = new Label("Last Flag Reached: 0");
        Label foodLevelLabel = new Label("Food Level: 9999");
        Label healthLevelLabel = new Label("Health Level: 0000");
        Label soundLabel = new Label("Sound: OFF");

        addComponent(BorderLayout.NORTH, timeLabel);
        addComponent(BorderLayout.NORTH, antCountLabel);
        addComponent(BorderLayout.NORTH, lastFlagReachedLabel);
        addComponent(BorderLayout.NORTH, foodLevelLabel);
        addComponent(BorderLayout.NORTH, healthLevelLabel);
        addComponent(BorderLayout.NORTH, soundLabel);
    }

    @Override
    public void update(Observable observable, Object data) {
        display();
    }

    /**
     * Display key information for the user to the terminal.
     */
    public void display() {
        // Create a container to hold the output statements
        Container outputContainer = new Container(new FlowLayout(Component.CENTER));

        // Create labels for each output statement
        Label livesLabel = new Label("Ant lives left: " + gwProxy.getAntLivesLeft());
        Label clockLabel = new Label("Clock value: " + gwProxy.getGameClock());

        // Loop through the game object collection to find the Ant object and add its attributes to the output container
        IIterator<GameObject> iterator = gwProxy.getGameObjectsIterator();
        while (iterator.hasNext()) {
            GameObject obj = iterator.getNext();
            if (obj instanceof Ant) {
                Ant aObj = (Ant) obj;
                Label flagLabel = new Label("Highest flag reached:" + aObj.getLastFlagReached());
                Label foodLabel = new Label("Ant current food level: " + aObj.getFoodLevel());
                Label healthLabel = new Label("Ant health level: " + aObj.getHealthLevel());

                // Add the labels to the container
                outputContainer.addComponent(livesLabel);
                outputContainer.addComponent(clockLabel);
                outputContainer.addComponent(flagLabel);
                outputContainer.addComponent(foodLabel);
                outputContainer.addComponent(healthLabel);
            }
        }

        // Add the output container to the north region of the border layout
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, outputContainer);
    }
}
