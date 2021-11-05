package com.mycompany.a3;
import java.util.*;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Spider extends Movable{
	private int maxSpiderSize;
	private int minSpiderSize;
	private int maxSpiderSpeed;
	private int minSpiderSpeed;
	Random randomSpiderNum = new Random();

	//speed 5-10
	public Spider(float x, float y) {
		super(ColorUtil.rgb(0,0,0));
		this.setMaxSpiderSize(200);
		this.setMinSpiderSize(100);
		this.setMaxSpiderSpeed(15);
		this.setMinSpiderSpeed(8);
		super.setHeading(randomSpiderNum.nextInt(360));

		x = randomSpiderNum.nextFloat() * 1000;
		y = randomSpiderNum.nextFloat() * 1000;
		this.setLocation(x, y);
		super.setSize(randomSpiderNum.nextInt((getMaxSpiderSize() - getMinSpiderSize()) + getMinSpiderSize()));
		super.setSpeed(randomSpiderNum.nextInt((getMaxSpiderSpeed() - getMinSpiderSpeed()) + getMinSpiderSpeed()));
		//this.setSpeed(0);
	}
	public void spiderMovements() {
		int turn = randomSpiderNum.nextInt(11) - 5;
		if ((this.getX() >= 1000 && this.getX() <= 0) && (this.getY() >= 1000 && this.getY() <= 0)) {
			this.setHeading(this.getHeading() + turn);
			
		 } else {
			 //Spider reached world border so turn around.
			 this.setHeading(this.getHeading() + turn);
		 }
		this.setLocation(getX() , getY());
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
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// TODO Auto-generated method stub
		int xLoc = (int) (pCmpRelPrnt.getX() + this.getX() - (this.getSize()/2)+5);
		int yLoc = (int) (pCmpRelPrnt.getY() + this.getY() - (this.getSize()/2)-5);
		
		//Top of triangle.
		int xTop = (int) (pCmpRelPrnt.getX() + this.getX());
		int yTop = (int) (pCmpRelPrnt.getY() + (this.getY() + (this.getSize()/2)));
		
		//Bottom left of triangle.
		int xBottomLeft = (int) (pCmpRelPrnt.getX() + (this.getX() - (this.getSize()/2)));
		int yBottomLeft = (int) (pCmpRelPrnt.getY() + (this.getY() - (this.getSize()/2)));
		
		//Bottom right of triangle.
		int xBottomRight = (int) (pCmpRelPrnt.getX() + (this.getX() + (this.getSize()/2)));
		int yBottomRight = (int) (pCmpRelPrnt.getY() + (this.getY() - (this.getSize()/2)));

		int xPoints[] = {xTop, xBottomLeft, xBottomRight};
		int yPoints[] = {yTop, yBottomLeft, yBottomRight};
		int nPoints = 3;

		g.setColor(this.getColor());
		g.drawPolygon(xPoints, yPoints, nPoints);

		
	}

	@Override
	public void handleCollision(GameObject otherObject) {
		// TODO Auto-generated method stub

		
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
