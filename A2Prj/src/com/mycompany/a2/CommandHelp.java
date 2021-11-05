package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class CommandHelp extends Command{

	public CommandHelp() {
		super("Help");
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		Command cOk = new Command("Ok");
		String commandHelp = "KeyBoard Controls\n"
				+ "a = Accelerate\n"
				+ "b = Brake\n"
				+ "l = Left Turn\n"
				+ "r = Right Turn\n"
				+ "f = Collide with Food Station\n"
				+ "g = Collide with Spider\n"
				+ "t = tick";
		
		Dialog.show("Help", commandHelp, cOk);
	}
}
