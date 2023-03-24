package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;

public class MapView extends Container implements Observer {
	private GameWorldProxyImpl gwProxy;
	private int width;
	private int height;

	public MapView(GameWorldProxyImpl gwP) {
		super(new BorderLayout());
		System.out.println("MapView is created!");
		this.gwProxy = gwP;
	}

//	public MapView(Layout layout) {
//		super(layout);
//		// TODO Auto-generated constructor stub
//	}
//
//	public MapView(Layout layout, String uiid) {
//		super(layout, uiid);
//		// TODO Auto-generated constructor stub
//	}
	
    public int getWidth() {
        return super.getWidth();
    }
    
    public int getHeight() {
        return super.getHeight();
    }
	
	@Override
	public void update(Observable observable, Object data) {
		gwProxy.map();
	}
}
