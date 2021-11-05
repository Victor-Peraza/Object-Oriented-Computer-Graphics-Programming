package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandAccelerate extends Command{
	private GameWorld accelCommand;
	
	public CommandAccelerate(GameWorld accelCommand) {
		super("Accelerate");
		this.accelCommand = accelCommand;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Working");
		accelCommand.accelerate();
		System.out.println("Working");
	}

}
