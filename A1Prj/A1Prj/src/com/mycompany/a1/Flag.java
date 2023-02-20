/**
 * Flags are checkpoints the Ant must progressively hit in order to win the game.
 */
package com.mycompany.a1;

import java.util.ArrayList;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
/**
 * @author mchristiansen
 *
 */
public class Flag extends Fixed{

	/**
	 * Flags have a number that represents their position in the sequence.
	 */
	private int sequenceNumber;
	private ArrayList<Integer> seqNums = new ArrayList();
	private int maxSeqNum;
	
	public Flag(int size, Point location, int color, int sqNum) {
		// TODO Auto-generated constructor stub
		super(size, location, color);
		this.sequenceNumber = sqNum;
		this.seqNums.add(sqNum);
	}
	
	public void setColor() {
	}
	
	public int getColor() {
		return super.getColor();
	}
	
	
	public void setSize() {
	}
	
	public int getSize() {
		return super.getSize();
	}
	
	public void setLocation() {
	}
	
	public Point getLocation() {
		return super.getLocation();
	}
	
	public void addToTheWorldVector(GameObject obj) {
		super.addToTheWorldVector(obj);
	}
	
	public ArrayList<GameObject> getTheWorldVector() {
		return super.getTheWorldVector();
	}
	
	public void setSequenceNumber(int seqNum) {
		this.sequenceNumber = seqNum;
	}
	
	public int getSequenceNumber() {
		return this.sequenceNumber;
	}
	
	public ArrayList<Integer> getSequenceNumbers() {
		return this.seqNums;
	}
	
	public void setMaxSequenceNumber(ArrayList<Integer> seqNums) {
		this.maxSeqNum = this.seqNums.get(this.seqNums.size()-1);
	}
	
	public int getMaxSequenceNumber() {
		return maxSeqNum;
	}
	
	public String toString() {
		return ("Flag: loc=" + this.getLocation().getX() + "," + this.getLocation().getY() + " color=" + "[" + ColorUtil.red(this.getColor()) + "," + 
				ColorUtil.green(this.getColor()) + "," + ColorUtil.blue(this.getColor()) + "] " + " size=" + 
				this.getSize() + " seqNum=" + this.getSequenceNumber());
	}
	
	
}
