/**
 * Allows multiple of the same Item to easily be held
 * @author Jaycob Reitz
 */

public class ItemStack {
    private Item item;
    private int quantity;

    /**
     * Creates a stack of the same item
     * @param item the item type
     * @param quantity the amount of that item
     */
    public ItemStack(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Gets the Item type of the stack
     * @return
     */
    public Item getItem() {
        return item;
    }

    /**
     * Gets the quantity of the item in the stack
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Adds item/items to the stack
     * @param amount
     */
    public void add(int amount) {
        quantity += amount;
    }

    /**
     * Removes item/items from the stack
     * @param amount
     */
    public void remove(int amount) {
        quantity -= amount;
    }

    /**
     * Checks if the Stack is currently empty
     * @return boolean true if empty
     */
    public boolean isEmpty() {
        return quantity <= 0;
    }
}