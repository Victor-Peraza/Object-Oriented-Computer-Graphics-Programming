package com.mycompany.a1;

import com.codename1.charts.models.Point;

public abstract class GameObject {
	//randomize locations.
	private Point location;
	private int size; //note: all size objects are integers
	private int myColor;
	
	public GameObject(float x, float y) {
		this.location = new Point(x,y);
	}
	public GameObject(int size, int myColor) {
		this.size = size;
		this.myColor = myColor;
		
	}

	public void setX(float x) {
		this.location.setX(x);
	}
	
	public float getX() {
		return this.location.getX();
	}
	
	public void setY(float y) {
		location.setY(y);
	}
	
	public float getY() {
		return location.getY();
	}
	
	public void setSize(int size) {
		this.size = size;
		
	}
	
	public int getSize() {
		return size;
	}
	public void setLocation(float x, float y) {
		this.location = new Point(x,y);
	}
	
	public void setColor(int myColor) {
		this.myColor = myColor;
	}
	
	public int getColor() {
		return myColor;
	}

}
