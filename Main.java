/**
 * Main class which runs the program and controls the frame
 * @author Owen Edmundson
 */
public class Main {
	static Chest[] chestList;
	static int[] fightLoc;
	static Player player;
	static View screen;
	static int floor;
	static int mazeLength;
	
	/**
	 * The main method which runs the program
	 * @param args
	 */
	public static void main(String[] args) {
		mazeLength = 10;
		player = new Player(mazeLength, mazeLength);
		floor = 1;
		player.vision();
		chestList = new Chest[10];
		fightLoc = new int[20];
		
		for (int i = 0; i < fightLoc.length; i++) {
			fightLoc[i] = random(1, player.getHeight() * player.getWidth());
		}
		
		for (int i = 0; i < chestList.length; i++) {
			int chestSquare = random(1, player.getHeight() * player.getWidth());
			if (isChest(chestSquare) == null) {
				chestList[i] = new Chest(chestSquare, new HealthPotion());
			}
		}
		
		screen = new View();
		
		screen.addPanel(0);
		screen.addPanel(1);
		screen.addPanel(2);
		screen.repaint();
	}
	
	/**
	 * Generates a random integer in a range
	 * @param start the lower bound (inclusive)
	 * @param end the upper bound (exclusive)
	 * @return The integer generated
	 */
	public static int random(int start, int end) {
		return (int) (Math.random() * (end - start) + start);
	}
	
	/**
	 * Updates the screen after an action is taken
	 */
	public static void update() {
		if (player.getSquare() == player.getWidth() * player.getHeight() - 1) {
			newFloor();
		}
		if (isFight(player.getSquare())) {
			fight();
		} else {
			for (int i = 0; i < fightLoc.length; i++) {
				if (fightLoc[i] != -1) {
					fightLoc[i] += fightMove(fightLoc[i]);
				}
			}
			if (isFight(player.getSquare())) {
				fight();
			}
		}
		if (isChest(player.getSquare()) != null) {
			Chest chest = isChest(player.getSquare());
			for (int i = 0; i < chestList.length; i++) {
				if(chest.equals(chestList[i])) {
					player.getInventory().addItem(chest.getContent(), 1);
					chestList[i] = null;
					update();
				}
			}
		}
		reloadScreen();
	}
	
	/**
	 * Checks if there is a fight at a location
	 * @param loc the location to check
	 * @return true if there is a fight, false otherwise
	 */
	public static boolean isFight(int loc) {
		for (int i = 0; i < fightLoc.length; i++) {
			if (fightLoc[i] == loc) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * moves a fight
	 * @param loc the location of the fight
	 * @return the direction to move the fight in
	 */
	private static int fightMove(int loc) {
		int[] directions = {-1, player.getWidth(), 1, -player.getWidth()};
		int direction = random(0, 4);
		if (!player.getMaze().getSquare(loc)[direction] && !isFight(loc + directions[direction])) {
			return directions[direction];
		}
		return 0;
	}
	
	/**
	 * Code that activates when a fight is triggered
	 */
	private static void fight() {
		player.damage(random(5, 8));
		
		if(player.getHp() <= 0) {
			screen.end();
			screen.repaint();
		}
		
		for (int i = 0; i < fightLoc.length; i++) {
			if (fightLoc[i] == player.getSquare()) {
				fightLoc[i] = -1;
			}
		}
	}
	
	/**
	 * reloads the screen and updates the maze
	 */
	private static void reloadScreen() {
		screen.removePanel(0);
		player.addVisited(player.getSquare());
		player.vision();
		screen.mazeUpdate();
		screen.addPanel(0);
		screen.repaint();
	}
	
	/**
	 * Checks if a square has a chest on it
	 * @param square the square to check
	 * @return the chest that is there if there is one
	 */
	public static Chest isChest(int square) {
		for (int i = 0; i < chestList.length; i++) {
			if (chestList[i] != null && chestList[i].getSquare() == square) {
				return chestList[i];
			}
		}
		return null;
	}
	
	/**
	 * Takes the player to the next floor and resets everything
	 */
	public static void newFloor() {
		floor++;
		
		if (floor % 2 == 0) mazeLength++;
		
		player.generateMaze(mazeLength, mazeLength);
		
		fightLoc = new int[mazeLength * 2];
		chestList = new Chest[mazeLength];
		
		for (int i = 0; i < fightLoc.length; i++) {
			fightLoc[i] = random(1, player.getHeight() * player.getWidth());
		}
		
		for (int i = 0; i < chestList.length; i++) {
			int chestSquare = random(1, player.getHeight() * player.getWidth());
			if (isChest(chestSquare) == null) {
				chestList[i] = new Chest(chestSquare, new HealthPotion());
			}
		}
	}
}