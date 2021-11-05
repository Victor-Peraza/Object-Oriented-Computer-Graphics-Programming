package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandCollideSpider extends Command {
	private GameWorld spiderCommand;
	
	public CommandCollideSpider(GameWorld spiderCommand) {
		super("Collide with Spider");
		this.spiderCommand = spiderCommand;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		spiderCommand.gotten();
	}

}
