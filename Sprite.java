import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Creates an object that is an image
 * @author Owen Edmundson
 */
public class Sprite extends Object implements ImageObserver{
	private Image image;
	
	/**
	 * creates a sprite with specified image and dimensions
	 * @param url the url of the image
	 * @param dimensions integer array of the dimensions
	 */
	public Sprite(String url, int[] dimensions) {
		super(dimensions);
		BufferedImage file = null;
		try {
			file = ImageIO.read(new File(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = file.getScaledInstance(dimensions[2], dimensions[3], 0);
	}
	
	/**
	 * creates a sprite with specified image and dimensions
	 * @param url the url of the image
	 * @param dimensions double array of the dimensions
	 */
	public Sprite(String url, double[] dimensions) {
		super(dimensions);
		BufferedImage file = null;
		try {
			file = ImageIO.read(new File(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = file.getScaledInstance((int) dimensions[2], (int)dimensions[3], 0);
	}

	/**
	 * Overrides the draw function of object to draw an image
	 * @param g the place that the shape is drawn
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(this.image, this.getX(), this.getY(), this);
	}
	
	/**
	 * Method that is required for drawing an image to work
	 */
	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		return false;
	}
}