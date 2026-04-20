/**
 * Keeps track of the status of enemies
 * @author Owen Edmundson
 */
public class Enemy {
	private int square;
	private int hp;
	private int damage;
	
	/**
	 * creates an enemy at a specified square
	 * @param square the square that the enemy is on
	 */
	public Enemy(int square) {
		this.hp = Main.random(20, 30);
		this.damage = Main.random(5,  10);
		this.square = square;
	}
	
	/**
	 * gets the damage that the enemy does
	 * @return int damage
	 */
	public int getDamage() {
		return this.damage;
	}
	
	/**
	 * gets the hp of the enemy
	 * @return int hp
	 */
	public int getHp() {
		return this.hp;
	}
	
	/**
	 * damages the enemy by a specified amount
	 * @param damage the amount of damage done
	 */
	public void damage(int damage) {
		this.hp -= damage;
	}
	
	/**
	 * gets the square that the enemy is on
	 * @return int square
	 */
	public int getSquare() {
		return this.square;
	}
	
	/**
	 * Moves the enemy in a random direction
	 */
	public void move() {
		int[] directions = {-1, Main.player.getWidth(), 1, -Main.player.getWidth()};
		int direction = Main.random(0, 4);
		if (!Main.player.getMaze().getSquare(this.square)[direction] && Main.isEnemy(this.square + directions[direction]) == null) {
			this.square += directions[direction];
		}
	}
}