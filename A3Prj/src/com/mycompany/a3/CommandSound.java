package com.mycompany.a3;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandSound extends Command{
	//Note: include a check box showing the current state of the "sound" attribute.
	private GameWorld soundCommand;
	
	public CommandSound(GameWorld soundCommand) {
		super("Sound: ON");
		this.soundCommand = soundCommand;
	}
	
	//match check box so it sets the switch status on or off
	//Note: Add Sound State in side menu 
	@Override
	public void actionPerformed(ActionEvent ev) {
		CheckBox soundBox = new CheckBox();
		soundBox = (CheckBox) ev.getComponent();
		
		if (soundBox.isSelected()) {
			soundCommand.soundSwitch(true);
			soundBox.setText("Sound: ON");
			
		} else {
			soundCommand.soundSwitch(false);
			soundBox.setText("Sound: OFF");
		}
	}
}
