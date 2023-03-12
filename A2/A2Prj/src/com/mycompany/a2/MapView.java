package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.layouts.Layout;

public class MapView extends Container implements Observer {
	
	// Override getWidth() to call super implementation
    public int getWidth() {
        return super.getWidth();
    }

    // Override getHeight() to call super implementation
    public int getHeight() {
        return super.getHeight();
    }

	public MapView() {
		// TODO Auto-generated constructor stub
	}

	public MapView(Layout layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public MapView(Layout layout, String uiid) {
		super(layout, uiid);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub

	}
	
	public void map() {
		System.out.println("Printing map to console");
		for (int i=0; i < gameObjects().size(); i++) {
			System.out.println(gameObjects().get(i).toString());
		}	
	}

}
