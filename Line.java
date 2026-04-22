import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	 * Overrides the draw function of object to draw a line/wall.
	 * @param g the place that the shape is drawn
	 */
	@Override
	public void draw(Graphics g) {
		BufferedImage wall = null;
		BufferedImage floor = null;
		
		if (this.getHeight() < this.getWidth()) {
			try {
				wall = ImageIO.read(new File("new-sprites/Level Elements/Wall-overlay-texture.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(wall, this.getX(), this.getY(), this.getWidth(), this.getWidth(), null);
		}
		if (this.getHeight() > this.getWidth()) {
			
			try {
				wall = ImageIO.read(new File("new-sprites/Level Elements/Wall-overlay-texture2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(wall, this.getX(), this.getY(), this.getHeight(), this.getHeight(), null);
		}
        
    }
}