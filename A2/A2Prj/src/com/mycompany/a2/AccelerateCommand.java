package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;

public class AccelerateCommand extends Command {
	private GameWorld gw;

	public AccelerateCommand(GameWorld gw) {
		super("Accelerate");
		this.gw = gw;
		// TODO Auto-generated constructor stub
	}

	public AccelerateCommand(String command, Image icon) {
		super(command, icon);
		// TODO Auto-generated constructor stub
	}

	public AccelerateCommand(String command, int id) {
		super(command, id);
		// TODO Auto-generated constructor stub
	}

	public AccelerateCommand(String command, Image icon, int id) {
		super(command, icon, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void actionPerformed(ActionEvent evt) {
        gw.accelerate();
    }

}
