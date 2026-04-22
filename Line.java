import java.awt.*;

/**
 * creates an object that is a line
 * @author Owen Edmundson
 */
public class Line extends Object {
	/**
	 * creates a line with specified dimensions
	 * @param dimensions integer array of dimensions
	 */
	public Line(int[] dimensions) {
		super(dimensions);
	}
	
	/**
	 * creates a line with specified dimensions
	 * @param dimensions double array of dimensions
	 */
	public Line(double[] dimensions) {
		super(dimensions);
	}
	
	/**
	 * Overrides the draw function of object to draw a line
	 * @param g the place that the shape is drawn
	 */
	@Override
	public void draw(Graphics g) {
		Image wall = Toolkit.getDefaultToolkit().getImage("new-sprites/Level Elements/Wall-overlay-texture");
        g.drawImage(wall, this.getX(), this.getY(), this.getX() + this.getWidth(), this.getY() + this.getHeight(), null);
    }
}