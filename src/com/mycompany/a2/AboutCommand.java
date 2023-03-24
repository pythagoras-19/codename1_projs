package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command {

	public AboutCommand(String command) {
		super(command);
		// TODO Auto-generated constructor stub
	}

	public AboutCommand(String command, Image icon) {
		super(command, icon);
		// TODO Auto-generated constructor stub
	}

	public AboutCommand(String command, int id) {
		super(command, id);
		// TODO Auto-generated constructor stub
	}

	public AboutCommand(String command, Image icon, int id) {
		super(command, icon, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void actionPerformed(ActionEvent evt) {
        Dialog.show("About", "Matthew Christiansen, CSC 133, V.1 of StartToFinish Game!", "Ok", null);
    }

}
