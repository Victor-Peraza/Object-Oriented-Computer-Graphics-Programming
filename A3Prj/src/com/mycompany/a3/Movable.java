package com.mycompany.a3;



public abstract class Movable extends GameObject {

	//attributes
	private int heading;
	private int speed;
	
	
	public Movable(float x, float y, int heading, int speed) {
		super(x, y);
		this.heading = heading;
		this.speed = speed;
		
	}
	//Ant
	public Movable(int myColor) {
		super(myColor, myColor);
	
		}
	//0=north
	//90= east
	//180=south
	//270=west
	

	//implement math class
	public void move() {
	
		float radianCalc = (float) Math.toRadians(90 - this.getHeading());
		
		//Suggestion: If it reaches border make it equal to borderline minus 1 so that it escapes 
		//and doesnt get stuck and then set heading to turn around

		//Set Boundaries for moving objects.
		if (this instanceof Spider) {
			//Right
			if (this.getX() > 1700 ) {
				this.setHeading(-135);
				
			//Left
			} else if (this.getX() < 0){
				if (this.getHeading() < 0) {
					this.setHeading(135);		
				} else {
					this.setHeading(-225);
				}	
			}
			
			
			//Top 
			if (this.getY() > 1200) {
				if (this.getHeading() <= 0) {
					this.setHeading(-135);
				} else if (this.getHeading() >= 0) {
					this.setHeading(135);
					}
				
			} else if (this.getY() < 10) {
				if (this.getHeading() <= 0) {
					this.setHeading(-35);	
				} else if (this.getHeading() >= 0) {
					this.setHeading(35);
				} 
			}
		}
		
		if (this instanceof AntSingleton) {
			//Right
			if (this.getX() > 1650) {
				//this.setHeading(270);
				AntSingleton.getAnt().setX(1650);
	
			//Left
			} else if (this.getX() < 10) {
				//this.setHeading(-270);
				AntSingleton.getAnt().setX(10);
					
			}
			
			//Top 
			if (this.getY() > 1160) {
				//this.setHeading(-180);
				AntSingleton.getAnt().setY(1160);
				
			} else if (this.getY() < 20) {
				//this.setHeading(0);
				AntSingleton.getAnt().setY(20);


				
			}
		
		}
		//float radianCalc = (float) Math.toRadians(90 - this.getHeading());
		
		float deltaX = (float) (this.getX() + (Math.cos(radianCalc) * this.getSpeed()));
		float deltaY = (float) (this.getY() + (Math.sin(radianCalc) * this.getSpeed()));


		//newLocation(x, y) = oldLocation(x, y) + (deltaX, deltaY);
		this.setX(deltaX);
		this.setY(deltaY);
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
