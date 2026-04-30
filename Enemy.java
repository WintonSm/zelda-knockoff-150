/**
 * Keeps track of the status of enemies
 * @author Owen Edmundson
 */
abstract class Enemy {
	private int square;
	private int hp;
	private int damage;
	private Sprite sprite;
	
	/**
	 * creates an enemy at a specified square
	 * @param square the square that the enemy is on
	 */
	public Enemy(int square, int damage, int hp, String url, DrawingPanel panel) {
		this.square = square;
		this.damage = damage;
		this.hp = hp;
		double squareSizeX = panel.getWidth() / (double) Main.player.getWidth();
		double squareSizeY = panel.getHeight() / (double) Main.player.getHeight();
		int x = this.square % Main.player.getWidth();
		int y = this.square / Main.player.getWidth();
		this.sprite = new Sprite(url, new double[] {x * squareSizeX + 1, panel.getHeight() - (y + 1) * squareSizeY + 1, squareSizeX - 2, squareSizeY - 2});
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
	
	public Sprite getSprite(DrawingPanel panel) {
		return this.sprite;
	}
	
	/**
	 * Moves the enemy in a random direction
	 */
	public void move() {
		
	}
}