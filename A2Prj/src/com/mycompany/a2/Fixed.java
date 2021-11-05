package com.mycompany.a2;

import com.codename1.charts.models.Point;

public abstract class Fixed extends GameObject {


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
	}


	
	
}
