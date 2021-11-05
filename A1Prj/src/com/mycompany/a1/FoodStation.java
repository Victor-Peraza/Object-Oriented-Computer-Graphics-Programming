package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
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
		this.setColor(ColorUtil.rgb(0,255,0));
		this.setMaxStationSize(50);
		this.setMinStationSize(10);
		super.setSize(randomFoodAtt.nextInt((getMaxStationSize() - getMinStationSize())+ getMinStationSize()));
		this.setCapacity(this.getSize());
		x = randomFoodAtt.nextFloat() * 1000;
		y = randomFoodAtt.nextFloat() * 1000;
		this.setLocation(x, y);
		
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
