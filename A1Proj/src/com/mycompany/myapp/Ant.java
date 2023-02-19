/**
 * 
 */
package com.mycompany.myapp;

import java.util.ArrayList;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

/**
 * @author mchristiansen
 *
 */
public class Ant extends Movable implements ISteerable {

	/**
	 * 
	 */
	private float maximumSpeed;
	private int foodLevel;
	private int foodConsumptionRate;
	private int healthLevel;
	private int lastFlagReached;
	private int maxHealthLevel;
	
	public Ant(int size, Point location, int color) {
		// TODO Auto-generated constructor stub
		super(size, location, color); //TODO: update this to use GameObject constructor
		this.foodLevel = 20;
		this.healthLevel = 10;
		this.maxHealthLevel = 10;
		this.maximumSpeed = 20.0F;
		this.foodConsumptionRate = 2;
		this.lastFlagReached = 1;
		//this.setHeading(0.0F);
		
	}

	@Override
	public void steer(int heading) {
		// TODO Auto-generated method stub
		this.setHeading(heading);

	}
	
	public void setLocation(Point location) {
		//TODO verify no random override
		super.setLocation(location);
	}
	
	public Point getLocation() {
		return super.getLocation();
	}
	
	public int getColor() {
		return super.getColor();
	}
	
	public void move() {
		float deltaX = (float) Math.cos(Math.toRadians(this.getHeading())) * this.getSpeed();
		float deltaY = (float) Math.sin(Math.toRadians(this.getHeading())) * this.getSpeed();
		Point newPoint = new Point(super.getLocation().getX() + deltaX, super.getLocation().getY() + deltaY);
		this.setLocation(newPoint);
		/*
		 * Below we are dealing with the case of getting to the edge of the map.
		 */
		if (this.getLocation().getX() >= 1000) {
			super.setHeading(super.getHeading() - 180);
			this.move();
		}
		if (this.getLocation().getY() >= 1000) {
			super.setHeading(super.getHeading() - 180);
			this.move();
		}
		if (this.getLocation().getX() <= 0) {
			super.setHeading(super.getHeading() + 180);
			this.move();
		}
		if (this.getLocation().getY() <= 0) {
			super.setHeading(super.getHeading() + 180);
			this.move();
		}
	}
	
	public void addToTheWorldVector(GameObject obj) {
		super.addToTheWorldVector(obj);
	}
	
	public ArrayList<GameObject> getTheWorldVector() {
		return super.getTheWorldVector();
	}
	
	public void setHeading(int heading) {
		super.setHeading(heading);
	}
	
	public int getHeading() {
		return super.getHeading();
	}
	
	public void setSpeed(float speed) {
		super.setSpeed();
	}
	
	public int getSpeed() {
		return super.getSpeed();
	}
	
	public void setMaximumSpeed(float maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}
	
	public float getMaximumSpeed() {
		return this.maximumSpeed;
	}
	
	public void setFoodConsumptionRate(int foodConsumptionRate) {
		this.foodConsumptionRate = foodConsumptionRate;
	}
	
	public int getFoodConsumptionRate() {
		return this.foodConsumptionRate;
	}
	
	public void setHealthLevel(int healthLvl) {
		this.healthLevel = healthLvl;
	}
	
	public int getHealthLevel() {
		return this.healthLevel;
	}
	
	public void decreaseFoodLevel() {
		this.foodLevel = this.foodLevel - this.getFoodConsumptionRate();
	}
	
	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}
	
	public int getFoodLevel() {
		return this.foodLevel;
	}
	
	public void setFlagReached(int lastFlagReached) {
		this.lastFlagReached = lastFlagReached;
	}
	
	public int getLastFlagReached() {
		return this.lastFlagReached;
	}
	
	public int getMaxHealthLevel( ) {
		return this.maxHealthLevel;
	}
	
	public String toString() {
		return ("Ant: loc=" + getLocation().getX() + "," + getLocation().getY() + " color=" + "[" + ColorUtil.red(this.getColor()) + "," + 
				ColorUtil.green(this.getColor()) + "," + ColorUtil.blue(this.getColor()) + "] " + " heading=" + this.getHeading() + 
				" speed=" + this.getSpeed() + " size=" + this.getSize() + " maxSpeed=" + 
				this.getMaximumSpeed() + " foodConsumptionRate=" + this.getFoodConsumptionRate() );
	}
}
