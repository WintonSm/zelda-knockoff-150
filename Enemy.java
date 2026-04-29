/**
 * Keeps track of the status of enemies
 * @author Owen Edmundson
 */
abstract class Enemy {
	private int square;
	private int hp;
	private int damage;
	
	/**
	 * creates an enemy at a specified square
	 * @param square the square that the enemy is on
	 */
	public Enemy(int square, int damage, int hp) {
		this.square = square;
		this.damage = damage;
		this.hp = hp;
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
		
	}
}