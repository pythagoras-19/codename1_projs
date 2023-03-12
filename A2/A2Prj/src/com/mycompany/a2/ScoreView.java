package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.Layout;

public class ScoreView extends Container implements Observer {

	public ScoreView() {
		// TODO Auto-generated constructor stub
		super(new BorderLayout());
        
        Label timeLabel = new Label("Time: 0");
        Label antCountLabel = new Label("Ant Count: 0");
        
        addComponent(BorderLayout.WEST, timeLabel);
        addComponent(BorderLayout.EAST, antCountLabel);
	}

	public ScoreView(Layout layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public ScoreView(Layout layout, String uiid) {
		super(layout, uiid);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub

	}

}
