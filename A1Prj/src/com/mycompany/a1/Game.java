package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;


public class Game extends Form{
	private GameWorld gw;
	
	public Game() {
		gw = new GameWorld(); 
		gw.init();
		play();
		}
	
	private void play() {
		
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		
		myTextField.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				if (sCommand.length() != (0))
					
					switch (sCommand.charAt(0)) {
					
					//ant accelerates.
					case 'a':
						gw.accelerate();
			   			break;	
			   			
			   		//ant brakes or decelerates.
					case 'b':
						gw.brake();
						break;
						
					//turn ant 5 degrees left.
					case 'l':
						gw.left();
						break;
						
					//turn ant 5 degrees right.
					case 'r':
						gw.right();
						break;
						
					//Ant flag collisions  1-9 (PRETEND). 4 Flags for now.
					case '1':
						gw.lastFlagReached(1);
						break;
					case '2':
						gw.lastFlagReached(2);
						break;
					case '3':
						gw.lastFlagReached(3);
						break;
					case '4':
						gw.lastFlagReached(4);
						break;
					/*case '5':
						gw.lastFlagReached(5);
						break;
					case '6':
						gw.lastFlagReached(6);
						break;
					case '7':
						gw.lastFlagReached(7);
						break;
					case '8':
						gw.lastFlagReached(8);
						break;
					case '9':
						gw.lastFlagReached(9);
						break; */
						
					//ant-food collision (PRETEND).
					case 'f':
						gw.food();
						break;
					
					//spider-ant collision location (PRETEND).
					case 'g':
						gw.gotten();
						break;
					
					//game clock tick.
					case 't':
						gw.ticked();
						break; 
						
					//display game values.
					case 'd':
						gw.display();
						break;
						
					//show map.
					case 'm':
						gw.map();
						break;
						
					//exit/terminate.
					case 'x':
						gw.exit();
						break;
					
					//confirm exit (yes).
					case 'y':
						gw.yes();
						break;
					
					//cancel exit (no).
					case 'n':
						gw.no();
						break;  
			   			}
				}
			}
		);
		}
	}