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
public abstract class GameObject extends GameWorld {

	/**
	 * 
	 */
	private int size;
	private Point location;
	private int color;
	private ArrayList<GameObject> theWorldVector;
	
	// public GameObject() {}
	
	public GameObject(int size, Point location, int color) {
		// TODO Auto-generated constructor stub
		this.size = size;
		this.setLocation(location);
		this.setColor(color);
	}
	
	public void setSize(int size) {
	}
	
	public int getSize() {
		return size;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}
	
	public Point getLocation() {
		return this.location;
	}
	
	public void setColor(int color) {
		// TODO FINISH ME
		// not sure
		this.color = color;
	}
	
	public int getColor() {
		return this.color;
	}
	

}
