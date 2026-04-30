import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Creates the JFrame that all of the graphics are placed on
 * @author Owen Edmundson
 */
public class View {
	private JFrame frame;
	private DrawingPanel[] panels;
	private boolean wasdInit = false;
	
	/**
	 * Creates the JFrame that all of the graphics are placed on
	 */
	public View() {
		this.panels = new DrawingPanel[5];
		this.frame = new JFrame();
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.frame.setLayout(null);
		this.frame.setVisible(true);
		this.frame.getContentPane().setBackground(new Color(0, 0, 0));
		mazePanel();
		fightPanel();
		statPanel();
		itemPanel();
		endPanel();
		hp();
	}

	/**
	 * gets the panels that are in the panel array
	 * @return DrawingPanel array
	 */
	public DrawingPanel[] getPanels() {
		return this.panels;
	}
	
	/**
	 * revalidates and repaints the frame
	 */
	public void repaint() {
		this.frame.revalidate();
		this.frame.repaint();
	}
	
	/**
	 * adds a panel to the frame from the array of panels
	 * @param screen integer location of the panel to add to the frame
	 */
	public void addPanel(int screen) {
		this.frame.add(this.panels[screen]);
	}
	
	/**
	 * removes a panel from the frame
	 * @param screen integer location of the panel to remove from the frame
	 */
	public void removePanel(int screen) {
		this.frame.remove(this.panels[screen]);
	}
	
	/**
	 * The panel that shows at the ending
	 */
	public void endPanel() {
		DrawingPanel end = new DrawingPanel(scale(0, 0, 1.0, 1.0));
		this.panels[4] = end;
	}
	
	/**
	 * Shows either the win screen or the loss screen depending on if you are alive
	 */
	public void end() {
		DrawingPanel panel = this.panels[4];
		if (Main.player.getHp() > 0) {
			panel.addObject(new Sprite("win.jpg", scale(0, 0, 1.0, 1.0)));
			panel.addObject(new Sprite("new-sprites/Player(s)/Adventurer-Base-NoItems.png", scale(.3, .5, .2, .3)));
		} else {
			panel.addObject(new Sprite("loss.jpg",  scale(0, 0, 1.0, 1.0)));
		}
		for (int i = 0; i < 4; i++) {
			this.removePanel(i);
		}
		this.addPanel(4);
	}
	
	/**
	 * The panel with the sword
	 */
	public void itemPanel() {
		DrawingPanel items = new DrawingPanel(scale(0.775, .1, .2, .8));
		items.setBackground(new Color(200, 200, 200));
		
		items.addObject(new Sprite("new-sprites/Items/Sword-basic.png", items.scale(.1, .05, .8, .3)));
		
		panels[3] = items;
	}
	
	/**
	 * Sets up the visuals during combat
	 * @param enemy the enemy being fought
	 */
	public void combatVisuals() {
		
	}
	
	/**
	 * Shows the hp of the enemy
	 * @param enemy the enemy to show the hp of
	 */
	public void enemyHp(Enemy enemy) {
		
	}
	
	/**
	 * shows the hp of the player
	 */
	public void hp() {
		DrawingPanel statPanel = this.panels[2];
		statPanel.removeAll();
		
		ImageIcon healingPotion = new ImageIcon("new-sprites/Items/Health-Potion-Large.png");
		JButton healingPotionBtn = new JButton(healingPotion);
		healingPotionBtn.setBorderPainted(false);
		healingPotionBtn.setContentAreaFilled(false);
		healingPotionBtn.setOpaque(false);
		
		int[] dims = statPanel.scale(.1, .4, .8, .1);
		healingPotionBtn.setBounds(dims[0], dims[1], dims[2], dims[3]);

		statPanel.add(healingPotionBtn);
		
		healingPotionBtn.addActionListener(e -> {
			Main.player.getInventory().useHealthPotion();
			Main.update();
		});
		
		JLabel healingPotions = new JLabel("Potions: " + Main.player.getInventory().getItemCount(new HealthPotion()));
		
		int[] potionCountDimensions = statPanel.scale(.1, .5, .8, .1);
		healingPotions.setBounds(potionCountDimensions[0], potionCountDimensions[1], potionCountDimensions[2], potionCountDimensions[3]);
		
		statPanel.add(healingPotions);
		
		JLabel health = new JLabel("Health = " + Main.player.getHp());
		int[] dimensions = statPanel.scale(.1, .6, .8, .1);
		health.setBounds(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
		statPanel.add(health);
	}
	
	/**
	 * Panel showing the status of the player
	 */
	public void statPanel() {
		DrawingPanel stats = new DrawingPanel(scale(0.025, .1, .2, .8));
		stats.setBackground(new Color(200, 200, 200));
		
		stats.addObject(new Sprite("new-sprites/Player(s)/Adventurer-Base-NoItems.png", stats.scale(.1, .05, .8, .3)));
		
		panels[2] = stats;
	}
	
	/**
	 * The panel showing the enemy
	 */
	public void fightPanel() {
		DrawingPanel fight = new DrawingPanel(scale(.25, .1, .5, .8));
		fight.setBackground(new Color (63, 63, 116));
		
		panels[1] = fight;
	}
	
	/**
	 * updates the maze and shows the hp of the player
	 */
	public void mazeUpdate() {
		this.mazePanel();
		hp();
	}
	
	/**
	 * The panel that the maze is on
	 */
	public void mazePanel() {
		boolean[][] maze = Main.player.getMaze().getSquares();
		int floor = Main.floor;
		int width = Main.player.getWidth();
		int height = Main.player.getHeight();
		DrawingPanel mazePanel = new DrawingPanel(scale(.25, .1, .5, .8));
		mazePanel.setBackground(new Color (63, 63, 116));
		
		double squareSizeX = mazePanel.getWidth() / (double) width;
		double squareSizeY = mazePanel.getHeight() / (double) height;
		
	    for (int i = 0; i < height; i++) {
	        for (int j = 0; j < width; j++) {
	        	if (Main.player.getVisited()[i * width + j]) {
	        		if (maze[i * width + j][0]) {
	        			mazePanel.addObject(new Line(new double[] {squareSizeX * j, mazePanel.getHeight() - squareSizeY * (i + 1), 0, squareSizeY}));
	        		}
	        		if (maze[i * width + j][1]) {
	        			mazePanel.addObject(new Line(new double[] {squareSizeX * j, mazePanel.getHeight() - squareSizeY * (i + 1), squareSizeX, 0}));
	        		}
	        		if (maze[i * width + j][2]) {
	        			mazePanel.addObject(new Line(new double[] {squareSizeX * (j + 1), mazePanel.getHeight() - squareSizeY * (i + 1), 0, squareSizeY}));
	        		}
	        		if (maze[i * width + j][3]) {
	        			mazePanel.addObject(new Line(new double[] {squareSizeX * j, mazePanel.getHeight() - squareSizeY * i, squareSizeX, 0}));
	        		}
	        	}
	        }
	    }
	    //directions(mazePanel);
	   
    	BehaviorController.getInstance().wasdSupport(mazePanel);
    	addEnemies(mazePanel);
    	addChests(mazePanel);
    	
    	JLabel floors = new JLabel("Floor: " + floor);
    	int[] dimensions = mazePanel.scale(.05, 0, .5, .1);
		floors.setBounds(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
		
		mazePanel.add(floors);

	    panels[0] = mazePanel;
	}
	
	/**
	 * Shows the buttons to move around the maze
	 * @param panel the panel to place them on
	 */
	public void directions(DrawingPanel panel) {
		double squareSizeX = panel.getWidth() / (double) Main.player.getWidth();
		double squareSizeY = panel.getHeight() / (double) Main.player.getHeight();
		int x = Main.player.getSquare() % Main.player.getWidth();
		int y = Main.player.getSquare() / Main.player.getWidth();
		boolean[] walls = Main.player.getMaze().getSquare(Main.player.getSquare());
		
		Sprite hero = new Sprite("new-sprites/Player(s)/Adventurer-Base-NoItems.png", new double[] {x * squareSizeX + 1, panel.getHeight() - (y + 1) * squareSizeY + 1, squareSizeX - 2, squareSizeY - 2});
		panel.addObject(hero);
		
		
		addEnemies(panel);
	}
	
	/**
	 * Shows the enemies when they are within vision
	 * @param panel the panel to add them to
	 */
	public void addEnemies(DrawingPanel panel) {
		double squareSizeX = panel.getWidth() / (double) Main.player.getWidth();
		double squareSizeY = panel.getHeight() / (double) Main.player.getHeight();
		for (int square : Main.player.getVision()) {
			if (Main.isFight(square)) {
				int x = square % Main.player.getWidth();
				int y = square / Main.player.getWidth();
				Sprite enemy = new Sprite("new-sprites/Enemies/Skeleton-basic.png", new double[] {x * squareSizeX + 1, panel.getHeight() - (y + 1) * squareSizeY + 1, squareSizeX - 2, squareSizeY - 2});
				panel.addObject(enemy);
			}
		}
		Sprite exit = new Sprite("new-sprites/Level Elements/Exit.png", new double[] {(Main.player.getWidth() - 1) * squareSizeX + 1, panel.getHeight() - Main.player.getHeight() * squareSizeY + 1, squareSizeX - 2, squareSizeY - 2});
		panel.addObject(exit);
	}
	
	/**
	 * Shows the chests when they are within vision
	 * @param panel the panel to add them to
	 */
	public void addChests(DrawingPanel panel) {
		double squareSizeX = panel.getWidth() / (double) Main.player.getWidth();
		double squareSizeY = panel.getHeight() / (double) Main.player.getHeight();
		for (int square : Main.player.getVision()) {
			if (Main.isChest(square) != null) {
				int x = square % Main.player.getWidth();
				int y = square / Main.player.getWidth();
				Sprite chest = new Sprite("new-sprites/Level Elements/Chest1.png", new double[] {x * squareSizeX + 1, panel.getHeight() - (y + 1) * squareSizeY + 1, squareSizeX - 2, squareSizeY - 2});
				panel.addObject(chest);
			}
		}
	}
	
    /**
     * Scales the dimensions of a Panel to fit on this frame
     * @param x the percentage across the width of the frame of the x position
     * @param y the percentage across the height of the frame of the y position
     * @param width the percentage across the width of the frame of the width
     * @param height the percentage across the height of the frame of the height
     * @return integer array of the dimensions
     */
	public int[] scale(double x, double y, double width, double height) {
		return new int[] {(int) (this.frame.getWidth() * x), (int) (this.frame.getHeight() * y), (int) (this.frame.getWidth() * width), (int) (this.frame.getHeight() * height)};
	}
}