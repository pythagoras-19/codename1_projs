/**
 * Game instantiates GameWorld() and gives the ability for user input to play the game.
 */

package com.mycompany.a2;


import static com.codename1.ui.CN.*;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;

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
        sv = new ScoreView(gameWorldProxy); // create an "Observer" for the game/ant state data
        mv = new MapView(gameWorldProxy); // create an "Observer" for the map
        mv.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(255, 0, 0)));
        this.add(BorderLayout.CENTER, mv);
        
        // Register observers with the model
        gw.addObserver(mv);
        gw.addObserver(sv); 
        
        //title bar
        Toolbar myToolBar = new Toolbar();
        this.setToolbar(myToolBar);
        myToolBar.setTitle("StartToFinish Game");
        
        AboutCommand about = new AboutCommand("About");
        Button aboutButton = new Button("About");
        aboutButton.setUIID("About");
        aboutButton.setCommand(about);
        myToolBar.addComponentToSideMenu(aboutButton);
        aboutButton.getAllStyles().setBgTransparency(255);
        aboutButton.getAllStyles().setBgColor(ColorUtil.GRAY);
        
        AccelerateCommand accelerate = new AccelerateCommand("Accelerate", gw);
        Button accelerateButton = new Button("Accelerate");
        accelerateButton.setUIID("Accelerate");
        accelerateButton.setCommand(accelerate);
        myToolBar.addComponentToSideMenu(accelerateButton);
        accelerateButton.getAllStyles().setBgTransparency(255);
        accelerateButton.getAllStyles().setBgColor(ColorUtil.GRAY);
        
        ExitCommand exit = new ExitCommand("Exit", gw);
        Button exitButton = new Button("Exit");
        exitButton.setUIID("Exit");
        exitButton.setCommand(exit);
        myToolBar.addComponentToSideMenu(exitButton);
        exitButton.getAllStyles().setBgTransparency(255);
        exitButton.getAllStyles().setBgColor(ColorUtil.GRAY);
        
        SoundCommand sound = new SoundCommand("Sound", gw);
        //Button soundButton = new Button("Sound");
        CheckBox soundCheck = new CheckBox("Sound");
        soundCheck.setCommand(sound);
        myToolBar.addComponentToSideMenu(soundCheck);
        soundCheck.getAllStyles().setBgTransparency(255);
        soundCheck.getAllStyles().setBgColor(ColorUtil.GRAY);
        //soundButton.setUIID("Sound");
        //soundButton.setCommand(sound);
        //myToolBar.addComponentToSideMenu(soundButton);
        //soundButton.getAllStyles().setBgTransparency(255);
        //soundButton.getAllStyles().setBgColor(ColorUtil.GRAY);
        
        HelpCommand help = new HelpCommand("Help", gw);
        Button helpButton = new Button("Help");
        helpButton.setUIID("Help");
        helpButton.setCommand(help);
        myToolBar.addComponentToSideMenu(helpButton);
        myToolBar.addCommandToRightBar(help);
        helpButton.getAllStyles().setBgTransparency(255);
        helpButton.getAllStyles().setBgColor(ColorUtil.GRAY);
        this.setToolbar(myToolBar);
        
        // Create commands for each command not in title bar
        LeftCommand left = new LeftCommand("Move Left", gw);
        BrakeCommand brake = new BrakeCommand("Brake", gw);
        RightCommand right = new RightCommand("Move Right", gw);
        CollideWithFlagCommand collideWithFlag = new CollideWithFlagCommand("Collide with Flag", gw);
        CollideWithSpiderCommand collideWithSpider = new CollideWithSpiderCommand("Collide with Spider", gw);
        CollideWithFoodStationsCommand collideWithFoodStations = new CollideWithFoodStationsCommand("Collide with FoodStations", gw);
        TickCommand tick = new TickCommand("Tick", gw);
        

        // Create control containers for the buttons
        
        //left side
        Container leftButtonContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Button accelerateButtonOnLeft = new Button("Accelerate");
        accelerateButtonOnLeft.getUnselectedStyle().setBgTransparency(255);
        accelerateButtonOnLeft.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
        accelerateButtonOnLeft.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
        accelerateButtonOnLeft.getUnselectedStyle().setBorder(Border.createLineBorder(3,ColorUtil.BLACK));
        accelerateButtonOnLeft.getAllStyles().setPadding(Component.TOP, 5);
        accelerateButtonOnLeft.getAllStyles().setPadding(Component.BOTTOM, 5);
        accelerateButtonOnLeft.setCommand(accelerate);
        leftButtonContainer.add(accelerateButtonOnLeft);

        Button leftButton = new Button("Left");
        leftButton.getUnselectedStyle().setBgTransparency(255);
        leftButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
        leftButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
        leftButton.getUnselectedStyle().setBorder(Border.createLineBorder(3,ColorUtil.BLACK));
        leftButton.getAllStyles().setPadding(Component.TOP, 5);
        leftButton.getAllStyles().setPadding(Component.BOTTOM, 5);
        leftButton.setCommand(left);
        leftButtonContainer.add(leftButton);
        leftButtonContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
        borderLayout.addLayoutComponent(BorderLayout.WEST, leftButtonContainer, this);
        
        //right side
        Container rightButtonContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Button brakeButton = new Button("Brake");
        brakeButton.getUnselectedStyle().setBgTransparency(255);
        brakeButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
        brakeButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
        brakeButton.getUnselectedStyle().setBorder(Border.createLineBorder(3,ColorUtil.BLACK));
        brakeButton.getAllStyles().setPadding(Component.TOP, 5);
        brakeButton.getAllStyles().setPadding(Component.BOTTOM, 5);
        brakeButton.setCommand(brake);
     
        Button rightButton = new Button("Right");
        rightButton.getUnselectedStyle().setBgTransparency(255);
        rightButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
        rightButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
        rightButton.getUnselectedStyle().setBorder(Border.createLineBorder(3,ColorUtil.BLACK));
        rightButton.getAllStyles().setPadding(Component.TOP, 5);
        rightButton.getAllStyles().setPadding(Component.BOTTOM, 5);
        rightButton.setCommand(right);
        rightButtonContainer.add(brakeButton);
        rightButtonContainer.add(rightButton);
        rightButtonContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
        borderLayout.addLayoutComponent(BorderLayout.EAST,rightButtonContainer, this);
        
        //south side
        Container southButtonContainer = new Container(new FlowLayout(Component.CENTER));
        Button collideWithFlagButton = new Button(collideWithFlag);
        collideWithFlagButton.getUnselectedStyle().setBgTransparency(255);
        collideWithFlagButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
        collideWithFlagButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
        collideWithFlagButton.getUnselectedStyle().setBorder(Border.createLineBorder(3,ColorUtil.BLACK));
        collideWithFlagButton.getAllStyles().setPadding(Component.TOP, 5);
        collideWithFlagButton.getAllStyles().setPadding(Component.BOTTOM, 5);

        Button collideWithSpiderButton = new Button(collideWithSpider);
        collideWithSpiderButton.getUnselectedStyle().setBgTransparency(255);
        collideWithSpiderButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
        collideWithSpiderButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
        collideWithSpiderButton.getUnselectedStyle().setBorder(Border.createLineBorder(3,ColorUtil.BLACK));
        collideWithSpiderButton.getAllStyles().setPadding(Component.TOP, 5);
        collideWithSpiderButton.getAllStyles().setPadding(Component.BOTTOM, 5);

        Button collideWithFoodStationsButton = new Button(collideWithFoodStations);
        collideWithFoodStationsButton.getUnselectedStyle().setBgTransparency(255);
        collideWithFoodStationsButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
        collideWithFoodStationsButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
        collideWithFoodStationsButton.getUnselectedStyle().setBorder(Border.createLineBorder(3,ColorUtil.BLACK));
        collideWithFoodStationsButton.getAllStyles().setPadding(Component.TOP, 5);
        collideWithFoodStationsButton.getAllStyles().setPadding(Component.BOTTOM, 5);

        Button tickButton = new Button(tick);
        tickButton.getUnselectedStyle().setBgTransparency(255);
        tickButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
        tickButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
        tickButton.getUnselectedStyle().setBorder(Border.createLineBorder(3,ColorUtil.BLACK));
        tickButton.getAllStyles().setPadding(Component.TOP, 5);
        tickButton.getAllStyles().setPadding(Component.BOTTOM, 5);
        tickButton.setCommand(tick);

        southButtonContainer.add(collideWithFlagButton);
        southButtonContainer.add(collideWithSpiderButton);
        southButtonContainer.add(collideWithFoodStationsButton);
        southButtonContainer.add(tickButton);
        southButtonContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
        borderLayout.addLayoutComponent(BorderLayout.SOUTH, southButtonContainer, this);

        // Add control containers, MapView, and ScoreView to the form
        
//        Container labelContainer = new Container(new FlowLayout(Component.CENTER));
//		Label testLabel = new Label("I am a test of the label system");
//		testLabel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
//		labelContainer.add(testLabel);
//		labelContainer.getStyle().setBgColor(0xffffff);
//		labelContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(255, 0, 0)));
        //this.add(BorderLayout.CENTER, labelContainer);
        //sv.getAllStyles().setPadding(1, 1,10,10);
        this.add(BorderLayout.SOUTH, southButtonContainer);
        this.add(BorderLayout.NORTH, sv);
        this.add(BorderLayout.EAST, rightButtonContainer);
        this.add(BorderLayout.WEST, leftButtonContainer);
        //this.add(BorderLayout.CENTER, mv);
        
        // Bind commands to keys
        this.addKeyListener('a', accelerate);
        this.addKeyListener('b', brake);
        this.addKeyListener('l', left);
        this.addKeyListener('r', right);
        this.addKeyListener('f', collideWithFoodStations);
        this.addKeyListener('g', collideWithSpider);
        this.addKeyListener('t', tick);
        
        // Display the form
        this.show();
        // Query MapView's width and height and set them as world's width and height
        gw.setWidth(mv.getWidth());
        gw.setHeight(mv.getHeight());
        System.out.println("Height:" + mv.getHeight());
        System.out.println("Width:" + mv.getWidth());
        
        // Initialize world
        gw.init();
    }
}
