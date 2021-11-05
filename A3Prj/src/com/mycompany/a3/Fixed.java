package com.mycompany.a3;

import com.codename1.charts.models.Point;

public abstract class Fixed extends GameObject implements ISelectable{
	private boolean isSelected;


	public Fixed(int size, int myColor) {
		super(size, myColor);
		// TODO Auto-generated constructor stub
	}

	public Fixed(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setLocation(float x, float y) {
		this.location = new Point(x,y);
		if (isSelected) {
			super.setLocation(x, y);
		}
	}

	public boolean isSelected() {
		return isSelected;
	}
	
	public void setSelected(boolean selectState) {
		this.isSelected = selectState;
	}
	
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		float px = pPtrRelPrnt.getX();
		float py = pPtrRelPrnt.getY();
		
		
		float xLoc = pCmpRelPrnt.getX();
		float yLoc = pCmpRelPrnt.getY();
		
		if ((px > xLoc - this.getSize()/2) && (px < xLoc + this.getSize()/2) && (py > yLoc - this.getSize()/2) && (py < yLoc + this.getSize()/2)) {
			return true;
		} else {
			return false;
		}
	}
	
	


	
	
}
