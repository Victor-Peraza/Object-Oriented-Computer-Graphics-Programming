package com.mycompany.a1;
import java.util.Random;
import java.util.Vector;

import com.codename1.charts.util.ColorUtil;

public class GameWorld {
	
	private Vector<GameObject> objects;
	private Random randomAxis;
	private float x;
	private float y;
	private int ticks;
	private Ant ant;


	
	public GameWorld() {
		this.objects = new Vector<GameObject>();
		this.ticks = 0;

	}

	
	   public void init(){
		   
		 //code here to create the
		 //initial game objects/setup
		   Flag flag1 = new Flag(200, 200, 1);
		   Flag flag2 = new Flag(200, 800, 2);
		   Flag flag3 = new Flag(700, 800, 3);
		   Flag flag4 = new Flag(900, 400, 4);
		   /*
		   Flag flag5 = new Flag(300, 300, 5);
		   Flag flag6 = new Flag(350, 850, 6);
		   Flag flag7 = new Flag(400, 875, 7);
		   Flag flag8 = new Flag(750, 900, 8);
		   Flag flag9 = new Flag(950, 950, 9);*/
		   
		   //Ant ant = new Ant();
		   ant = new Ant();
		   ant.setLocation(flag1.getX(),flag1.getY());
		
		   
		   randomAxis = new Random();

		   
		   Spider spider1 = new Spider(x, y);
		   Spider spider2 = new Spider(x, y);
		   
		   FoodStation station1 = new FoodStation(x, y);
		   FoodStation station2 = new FoodStation(x, y);
		   
		   objects.add(flag1);
		   objects.add(flag2);
		   objects.add(flag3);
		   objects.add(flag4);
		   /*
		   objects.add(flag5);
		   objects.add(flag6);
		   objects.add(flag7);
		   objects.add(flag8);
		   objects.add(flag9); */
		   //objects.add(ant);
		   
		   objects.add(ant);
		   
		   
		   objects.add(spider1);
		   objects.add(spider2);
		   
		   objects.add(station1);
		   objects.add(station2);
		   
		   
		 } 
	   
	   //re-initialize world.
	   public void reInit() {
		  // ticks++;
		   if (ant.getLives() != 0) {
		   Flag flag1 = new Flag(200, 200, 1);
		   ant.setLocation(flag1.getX(),flag1.getY());
		   ant.setHealthLevel(10);
		   }
		   //objects.
		   for (int i = 0; i < objects.size(); i++) {
			   if (objects.elementAt(i) instanceof Spider) {
				   Spider spiders = (Spider) objects.elementAt(i);
				   objects.remove(spiders);
				   Spider spawnSpider = new Spider(x,y);
				   objects.add(spawnSpider);
			   }
			   
			   if (objects.elementAt(i) instanceof FoodStation) {
				   FoodStation stations = (FoodStation) objects.elementAt(i);
				   objects.remove(stations);
				   FoodStation spawnStations = new FoodStation(x,y);
				   objects.add(spawnStations);
				   
			   }
		   }
		   
	   }

	   

		    // additional methods here to
		    // manipulate world objects and
		    // related game state data


	 //ant accelerates.
	   public void accelerate() {
		   for (int i = 0; i < objects.size(); i++) {
			   if (objects.elementAt(i) instanceof Ant) {
				  ((Ant) objects.elementAt(i)).incSpeed();
				  }
			   }
		   }
	   
	 //ant brakes or decelerates.
	   public void brake() {
		   for (int i = 0; i < objects.size(); i++) {
			   if (objects.elementAt(i) instanceof Ant) {
				   ((Ant) objects.elementAt(i)).decSpeed();
				   System.out.println("Braking.");
			   }
		   }
	   }
	   
	 //turn ant 5 degrees right.
	   public void right() {		  
		   for (int i = 0; i < objects.size(); i++) {
			   if (objects.elementAt(i) instanceof Ant) {
				   ((Ant) objects.elementAt(i)).steerRight();
				   System.out.println("Turning Right.");
				   }
			   }
		   }
	   
	 //turn ant 5 degrees left.
	   public void left() {
		   for (int i = 0; i < objects.size(); i++) {
			   if (objects.elementAt(i) instanceof Ant) {
				   ((Ant) objects.elementAt(i)).steerLeft();
				   System.out.println("Turning Left.");
				   }
			   }
		   }
	   
	 //Ant flag collisions (PRETEND).
	   public void lastFlagReached(int sequenceNumber) {
		   for (int i = 0; i < objects.size(); i++) {
			   if (objects.elementAt(i) instanceof Ant) {
				   int flagCount = ((Ant) objects.elementAt(i)).getRecentFlag();
				   flagCount+=1;
				   if (flagCount == sequenceNumber) {
					   ((Ant) objects.elementAt(i)).setRecentFlag(sequenceNumber);
				   }
			   } 
		   } 
	   } 
	   
	   //food station-ant collisions
	   public void food() {
		   int capacity = 0;
		    for(int i = 0; i < objects.size(); i++) {
		        if(objects.elementAt(i) instanceof FoodStation) {
		        	if (((FoodStation) objects.elementAt(i)).getCapacity() != 0) { //make all station cap instances down to 0 if it's not.
		            FoodStation station = (FoodStation)objects.elementAt(i);
		            capacity = station.getCapacity();
		            station.setColor(ColorUtil.rgb(158, 255, 187));//"dim to light green."
		            station.setCapacity(0);
		            station.setSize(0);
		            break;
		        	}
		        }
		    }
		    
		    for (int i = 0; i < objects.size(); i++) {
		        if (objects.elementAt(i) instanceof Ant) {
		            Ant ant = (Ant) objects.elementAt(i);
		            if (ant.getFoodLevel() != 0) {
		            ant.setFoodLevel(ant.getFoodLevel() + capacity);
		            } else {
		            	ant.antDies();
		            }
		        }
		    }
	   }
	   
	   //spider-ant collisions
	   public void gotten() {
		   for (int i = 0; i < objects.size(); i++) {
			   if (objects.elementAt(i) instanceof Spider) {
				   Spider spiders = (Spider) objects.elementAt(i);

					  //remove colliding spider, then spawn a new one.
					  objects.removeElement(spiders);
					  x = randomAxis.nextFloat() * spiders.getWidth();
					  y = randomAxis.nextFloat() * spiders.getHeight();
					  Spider spawnSpider = new Spider(x,y);
					  objects.add(spawnSpider);	  
			   }
		   }
		   
		   //Ant may dim, decrease speed, lose lives, and die.
		   for (int i = 0; i < objects.size(); i++) {
			   if (objects.elementAt(i) instanceof Ant) {
				   Ant ant = (Ant) objects.elementAt(i);
				   if (ant.getHealthLevel() > 0) {
				   ant.setHealthLevel(ant.getHealthLevel() -1);
					  int dim = 0;
					  dim+=20;
					  ant.setColor(ColorUtil.rgb(250,dim,dim));
					  ant.decSpeed();
				   } else if (ant.antDies()) {

					  reInit();
					  reInit();
				   } 
			   }
		   }
	   }
	   
	   public void ticked() {
		   ticks++;
		   //Ant Ticks.
		   for (int i = 0; i < objects.size(); i++) {
			   if (objects.elementAt(i) instanceof Ant) {
				   Ant ant = ((Ant) objects.elementAt(i));
				   ant.move();
				   if (ant.getFoodLevel() != 0) { //|| ((Ant) objects.elementAt(i)).getHealthLevel() != 0 ) {
					   ant.setHeading(ant.getHeading());
					   ant.antEatsFood();					   
				   } else if (ant.antDies()){
					   reInit();
					   reInit();
					   System.out.println("One Life Lost.");
					   System.out.println("World Reset.");   
				   } 
				   
				   if (ant.getRecentFlag() == 4) {
					   System.out.println("Game over, you win! Total time: " + ticks);
					   System.exit(0);
					   
				   } 
				   
			   }
		   }
		   
		   //Spider Ticks.
		   for (int i = 0; i < objects.size(); i++) {
			   if (objects.elementAt(i) instanceof Spider) {
				   ((Spider) objects.elementAt(i)).spiderMovements();
				   ((Spider) objects.elementAt(i)).move();
				   
			   }
		   }
		   
		   
	   }
	   
	   public void display() {
		   for (int i = 0; i < objects.size(); i++) {
			   if (objects.get(i) instanceof Ant) {
				   System.out.println("GAME STATE");
				   System.out.println("Lives: " + ((Ant) objects.elementAt(i)).getLives());
				   System.out.println("Health Level: " + ((Ant) objects.elementAt(i)).getHealthLevel());
				   System.out.println("Flags Captured: " + ((Ant) objects.elementAt(i)).getRecentFlag());
				   System.out.println("Food Level: "  + ((Ant) objects.elementAt(i)).getFoodLevel());
				   System.out.println("Current Clock Time: " + ticks);
			   }
		   } 
	   }
	   
	   public void map() {
		   for (int i = 0; i < objects.size(); i++) {
			   System.out.println(objects.elementAt(i));
		   }
	   }
	   
	   public void exit() {
		   System.out.println("Exit Game? Press y(yes) or n(no).");
	   }
	   
	   public void yes() {
		System.exit(0);
		   
	   }
	   
	   public void no() {
		   System.out.println("Canceled Exit.");
	   }
}
