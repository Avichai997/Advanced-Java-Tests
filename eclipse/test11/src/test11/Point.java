package test11;

import java.io.Serializable;

public class Point implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final double x, y, z;

	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point() {
		x = 0;
		y = 0;
		z = 0;
	}


	@Override
	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
}
