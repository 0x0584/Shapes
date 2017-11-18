package shape;

import point.Point;
import drawing.Drawing;

/** the second fundamental block which is the Shape class, the responsible for
 * any interaction with the GUI
 * 
 * @author Anas Rchid */
abstract public class Shape extends Drawing {
	protected Point points[][];

	/** window's texture pixels as array of int[][]
	 *
	 * @author Anas Rchid (0x0584)
	 * @version 0.0.1
	 * @since the beginning
	 *
	 * @return int[][] of pixels */
	protected abstract int[][] renderPlot(Point center, Point points[][]);
	
	/** output the rendered texture to the screen using the C program.
	 * it prints using points: int points[][]
	 *
	 * @author Anas Rchid (0x0584)
	 * @version 0.0.1
	 * @since the beginning */
	protected abstract void renderOnScreen();

}
