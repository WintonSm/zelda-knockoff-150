import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Creates panels that go on the frame
 * @author Owen Edmundson
 */
public class DrawingPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ArrayList<Object> objects;
	private int panelWidth;
	private int panelHeight;
	
	/**
	 * Creates a panel of specified dimensions
	 * @param dimensions integer array of dimensions
	 */
    public DrawingPanel(int[] dimensions) {
    	this.objects = new ArrayList<Object>();
        this.panelWidth = dimensions[2];
        this.panelHeight = dimensions[3];
        this.setPreferredSize(new Dimension(dimensions[2], dimensions[3]));
        this.setBounds(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
        this.setLayout(null);
    }
    
    /**
     * Draws all of the objects and components on the panel
     * @param g the place to draw the components
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object object : this.objects) {
        	object.draw(g);
        }
    }
    
    /**
     * gets the objects in the panel
     * @return ArrayList of objects 
     */
    public ArrayList<Object> getObjects() {
    	return this.objects;
    }
    
    /**
     * adds an object to the ArrayList of objects
     * @param object the object to add
     */
    public void addObject(Object object) {
    	this.objects.add(object);
    }
    
    /**
     * removes all of the sprites from the ArrayList of Ojects
     * used for removing the directions from the maze panel
     */
    public void removeDirections() {
        objects.removeIf(object -> object instanceof Sprite);
    }
    
    /**
     * Scales the dimensions of an object to fit on this panel
     * @param x the percentage across the width of the panel of the x position
     * @param y the percentage across the height of the panel of the y position
     * @param width the percentage across the width of the panel of the width
     * @param height the percentage across the height of the panel of the height
     * @return integer array of the dimensions
     */
    public int[] scale(double x, double y, double width, double height) {
		return new int[] {(int) (this.panelWidth * x), (int) (this.panelHeight * y), (int) (this.panelWidth * width), (int) (this.panelHeight * height)};
	}
}