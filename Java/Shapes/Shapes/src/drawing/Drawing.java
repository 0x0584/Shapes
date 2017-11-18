package drawing;

import GUI.Settings;

/** Drawing this is like the Object class for anything that would be plotted on
 * the screen
 * 
 * @author Anas Rchid
 * @version 0.0.1
 * @since the beginning */
abstract public class Drawing {
	protected Color fgcolor, bgcolor, fillcolor;
	protected boolean isfillable;
	protected Settings settings;

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
 
	public boolean isFillable() {
		return isfillable;
	}

	public void setFillable(boolean isfillable) {
		this.isfillable = isfillable;
	}

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

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
}
