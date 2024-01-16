package test;

import java.util.Observable;

public class LevelA extends Observable{
	
	public enum Direction{up,down,left,right}
	
	public interface MovePolicy{
		boolean isLegal(char[][] data,int cx,int cy,Direction d);
	}
	
	private char[][] data;
	private int cx,cy;
	MovePolicy mp;
	
	public void setMovePolicy(MovePolicy mp){
		this.mp=mp;
		setChanged();
		notifyObservers();
	}

	public void setData(char[][] data, int cx, int cy){
		this.data=data;
		this.cx=cx;
		this.cy=cy;
		setChanged();
		notifyObservers();
	}
	
	public void moveCharacter(Direction d){
		if(mp.isLegal(data, cx, cy, d)){
			switch(d){
			case up: cy--;break;
			case down: cy++;break;
			case left: cx--;break;
			case right: cx++;break;
			}
			setChanged();
			notifyObservers();
		}
	}
}
