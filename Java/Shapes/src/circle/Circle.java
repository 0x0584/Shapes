package circle;

import GUI.SDL_GUI;
import GUI.Settings;
import point.Point;
import shape.Shape;

public class Circle extends Shape {
	private double radius;
	private Point center;

	@Override
	public void renderOnScreen() {
		/* this calls the renderPlot */
		new SDL_GUI( ).plot(points);
	}

	public Circle() {
		this(200.00, new Point( ));
	}

	public Circle(double radius, Point center) {
		int height = settings.getScreenHeight( ), width = settings
				.getScreenWidth( );
		double cy = center.gety( );
		double cx = center.getx( );

		points = new Point[height][width];

		for(int x = 0; x < points.length; x++) {
			for(int y = 0; y < points[x].length; y++) {
				points[y][x] = null;
			}
		}

		/* (x - cx)^2 - (y - cy)^2 = r^2 */

		for(double x = (cx - radius); x <= (cx + radius); x += precision) {
			double equ = Math.abs(Math.pow(radius, 2) - Math.pow(x - cx, 2));
			double y = Math.sqrt(equ);

			points[(int) (cy - Math.rint(y))][(int) Math.rint(x)] = new Point(x, y,
					Settings.BLACK);
			points[(int) (cy + Math.rint(y))][(int) Math.rint(x)] = new Point(x, y,
					Settings.BLACK);
		}

		this.radius = radius;
		this.center = center;
	}

	public double getRadius() {
		return radius;
	}

	public Point getCenter() {
		return center;
	}

//	@Override
//	protected int[][] renderPlot(Point center, Point[][] points) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
