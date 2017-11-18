package drawing;

/** Color is a class that takes, at least for now, red, green, blue values
 * and store them providing a hexadecimal address of the corresponding Color
 * 
 * @author Anas Rchid
 * @version 0.0.1
 * @since the beginning */
public class Color {
	public Integer r, g, b;
	public final String hexa;

	public Color(int red, int green, int blue) {
		r = red;
		g = green;
		b = blue;
		hexa = getHexa( );
	}

	public String getHexa() {
		return (Integer.toHexString(r) + Integer.toHexString(g) + Integer
				.toHexString(b)).toUpperCase( );
	}
	
	/* convert hexadecimal string to int
	 * printf("%ld\n", strtol(argv[1], NULL, 16)); */
};
