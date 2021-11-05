package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class CommandCollideFlag extends Command {
	//Note: display a dialog box that allows the user to enter the number on a text field located on the dialog box.(between 1-9)
	//if user inputs an invalid value display error (try catch?)
	private GameWorld flagCommand;
	
	public CommandCollideFlag(GameWorld flagCommand) {
		super("Collide with Flag");
		this.flagCommand = flagCommand;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//convert the input into an integer and vet any number that is not 1-9.
		
		TextField enterNumber = new TextField();
		Command cEnter = new Command ("Enter");
		Command cOk = new Command ("Ok");
		Command c = Dialog.show("Enter a Flag Number:", enterNumber, cEnter);
		
		try {
		int inputToInt = Integer.parseInt(enterNumber.getText().toString());
		
		if (c == cEnter && (inputToInt <= 9 && inputToInt >= 1)) {
			flagCommand.lastFlagReached(inputToInt);
			
		} else {
			Dialog.show("Incorrect Input", "Must be a number 1 through 9", cOk);
			
		}
		} catch(NumberFormatException e) {
			Dialog.show("Incorrect Input", "Must be a number 1 through 9", cOk);
			
		
		}
	}

}
