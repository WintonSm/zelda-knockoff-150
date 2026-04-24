/**
 * The abstract class for all items
 * @author Jaycob Reitz
 */

public abstract class Item {
	protected String type;
	
	/**
	 * Gets the type of the item
	 * @return the item type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Whatever the item does when used 
	 */
	public abstract void use();
}