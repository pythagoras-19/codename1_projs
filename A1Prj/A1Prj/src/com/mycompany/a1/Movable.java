/**
 * Movable is a class that deals with GameObjects that can move within the GameWorld.
 * Parent of Ant and Spider.
 */
package com.mycompany.a1;

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
	
	public void move() {
		float deltaX = (float) Math.cos(Math.toRadians(this.getHeading())) * this.getSpeed();
		float deltaY = (float) Math.sin(Math.toRadians(this.getHeading())) * this.getSpeed();
		Point newPoint = new Point(this.getLocation().getX() + deltaX, this.getLocation().getY() + deltaY);
		this.setLocation(newPoint);
		/*
		 * Below we are dealing with the case of getting to the edge of the map.
		 */
		if (this.getLocation().getX() >= 1000) {
			this.setHeading(this.getHeading() - 180);
			this.move();
		}
		if (this.getLocation().getY() >= 1000) {
			this.setHeading(this.getHeading() - 180);
			this.move();
		}
		if (this.getLocation().getX() <= 0) {
			this.setHeading(this.getHeading() + 180);
			this.move();
		}
		if (this.getLocation().getY() <= 0) {
			this.setHeading(this.getHeading() + 180);
			this.move();
		}
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
