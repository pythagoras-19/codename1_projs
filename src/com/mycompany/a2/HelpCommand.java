package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command {
	private GameWorld gw;
	public HelpCommand(String command, GameWorld gameWorld) {
		super(command);
		this.gw = gameWorld;
		// TODO Auto-generated constructor stub
	}

	public HelpCommand(String command, Image icon) {
		super(command, icon);
		// TODO Auto-generated constructor stub
	}

	public HelpCommand(String command, int id) {
		super(command, id);
		// TODO Auto-generated constructor stub
	}

	public HelpCommand(String command, Image icon, int id) {
		super(command, icon, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		Dialog.show("Help", "You can use a, b, l, r, t, g, f" ,"Ok", null);
	}
}
