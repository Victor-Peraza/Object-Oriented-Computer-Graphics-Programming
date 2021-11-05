package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form{
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;

	private Container leftContainer;
	private Container rightContainer;
	private Container bottomContainer;
	
	private CommandAbout about;
	private CommandAccelerate accelerate;
	private CommandBrake brake;
	private CommandCollideFlag flag;
	private CommandCollideFoodStation food;
	private CommandCollideSpider spider;
	private CommandExit exit;
	private CommandHelp help;
	private CommandLeftTurn left;
	private CommandRightTurn right;
	private CommandSound sound;
	private CommandTick tick;
	
	private Button accelerateButton;
	private Button brakeButton;
	private Button leftButton;
	private Button rightButton;
    private Button flagButton;
	private Button foodButton;
	private Button spiderButton;
	private Button tickButton;

	
	//Note: create a single instance of each command object.  
	public Game() {
		//GUI
		gw = new GameWorld();
		mv = new MapView();
		sv = new ScoreView();

		gw.addObserver(mv);
		gw.addObserver(sv);
		
		leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		rightContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		bottomContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
		
		about = new CommandAbout();
		accelerate = new CommandAccelerate(gw);
		brake = new CommandBrake(gw);
		flag = new CommandCollideFlag(gw);
		food = new CommandCollideFoodStation(gw);
		spider = new CommandCollideSpider(gw);
		exit = new CommandExit();
		help = new CommandHelp();
		left = new CommandLeftTurn(gw);
		right = new CommandRightTurn(gw);
		sound = new CommandSound(gw);
		tick = new CommandTick(gw);
		
		accelerateButton = new Button(accelerate);
		brakeButton = new Button(brake);
		leftButton = new Button(left);
		rightButton = new Button(right);
		flagButton = new Button(flag);
		foodButton = new Button(food);
		spiderButton = new Button(spider);
		tickButton = new Button (tick);
		
		screenLayout();
		
		gw.init();
		
		//query mapview's width and height
		gw.setMapWidth(mv.getWidth());
		gw.setMapHeight(mv.getHeight());
		
		this.show();
		
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
		
		/****************FLAG BUTTON******************/
		bottomContainer.getAllStyles().setPadding(Component.LEFT, 450);
		flagButton.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		flagButton.getUnselectedStyle().setBgTransparency(255);
		flagButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		flagButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		flagButton.getAllStyles().setPadding(Component.RIGHT, 5);
		flagButton.getAllStyles().setPadding(Component.LEFT, 5);
		flagButton.getAllStyles().setPadding(Component.TOP, 5);
		flagButton.getAllStyles().setPadding(Component.BOTTOM, 5);
		bottomContainer.add(flagButton);
		
		/****************SPIDER BUTTON******************/
		spiderButton.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		spiderButton.getUnselectedStyle().setBgTransparency(255);
		spiderButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		spiderButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		bottomContainer.add(spiderButton);
		
		/****************FOOD BUTTON******************/
		foodButton.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		foodButton.getUnselectedStyle().setBgTransparency(255);
		foodButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		foodButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		bottomContainer.add(foodButton);
		
		/****************TICK BUTTON******************/
		tickButton.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		tickButton.getUnselectedStyle().setBgTransparency(255);
		tickButton.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		tickButton.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		bottomContainer.add(tickButton);
		
		/****************KEY BINDINGS******************/
		addKeyListener('a', accelerate);
		addKeyListener('b', brake);
		addKeyListener('l', left);
		addKeyListener('r', right);
		addKeyListener('f', food);
		addKeyListener('g', spider);
		addKeyListener('t', tick);
		
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
	
}