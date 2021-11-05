package com.mycompany.a3;

public class AntSingleton extends Ant{
	private static AntSingleton ant;
	
	private AntSingleton() {
		
	}
	
	public static AntSingleton getAnt() {
		if (ant == null)
			ant = new AntSingleton();
		return ant;
			
	}
}
