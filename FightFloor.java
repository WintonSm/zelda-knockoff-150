import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FightFloor extends Object {

	public FightFloor(int[] dimensions) {
		super(dimensions);
	}
	
	public FightFloor(double[] dimensions) {
		super(dimensions);
	}
	
	@Override
	public void draw(Graphics g) {
		BufferedImage floor = null;
		try {
			floor = ImageIO.read(new File("new-sprites/Level Elements/Floor-Texture1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(floor, this.getX(), this.getY(), this.getWidth(), this.getWidth(), null);
	}
}
