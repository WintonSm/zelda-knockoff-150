/**
 * Generates the maze
 * @author Owen Edmundson
 */
public class MazeGenerator {
	private int width;
	private int height;
	private int squareAmount;
	private boolean[][] squares;
	
	/**
	 * Sets the dimensions for the maze then calls the generate maze function
	 * @param width the width of the maze
	 * @param height the height of the maze
	 */
	public MazeGenerator(int width, int height) {
		this.width = width;
		this.height = height;
		this.squareAmount = width * height;
		generateMaze();
	}
	
	/**
	 * Checks if a value is in an array
	 * @param arr the array to check
	 * @param value the value to find
	 * @return True if the value is in the array, false otherwise
	 */
	public boolean in(int[] arr, int value) {
		for (int i: arr) {
			if (i == value) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Generates a maze stored in the squares array
	 */
	public void generateMaze() {
		this.squares = new boolean[squareAmount][4];
		int[] directions = {-1, width, 1, -width};
		int[] top = new int[width];
		int[] bottom = new int[width];
		int[] left = new int[height];
		int[] right = new int[height];
		VariableArray squaresDone = new VariableArray(squareAmount);
		VariableArray whitelist = new VariableArray(squareAmount);
		
		for (int i = 0; squareAmount > i; i++) {
			for (int j = 0; j < 4; j++) {
				this.squares[i][j] = true;
			}
		}
		for (int i = 0; i < width; i++) {
	        top[i] = squareAmount - i - 1;
	        bottom[i] = i;
	    }
		for (int i = 0; i < height; i++) {
	        left[i] = i * width;
	        right[i] = (i + 1) * width - 1;
	    }
		
		squaresDone.append(Main.random(0, squareAmount));
		whitelist.append(squaresDone.get(0));
		boolean[] possible = {false, false, false, false};
		int square = 0;
		int direction = 0;
		int[] secondRemove = {2, 3, 0, 1};
		
		while (!(whitelist.len() == 0)) {
	        square = whitelist.get(Main.random(0, whitelist.len()));
	        
	        possible[0] = (squaresDone.in(square - 1) || in(left, square)) ? false : true;
	        possible[1] = (squaresDone.in(square + width) || in(top, square)) ? false : true;
	        possible[2] = (squaresDone.in(square + 1) || in(right, square)) ? false : true;
	        possible[3] = (squaresDone.in(square - width) || in(bottom, square)) ? false : true;

	        if (!possible[0] && !possible[1] && !possible[2] && !possible[3]) {
	            whitelist.del(square);
	            continue;
	        }
	        
	        direction = Main.random(0, 4);
	        while (!possible[direction]) {
	            direction = Main.random(0, 4);
	        }
	        squaresDone.append(square + directions[direction]);
	        whitelist.append(square + directions[direction]);
	        this.squares[square][direction] = false;
	        this.squares[square + directions[direction]][secondRemove[direction]] = false;
		}
	}
	
	/**
	 * gets the array representing a square in the maze
	 * @param square the square to get
	 * @return The array of that square
	 */
	public boolean[] getSquare(int square) {
		return this.squares[square];
	}
	
	/**
	 * gets the squares array
	 * @return squares boolean array of arrays
	 */
	public boolean[][] getSquares() {
		return this.squares;
	}
}