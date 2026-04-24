/**
 * Health Potion class that heals player by 10
 * @author Jaycob Reitz 
 */

public class HealthPotion extends Item {
	
	/**
	 * Creates a health potion 
	 */
	public HealthPotion() {
		this.type = "Health Potion";
	}

	@Override
	public void use() {
		Main.player.heal(10);
	}
}