package GUI;

import drawing.Color;

import point.Point;

public class Settings {
	public Settings() {
		this.width = WIDTH;
		this.height = HEIGHT;
		this.center = CENTER;
	}

	public Settings(int width, int height) {
		center = getCenter(this.width = width, this.height = height);
	}

	private static Point getCenter(int width, int height) {
		return new Point((width / 2), (height / 2), BLACK);
	}

	/* shared constants */
	public final static int WIDTH = 640, HEIGHT = 480;
	public final static Point CENTER = getCenter(WIDTH, HEIGHT);
	public final static Color BLACK = new Color(0xFF, 0xFF, 0xFF);
	public final static Color WHITE = new Color(0x00, 0x00, 0x00);

	private Color fgcolor, bgcolor, fillcolor;
	private int width, height;
	Point center;
	
		/* getters and setters */
	public Color getFgcolor() {
		return fgcolor;
	}

	public void setFgcolor(Color fgcolor) {
		this.fgcolor = fgcolor;
	}

	public Color getBgcolor() {
		return bgcolor;
	}

	public void setBgcolor(Color bgcolor) {
		this.bgcolor = bgcolor;
	}

	public Color getFillcolor() {
		return fillcolor;
	}

	public void setFillcolor(Color fillcolor) {
		this.fillcolor = fillcolor;
	}
	
	public Point getCenter() {
		return center;
	}

	public int getScreenWidth() {
		return width;
	}

	public int getScreenHeight() {
		return height;
	}
}
