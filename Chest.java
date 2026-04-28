
public class Chest {
	
	private int square;
	private Item content;
	
	public Chest(int square, Item item) {
		this.square = square;
		this.content = item;
	}
	
	public int getSquare() {
		return square;
	}
	
	public Item getContent() {
		return content;
	}
}
