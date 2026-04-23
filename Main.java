/**
 * Main class which runs the program and controls the frame
 * @author Owen Edmundson
 */
public class Main {
	static Enemy[] enemyList;
	static Player player;
	static View screen;
	
	/**
	 * The main method which runs the program
	 * @param args
	 */
	public static void main(String[] args) {
		player = new Player(15, 15);
		player.vision();
		enemyList = new Enemy[30];
		
		for (int i = 0; i < enemyList.length; i++) {
			int enemySquare = random(1, player.getHeight() * player.getWidth());
			if (isEnemy(enemySquare) == null) {
				enemyList[i] = new Enemy(enemySquare);
			}
		}
		
		
		
		screen = new View();
		
		screen.addPanel(0);
		screen.addPanel(2);
		screen.addPanel(3);
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
			screen.end();
		}
		if (isEnemy(player.getSquare()) == null) {
			for (Enemy enemy : enemyList) {
				if (enemy != null) {
					enemy.move();
				}
			}
			screen.removePanel(0);
			player.addVisited(player.getSquare());
			player.vision();
			screen.mazeUpdate();
			screen.addPanel(0);
			screen.repaint();
		} else {
			Enemy enemy = isEnemy(player.getSquare());
			if (enemy.getHp() < 1) {
				for (int i = 0; i < enemyList.length; i++) {
					if (enemy.equals(enemyList[i])) {
						enemyList[i] = null;
						break;
					}
				}
				screen.removePanel(1);
				update();
			} else {
				screen.removePanel(0);
				screen.removePanel(1);
				screen.combatVisuals(enemy);
				screen.addPanel(1);
				screen.repaint();
			}
		}
	}
	
	/**
	 * Gets the enemy at a certain square
	 * @param square the square to check
	 * @return the enemy object if there is one, null otherwise
	 */
	public static Enemy isEnemy(int square) {
		for (int i = 0; i < enemyList.length; i++) {
			if (enemyList[i] != null && enemyList[i].getSquare() == square) {
				return enemyList[i];
			}
		}
		return null;
	}
}