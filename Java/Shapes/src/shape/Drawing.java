package shape;

/** Drawing this is like the Object class for anything that would be plotted on
 * the screen
 * 
 * @author Anas Rchid
 * @version 0.0.1
 * @since the beginning */
public class Drawing {
	/** Color is a class that takes, at least for now, red, green, blue values
	 * and store them providing a hexadecimal address of the corresponding Color
	 * 
	 * @author Anas Rchid
	 * @version 0.0.1
	 * @since the beginning */
	public class Color {
		final Integer r, g, b;
		final String hexa;

		public Color(int red, int green, int blue) {
			r = red;
			g = green;
			b = blue;
			hexa = getHexa( );
		}

		private String getHexa() {
			return (Integer.toHexString(r) + Integer.toHexString(g) + Integer
					.toHexString(b)).toUpperCase( );
		}

		/* TODO: create getRGB(String) -> hexa */
	};

	protected Color fgcolor, bgcolor, fillcolor;
	protected boolean dofill;

	public Drawing() {
		bgcolor = fillcolor = new Color(0x00, 0x00, 0x00); /* white 0x000000 */
		fgcolor = new Color(0xFF, 0xFF, 0xFF); /* black 0xFFFFFF */
	}

	/* getters and setters */

	/** if `dofill` is false, then the Drawing is hidden
	 *
	 * @author Anas Rchid (0x0584)
	 * @version 0.0.1
	 * @since the beginning
	 * @param dofill
	 *            boolean value to tell that the drawing is filled or not filled
	 * @return =true= if the drawing is visible. */

	public boolean isHiden(boolean show) {
		return this.dofill = show;
	}
}
