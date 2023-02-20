/**
 * This is the implementation of the Ant class. 
 * 
 */
package com.mycompany.a1;

import java.util.ArrayList;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

/**
 * @author mchristiansen
 *
 */
public class Ant extends Movable implements ISteerable {

	/**
	 * Fields below for use.
	 */
	private float maximumSpeed;
	private int foodLevel;
	private int foodConsumptionRate;
	private int healthLevel;
	private int lastFlagReached;
	private int maxHealthLevel;
	
	public Ant(int size, Point location, int color) {
		super(size, location, color); 
		this.foodLevel = 20;
		this.healthLevel = 10;
		this.maxHealthLevel = 10;
		this.maximumSpeed = 20.0F;
		this.foodConsumptionRate = 2;
		this.lastFlagReached = 1;
		//this.setHeading(0.0F);
		
	}
	
	/**
	 * The steer() method is steering the Ant based on a new heading given.
	 * @param heading
	 * sets the heading of the Ant to the new heading.
	 */
	@Override
	public void steer(int heading) {
		// TODO Auto-generated method stub
		this.setHeading(heading);
	}
	
	/**
	 * Sets the location of Ant to a new location.
	 * @param a location of type Point from the CN1 library.
	 */
	public void setLocation(Point location) {
		//TODO verify no random override
		super.setLocation(location);
	}
	
	/**
	 * Return Ant's location.
	 * @return Ant's current location on the map of type Point
	 */
	public Point getLocation() {
		return super.getLocation();
	}
	
	/**
	 * Return the Ant's color.
	 * @return color of type integer.
	 */
	public int getColor() {
		return super.getColor();
	}
	
	/**
	 * Move the Ant on the map.
	 * We will calculate the change in X and Y with the current speed of the Ant.
	 * Then we will get the Point the Ant will be located at with the speed and heading.
	 * We will then set the Ant's new location to this Point.
	 * 
	 * We also need to deal with the case the Ant gets to edge of map. We will turn the ant around and move() it again.
	 */
	public void move() {
		super.move();
	}
	
	/**
	 * Set the heading of the Ant
	 * @param heading of type Integer the Ant will be pointed in.
	 */
	public void setHeading(int heading) {
		super.setHeading(heading);
	}
	
	/**
	 * Return the current heading of the Ant.
	 * @return Ant's heading of type Integer.
	 */
	public int getHeading() {
		return super.getHeading();
	}
	
	/**
	 * Set the speed of the Ant.
	 * @param speed
	 */
	public void setSpeed(float speed) {
		super.setSpeed();
	}
	
	/**
	 * Return the speed of the Ant
	 * @return speed of type integer
	 */
	public int getSpeed() {
		return super.getSpeed();
	}
	
	/**
	 * Set the maximum speed achievable by the Ant to @param maximumSpeed
	 * @param maximumSpeed
	 */
	public void setMaximumSpeed(float maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}
	
	/**
	 * Get the maximum speed of the Ant
	 * @return maximumSpeed
	 */
	public float getMaximumSpeed() {
		return this.maximumSpeed;
	}
	
	/**
	 * Set the food consumption rate of the Ant.
	 * @param foodConsumptionRate
	 */
	public void setFoodConsumptionRate(int foodConsumptionRate) {
		this.foodConsumptionRate = foodConsumptionRate;
	}
	
	/**
	 * Return the food consumption rate of the Ant.
	 * @return foodConsumptionRate
	 */
	public int getFoodConsumptionRate() {
		return this.foodConsumptionRate;
	}
	
	/**
	 * Set the health level of the Ant.
	 * @param healthLvl
	 */
	public void setHealthLevel(int healthLvl) {
		this.healthLevel = healthLvl;
	}
	
	/**
	 * 
	 * @return the health level of the Ant
	 */
	public int getHealthLevel() {
		return this.healthLevel;
	}
	
	/**
	 * Set the food level to a decreased amount based on the food consumption rate of the Ant.
	 */
	public void decreaseFoodLevel() {
		this.foodLevel = this.foodLevel - this.getFoodConsumptionRate();
	}
	
	/**
	 * Set the food level of the Ant.
	 * @param foodLevel
	 */
	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}
	
	/**
	 * Get the food level of the Ant.
	 * @return
	 */
	public int getFoodLevel() {
		return this.foodLevel;
	}
	
	/**
	 * The Ant reached a new flag and we need to set it as the lastFlagReached
	 * @param lastFlagReached
	 */
	public void setFlagReached(int lastFlagReached) {
		this.lastFlagReached = lastFlagReached;
	}
	
	/**
	 * 
	 * @return lastFlagReached the last flag reached by the Ant currently.
	 */
	public int getLastFlagReached() {
		return this.lastFlagReached;
	}
	
	/**
	 * @return maxHealthLevel of the Ant
	 */
	public int getMaxHealthLevel( ) {
		return this.maxHealthLevel;
	}
	
	/**
	 * @return a string of all the important information for the 'd' (display) command to the user.
	 */
	public String toString() {
		return ("Ant: loc=" + getLocation().getX() + "," + getLocation().getY() + " color=" + "[" + ColorUtil.red(this.getColor()) + "," + 
				ColorUtil.green(this.getColor()) + "," + ColorUtil.blue(this.getColor()) + "] " + " heading=" + this.getHeading() + 
				" speed=" + this.getSpeed() + " size=" + this.getSize() + " maxSpeed=" + 
				this.getMaximumSpeed() + " foodConsumptionRate=" + this.getFoodConsumptionRate() );
	}

}
