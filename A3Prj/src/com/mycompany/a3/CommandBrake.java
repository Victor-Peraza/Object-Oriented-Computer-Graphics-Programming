package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandBrake extends Command {
	private GameWorld brakeCommand;

	
	public CommandBrake(GameWorld brakeCommand) {
		super("Brake");
		this.brakeCommand = brakeCommand;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		brakeCommand.brake();
	}

}
