package point;

import settings.Settings;
import shape.Drawing;

/** this is teh fundamental class 
 * @author arfed
 *
 */
public class Point extends Drawing {
	private static Point center;
	int x, y;

	public Point() {
		this(center = new Point((Settings.width / 2), (Settings.height / 2)));
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	/* getters and setters */
	public int getx() {
		return x;
	}

	public void setx(int x) {
		this.x = x;
	}

	public int gety() {
		return y;
	}

	public void sety(int y) {
		this.y = y;
	}

	protected static Point getCenter() {
		return center;
	}
}
