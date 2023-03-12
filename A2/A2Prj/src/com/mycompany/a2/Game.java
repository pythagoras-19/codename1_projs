/**
 * Game instantiates GameWorld() and gives the ability for user input to play the game.
 */

package com.mycompany.a2;


import static com.codename1.ui.CN.*;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
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

        gw = new GameWorld(); // create "Observable" GameWorld
        mv = new MapView(); // create an "Observer" for the map
        sv = new ScoreView(); // create an "Observer" for the game/ant state data

        // Register observers with the model
        gw.addObserver(mv);
        gw.addObserver(sv);

        // red border for MapView
        mv.getAllStyles().setBorder(Border.createLineBorder(2, 0xff0000));

        // Create commands for each command
        Command moveLeft = new Command("Move Left");
        Command moveRight = new Command("Move Right");
        Command moveUp = new Command("Move Up");
        Command moveDown = new Command("Move Down");

        // Add commands to side menu and title bar area
        this.getToolbar().addCommandToSideMenu(moveLeft);
        this.getToolbar().addCommandToSideMenu(moveRight);
        this.getToolbar().addCommandToSideMenu(moveUp);
        this.getToolbar().addCommandToSideMenu(moveDown);
        this.getToolbar().setTitle("Ant Game");

        // Bind commands to keys
        this.addKeyListener('a', moveLeft);
        this.addKeyListener('d', moveRight);
        this.addKeyListener('w', moveUp);
        this.addKeyListener('s', moveDown);

        // Create control containers for the buttons
        Container moveContainer = new Container();
        moveContainer.getAllStyles().setMarginTop(10);
        moveContainer.getAllStyles().setMarginBottom(10);

        // Add buttons to the control containers
        Button leftButton = new Button(moveLeft);
        Button rightButton = new Button(moveRight);
        Button upButton = new Button(moveUp);
        Button downButton = new Button(moveDown);
        moveContainer.add(leftButton).add(rightButton).add(upButton).add(downButton);

        // Add commands to the buttons
        leftButton.setCommand(moveLeft);
        rightButton.setCommand(moveRight);
        upButton.setCommand(moveUp);
        downButton.setCommand(moveDown);

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
