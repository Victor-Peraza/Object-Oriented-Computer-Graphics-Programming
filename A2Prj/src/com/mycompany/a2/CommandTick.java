package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandTick extends Command{
	private GameWorld tickCommand;
	
	public CommandTick(GameWorld tickCommand) {
		super("Tick");
		this.tickCommand = tickCommand;
		
	}
	
	@Override
	public void actionPerformed (ActionEvent ev) {
		tickCommand.ticked();
	}

}
