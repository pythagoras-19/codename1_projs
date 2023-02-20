/**
 * Fixed class that is the parent of our fixed objects like FoodStation and Flag
 */
package com.mycompany.a1;

import java.util.ArrayList;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
/**
 * @author mchristiansen
 *
 */
public abstract class Fixed extends GameObject {

	public Fixed(int size, Point location, int color) {
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
