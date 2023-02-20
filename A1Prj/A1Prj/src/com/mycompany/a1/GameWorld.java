/**
 * GameWorld class where the GameWorld items will be updated and be used as a way to interface with GameObjects.
 */
package com.mycompany.a1;

import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
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

/**
 * @author mchristiansen
 *
 */
public class GameWorld {

	/**
	 * Here we are creating an ArrayList to store all the GameObjects that the user will be using the play the game.
	 * We also have antLivesLeft which is exit criteria from the game.
	 * The variable gameClock is used to track the total time the user is playing the game.
	 * The ArrayList seqNums holds the sequence numbers from the flags and offers access to the sequence nums.
	 */
	private ArrayList<GameObject> theWorldVector = new ArrayList<GameObject>(); // TODO: Rename?
	private int antLivesLeft;
	private int gameClock;
	private ArrayList<Integer> seqNums = new ArrayList<Integer>();
	
	
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
		Ant ant = new Ant(antSize, antLocation, antColor);
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
		
		// add to worldVector
		addToTheWorldVector(ant);
		addToTheWorldVector(flag1);
		addToTheWorldVector(flag2);
		addToTheWorldVector(flag3);
		addToTheWorldVector(flag4);
		addToTheWorldVector(spider1);
		addToTheWorldVector(spider2);
		addToTheWorldVector(foodStation1);
		addToTheWorldVector(foodStation2);
	}
	
	/**
	 * Accelerate the Ant by increasing the speed.
	 * We only want to increase the speed (by 1) if the Food level and the health level are greater than 0.
	 * In addition, the speed of the Ant must be less than Maximum speed of the Ant.
	 */
	public void accelerate() {
		for (int i=0; i < getTheWorldVector().size(); i++) {
			if (theWorldVector.get(i) instanceof Ant) {
				Ant aObj = (Ant) theWorldVector.get(i);
				if (aObj.getFoodLevel() > 0 && aObj.getHealthLevel() > 0 && aObj.getSpeed() < aObj.getMaximumSpeed()-1) {
					aObj.setSpeed(aObj.getSpeed() + 1);
				}
			}
		}
	}
	
	/**
	 * Increase the clock because the clock was ticked.
	 */
	public void increaseGameClock() {
		this.gameClock = this.gameClock + 1;
	}
	
	public void addToTheWorldVector(GameObject obj) {
		this.theWorldVector.add(obj);
	}
	
	public ArrayList<GameObject> getTheWorldVector() {
		return this.theWorldVector;
	}

	public void setAntLivesLeft(int lives) {
		this.antLivesLeft = lives;
	}
	
	public int getAntLivesLeft() {
		return this.antLivesLeft;
	}
	
	public void setGameClock(int clock) {
		this.gameClock = clock;
	}
	
	public int getGameClock() {
		return this.gameClock;
	}
	
	/**
	 * Print out the map of the Game by going through each of the GameObjects and listing their respective 
	 * information.
	 */
	public void map() {
		System.out.println("Printing map to console");
		for (int i=0; i < getTheWorldVector().size(); i++) {
			System.out.println(getTheWorldVector().get(i).toString());
		}	
	}
	
	/**
	 * Tick the clock.
	 * The @class Movable objects move() according to their heading and speed.
	 * When the Ant moves, its food level will decrease. If the food level reaches 0, the Ant must lose a life.
	 * If the Ant has no lives left, the game finishes. If it has lives left, the GameWorld is reinitialized.
	 */
	public void tick() {
		this.increaseGameClock(); // tick the clock
		//Move the Movable objects
		for (int i=0; i < getTheWorldVector().size(); i++) {
			if (theWorldVector.get(i) instanceof Movable) {
				Movable mObj = (Movable) theWorldVector.get(i);
				mObj.move();
			}
			// The Ant's status effects the Game's continuation 
			// Here we calculate the new values for the Ant
			if (theWorldVector.get(i) instanceof Ant) {
				Ant aObj = (Ant) theWorldVector.get(i);
				aObj.move();
				aObj.decreaseFoodLevel();
				if (aObj.getFoodLevel() == 0) {
					aObj.setSpeed(0);
					this.antLivesLeft -= 1;
					if(this.antLivesLeft == 0) {
						System.out.println("Game over, you failed!");
						System.exit(0); // game over
					} else {
						ColorUtil.green(aObj.getColor() + 10); //lighten the red
						aObj.setSpeed(aObj.getSpeed() - 1); 
						for (int k=0; k < getTheWorldVector().size(); k++) {
							this.theWorldVector.set(k, null);
						}
					System.gc();
					this.init(); // still has a life left, reinitialize game world but keep clock
					return;
					}
				}
			}
		}
	}
	
	/**
	 * Slow down the speed of the Ant.
	 */
	public void brake() {
		for (int i=0; i < getTheWorldVector().size(); i++) {
			if (theWorldVector.get(i) instanceof Ant) {
				Ant aObj = (Ant) theWorldVector.get(i);
				if (aObj.getSpeed() > 1) {
					aObj.setSpeed(aObj.getSpeed() - 1);
				}
			}
		}
	}
	
	/**
	 * Steer the Ant left.
	 */
	public void left() {
		for (int i=0; i < getTheWorldVector().size(); i++) {
			if (theWorldVector.get(i) instanceof Ant) {
				Ant aObj = (Ant) theWorldVector.get(i);
				//aObj.setHeading(aObj.getHeading() -5);
				aObj.steer(aObj.getHeading() - 5);
			}
		}
	}
	
	/**
	 * Steer the Ant right.
	 */
	public void right() {
		for (int i=0; i < getTheWorldVector().size(); i++) {
			if (theWorldVector.get(i) instanceof Ant) {
				Ant aObj = (Ant) theWorldVector.get(i);
				//aObj.setHeading(aObj.getHeading() + 5);
				aObj.steer(aObj.getHeading() + 5);
			}
		}
	}
	
	/**
	 * Execute a collision with a flag and update the Ant's lastFlagReached.
	 * @param flag which is the desired flag reached.
	 * Must hit the the next sequential flag on the path for it to count.
	 */
	public void collidedFlag(int flag) {
		for (int i=0; i < getTheWorldVector().size(); i++) {
			if (theWorldVector.get(i) instanceof Ant) {
				Ant aObj = (Ant) theWorldVector.get(i);
				if(aObj.getLastFlagReached() + 1 == flag) { // the next sequential flag must be what is reached
					aObj.setFlagReached(flag);
					if(aObj.getLastFlagReached() == this.seqNums.get(this.seqNums.size() - 1)) {
						System.out.println("Game Over, you win! Total time: " + this.getGameClock());
						System.exit(0);
					}
				} else return;
			}
		}
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
		for (int i=0; i < getTheWorldVector().size(); i++) {
			if (theWorldVector.get(i) instanceof FoodStation && (randomFoodStation == foodStationCounter)) {
				FoodStation fObj = (FoodStation) theWorldVector.get(i);
				if (fObj.getCapacity() > 0) {
					// you can eat from it
					for (int j=0; j < getTheWorldVector().size(); j++) {
						if (theWorldVector.get(j) instanceof Ant) {
							Ant aObj = (Ant) theWorldVector.get(j);
							if(fObj.getCapacity() > aObj.getFoodLevel()) {
								aObj.setFoodLevel(fObj.getCapacity());
							}
							fObj.setCapacity(0);
							int emptyFoodStationColor = ColorUtil.rgb(144,238,144); // light green
							fObj.setColor(emptyFoodStationColor);
							// add a new food station with a new random size and location
							int newFoodStationSize = 10 + randomNum.nextInt(50);
							int newFoodStationColor = ColorUtil.rgb(50,50,50);
							float randomXVal = 0 + randomNum.nextInt(1000);
							float randomYVal = 0 + randomNum.nextInt(1000);
							Point newFoodStationLocation = new Point(randomXVal, randomYVal);
							//FoodStation newFoodStation = new FoodStation(newFoodStationSize, newFoodStationLocation, newFoodStationColor);
							FoodStation newFS = new FoodStation(newFoodStationSize, newFoodStationLocation, newFoodStationColor);
							theWorldVector.add(newFS);
							foodStationCounter += 1;
						}
					}
				}
			}
			else if (theWorldVector.get(i) instanceof FoodStation && !(randomFoodStation == foodStationCounter)) { // instance of FoodStation but NOT the right food station that was randomly picked
				foodStationCounter = foodStationCounter + 1;
			}
		}	
	}
	
	/**
	 * Ant collides with the Spider. 
	 * When this happens the Ant's health decreases by a value of 1. If the Ant has a 0 health value after this,
	 * it will lose a life. If the Ant has no lives left after this, it will be game over.
	 * Otherwise,the GameWorld is reinitialized.
	 */
	public void collidedSpider() {
		// decrease health level by 1 from Ant
		for (int i=0; i < getTheWorldVector().size(); i++) {
			if (theWorldVector.get(i) instanceof Ant) {
				Ant aObj = (Ant) theWorldVector.get(i);
				for (int j=0; j < getTheWorldVector().size();j++) {
					if (theWorldVector.get(j) instanceof Spider) {
						Spider sObj = (Spider) theWorldVector.get(j);
						sObj.setLocation(aObj.getLocation());
					}
				}
				aObj.setHealthLevel(aObj.getHealthLevel() - 1);
				aObj.setSpeed((aObj.getHealthLevel()/aObj.getMaxHealthLevel()) * aObj.getSpeed());
				if (aObj.getSpeed() == 0 || aObj.getHealthLevel() == 0) {
					this.antLivesLeft = this.antLivesLeft - 1;
					if(this.antLivesLeft == 0) {
						System.out.println("Game over, you failed!");
						System.exit(0); // game over
					} else {
						ColorUtil.green(aObj.getColor() + 10); //lighten the red
						for (int k=0; k < getTheWorldVector().size(); k++) {
							this.theWorldVector.set(k, null);
						}
						System.gc();
						this.init(); // still has a life left, reinitialize game world but keep clock
						return;
					}
				}
			}
		}
	}
	
	/**
	 * Display key information for the user to the terminal. 
	 */
	public void display() {
		// TODO: output number of lives left, current clock value (elapsed time), highest flag number the ant has reached (lastFlagReached), and 
		// ant's current foodLevel, and ant's healthLevel
		System.out.println("Ant lives left: " + this.antLivesLeft);
		System.out.println("Clock value: " + this.getGameClock());
		
		for (int i=0; i < getTheWorldVector().size(); i++) {
			if (theWorldVector.get(i) instanceof Ant) {
				Ant aObj = (Ant) theWorldVector.get(i);
				System.out.println("Highest flag reached:" + aObj.getLastFlagReached());
				System.out.println("Ant current food level: " + aObj.getFoodLevel());
				System.out.println("Ant health level: " + aObj.getHealthLevel());
			}
		}
	}
	
	public void exit() {
		System.out.println("Are you sure you want to exit? Hit 'y' or 'n'.");
	}
}
