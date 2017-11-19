package point;

import drawing.Color;
import drawing.Drawing;

import GUI.Settings;

/** defined by x,y. a Point is the fundamental class of all the shapes; shape is
 * combined from a vector of Point
 * 
 * @author arfed */
public class Point extends Drawing {
	double x, y;

	public Point() {
		this(Settings.CENTER, Settings.WHITE);
	}

	public Point(Point p, Color fill) {
		this(p.x, p.y, fill);
	}

	public Point(double x2, double y2, Color fill) {
		this.x = x2 - Settings.CENTER.getx( );
		this.y = y2 - Settings.CENTER.gety( );

		if(isfillable = (fill != null)) {
			fgcolor = fill;
		}
	}

	/* getters and setters */
	public double getx() {
		return x;
	}

	public void setx(int x) {
		this.x = x;
	}

	public double gety() {
		return y;
	}

	public void sety(int y) {
		this.y = y;
	}
}
