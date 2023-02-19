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
public abstract class Fixed extends GameObject {

	/**
	 * 
	 */
	public Fixed(int size, Point location, int color) {
		// TODO Auto-generated constructor stub
		super(size, location, color);
	}
	
	public void setLocation() {	// keep empty -- override
	}
	
	public Point getLocation() {
		return super.getLocation();
	}
	
	public void addToTheWorldVector(GameObject obj) {
		super.addToTheWorldVector(obj);
	}
	
	public ArrayList<GameObject> getTheWorldVector() {
		return super.getTheWorldVector();
	}


}
