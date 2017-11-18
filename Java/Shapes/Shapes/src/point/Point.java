package point;

import drawing.Color;
import drawing.Drawing;

import GUI.Settings;

/** defined by x,y. a Point is the fundamental class of all the shapes; shape is
 * combined from a vector of Point
 * 
 * @author arfed */
public class Point extends Drawing {
	int x, y;

	public Point() {
		this(Settings.CENTER, Settings.WHITE);
	}

	public Point(Point p, Color fill) {
		this(p.x, p.y, fill);
	}

	public Point(int x, int y, Color fill) {
		this.x = x;
		this.y = y;

		if(isfillable = (fill != null)) {
			fgcolor = fill;
		}
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
}
