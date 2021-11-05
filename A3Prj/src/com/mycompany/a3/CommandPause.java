package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandPause extends Command{
	private GameWorld pauseCommand;
	private Game gamePause;
	
	public CommandPause(GameWorld pauseCommand, Game gamePause) {
		super("Pause");
		this.pauseCommand = pauseCommand;
		this.gamePause = gamePause;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (!pauseCommand.isPaused()) {
			gamePause.pressPause();
			
		} else {
			gamePause.pressPlay();
			
		}
	}

}
