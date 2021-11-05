package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Ant extends Movable implements ISteerable{	

	//Ant exclusive attributes.
	private int maxSpeed;
	private double foodLevel;
	private double foodConsumptionRate;
	private int healthLevel;
	private int recentFlag;
	private int currMaxSpeed;
	private int lives;

	
	public Ant() {
		super(ColorUtil.rgb(255,0,0));
		super.setSize(40);
		this.setSpeed(0);
		this.setHeading(0);
		this.setMaxSpeed(50);
		this.setFoodLevel(30);
		this.setFoodConsumptionRate(0.02);
		this.setHealthLevel(10);
	    this.setRecentFlag(1);//ant is currently on flag 1.
		this.currMaxSpeed = getMaxSpeed() * (getHealthLevel()/10);
		this.setLives(3);
		
		
	}
	//0 & 360=north
	//90 = east
	//180=south
	//270=west
	
	@Override
	public void steerRight() {
		//Full 360.
		//if (this.getHeading() < 360) {
			int antHeadingRight = this.getHeading();
			this.setHeading(antHeadingRight += 30);
			
		//} else {
		//	this.setHeading(0);
		///}
	}
	
	@Override
	public void steerLeft() {
		//Full 360.
	//	if (this.getHeading() > 0) {
		int antHeadingLeft = this.getHeading();
		this.setHeading(antHeadingLeft -= 30);
		
	//	} else {
			//this.setHeading(360);
		//}
	}

	public void incSpeed() {
		int loseLifeNoFood = this.getLives();
		//current speed that's going to increase.
		int currSpeedInc = this.getSpeed();
		if (currMaxSpeed > currSpeedInc && getLives() != 0) {
			this.setSpeed(currSpeedInc += 5);
			System.out.println("Accelerating.");
			
		} else if (getFoodLevel() <=0 && loseLifeNoFood > 0 && getSpeed() >= 0) {
			this.setSpeed(0);
			loseLifeNoFood--;
			System.out.print("No Food. One Life Lost.");
				
			//if ant loses health, the speed will re-calibrate.
		} else if (currSpeedInc > currMaxSpeed) {
			this.setSpeed(currMaxSpeed);
			
		} else if (currSpeedInc == currMaxSpeed) {
			System.out.println("Speed Limit Reached.");
			
			
		}
	}
	//
	public void decSpeed() {
		//current speed that's going to decrease.
		int currSpeedDec = this.getSpeed(); 
		int loseLifeNoFood = this.getLives();
		if (currSpeedDec > 0) {
			this.setSpeed(currSpeedDec -= 5);
			
			//if ant food level equals zero, it loses a life and it stops.
		/*} else if (getFoodLevel() <= 0 && loseLifeNoFood > 0) {
			this.setSpeed(0);
			loseLifeNoFood--;
			System.out.print("No Food. One Life Lost.");*/
			
			//if ant loses health, the speed will re-calibrate.
		} else if (currSpeedDec > currMaxSpeed) { 
			this.setSpeed(currMaxSpeed);
			
		} else {
			this.setSpeed(0);
			System.out.println("You Stopped. Speed at 0");
			return;
		}
	}
	
	
	public boolean antDies() {//call this in init
		if (this.getLives() == 0) {
			this.setSpeed(0);
			System.out.println("Game over, You failed!");
			System.exit(0);
			return true;
			
			//If ant has less than 1 life, exit game if true
		} else if (this.getHealthLevel() == 0 && this.getLives() > 0 && this.getFoodLevel() == 0) {
			this.setLives(this.getLives() - 1);
			this.setHealthLevel(10);
			return true;
			
		} else if (this.getFoodLevel() <= 0) {
			this.setFoodLevel(0);
			if (this.getFoodLevel() == 0) {
			this.setSpeed(0);
			//this.setFoodLevel(10);
			this.setLives(this.getLives() - 1);
			return true;
			}
			
		}
		return false;
	}
	
	
	
	public void antEatsFood() {
		if (this.getFoodLevel() >= 0) {
		this.setFoodLevel(this.getFoodLevel() - (this.getFoodConsumptionRate()));
		} else if (this.getFoodLevel() == 0) {
			this.setLives(this.getLives() - 1);
		}
	}

	public void setRecentFlag(int recentFlag) {
		this.recentFlag = recentFlag;
	}
	
	public int getRecentFlag() {
		return recentFlag;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setHealthLevel(int healthLevel) {
		this.healthLevel = healthLevel;
	}
	
	public int getHealthLevel() {
		return this.healthLevel;
	}
	
	public void setFoodLevel(double d) {
		this.foodLevel = d;
	}
	
	public double getFoodLevel() {
		return foodLevel;
	}
	
	public void setFoodConsumptionRate(double d) {
		this.foodConsumptionRate = d;
	}
	
	public double getFoodConsumptionRate() {
		return foodConsumptionRate;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public int getLives() {
		return lives;
	}
	
	//Draw Ant in map view.
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		int xLoc = (int) (pCmpRelPrnt.getX() + this.getX() - (this.getSize()/2));
		int yLoc = (int) (pCmpRelPrnt.getY() + this.getY() - (this.getSize()/2));
		
		g.setColor(this.getColor());
		g.fillArc(xLoc, yLoc, 2 * this.getSize(), 2 * this.getSize(), 0, 360);
		
		
	}



	@Override
	public void handleCollision(GameObject otherObject) {
		// TODO Auto-generated method stub
		
		if (otherObject instanceof Flag) {
			int sequenceNumber = ((Flag) otherObject).getSequenceNumber();
			this.getGameWorld().lastFlagReached(sequenceNumber);
		}
		if (otherObject instanceof Spider) {
			this.getGameWorld().gotten();
		}

		
	}

	
	@Override
	public String toString() {
		String antDesc = "Ant: " +
				" loc=" + Math.round(this.getX() * 10.0)/10.0+ "," + Math.round(this.getY() * 10.0)/10.0 + 
				" color=" + "[" + ColorUtil.red(this.getColor()) + "," + 
								  ColorUtil.green(this.getColor()) + ","+ 
								  ColorUtil.blue(this.getColor()) + "]" +
				" heading=" + this.getHeading() + 
				" speed=" + this.getSpeed() +
				" size=" + this.getSize() +
				" maxSpeed=" + this.getMaxSpeed() +
				" foodConsumptionRate=" + this.getFoodConsumptionRate();
		
		return antDesc;
	}


}
