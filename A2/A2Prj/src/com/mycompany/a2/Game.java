/**
 * Game instantiates GameWorld() and gives the ability for user input to play the game.
 */

package com.mycompany.a2;


import static com.codename1.ui.CN.*;
import com.codename1.ui.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

import java.io.IOException;

import com.codename1.charts.util.ColorUtil;
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
        //super(new BorderLayout());
        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        
        gw = new GameWorld(); // create "Observable" GameWorld
        GameWorldProxyImpl gameWorldProxy = new GameWorldProxyImpl(gw);
        mv = new MapView(gameWorldProxy); // create an "Observer" for the map
        sv = new ScoreView(gameWorldProxy); // create an "Observer" for the game/ant state data

        // Register observers with the model
        gw.addObserver(mv);
        gw.addObserver(sv);
        
        // mytest
        // this.setTitle("StartToFinish");

        // red border for MapView
        mv.getAllStyles().setBorder(Border.createLineBorder(2, 0xff0000));
        
        
        //title bar
        Toolbar myToolBar = new Toolbar();
        setToolbar(myToolBar);
        TextField myTF = new TextField();
        myToolBar.setTitle("StartToFinish");
        Command titleBarItem1 = new Command("Help");
        myToolBar.addCommandToRightBar(titleBarItem1);
        
        Container titleBarContainer = new Container(new FlowLayout(Component.CENTER));
        titleBarContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.YELLOW));
        //Container titleBar = new Container(new BorderLayout(Component.CENTER));
        titleBarContainer.setUIID("TitleBar");
        titleBarContainer.getStyle().setPadding(0, 10, 0, 10);
        Label title = new Label("StartToFinish");
        this.setTitleComponent(new Label("StartToFinish"));
        title.setUIID("Title");
        // help button in title bar
        Command help = new Command("Help");
        Button helpButton = new Button();
        helpButton.setUIID("Help");
        helpButton.setCommand(help);

        Command about = new Command("About");
        Button aboutButton = new Button("About");
        aboutButton.setUIID("About");
        aboutButton.setCommand(about);
        aboutButton.addActionListener(e -> {
            // show the about dialog
            Dialog.show("About", "This is the StartToFinish game!", "OK", null);
        });

        titleBarContainer.add(title);
        titleBarContainer.add(helpButton);
        titleBarContainer.add(aboutButton);
        
        this.add(BorderLayout.NORTH, titleBarContainer);

        // Create commands for each command not in title bar
        Command accelerate = new Command("Accelerate");
        Command left = new Command("Move Left");
        Command brake = new Command("brake");
        Command right = new Command("Move Right");
        Command collideWithFlag = new Command("Collide with Flag");
        Command collideWithSpider = new Command("Collide with Spider");
        Command collideWithFoodStations = new Command("Collide with FoodStations");
        Command tick = new Command("Tick");
        

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
        this.add(BorderLayout.SOUTH, southButtonContainer);
        //this.add(BorderLayout.NORTH, sv);
        this.add(BorderLayout.EAST, rightButtonContainer);
        this.add(BorderLayout.WEST, leftButtonContainer);
        
        // Bind commands to keys
        this.addKeyListener('a', accelerate);
        this.addKeyListener('b', brake);
        this.addKeyListener('l', left);
        this.addKeyListener('r', right);
        this.addKeyListener('f', collideWithFoodStations);
        this.addKeyListener('g', collideWithSpider);
        this.addKeyListener('t', tick);
        

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
