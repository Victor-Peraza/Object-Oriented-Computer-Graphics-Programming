package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;

public class CommandExit extends Command {
	//Note: should  use a dialog box to prompt graphically for confirmation and then exit the program.
	
	public CommandExit() {
		super("Exit");
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		Boolean cYes = Dialog.show("Confirm Exit", "Are you sure want to exit?", "Yes", "Cancel");
		
		if (cYes) {
			Display.getInstance().exitApplication();
		}
	}
	
}
