/**
 * GameWorld class where the GameWorld items will be updated and be used as a way to interface with GameObjects.
 */
package com.mycompany.a2;

import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;

import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.io.NetworkEvent;

import static com.codename1.ui.CN.addNetworkErrorListener;
import static com.codename1.ui.CN.getCurrentForm;
import static com.codename1.ui.CN.updateNetworkThreadCount;

import com.codename1.io.Log;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.plaf.UIManager;

import com.codename1.charts.models.*;
import com.codename1.charts.util.ColorUtil;

import java.util.ArrayList;
import java.util.Random;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
//
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;
import java.util.Observable;
import java.util.Observer;


/**
 * @author mchristiansen
 *
 */
public class GameWorld extends Observable {

	/**
	 * Here we are creating an ArrayList to store all the GameObjects that the user will be using the play the game.
	 * We also have antLivesLeft which is exit criteria from the game.
	 * The variable gameClock is used to track the total time the user is playing the game.
	 * The ArrayList seqNums holds the sequence numbers from the flags and offers access to the sequence nums.
	 */
	private GameObjectCollection gameObjects = new GameObjectCollection();
	private int height;
	private int width;
	private int antLivesLeft;
	private int gameClock;
	private ArrayList<Integer> seqNums = new ArrayList<Integer>();
	boolean sound = false;
	
	
	public GameWorld() {
		// TODO Auto-generated constructor stub
		this.setAntLivesLeft(3);
		this.setGameClock(0);
	}
	
	public void init() {
		// code here to create the initial game objects / setup
		Random randomNum = new Random();
		float randomXVal = 0 + randomNum.nextInt(1000);
		float randomYVal = 0 + randomNum.nextInt(1000);
		Point location = new Point(randomXVal, randomYVal);
		Point antLocation = new Point(5.5F,5.5F);
		Point spider1Location = new Point(300.72F, 300.44F);
		Point spider2Location = new Point(1.43F, 600.24F);
		Point foodStation1Location = new Point(50.65F, 200.98F);
		Point foodStation2Location = new Point(250.23F, 700.5F);
		int antColor = ColorUtil.rgb(255,0,0);
		int flag1Color = ColorUtil.rgb(0,0,255);
		int spiderColor = ColorUtil.rgb(0,0,0);
		int foodStationColor = ColorUtil.rgb(50,50,50);
		int spider1Size = 10 + randomNum.nextInt(40);
		int spider2Size = 10 + randomNum.nextInt(40);
		int foodStation1Size = 10 + randomNum.nextInt(40);
		int foodStation2Size = 10 + randomNum.nextInt(40);
		int antSize = 10;
		int flagSize = 20;
		Ant ant = Ant.getInstance(antSize, antLocation, antColor);
		Flag flag1 = new Flag(flagSize, antLocation, flag1Color, 1); // Ant is initially located here
		this.seqNums.add(flag1.getSequenceNumber());
		Flag flag2 = new Flag(flagSize, location, flag1Color, 2);
		this.seqNums.add(flag2.getSequenceNumber());
		randomXVal = 0 + randomNum.nextInt(1000);
		randomYVal = 0 + randomNum.nextInt(1000);
		location = new Point(randomXVal, randomYVal);
		Flag flag3 = new Flag(flagSize, location, flag1Color, 3);
		this.seqNums.add(flag3.getSequenceNumber());
		randomXVal = 0 + randomNum.nextInt(1000);
		randomYVal = 0 + randomNum.nextInt(1000);
		location = new Point(randomXVal, randomYVal);
		Flag flag4 = new Flag(flagSize, location, flag1Color, 4);
		this.seqNums.add(flag4.getSequenceNumber());
		Spider spider1 = new Spider(spider1Size, spider1Location, spiderColor);
		Spider spider2 = new Spider(spider2Size, spider2Location, spiderColor);
		FoodStation foodStation1 = new FoodStation(foodStation1Size, foodStation1Location, foodStationColor);
		FoodStation foodStation2 = new FoodStation(foodStation2Size, foodStation2Location, foodStationColor);
		
		// add to gameObjects collection
		gameObjects.add(ant);
		gameObjects.add(flag1);
		gameObjects.add(flag2);
		gameObjects.add(flag3);
		gameObjects.add(flag4);
		gameObjects.add(spider1);
		gameObjects.add(spider2);
		gameObjects.add(foodStation1);
		gameObjects.add(foodStation2);
	}
	
	
	/*
	 * Return the game objects collection
	 */
	public GameObjectCollection getGameObjects() {
		return this.gameObjects;
	}
	
	public void addToGameObjectCollection(GameObject obj) {
		this.gameObjects.add(obj);
	}
	
	/**
	 * Accelerate the Ant by increasing the speed.
	 * We only want to increase the speed (by 1) if the Food level and the health level are greater than 0.
	 * In addition, the speed of the Ant must be less than Maximum speed of the Ant.
	 */
	public void accelerate() {
	    IIterator<GameObject> iterator = gameObjects.getIterator();
	    while (iterator.hasNext()) {
	        GameObject obj = iterator.getNext();
	        if (obj instanceof Ant) {
	            Ant ant = (Ant) obj;
	            if (ant.getFoodLevel() > 0 && ant.getHealthLevel() > 0 && ant.getSpeed() < ant.getMaximumSpeed() - 1) {
	                ant.setSpeed(ant.getSpeed() + 1);
	            }
	        }
	    }
	    this.setChanged();
	    this.notifyObservers();
	}

	/**
	 * Increase the clock because the clock was ticked.
	 */
	public void increaseGameClock() {
		this.gameClock = this.gameClock + 1;
		this.setChanged();
	    this.notifyObservers();
	}

	public void setAntLivesLeft(int lives) {
		this.antLivesLeft = lives;
		this.setChanged();
	    this.notifyObservers();
	}
	
	public int getAntLivesLeft() {
		return this.antLivesLeft;
	}
	
	public void setGameClock(int clock) {
		this.gameClock = clock;
		this.setChanged();
	    this.notifyObservers();
	}
	
	public int getGameClock() {
		return this.gameClock;
	}
	
	/**
	 * Tick the clock.
	 * The @class Movable objects move() according to their heading and speed.
	 * When the Ant moves, its food level will decrease. If the food level reaches 0, the Ant must lose a life.
	 * If the Ant has no lives left, the game finishes. If it has lives left, the GameWorld is reinitialized.
	 */
	public void tick() {
	    this.increaseGameClock(); // tick the clock
	    IIterator<GameObject> iterator = gameObjects.getIterator();
	    while (iterator.hasNext()) {
	        GameObject obj = iterator.getNext();
	        if (obj instanceof Movable) {
	            Movable mObj = (Movable) obj;
	            mObj.move();
	        }
	        if (obj instanceof Ant) {
	            Ant aObj = (Ant) obj;
	            aObj.move();
	            aObj.decreaseFoodLevel();
	            if (aObj.getFoodLevel() == 0) {
	                aObj.setSpeed(0);
	                this.antLivesLeft -= 1;
	                if (this.antLivesLeft == 0) {
	                    Dialog.show("Game Over", "You failed!", "OK", null);
	                    System.exit(0);
	                } else {
	                    ColorUtil.green(aObj.getColor() + 10); //lighten the red
	                    aObj.setSpeed(aObj.getSpeed() - 1);
	                    iterator.remove();
	                    init();
	                    return;
	                }
	            }
	        }
	    }
	    this.setChanged();
	    this.notifyObservers();
	}

	
	/**
	 * Slow down the speed of the Ant.
	 */
	public void brake() {
	    IIterator<GameObject> iterator = gameObjects.getIterator();
	    while (iterator.hasNext()) {
	        GameObject obj = iterator.getNext();
	        if (obj instanceof Ant) {
	            Ant aObj = (Ant) obj;
	            if (aObj.getSpeed() > 1) {
	                aObj.setSpeed(aObj.getSpeed() - 1);
	            }
	        }
	    }
	    this.setChanged();
	    this.notifyObservers();
	}

	
	/**
	 * Steer the Ant left.
	 */
	public void left() {
	    IIterator<GameObject> iterator = gameObjects.getIterator();
	    while (iterator.hasNext()) {
	        GameObject obj = iterator.getNext();
	        if (obj instanceof Ant) {
	            Ant ant = (Ant) obj;
	            ant.steer(ant.getHeading() - 5);
	        }
	    }
	    this.setChanged();
	    this.notifyObservers();
	}

	
	/**
	 * Steer the Ant right.
	 */
	public void right() {
	    IIterator<GameObject> iterator = gameObjects.getIterator();
	    while (iterator.hasNext()) {
	        GameObject obj = iterator.getNext();
	        if (obj instanceof Ant) {
	            Ant ant = (Ant) obj;
	            ant.steer(ant.getHeading() + 5);
	        }
	    }
	    this.setChanged();
	    this.notifyObservers();
	}

	
	/**
	 * Execute a collision with a flag and update the Ant's lastFlagReached.
	 * @param flag which is the desired flag reached.
	 * Must hit the the next sequential flag on the path for it to count.
	 */
	public void collidedFlag() {
	    // Get the highest flag number
	    int lastFlag = seqNums.get(seqNums.size() - 1);

	    // Prompt the user to enter the flag number
	    int flagNum = 0;
	    TextField flagField = new TextField("", "", 4, TextArea.NUMERIC);
	    Dialog.show("Enter Flag Number", FlowLayout.encloseCenterMiddle(new Label("Enter flag number (1-" + lastFlag + "):"), flagField),
	            new Command("OK"), new Command("Cancel"));
	    String text = flagField.getText();
	    if (text != null && !text.isEmpty()) {
	        flagNum = Integer.parseInt(text);
	    }

	        if (flagNum == -1 || flagNum < 1 || flagNum > lastFlag) {
	            Dialog.show("Invalid Flag Number", "Please enter a valid flag number.", "OK", null);
	        }

	    // Check if the flag was reached by the ant
	    IIterator<GameObject> iterator = gameObjects.getIterator();
	    while (iterator.hasNext()) {
	        GameObject obj = iterator.getNext();
	        if (obj instanceof Ant) {
	            Ant ant = (Ant) obj;
	            if (ant.getLastFlagReached() + 1 == flagNum) {
	                ant.setFlagReached(flagNum);
	                if (ant.getLastFlagReached() == lastFlag) {
	                    Dialog.show("Game Over", "You win! Total time: " + getGameClock(), "OK", null);
	                    exit();
	                }
	            } else {
	                Dialog.show("Invalid Flag", "The flag entered is not the next sequential flag to be reached.", "OK", null);
	            }
	        }
	    }
	    this.setChanged();
	    this.notifyObservers();
	}


	
	/**
	 * The Ant Collided with a food station.
	 * This causes the Ant's foodlevel to match the foodstation's capacity IF the foodstation capacity is more 
	 * than the foodlevel of the Ant.
	 */
	public void collidedFoodStation() {
	    Random randomNum = new Random();
	    int randomFoodStation = 0 + randomNum.nextInt(1);
	    int foodStationCounter = 0;
	    IIterator<GameObject> iterator = gameObjects.getIterator();
	    while (iterator.hasNext()) {
	        GameObject obj = iterator.getNext();
	        if (obj instanceof FoodStation && (randomFoodStation == foodStationCounter)) {
	            FoodStation fObj = (FoodStation) obj;
	            if (fObj.getCapacity() > 0) {
	                // you can eat from it
	                IIterator<GameObject> antIterator = gameObjects.getIterator();
	                while (antIterator.hasNext()) {
	                    GameObject antObj = antIterator.getNext();
	                    if (antObj instanceof Ant) {
	                        Ant aObj = (Ant) antObj;
	                        if (fObj.getCapacity() > aObj.getFoodLevel()) {
	                            aObj.setFoodLevel(fObj.getCapacity());
	                        }
	                        fObj.setCapacity(0);
	                        int emptyFoodStationColor = ColorUtil.rgb(144, 238, 144); // light green
	                        fObj.setColor(emptyFoodStationColor);
	                        // add a new food station with a new random size and location
	                        int newFoodStationSize = 10 + randomNum.nextInt(50);
	                        int newFoodStationColor = ColorUtil.rgb(50, 50, 50);
	                        float randomXVal = 0 + randomNum.nextInt(1000);
	                        float randomYVal = 0 + randomNum.nextInt(1000);
	                        Point newFoodStationLocation = new Point(randomXVal, randomYVal);
	                        FoodStation newFS = new FoodStation(newFoodStationSize, newFoodStationLocation, newFoodStationColor);
	                        gameObjects.add(newFS);
	                        foodStationCounter += 1;
	                    }
	                }
	            }
	        } else if (obj instanceof FoodStation && !(randomFoodStation == foodStationCounter)) { // instance of FoodStation but NOT the right food station that was randomly picked
	            foodStationCounter = foodStationCounter + 1;
	        }
	    }
	    this.setChanged();
	    this.notifyObservers();
	}

	
	/**
	 * Ant collides with the Spider. 
	 * When this happens the Ant's health decreases by a value of 1. If the Ant has a 0 health value after this,
	 * it will lose a life. If the Ant has no lives left after this, it will be game over.
	 * Otherwise,the GameWorld is reinitialized.
	 */
	public void collidedSpider() {
	    // decrease health level by 1 from Ant
	    IIterator<GameObject> iterator = gameObjects.getIterator();
	    while (iterator.hasNext()) {
	        GameObject obj = iterator.getNext();
	        if (obj instanceof Ant) {
	            Ant aObj = (Ant) obj;
	            IIterator<GameObject> spiderIterator = gameObjects.getIterator();
	            while (spiderIterator.hasNext()) {
	                GameObject spiderObj = spiderIterator.getNext();
	                if (spiderObj instanceof Spider) {
	                    Spider sObj = (Spider) spiderObj;
	                    sObj.setLocation(aObj.getLocation());
	                }
	            }
	            aObj.setHealthLevel(aObj.getHealthLevel() - 1);
	            aObj.setSpeed((aObj.getHealthLevel() / aObj.getMaxHealthLevel()) * aObj.getSpeed());
	            if (aObj.getSpeed() == 0 || aObj.getHealthLevel() == 0) {
	                this.antLivesLeft = this.antLivesLeft - 1;
	                if (this.antLivesLeft == 0) {
	                    Dialog.show("Game Over", "You failed!", "OK", null);
	                    System.exit(0);
	                } else {
	                    aObj.setColor(ColorUtil.GREEN); // lighten the red
	                    // iterator.remove();
	                    System.gc();
	                    init(); // still has a life left, reinitialize game world but keep clock
	                    return;
	                }
	            }
	        }
	    }
	    this.setChanged();
	    this.notifyObservers();
	}

	
	
	public void exit() {
		System.out.println("Are you sure you want to exit? Hit 'y' or 'n'.");
		Display.getInstance().exitApplication();
	}

	public void setWidth(int mapWidth) {
		// TODO Auto-generated method stub
		this.width = mapWidth;
		this.setChanged();
	    this.notifyObservers();
	}

	public void setHeight(int mapHeight) {
		// TODO Auto-generated method stub
		this.height = mapHeight;
		this.setChanged();
	    this.notifyObservers();
	}
}
