package test;

public class EuclideanDist implements DistCalculator {

	private static int invoks=0;
	
	public static int getInvokes() {return invoks;}
	
	@Override
	public double distance(Point p1, Point p2) {
		double X=(p1.getX() - p2.getX())*(p1.getX() - p2.getX());
		double Y=(p1.getY() - p2.getY())*(p1.getY() - p2.getY());
		double Z=(p1.getZ() - p2.getZ())*(p1.getZ() - p2.getZ());
		++invoks;
		return Math.sqrt(X+Y+Z);
	}
}
