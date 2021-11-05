package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Font;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Flag extends Fixed{

	//flag fixed attributes
	//sequence number
	//way point(location)
	//fixed color
	//fixed size
	private int sequenceNumber;

	
	public Flag(float x, float y, int sequenceNumber) {
		//super(ColorUtil.rgb(0,0,255));
		super(x, y);
		this.setColor(ColorUtil.rgb(104, 190, 227));
		super.setSize(100);
		this.setSequenceNumber(sequenceNumber);
		this.setLocation(x, y);
		
	}
	
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	@Override
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		float px = pPtrRelPrnt.getX();
		float py = pPtrRelPrnt.getY();
		
		float xLoc = pCmpRelPrnt.getX();
		float yLoc = pCmpRelPrnt.getY();
		
		if ((px >= xLoc - this.getSize()/2) && (px <= xLoc + this.getSize()/2) && (py >= yLoc - this.getSize()/2) && (py <= yLoc + this.getSize()/2)) {
			return true;
		} else {
			return false;
		}
	}

	//Note: To draw a unfilled and filled triangle you can use drawPolygon()/fillPolygon()
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
		
		Font font = g.getFont();
		//int sizeCalibrate = this.getSize() * 6;

		int xPoints[] = {xTop, xBottomLeft, xBottomRight};
		int yPoints[] = {yTop, yBottomLeft, yBottomRight};
		int nPoints = 3;
		
		int stringX = font.stringWidth("" + this.getSequenceNumber());
		int stringY = font.getHeight();
		g.setColor(this.getColor());
		
		if (this.isSelected()) {
			g.drawPolygon(xPoints, yPoints, nPoints);

		} else {
			g.fillPolygon(xPoints, yPoints, nPoints);

		}
		
		font = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_LARGE);
		g.setFont(font);
		g.setColor(ColorUtil.BLACK);
		g.drawString("" + this.getSequenceNumber(),xLoc + (this.getSize()/2 - stringX/2) - 5 , yLoc + (this.getSize()/2 - stringY/2) - 5);
	}

	@Override
	public boolean collidesWith(GameObject otherObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void handleCollision(GameObject otherObject) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		//String parentDesc = super.toString();
		String flagDesc = "Flag:" +
				" loc=" + Math.round(this.getX() * 10.0)/10.0+ "," + Math.round(this.getY() * 10.0)/10.0 + 
				" color=" + "[" + ColorUtil.red(this.getColor()) + "," + 
									ColorUtil.green(this.getColor()) + ","+ 
									ColorUtil.blue(this.getColor()) + "]" +
				" seqNum=" + this.getSequenceNumber();
		
		return flagDesc;
	}


}
