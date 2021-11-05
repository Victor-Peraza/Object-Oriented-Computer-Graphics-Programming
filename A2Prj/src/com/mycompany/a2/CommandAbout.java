package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class CommandAbout extends Command {
	public CommandAbout() {
		super("About");
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {

		Dialog.show("About", "The Path Game\n Victor Peraza\n CSC 133\n Assignment 2", "Ok", null);
	}

}
