package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	private GameWorld map ;
	private static float mapX;
	private static float mapY;
	
	public MapView(GameWorld map, Game game) {
		this.map = map;
		Container center = new Container();
		center.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(255,0,0)));
		this.setLayout(new BorderLayout());
		add(BorderLayout.CENTER,center);
	
		this.setWidth(this.getLayoutWidth());
		MapView.setMapX(this.getHeight());
		MapView.setMapY(this.getWidth());

	
		//this.setMapX(center.getY());
	}
	
	//call gameworld method that outputs gameobject info
	//text output to console for now.
	
	public static void setMapX(float mapX) {
		MapView.mapX = mapX;
	}
	
	public static float getMapX() {
		return mapX;
	}
	
	public static void setMapY(float mapY) {
		MapView.mapY = mapY;
	}
	
	public static float getMapY() {
		return mapY;
	}
	
	@Override
	public void update (Observable o, Object arg) {
		map = (GameWorld) o;
		repaint();
		
	}
	//iterate gameobjects invoking draw() in each object
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		IIterator iterator = map.gameWorldIterator().getIterator();
		Point pCmpRelPrnt = new Point(getX(), getY());
		
		while (iterator.hasNext()) {
			GameObject getNext = iterator.getNext();
			//System.out.println(iterator.getNext());
			if (getNext instanceof IDrawable) {
				((IDrawable) getNext).draw(g, pCmpRelPrnt);
			}
		}
	}
	
	//save the pointer pressed location
	//return components relative to the screen origin(parent container's origin)
	
	@Override
	public void pointerPressed(int x, int y) {
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		
		//pointer position relative to the parent origin
		Point pPtrRelPrnt = new Point(x, y);
		//component position relative to the parent origin
		Point pCmpRelPrnt = new Point(getX(), getY());
		
		IIterator iterator = map.gameWorldIterator().getIterator();
		while (iterator.hasNext()) {
			GameObject object = iterator.getNext();
			if (object instanceof ISelectable) {
				ISelectable select = (ISelectable) object;
				if (select.contains(pPtrRelPrnt, pCmpRelPrnt)) {
					select.setSelected(true);
				} else {
					select.setSelected(false);
				}
			}
		}
		repaint();
	}
	
	
}
