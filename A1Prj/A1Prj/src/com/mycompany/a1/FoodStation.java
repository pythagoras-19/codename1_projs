/**
 * FoodStation's offer food to the Ant to keep its FoodLevel high.
 */
package com.mycompany.a1;

import java.util.ArrayList;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
/**
 * @author mchristiansen
 *
 */
public class FoodStation extends Fixed{

	/**
	 * FoodStation's have a capacity for which holds the amount of food they have.
	 */
	private int capacity;
	
	public FoodStation(int size, Point location, int color) {
		// TODO Auto-generated constructor stub
		super(size, location, color);
		this.capacity = size;
	}
	public void addToTheWorldVector(GameObject obj) {
		super.addToTheWorldVector(obj);
	}
	
	public ArrayList<GameObject> getTheWorldVector() {
		return super.getTheWorldVector();
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public Point getLocation() {
		return super.getLocation();
	}
	
	public String toString() {
		return ("FoodStation: loc=" + this.getLocation().getX() + "," + this.getLocation().getY() + " color=" + "[" + ColorUtil.red(this.getColor()) + "," + 
				ColorUtil.green(this.getColor()) + "," + ColorUtil.blue(this.getColor()) + "] " + 
				" size=" + this.getSize() + " capacity=" + this.getCapacity());
	}


}
