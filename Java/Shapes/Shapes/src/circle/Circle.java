package circle;

import GUI.SDL_GUI;
import point.Point;
import shape.Shape;

public class Circle extends Shape {
	@SuppressWarnings("unused")
	private double radius;
	@SuppressWarnings("unused")
	private Point center;
	
	
	@Override
	protected int[][] renderPlot(Point center, Point points[][]) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void renderOnScreen() {
		/* this calls the renderPlot */
	new SDL_GUI().plot(points);
	}

	public Circle() {
		
	}
}
