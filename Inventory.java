/**
 * The inventory class for the player to store items
 * @author Jaycob Reitz
 */

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<ItemStack> items;
	
	/**
	 * Creates the player's inventory
	 */
	public Inventory() {
		this.items = new ArrayList<>();
	}
	
	/**
	 * Adds item/items to the player's inventory
	 * @param item the item type for the stack
	 * @param amount the amount of the item to be added
	 */
	public void addItem(Item item, int amount) {
	    for (ItemStack stack : items) {
	        if (stack.getItem().getClass() == item.getClass()) {
	            stack.add(1);
	            return;
	        }
	    }
	    items.add(new ItemStack(item, amount));
	}
	
	/**
	 * Uses a health potion (Will Fix to become just "useItem(Item item)") 
	 */
	public void useHealthPotion() {
		if(Main.player.getHp() == Main.player.getMaxHp()) return;
		
		for (ItemStack stack : items) {
	        if (stack.getItem() instanceof HealthPotion) {
	            stack.getItem().use();
	            stack.remove(1);

	            if (stack.isEmpty()) {
	                items.remove(stack);
	            }
	            return;
	        }
	    }
	}
	
	/**
	 * Returns the amount of health potions in inventory (Similarly will be changed to "getItemCount(Item item)"
	 * @return int of health potions
	 */
	public int getHealthPotionCount() {
	    for (ItemStack stack : items) {
	        if (stack.getItem() instanceof HealthPotion) {
	            return stack.getQuantity();
	        }
	    }
	    return 0;
	}
	
	/**
	 * Gets the list of Items in the inventory
	 * @return List<ItemStack> list of all item stacks in inventory
	 */
	public List<ItemStack> getItems() {
		return items;
	}
}