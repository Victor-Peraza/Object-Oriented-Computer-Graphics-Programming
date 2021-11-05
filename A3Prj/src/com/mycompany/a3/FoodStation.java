package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Font;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import java.util.*;

public class FoodStation extends Fixed{

	//food station fixed attributes
	//capacity(food amount)
	//stop movement if ant has no food?
	//location 
	//color
	//size
	//randomize size
	
	//note: initial capacity is proportional to the size of the food station.
	private int capacity;
	private int maxStationSize;
	private int minStationSize;

	//private Random randomAxis = new Random();
	
	//randomize food station size.
	private Random randomFoodAtt = new Random(); 
	
	public FoodStation(float x, float y) {
		super(x, y);
		//super(ColorUtil.rgb(0,255,0));
		this.setColor(ColorUtil.rgb(113, 150, 54));
		this.setMaxStationSize(50);
		this.setMinStationSize(10);
		super.setSize(randomFoodAtt.nextInt((getMaxStationSize() - getMinStationSize())+ getMinStationSize()));
		this.setCapacity(this.getSize());
		x = randomFoodAtt.nextFloat() * 1000;
		y = randomFoodAtt.nextFloat() * 1000;
		this.setLocation(x, y);
		
	}
	
	@Override
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		int xLoc = (int) (pCmpRelPrnt.getX() + this.getX() - (this.getSize()/2));
		int yLoc = (int) (pCmpRelPrnt.getY() + this.getY() - (this.getSize()/2));
		
		Font font = g.getFont();
		int sizeCalibrate = this.getSize()*6;
		
		int stringX = font.stringWidth("" + this.getCapacity());
		int stringY = font.getHeight();
		g.setColor(this.getColor());
		if (this.isSelected()) {
			g.drawRect(xLoc, yLoc, sizeCalibrate, sizeCalibrate);
		} else {
			g.fillRect(xLoc, yLoc, sizeCalibrate, sizeCalibrate);
		}
		
		font = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE);
		g.setFont(font);
		g.setColor(ColorUtil.BLACK);
		g.drawString("" + this.getCapacity(),xLoc + (sizeCalibrate/2 - stringX/2) , yLoc + (sizeCalibrate/2 - stringY/2));

	}


	@Override
	public boolean collidesWith(GameObject otherObject) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void handleCollision(GameObject otherObject) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		float px = pPtrRelPrnt.getX();
		float py = pPtrRelPrnt.getY();
		
		float xLoc = pCmpRelPrnt.getX();
		float yLoc = pCmpRelPrnt.getY();
		
		if ((px >= xLoc - this.getSize()/2) && (px <= xLoc + this.getSize()/2) && (py >= yLoc - this.getSize()/2) && (py <= yLoc + this.getSize()/2)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public void setMaxStationSize(int max) {
		this.maxStationSize = max;
	}
	
	public int getMaxStationSize() {
		return maxStationSize;
	}
	
	public void setMinStationSize(int min) {
		this.minStationSize = min;
	}
	
	public int getMinStationSize() {
		return minStationSize;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	@Override
	public String toString() {
		String stationDesc = "Food Station: " + 
				" loc=" + Math.round(this.getX() * 10.0)/10.0+ "," + Math.round(this.getY() * 10.0)/10.0 +
				" color=" + "[" + ColorUtil.red(this.getColor()) + "," + 
							ColorUtil.green(this.getColor()) + ","+ 
							ColorUtil.blue(this.getColor()) + "]" +
				" size=" + this.getSize() +
				" capacity=" + this.getCapacity();
		
		return stationDesc;
		
		
	}

}
