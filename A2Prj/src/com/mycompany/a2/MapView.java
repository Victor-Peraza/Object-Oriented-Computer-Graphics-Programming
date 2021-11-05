package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	private GameWorld map;
	
	public MapView() {
		Container center = new Container();
		center.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(255,0,0)));
		this.setLayout(new BorderLayout());
		add(BorderLayout.CENTER, center);
	}
	
	//call gameworld method that outputs gameobject info
	//text output to console for now.
	@Override
	public void update (Observable o, Object arg) {
		map = (GameWorld) o;
		IIterator iterator = map.gameWorldIterator().getIterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.getNext());
		}
		
		
	}
}
