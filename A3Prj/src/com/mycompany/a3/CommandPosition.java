package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandPosition extends Command{
	private GameWorld positionCommand;
	
	public CommandPosition(GameWorld positionCommand) {
		super("Position");
		this.positionCommand= positionCommand;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (positionCommand.isPaused()) {
			positionCommand.positionSwitch(false);
			
		}
	}

}
