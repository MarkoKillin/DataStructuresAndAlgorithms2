
public class Point2d {
	double x,y;

	public Point2d(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public boolean coincident(Point2d p) {
		return this.x == p.x && this.y == p.y;
	}
	
	public double distance(Point2d p) {
		double dx = this.x - p.x;
		double dy = this.y - p.y;
		dx = dx*dx;
		dy = dy*dy;
		return Math.sqrt(dx + dy);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
