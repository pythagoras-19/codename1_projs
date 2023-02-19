/**
 * Movable is a class that deals with GameObjects that can move within the GameWorld.
 * Parent of Ant and Spider.
 */
package com.mycompany.myapp;

import java.util.ArrayList;
import com.codename1.charts.models.Point;
import java.util.Random;

/**
 * @author mchristiansen
 *
 */
public abstract class Movable extends GameObject {

	/**
	 * Heading and speed are necessary items to determine movement of GameObjects.
	 */
	private int heading;
	private int speed;
	
	
	
	public Movable(int size, Point location, int color) {
		super(size, location, color);
		if (this instanceof Ant) {
			this.heading = 0;
			this.speed = 10;
		}
		if (this instanceof Spider) {
			Random randomNum = new Random();
			this.heading = 0 + randomNum.nextInt(359);
			this.setSpeed();
		}
	}
	
	public void move(int heading, int speed) {
	}
	
	public int getColor() {
		return super.getColor();
	}
	
	public void addToTheWorldVector(GameObject obj) {
		super.addToTheWorldVector(obj);
	}
	
	public ArrayList<GameObject> getTheWorldVector() {
		return super.getTheWorldVector();
	}
	
	public void setHeading(int heading) {
		 this.heading = heading;
	}
	
	public int getHeading() {
		return heading;
	}
	
	public void setSpeed() {
		Random randomNum = new Random();
		this.speed = 5 + randomNum.nextInt(10);
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setLocation(Point location) {
		super.setLocation(location);
	}
	
	public Point getLocation() {
		return super.getLocation();
	}
	
}
