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
public class Spider extends Movable {

	/**
	 * 
	 */
	public Spider(int size, Point location, int color) {
		// TODO Auto-generated constructor stub
		super(size, location, color);
	}
	
	public void setColor() {
		// TODO verify empty body override
	}
	
	public void move() {
		// TODO override specific to spider	
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
	
	public void setLocation(Point location) {
		super.setLocation(location);
	}
	
	public Point getLocation() {
		return super.getLocation();
	}
	
	public String toString() {
		return ("Spider: loc=" + this.getLocation().getX() + "," + this.getLocation().getY() + " color=" + "[" + ColorUtil.red(this.getColor()) + "," + 
				ColorUtil.green(this.getColor()) + "," + ColorUtil.blue(this.getColor()) + "] " + " heading=" + this.getHeading() + 
				" speed=" + this.getSpeed() + " size=" + this.getSize());
	}
	
}
