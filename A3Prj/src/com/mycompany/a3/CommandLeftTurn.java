package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandLeftTurn extends Command{
	private GameWorld leftCommand;
	
	public CommandLeftTurn(GameWorld leftCommand) {
		super("Left");
		this.leftCommand = leftCommand;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		leftCommand.left();
	}
}
