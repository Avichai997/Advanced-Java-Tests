package test;

import java.io.Serializable;

public class Level implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Direction{up,down,left,right}
	
	public interface MovePolicy{
		boolean isLegal(char[][] data,int cx,int cy,Direction d);
	}
	
	private char[][] data;
	private int cx,cy;
	MovePolicy mp;
	
	public Level() {
		data=null;
		cx=0;cy=0;
		mp=null;
	}
	
	public void setMovePolicy(MovePolicy mp){
		this.mp=mp;
	}

	public void setData(char[][] data, int cx, int cy){
		this.data=data;
		this.cx=cx;
		this.cy=cy;
	}
	
	public void moveCharacter(Direction d){
		if(mp.isLegal(data, cx, cy, d)){
			switch(d){
			case up: cy--;break;
			case down: cy++;break;
			case left: cx--;break;
			case right: cx++;break;
			}
		}
	}

	public char[][] getData() {
		return data;
	}

	public void setData(char[][] data) {
		this.data = data;
	}

	public int getCx() {
		return cx;
	}

	public void setCx(int cx) {
		this.cx = cx;
	}

	public int getCy() {
		return cy;
	}

	public void setCy(int cy) {
		this.cy = cy;
	}

	public MovePolicy getMp() {
		return mp;
	}

	public void setMp(MovePolicy mp) {
		this.mp = mp;
	}
}
