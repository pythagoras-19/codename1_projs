package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.layouts.Layout;

public class MapView extends Container implements Observer {
	private int width;
	private int height;
	private GameWorld gw;
	private GameWorldProxyImpl gwProxy;

	public MapView(GameWorldProxyImpl gwP) {
		// TODO Auto-generated constructor stub
		this.width = 1000;
		this.height = 1000;
		this.gwProxy = gwP;
	}

	public MapView(Layout layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public MapView(Layout layout, String uiid) {
		super(layout, uiid);
		// TODO Auto-generated constructor stub
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	// Override getWidth() to call super implementation
    public int getWidth() {
        return super.getWidth();
    }

    public void setHeight(int height) {
    	this.height = height;
    }
    // Override getHeight() to call super implementation
    public int getHeight() {
        return super.getHeight();
    }
	
	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		this.map();
	}
	
	/**
	 * Print out the map of the Game by going through each of the GameObjects and listing their respective 
	 * information.
	 * Will print out to the console.
	 */
	public void map() {
	    System.out.println("Printing map to console");
	    IIterator<GameObject> iterator = gwProxy.getGameObjectsIterator();
	    while (iterator.hasNext()) {
	        GameObject obj = iterator.getNext();
	        System.out.println(obj.toString());
	    }
	}



}
