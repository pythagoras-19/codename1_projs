/**
 * GameObject class that deals with all Movable and Fixed GameObjects in our game.
 * This is the parent class of Movable and Fixed.
 */
package com.mycompany.a1;

import java.util.ArrayList;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

/**
 * @author mchristiansen
 *
 */
public abstract class GameObject extends GameWorld {

	/**
	 * Size, location, and color are main elements of creating a GameObject.
	 * 
	 */
	private int size;
	private Point location;
	private int color;
	
	public GameObject(int size, Point location, int color) {
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
		this.color = color;
	}
	
	public int getColor() {
		return this.color;
	}
}
