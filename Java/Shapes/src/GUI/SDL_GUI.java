package GUI;

import point.Point;

/** The GUI layer is basically a call of native C function via the shared
 * library sdlgui.so this plots the shape on a SDL window (based on c
 * function written already)
 * 
 * @author Anas Rchid (0x0584)
 * @version 0.0.1
 * @since the beginning */
public class SDL_GUI {
	/* c function */
	private native void __plot(int argc, String argv);

	/* TODO: finish this
	 * shared library, in this case it's the C program */
	static {
		System.loadLibrary("sdlgui");
	}

	public SDL_GUI() {
		this(new Settings( ));
	}

	public SDL_GUI(Settings settings) {
		this.settings = settings;
	}

	/* this is fucking */
	public static void main(String args[]) {
		new SDL_GUI( ).plot(new Point[2][5]);
	}

	public void plot(Point points[][]) {
		final int height = settings.getScreenHeight( );
		final int width = settings.getScreenWidth( );
		final int size = height * width;

		int pixels[] = new int[size];
		int argc = 0;

		String args = "-w 640 -h 480 -bg 000000 -fg FFFFFF ";
		argc = 8; /* this is ^{count} */

		/* initialize background */
		for(int i = 0; i < size; ++argc, ++i) {
			pixels[i] = Integer.parseInt(settings.getBgcolor( ).hexa, 16);
		}

		/* TODO: after parsing the settings, discover how to parse those
		 * pacifications for each point:
		 * 
		 * + is it isfillable (is so the mention fillcolor `-f FCFCFC`)
		 * 
		 * NOTE: the array trick ((j * height) + width) is a way to get index of
		 * 2d array in 1d array */
		for(int j = 0; j < width; ++j) {
			for(int i = 0; i < height; i++) {
				pixels[(j * height) + width] = Integer.parseInt(points[j][i]
						.getSettings( ).getFgcolor( ).hexa, 16);
			}
		}

		for(int i = 0; i < size; ++i) {
			args += " " + pixels[i];
		}

		__plot(argc, args);
	}

	Settings settings;
}
