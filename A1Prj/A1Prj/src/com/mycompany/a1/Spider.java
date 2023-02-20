/**
 * This is the implementation of the Spider class.
 * Unlike the Ant, the Spiders is not steerable and therefore cannot change its heading from the user.
 */

package com.mycompany.a1;

import java.util.ArrayList;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
/**
 * @author mchristiansen
 */
public class Spider extends Movable {

	/**
	 * Spider will call its parent Movable to create its object.
	 */
	public Spider(int size, Point location, int color) {
		super(size, location, color);
	}
	
	/**
	 * Cannot change its color after initial instantiation.
	 */
	public void setColor() {
	}
	
	/**
	 * After we update the Spiders location based on its speed and heading we will make sure that Point
	 * is not off the map. If it is off the map we will turn the Spider around and move it.
	 */
	public void move() {
		super.move();
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
