package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandCollideFoodStation extends Command{
	private GameWorld foodCommand;
	
	public CommandCollideFoodStation(GameWorld foodCommand) {
		super("Collide with Food Stations");
		this.foodCommand = foodCommand;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		foodCommand.food();
	}

}
