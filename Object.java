import java.awt.Graphics;

/**
 * Abstract class providing a framework for objects on the screens
 * @author Owen Edmundson
 */
abstract class Object {
	private int x;
	private int y;
	private int width;
	private int height;
	
	/**
	 * Creates an object with specified dimensions
	 * @param dimensions integer array of dimensions
	 */
	public Object(int[] dimensions) {
		this.x = dimensions[0];
		this.y = dimensions[1];
		this.width = dimensions[2];
		this.height = dimensions[3];
	}
	
	/**
	 * Creates an object with specified dimensions
	 * @param dimensions double array of dimensions
	 */
	public Object(double[] dimensions) {
		this.x = (int) dimensions[0];
		this.y = (int) dimensions[1];
		this.width = (int) dimensions[2];
		this.height = (int) dimensions[3];
	}

	/**
	 * gets the x position of the object
	 * @return int x
	 */
	int getX() {
		return x;
	}
	
	/**
	 * gets the y position of the object
	 * @return int y
	 */
	int getY() {
		return y;
	}
	
	/**
	 * gets the width of the object
	 * @return int width
	 */
	int getWidth() {
		return this.width;
	}

	/**
	 * gets the height of the object
	 * @return int height
	 */
	int getHeight() {
		return this.height;
	}
	
	/**
	 * Makes subclasses require a draw method
	 * @param g the place to draw the object
	 */
	abstract void draw(Graphics g);
}