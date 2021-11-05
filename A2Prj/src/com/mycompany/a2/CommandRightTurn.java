package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandRightTurn extends Command{
	private GameWorld rightCommand;
	
	public CommandRightTurn(GameWorld rightCommand) {
		super("Right");
		this.rightCommand = rightCommand;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		rightCommand.right();
	}
}
