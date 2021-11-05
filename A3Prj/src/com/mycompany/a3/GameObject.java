package com.mycompany.a3;

import java.util.Random;
import java.util.Vector;

import com.codename1.charts.models.Point;


public abstract class GameObject implements IDrawable, ICollider{
	protected Point location;
	private int size; //note: all size objects are integers
	private int myColor;
	private Vector<GameObject> obj;
	private GameWorld gameWorld;

	
	
	public GameObject(float x, float y) {
		this.location = new Point(x,y);
	}
	public GameObject(int size, int myColor) {
		this.size = size;
		this.myColor = myColor;
		obj = new Vector<GameObject>();
		
	}
	@Override
	public boolean collidesWith(GameObject otherObject) {
		float rad = this.getSize()/2;
		float objRad = otherObject.getSize()/2;
		
		float leftOne = this.getX() - rad;
		float leftTwo = otherObject.getX() - objRad;
		
		float rightOne = this.getX() + rad;
		float rightTwo = otherObject.getX() + objRad;
		
		float topOne = this.getY() - rad;
		float topTwo = otherObject.getY() - objRad;
		
		float botOne = this.getY() + rad;
		float botTwo = otherObject.getY() + objRad;
		
		if ( (rightOne < leftTwo|| leftOne > rightTwo) || (botOne < topTwo || topOne > botTwo)) {
			if (obj.contains(otherObject)) {
				obj.remove(otherObject);
			}
			
			return false;
		} else {
			obj.add(otherObject);
			otherObject.obj.add(this);
			return true;
		}
		
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
	
	public Point getLocation() {
		return this.location;
	}
	
	public void setColor(int myColor) {
		this.myColor = myColor;
	}
	
	public int getColor() {
		return myColor;
	}
	
	
	public void collider(GameObject gameObj) {
		this.obj.add(gameObj);
	}
	
	public GameWorld getGameWorld() {
		return gameWorld;
	}
	

	


}
