import java.util.ArrayList;
/**
 * Keeps track of the player's status and the maze
 * @author Owen Edmundson
 */
public class Player {
	private int square;
	private int width;
	private int height;
	private MazeGenerator maze;
	private boolean[] visited;
	private ArrayList<Integer> vision;
	private int maxHp;
	private int hp;
	private int damage;
	private Inventory inventory;
	
	/**
	 * Calls the maze generator and sets the player position
	 * @param width the width of the maze
	 * @param height the height of the maze
	 */
	public Player(int width, int height) {
		generateMaze(width, height);
		this.maxHp = 100;
		this.hp = 100;
		this.damage = 10;
		this.inventory = new Inventory();
		inventory.addItem(new HealthPotion(), 2);
	}
	
	public void generateMaze(int width, int height) {
		this.maze = new MazeGenerator(width, height);
		this.width = width;
		this.height = height;
		this.square = 0;
		this.visited = new boolean[width * height];
		this.visited[this.square] = true;
		this.vision = new ArrayList<Integer>();
	}
	
	/**
	 * sets the vision ArrayList to all squares that can be seen by the player
	 * Adds all squares that can be seen by the player to the visited Array
	 */
	public void vision() {
		int[] directions = {-1, this.width, 1, -this.width};
		this.vision.clear();
		for (int i = 0; i < 4; i++) {
			int square = this.square;
			while(!this.maze.getSquares()[square][i]) {
				square += directions[i];
				this.visited[square] = true;
				this.vision.add(square);
			}
		}
	}
	
	/**
	 * gets an ArrayList of all squares that can be seen by the player
	 * @return integer ArrayList vision
	 */
	public ArrayList<Integer> getVision() {
		return vision;
	}
	
	/**
	 * Moves the player to the left if there is no wall in the way
	 */
	public void moveLeft() {
		if (!this.maze.getSquare(this.square)[0]) {
			this.square -= 1;
		}
	}
	/**
	 * Moves the player up if there is no wall in the way
	 */
	public void moveUp() {
		if (!this.maze.getSquare(this.square)[1]) {
			this.square += width;
		}
	}
	/**
	 * Moves the player to the right if there is no wall in the way
	 */
	public void moveRight() {
		if (!this.maze.getSquare(this.square)[2]) {
			this.square += 1;
		}
	}
	/**
	 * Moves the player down if there is no wall in the way
	 */
	public void moveDown() {
		if (!this.maze.getSquare(this.square)[3]) {
			this.square -= this.width;
		}
	}
	
	/**
	 * gets the maze that the player is in
	 * @return MazeGenerator maze
	 */
	public MazeGenerator getMaze() {
		return this.maze;
	}
	
	/**
	 * gets the width of the maze
	 * @return int width
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * gets the height of the maze
	 * @return int height
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * gets an array of the squares visited by the player
	 * @return boolean array visited
	 */
	public boolean[] getVisited() {
		return visited;
	}
	
	/**
	 * gets the square that the player is on
	 * @return int square
	 */
	public int getSquare() {
		return square;
	}
	
	/**
	 * adds a square to the list of squares visited by the player
	 * @param square the square to add
	 */
	public void addVisited(int square) {
		this.visited[square] = true;
	}
	
	/**
	 * gets the hp of the player
	 * @return int hp
	 */
	public int getHp() {
		return this.hp;
	}
	
	/**
	 * gets the max hp of the player
	 * @return int maxHp
	 */
	public int getMaxHp() {
		return this.maxHp;
	}
	
	/**
	 * Heals the player for a certain amount
	 * @param healing int amount of healing
	 */
	public void heal(int healing) {
		this.hp += healing;
		if (this.hp > this.maxHp) {
			this.hp = this.maxHp;
		}
	}
	
	/**
	 * damages the player
	 * @param damage the amount of damage taken
	 */
	public void damage(int damage) {
		this.hp -= damage;
		if (this.hp > this.maxHp) {
			this.hp = this.maxHp;
		}
	}
	
	/**
	 * gets the damage that the player does
	 * @return int damage
	 */
	public int getDamage() {
		return this.damage;
	}
	
	/**
	 * Gets the player's current inventory
	 * @return Inventory inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}
}