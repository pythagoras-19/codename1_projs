package com.mycompany.myapp;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class Game {

	public Game() {
		// TODO Auto-generated constructor stub
		Form hi = new Form("Hi World", BoxLayout.y());
        hi.add(new Label("Hi World"));
        hi.show();
	}

}
