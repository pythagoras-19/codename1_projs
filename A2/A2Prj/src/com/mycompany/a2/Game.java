/**
 * Game instantiates GameWorld() and gives the ability for user input to play the game.
 */

package com.mycompany.a2;


import static com.codename1.ui.CN.*;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.geom.Border;

import java.io.IOException;
import com.codename1.io.NetworkEvent;
import java.lang.String; 
import java.util.Observable;
import java.util.Observer;
import java.util.Observable;
import java.util.Observer;

public class Game extends Form {
    private GameWorld gw;
    private MapView mv;
    private ScoreView sv;

    public Game(){
        super(new BorderLayout());
        BorderLayout borderLayout = new BorderLayout();

        gw = new GameWorld(); // create "Observable" GameWorld
        mv = new MapView(); // create an "Observer" for the map
        sv = new ScoreView(); // create an "Observer" for the game/ant state data

        // Register observers with the model
        gw.addObserver(mv);
        gw.addObserver(sv);

        // red border for MapView
        mv.getAllStyles().setBorder(Border.createLineBorder(2, 0xff0000));

        // Create commands for each command
        Command accelerate = new Command("Accelerate");
        Command left = new Command("Move Left");
        Command brake = new Command("brake");
        Command right = new Command("Move Right");
        Command collideWithFlag = new Command("Collide with Flag");
        Command collideWithSpider = new Command("Collide with Spider");
        Command collideWithFoodStations = new Command("Collide with FoodStations");
        Command tick = new Command("Tick");

        // Add commands to side menu and title bar area
        this.getToolbar().addCommandToSideMenu(moveLeft);
        this.getToolbar().addCommandToSideMenu(moveRight);
        this.getToolbar().addCommandToSideMenu(moveUp);
        this.getToolbar().addCommandToSideMenu(moveDown);
        this.getToolbar().setTitle("StartToFinish Game");

        // Bind commands to keys
        this.addKeyListener('a', moveLeft);
        this.addKeyListener('d', moveRight);
        this.addKeyListener('w', moveUp);
        this.addKeyListener('s', moveDown);

        // Create control containers for the buttons
        
        //left side
        Container leftButtonContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Button topButton = new Button("Accelerate");
        topButton.setCommand(accelerate);
        Button secondButton = new Button("Left");
        secondButton.setCommand(left);
        leftButtonContainer.add(topButton);
        leftButtonContainer.add(secondButton);
        borderLayout.addLayoutComponent(BorderLayout.WEST, topButton, leftButtonContainer);
        borderLayout.addLayoutComponent(BorderLayout.WEST, secondButton, leftButtonContainer);
        
        //right side
        Container rightButtonContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Button brakeButton = new Button("Brake");
        brakeButton.setCommand(brake);
        Button rightButton = new Button("Right");
        rightButton.setCommand(right);
        rightButtonContainer.add(brakeButton);
        rightButtonContainer.add(rightButton);
        borderLayout.addLayoutComponent(BorderLayout.EAST, brakeButton, rightButtonContainer);
        borderLayout.addLayoutComponent(BorderLayout.EAST, rightButton, rightButtonContainer);
        
        //south side
        Container southButtonContainer = new Container(new FlowLayout(Component.RIGHT));
        Button collideWithFlagButton = new Button(collideWithFlag);
        Button collideWithSpiderButton = new Button(collideWithSpider);
        Button collideWithFoodStationsButton = new Button(collideWithFoodStations);
        Button tickButton = new Button(tick);
        southButtonContainer.add(collideWithFlagButton);
        southButtonContainer.add(collideWithSpiderButton);
        southButtonContainer.add(collideWithFoodStationsButton);
        southButtonContainer.add(tickButton);
        borderLayout.addLayoutComponent(BorderLayout.SOUTH, collideWithFlagButton, southButtonContainer);
        borderLayout.addLayoutComponent(BorderLayout.SOUTH, collideWithSpiderButton, southButtonContainer);
        borderLayout.addLayoutComponent(BorderLayout.SOUTH, collideWithFoodStationsButton, southButtonContainer);
        borderLayout.addLayoutComponent(BorderLayout.SOUTH, tickButton, southButtonContainer);

        // Add control containers, MapView, and ScoreView to the form
        this.add(BorderLayout.CENTER, mv);
        this.add(BorderLayout.SOUTH, BorderLayout.centerAbsolute(new Container()));
        this.add(BorderLayout.NORTH, BorderLayout.centerAbsolute(new Container()));

        // Query MapView's width and height and set them as world's width and height
        int mapWidth = mv.getWidth(); // needs to be 1000
        int mapHeight = mv.getHeight(); // needs to be 1000
        gw.setWidth(mapWidth);
        gw.setHeight(mapHeight);

        // Initialize world
        gw.init();

        // Display the form
        this.show();
    }
}
