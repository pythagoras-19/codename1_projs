package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;

public class CollideWithSpiderComand extends Command {
	private GameWorld gw;

	public CollideWithSpiderComand(GameWorld gw) {
		super("Collide With Spider");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}

	public CollideWithSpiderComand(String command, Image icon) {
		super(command, icon);
		// TODO Auto-generated constructor stub
	}

	public CollideWithSpiderComand(String command, int id) {
		super(command, id);
		// TODO Auto-generated constructor stub
	}

	public CollideWithSpiderComand(String command, Image icon, int id) {
		super(command, icon, id);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void actionPerformed(ActionEvent evt) {
        gw.collidedSpider();
    }

}
