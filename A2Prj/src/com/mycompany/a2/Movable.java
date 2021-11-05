package com.mycompany.a2;

import com.codename1.charts.models.*;

public abstract class Movable extends GameObject {

	//attributes
	private int heading;
	private int speed;
	
	//Game World Position Limit
	private float maxWidth;
	private float maxHeight;
	
	public Movable(float x, float y) {
		super(x, y);
		
	}
	//Ant
	public Movable(int myColor) {
		super(myColor, myColor);
		// TODO Auto-generated constructor stub
		}
	//0=north
	//90= east
	//180=south
	//270=west
	

	//implement math class
	public void move() {
			
		float radianCalc = (float) Math.toRadians(90 - this.getHeading());
		float deltaX = (float) (Math.cos(radianCalc) * this.getSpeed());
		float deltaY = (float) (Math.sin(radianCalc) * this.getSpeed());
		
		
		//newLocation(x, y) = oldLocation(x, y) + (deltaX, deltaY);
		this.setX(deltaX + this.getX());
		this.setY(deltaY + this.getY());
		
		//newLocation
		this.setLocation(getX(),getY());
		
	}
	
	public void setHeading(int heading) {
		this.heading = heading;
	}
	
	public int getHeading() {
		return heading;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
}
