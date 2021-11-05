package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class ScoreView extends Container implements Observer {
	private Label timeNumber;
	private Label lifeNumber;
	private Label flagNumber;
	private Label foodNumber;
	private Label healthNumber;
	private Label soundSetting;
	private GameWorld score;
	
	public ScoreView() {
		
		this.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		/****************TIME****************/
		Label time = new Label("Time:");
		time.getAllStyles().setPadding(LEFT, 28);
		time.getAllStyles().setFgColor(ColorUtil.BLUE);
		this.add(time);
		
		timeNumber = new Label(" 0 ");
		timeNumber.getAllStyles().setPadding(RIGHT, 2);
		timeNumber.getAllStyles().setFgColor(ColorUtil.BLUE);
		this.add(timeNumber);
		
		/************LIVES LEFT**************/
		Label lives = new Label("Lives Left:");
		lives.getAllStyles().setPadding(LEFT, 2);
		lives.getAllStyles().setFgColor(ColorUtil.BLUE);
		this.add(lives);
		
		lifeNumber = new Label(" 0 ");
		lifeNumber.getAllStyles().setPadding(RIGHT, 2);
		lifeNumber.getAllStyles().setFgColor(ColorUtil.BLUE);
		this.add(lifeNumber);
		
		/************LAST FLAG REACHED**************/
		Label flag = new Label("Last Flag Reached:");
		flag.getAllStyles().setPadding(LEFT, 2);
		flag.getAllStyles().setFgColor(ColorUtil.BLUE);
		this.add(flag);
		
		flagNumber = new Label(" 0 ");
		flagNumber.getAllStyles().setPadding(RIGHT, 2);
		flagNumber.getAllStyles().setFgColor(ColorUtil.BLUE);
		this.add(flagNumber);
		
		/************FOOD LEVEL**************/
		Label food = new Label("Food Level:");
		food.getAllStyles().setPadding(LEFT, 2);
		food.getAllStyles().setFgColor(ColorUtil.BLUE);
		this.add(food);
		
		
		foodNumber = new Label(" 0   ");
		foodNumber.getAllStyles().setPadding(RIGHT, 2);
		foodNumber.getAllStyles().setFgColor(ColorUtil.BLUE);
		this.add(foodNumber);
		foodNumber.getAllStyles().setPadding(LEFT, 2);
		
		/************HEALTH LEVEL**************/
		Label health = new Label("Health Level:");
		health.getAllStyles().setPadding(LEFT, 2);
		health.getAllStyles().setFgColor(ColorUtil.BLUE);
		this.add(health);
		
		healthNumber = new Label(" 0 ");
		healthNumber.getAllStyles().setPadding(RIGHT, 2);
		healthNumber.getAllStyles().setFgColor(ColorUtil.BLUE);
		this.add(healthNumber);
		
		/****************SOUND*****************/
		Label sound = new Label("Sound:");
		sound.getAllStyles().setPadding(LEFT, 2);
		sound.getAllStyles().setFgColor(ColorUtil.BLUE);
		this.add(sound);
		
		soundSetting = new Label("OFF");
		soundSetting.getAllStyles().setPadding(RIGHT, 2);
		soundSetting.getAllStyles().setFgColor(ColorUtil.BLUE);
		this.add(soundSetting);
		
		
	}
	
	@Override
	public void update (Observable o, Object arg) {
		//add clock to ms
		score = (GameWorld)o;
		this.timeNumber.setText("" + score.viewTime()+" ");
		this.lifeNumber.setText("" + score.viewLives()+" ");
		this.flagNumber.setText("" + score.viewLastFlag());
		this.foodNumber.setText("" + (int) score.viewFoodLevel()+" ");
		this.healthNumber.setText("" + score.viewHealthLevel());
		
		if (score.viewSoundSetting()) {
			this.soundSetting.setText("ON");
		} else {
			this.soundSetting.setText("OFF");
			this.repaint();
		} 
		
	}

}
