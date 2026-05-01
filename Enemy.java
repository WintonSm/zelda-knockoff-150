/**
 * Keeps track of the status of enemies
 * @author Owen Edmundson
 */
abstract class Enemy {
	private int square;
	private int hp;
	private int damage;
	private Sprite sprite;
	private double squareSizeX;
	private double squareSizeY;
	
	/**
	 * creates an enemy at a specified square
	 * @param square the square that the enemy is on
	 */
	public Enemy(int square, int damage, int hp, String url, DrawingPanel panel) {
		this.square = square;
		this.damage = damage;
		this.hp = hp;
		this.squareSizeX = panel.getWidth() / (double) Main.player.getWidth();
		this.squareSizeY = panel.getHeight() / (double) Main.player.getHeight();
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
	public void move(int direction) {
		int[] directions = {-1, Main.player.getWidth(), 1, -Main.player.getWidth()};
		this.square += directions[direction];
		if (direction == 0) {
			this.sprite.move(-(int) squareSizeY, 0);
		} else if (direction == 1) {
			this.sprite.move(0, (int) squareSizeY);
		} else if (direction == 2) {
			this.sprite.move((int) squareSizeY, 0);
		} else {
			this.sprite.move(0, -(int) squareSizeY);
		}
	}
}