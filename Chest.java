/**
 * stores chest information
 * @author Jaycob Reitz
 */
public class Chest {
	private int square;
	private Item content;
	
	public Chest(int square, Item item) {
		this.square = square;
		this.content = item;
	}
	
	/**
	 * gets the square that the chest is in
	 * @return integer location of the chest in the maze
	 */
	public int getSquare() {
		return square;
	}
	
	/**
	 * gets the thing in the chest
	 * @return the item that is in the chest
	 */
	public Item getContent() {
		return content;
	}
}
