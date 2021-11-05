package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

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
		this.setColor(ColorUtil.rgb(0,0,255));
		super.setSize(10);
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
