package com.mycompany.a1;
import java.util.*;

import com.codename1.charts.util.ColorUtil;

public class Spider extends Movable{
	private int maxSpiderSize;
	private int minSpiderSize;
	private int maxSpiderSpeed;
	private int minSpiderSpeed;
	private Random randomSpiderNum = new Random();

	//speed 5-10
	public Spider(float x, float y) {
		super(ColorUtil.rgb(0,0,0));
		this.setMaxSpiderSize(50);
		this.setMinSpiderSize(10);
		this.setMaxSpiderSpeed(10);
		this.setMinSpiderSpeed(5);
		this.setHeading(randomSpiderNum.nextInt(360));
		this.setHeight(1000);
		this.setWidth(1000);
		x = randomSpiderNum.nextFloat() * this.getWidth();
		y = randomSpiderNum.nextFloat() * this.getHeight();
		this.setLocation(x, y);
		super.setSize(randomSpiderNum.nextInt((getMaxSpiderSize() - getMinSpiderSize()) + getMinSpiderSize()));
		super.setSpeed(randomSpiderNum.nextInt((getMaxSpiderSpeed() - getMinSpiderSpeed()) + getMinSpiderSpeed()));
	}
	public void spiderMovements() {

		int turn = randomSpiderNum.nextInt(11) - 5;
		if ((this.getX() < this.getWidth() && this.getX() > 0) && (this.getY() < this.getHeight() && this.getY() > 0)) {
			this.setHeading(this.getHeading() + turn);
		 } else {
			 //Spider reached world border so turn around.
			 this.setHeading(this.getHeading() + 180);
		 }

	}
	
	
	public void setMaxSpiderSize(int max) {
		this.maxSpiderSize = max;
	}
	
	public int getMaxSpiderSize() {
		return maxSpiderSize;
	}
	
	public void setMinSpiderSize(int min) {
		this.minSpiderSize = min;
	}
	
	public int getMinSpiderSize() {
		return minSpiderSize;
	}
	
	public void setMaxSpiderSpeed(int maxSpiderSpeed) {
		this.maxSpiderSpeed = maxSpiderSpeed;
	}
	
	public int getMaxSpiderSpeed() {
		return maxSpiderSpeed;
	}
	
	public void setMinSpiderSpeed(int minSpiderSpeed) {
		this.minSpiderSpeed = minSpiderSpeed;
	}
	
	public int getMinSpiderSpeed() {
		return minSpiderSpeed;
	}
	
	@Override 
	public String toString() {
		String spiderDesc = "Spider: " + 
				" loc=" + Math.round(this.getX() * 10.0)/10.0+ "," + Math.round(this.getY() * 10.0)/10.0 + 
				" color= " + "[" + ColorUtil.red(this.getColor()) + "," + 
								   ColorUtil.green(this.getColor()) + ","+ 
								   ColorUtil.blue(this.getColor()) + "]" +
				" heading=" + this.getHeading() + 
				" speed=" + this.getSpeed() +
				" size=" + this.getSize();
		
		return spiderDesc;	
	}
}
