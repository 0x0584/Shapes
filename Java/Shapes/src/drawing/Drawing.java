package drawing;

import GUI.Settings;

/** Drawing this is like the Object class for anything that would be plotted on
 * the screen
 * 
 * @author Anas Rchid
 * @version 0.0.1
 * @since the beginning */
public class Drawing {
	/* shared attributes */
	protected Color fgcolor, bgcolor, fillcolor;
	protected boolean isfillable;

	/* constant members */
	protected final Settings settings = new Settings( );
	protected final static double precision = 1e-4;

	/** if `show` is false, then the Drawing is hidden
	 *
	 * @author Anas Rchid (0x0584)
	 * @version 0.0.1
	 * @since the beginning
	 * @param show
	 *            boolean value to tell that the drawing is filled or not filled
	 * 
	 * @return true if the drawing is visible. */
	public boolean isHiden(boolean show) {
		return this.isfillable = show;
	}

	/* getters and setters */
	public boolean isFillable() {
		return isfillable;
	}

	public void setFillable(boolean isfillable) {
		this.isfillable = isfillable;
	}

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

	public Settings getSettings() {
		return settings;
	}
}
