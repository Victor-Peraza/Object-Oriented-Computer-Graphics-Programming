package com.mycompany.a3;
import java.util.Random;
import java.util.Observable;

import com.codename1.charts.util.ColorUtil;

import com.mycompany.a3.FoodStation;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.IIterator;

public class GameWorld extends Observable{
	
	private GameObjectCollection objects;
	private Random randomAxis;
	private float x;
	private float y;
	private int ticks;
	private AntSingleton ant;
	private boolean soundIs;
	private static int mapWidth = 1000;
	private static int mapHeight = 1000;
	//private boolean location;
	private boolean pause;
	private boolean position;


	
	public GameWorld() {
		this.objects = new GameObjectCollection();
		this.ticks = 0;
		this.soundIs = true;//sound is on
		//this.location = false;
		this.pause = false;
		this.position = false;
		//this.setMapWidth(1000);
		//this.setMapHeight(1000);

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
		   //ant = new Ant();
		   ant = AntSingleton.getAnt();
		   ant.setLocation(flag1.getX(),flag1.getY());
		
		   FoodStation station1 = new FoodStation(x, y);
		   FoodStation station2 = new FoodStation(x, y);
		   
		   randomAxis = new Random();

		   x = randomAxis.nextFloat() * 1000;
		   y = randomAxis.nextFloat() * 1000;
		   Spider spider1 = new Spider(x, y);
		   Spider spider2 = new Spider(x, y);
		   
		   
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
		   this.setChanged();
		   this.notifyObservers();
		  
		 } 
	   
	   //re-initialize world.
	   public void reInit() {
		  // ticks++;
		   if (ant.getLives() != 0) {
		   Flag flag1 = new Flag(200, 200, 1);
		   ant.setLocation(flag1.getX(),flag1.getY());
		   ant.setHealthLevel(10);
		   ant.setFoodLevel(20);
		   }
		   //objects.
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
			   if (getNext instanceof Spider) {
				   Spider spiders = (Spider) getNext;
				   iteratorObject.remove(spiders);
				   Spider spawnSpider = new Spider(x,y);
				   objects.add(spawnSpider);
			   }
			   
			   if (getNext instanceof FoodStation) {
				   FoodStation stations = (FoodStation) getNext;
				   iteratorObject.remove(stations);
				   FoodStation spawnStations = new FoodStation(x,y);
				   objects.add(spawnStations);
				   
			   }
		   }//while ends
		   this.setChanged();
		   this.notifyObservers();
		   
	   }
	   
	   public GameObjectCollection gameWorldIterator() {
		   return objects;
	   }
	   
	   
	   public void setMapWidth(int mapWidth) {
		   GameWorld.mapWidth = mapWidth;
		   }
	   
	   public static int getMapWidth() {
		   return mapWidth;
		   }
	   
	   public void setMapHeight(int mapHeight) {
			GameWorld.mapHeight = mapHeight;
			}
	   
	   public static int getMapHeight() {
		   return mapHeight;
		   }
	   
	   

		    // additional methods here to
		    // manipulate world objects and
		    // related game state data


	 //ant accelerates.
	   public void accelerate() {
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
			   if (getNext instanceof AntSingleton) {
				  ((AntSingleton) getNext).incSpeed();
				  System.out.println("Test");
				  }
			   }

		   }
	   
	 //ant brakes or decelerates.
	   public void brake() {
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
			   if (getNext instanceof AntSingleton) {
				   ((AntSingleton) getNext).decSpeed();
				   System.out.println("Braking.");
			   }
		   }
		   this.setChanged();
		   this.notifyObservers();
	   }
	   
	 //turn ant 5 degrees right.
	   public void right() {
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
			   if (getNext instanceof AntSingleton) {
				   ((AntSingleton) getNext).steerRight();
				   System.out.println("Turning Right.");
				   }
			   }
		   this.setChanged();
		   this.notifyObservers();
		   }
	   
	 //turn ant 5 degrees left.
	   public void left() {
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
			   if (getNext instanceof AntSingleton) {
				   ((AntSingleton) getNext).steerLeft();
				   System.out.println("Turning Left.");
				   }
			   }
		   this.setChanged();
		   this.notifyObservers();
		   }
	   
	 //Ant flag collisions (PRETEND).
	   public void lastFlagReached(int sequenceNumber) {
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
			   if (getNext instanceof AntSingleton) {
				   int flagCount = ((AntSingleton) getNext).getRecentFlag();
				   flagCount+=1;
				   if (flagCount == sequenceNumber) {
					   ((AntSingleton) getNext).setRecentFlag(sequenceNumber);
				   }
			   } 
		   }
		   setChanged();
		   notifyObservers();

		   
	   } 
	   
	   //food station-ant collisions
	   public void food(FoodStation food, Ant ant) {
		   int capacity = 0;
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
		        if(getNext instanceof FoodStation) {
		        	if (((FoodStation)getNext).getCapacity() != 0) { //make all station cap instances down to 0 if it's not.
		            FoodStation station = (FoodStation)getNext;
		            capacity = station.getCapacity();
		            station.setColor(ColorUtil.rgb(158, 255, 187));//"dim to light green."
		            station.setCapacity(0);
		            station.setSize(0);
		            break;
		        	}
		        }
		   }
		   setChanged();
		   notifyObservers();
		   }
	   
	   //spider-ant collisions
	   public void gotten() {
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
			   if (getNext instanceof Spider) {
				   Spider spiders = (Spider) getNext;

					  //remove colliding spider, then spawn a new one.
					  iteratorObject.remove(spiders);
					  x = randomAxis.nextFloat() * getMapWidth();
					  y = randomAxis.nextFloat() * getMapHeight();
					  Spider spawnSpider = new Spider(x,y);
					  objects.add(spawnSpider);	  
			   }
		   }
		   
		   IIterator iteratorObject2 = objects.getIterator();
		   //Ant may dim, decrease speed, lose lives, and die.
		   while (iteratorObject2.hasNext()) {
			   GameObject getNext = iteratorObject2.getNext();
			   if (getNext instanceof AntSingleton) {
				   AntSingleton ant = (AntSingleton) getNext;
				   if (ant.getHealthLevel() > 0) {
				   ant.setHealthLevel(ant.getHealthLevel() -1);
					  int dim = 0;
					  dim+=20;
					  ant.setColor(ColorUtil.rgb(250,dim,dim));
					  ant.decSpeed();
					  return;
				   } else if (ant.antDies()) {

					  reInit();
					  reInit();
					  return;
				   } 
			   }
		   }
		   
		   this.setChanged();
		   this.notifyObservers();
	   }
	   
	   //remove correlation tickrate/refreshrate from foodscoms and time
	   public void ticked(int time) {
		 ticks += time;
	
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
			   if (getNext instanceof AntSingleton) {
				   //Ant ant = ((Ant) iteratorObject.getNext());
				   AntSingleton ant =  (AntSingleton) getNext;
				   ((Movable) ant).move();
				   if ( ( (AntSingleton) ant).getFoodLevel() >= 0) { //|| ((Ant) objects.elementAt(i)).getHealthLevel() != 0 ) {
					   ((Movable) ant).setHeading(((Movable) ant).getHeading());
					   ((AntSingleton) ant).antEatsFood();					   
				   } else if (((AntSingleton) ant).antDies()){
					   reInit();
					   reInit();
					   reInit();
					   System.out.println("One Life Lost.");
					   System.out.println("World Reset.");   
				   } 
				   
				   if (((AntSingleton) ant).getRecentFlag() == 4) {
					   System.out.println("Game over, you win! Total time: " + ticks);
					   System.exit(0);
					   
				   } 
				   
			   }
		   }
		   
		   //Spider Ticks.
		   IIterator iteratorObject2 = objects.getIterator();
		   while (iteratorObject2.hasNext()) {
			   GameObject getNext = iteratorObject2.getNext();
			   if (getNext instanceof Spider) {
				   ((Spider) getNext).spiderMovements();
				   ((Spider) getNext).move();
				   
			   }
		   }
		   
		   this.setChanged();
		   this.notifyObservers();
		   
		   
	   }
	   
	   public void soundSwitch(boolean gameSound) {
		   this.soundIs = gameSound;
		   this.setChanged();
		   this.notifyObservers();
	   }
	    
	   /********SCOREVIEW ACCESSS**********/
	   public int viewTime() {
		   return ticks/1000;///10000
	   }
	   
	   public int viewLives() {
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
			   if (getNext instanceof AntSingleton) {
				   return ((AntSingleton) getNext).getLives();  
			   }
		   }
		return 0;
	   }
	   
	   public int viewLastFlag() {
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
			   if (getNext instanceof AntSingleton) {
				   return ((AntSingleton) getNext).getRecentFlag();
			   }
		   }
		return 0;
	   }
	   
	   public double viewFoodLevel() {
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
			   if (getNext instanceof AntSingleton) {
				   return ((AntSingleton) getNext).getFoodLevel();
				   
			   }
		   }
		   return 0;
	   }
	   
	   public int viewHealthLevel() {
		   IIterator iteratorObject = objects.getIterator();
		   while (iteratorObject.hasNext()) {
			   GameObject getNext = iteratorObject.getNext();
			   if (getNext instanceof AntSingleton) {
				   return ((AntSingleton) getNext).getHealthLevel();
				   
			   }
		   }
		   return 0;
	   }
	   
	   public boolean viewSoundSetting() {
		   return soundIs;
	   }
	   
	   public void setPause(boolean pauseState) {
		   this.pause = pauseState;
	   }
	   
	   public boolean isPaused() {
		   return pause;
	   }
	   
	   public void positionSwitch(boolean gamePosition) {
		   this.position = gamePosition;
	   }
	   public boolean getPositionSwitch() {
		   return position;
	   }
   	   
	   
}
