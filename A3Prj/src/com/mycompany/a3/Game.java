package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Toolbar;


public class Game extends Form implements Runnable{
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;

	private Container leftContainer;
	private Container rightContainer;
	private Container bottomContainer;
	
	private CommandAbout about;
	private CommandAccelerate accelerate;
	private CommandBrake brake;
	private CommandExit exit;
	private CommandHelp help;
	private CommandLeftTurn left;
	private CommandRightTurn right;
	private CommandSound sound;
	private CommandPause pause;
	private CommandPosition position;
	
	private Button accelerateButton;
	private Button brakeButton;
	private Button leftButton;
	private Button rightButton;
	private Button pauseButton;
	private Button positionButton;

	private int timerTickRate;
	private UITimer timer;
	

	
	//Note: create a single instance of each command object.  
	public Game() {
		//GUI
		gw = new GameWorld();
		timer = new UITimer(this);
		mv = new MapView(gw, this);
		sv = new ScoreView();
		

		gw.addObserver(mv);
		gw.addObserver(sv);
		
		leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		rightContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		bottomContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
		
		about = new CommandAbout();
		accelerate = new CommandAccelerate(gw);
		brake = new CommandBrake(gw);
		exit = new CommandExit();
		help = new CommandHelp();
		left = new CommandLeftTurn(gw);
		right = new CommandRightTurn(gw);
		sound = new CommandSound(gw);
		pause = new CommandPause(gw, this);
		position = new CommandPosition(gw);
		
		accelerateButton = new Button(accelerate);
		brakeButton = new Button(brake);
		leftButton = new Button(left);
		rightButton = new Button(right);
		pauseButton = new Button(pause);
		positionButton = new Button(position);
		
		screenLayout();
		
		//gw.init();
		
		//query mapview's width and height
		//gw.setMapWidth(mv.getWidth());
		//gw.setMapHeight(mv.getHeight());
		gw.setMapWidth(1000);
		gw.setMapHeight(1000);
		
		this.show();
		gw.init();
		
		timerTickRate = 20;
		timer.schedule(timerTickRate, true, this);
		
		
		}
	
	
	
	// on-screen buttons, key bindings, side menu items(toolbar,checkbox) & (refer to table)
	private void screenLayout() {
		
		/****************BODY******************/
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, mv);
		add(BorderLayout.NORTH , sv);
		leftContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		add(BorderLayout.WEST, leftContainer);
		rightContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		add(BorderLayout.EAST, rightContainer);
		bottomContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		add(BorderLayout.SOUTH, bottomContainer);
		
		/****************ACCELERATE BUTTON******************/
		leftContainer.getAllStyles().setPadding(Component.TOP, 90);
		accelerateButton.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		accelerateButton.getUnselectedStyle().setBgTransparency(255);
		accelerateButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		accelerateButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		accelerateButton.getAllStyles().setPadding(Component.TOP, 5);
		accelerateButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		leftContainer.add(accelerateButton);
		
		
		/****************LEFT BUTTON******************/
		leftButton.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		leftButton.getUnselectedStyle().setBgTransparency(255);
		leftButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		leftButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		leftButton.getAllStyles().setPadding(Component.TOP, 5);
		leftButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		leftContainer.add(leftButton);
		
		/****************BRAKE BUTTON******************/
		rightContainer.getAllStyles().setPadding(Component.TOP, 90);
		brakeButton.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		brakeButton.getUnselectedStyle().setBgTransparency(255);
		brakeButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		brakeButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		brakeButton.getAllStyles().setPadding(Component.TOP, 5);
		brakeButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		rightContainer.add(brakeButton);

		/****************RIGHT BUTTON******************/
		rightButton.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		rightButton.getUnselectedStyle().setBgTransparency(255);
		rightButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		rightButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		rightButton.getAllStyles().setPadding(Component.TOP, 5);
		rightButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		rightContainer.add(rightButton);
		
			
		/****************POSITION BUTTON******************/
		bottomContainer.getAllStyles().setPadding(Component.LEFT, 800);
		positionButton.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		positionButton.getUnselectedStyle().setBgTransparency(255);
		positionButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		positionButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		positionButton.getAllStyles().setPadding(Component.RIGHT, 2);
		positionButton.getAllStyles().setPadding(Component.LEFT, 2);
		positionButton.getAllStyles().setPadding(Component.TOP, 5);
		positionButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		positionButton.setEnabled(false);
		bottomContainer.add(positionButton);
		
		
		/****************PAUSE BUTTON******************/
		pauseButton.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		pauseButton.getUnselectedStyle().setBgTransparency(255);
		pauseButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		pauseButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		bottomContainer.add(pauseButton);
		
		
		/****************KEY BINDINGS******************/
		addKeyListener('a', accelerate);
		addKeyListener('b', brake);
		addKeyListener('l', left);
		addKeyListener('r', right);

		
		/****************SIDE MENU******************/
		Toolbar toolbar = new Toolbar();
		setToolbar(toolbar);
		toolbar.setTitle("The Path Game");
		toolbar.addCommandToSideMenu(accelerate);
		toolbar.addCommandToSideMenu(about);
		toolbar.addCommandToSideMenu(exit);
		
		CheckBox soundBox = new CheckBox();
		soundBox.setCommand(sound);
		soundBox.setSelected(gw.viewSoundSetting());
		soundBox.getAllStyles().setFgColor(ColorUtil.WHITE);
		toolbar.addComponentToSideMenu(soundBox);
		
		toolbar.addCommandToRightBar(help);
		
	}
	
	//If Paused
	//Disable buttons, keys, and menu.
	public void pressPause() {
		accelerateButton.setEnabled(false);
		brakeButton.setEnabled(false);
		leftButton.setEnabled(false);
		rightButton.setEnabled(false);
		positionButton.setEnabled(true);
		pauseButton.setText("Play");
		
		removeKeyListener('a', accelerate);
		removeKeyListener('b', brake);
		removeKeyListener('l', left);
		removeKeyListener('r', right);
		
		accelerate.setEnabled(false);
		brake.setEnabled(false);
		left.setEnabled(false);
		right.setEnabled(false);
		sound.setEnabled(false);
		gw.soundSwitch(false);
		position.setEnabled(true);
		gw.setPause(true);
		
		timer.cancel();
		
	}
	
	public void pressPlay() {
		accelerateButton.setEnabled(true);
		brakeButton.setEnabled(true);
		leftButton.setEnabled(true);
		rightButton.setEnabled(true);
		positionButton.setEnabled(false);
		pauseButton.setText("Pause");
		
		addKeyListener('a', accelerate);
		addKeyListener('b', brake);
		addKeyListener('l', left);
		addKeyListener('r', right);
		
		accelerate.setEnabled(true);
		brake.setEnabled(true);
		left.setEnabled(true);
		right.setEnabled(true);
		sound.setEnabled(true);
		gw.soundSwitch(true);
		gw.setPause(false);
		position.setEnabled(false);
		
		timer.schedule(timerTickRate, true, this);
		
	}



	@Override
	public void run() {
		gw.ticked(timerTickRate);
	
		
		
	}
}