
import java.awt.event.ActionEvent;

import javax.swing.*;

/*
 * An intermediary class for storing and transferring certain data between the view and model logic.
 * Also stores the WASD functionality.
 * @author Quenton Smith
 */

public class BehaviorController {
	private int floor;
	
	private static final BehaviorController instance = new BehaviorController();
	
	public static BehaviorController getInstance() {
		if (instance == null) {
			BehaviorController instance = new BehaviorController();
		}
		return instance;	
	}
	
	private BehaviorController() {
		this.floor = 1;
	}


	//Floor methods
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	
	/*
	 * This is where all the key bindings go.
	 * If you need to create a new one, copy one of the InputMap/ActionMap statements and
	 * adjust it to the key you need and the function you're trying to call.
	 */
	public void wasdSupport(DrawingPanel panel) {

	    panel.setFocusable(true);

	    double squareSizeX = panel.getWidth() / (double) Main.player.getWidth();
	    double squareSizeY = panel.getHeight() / (double) Main.player.getHeight();
	    int x = Main.player.getSquare() % Main.player.getWidth();
	    int y = Main.player.getSquare() / Main.player.getWidth();

	    Sprite hero = new Sprite("new-sprites/Player(s)/Adventurer-Base-NoItems.png", new double[] {x * squareSizeX + 1, panel.getHeight() - (y + 1) * squareSizeY + 1, squareSizeX - 2, squareSizeY - 2});

	    panel.addObject(hero);

	    System.out.println(panel.isFocusOwner());

	    InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	    ActionMap actionMap = panel.getActionMap();

	    boolean[] walls = Main.player.getMaze().getSquare(Main.player.getSquare());

	    inputMap.put(KeyStroke.getKeyStroke("A"), "left");
	    actionMap.put("left", new AbstractAction() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (!walls[0]) {
	                Main.player.moveLeft();
	                Main.update();
	            }
	        }
	    });

	    inputMap.put(KeyStroke.getKeyStroke("W"), "up");
	    actionMap.put("up", new AbstractAction() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (!walls[1]) {
	                Main.player.moveUp();
	                Main.update();
	            }
	        }
	    });

	    inputMap.put(KeyStroke.getKeyStroke("D"), "right");
	    actionMap.put("right", new AbstractAction() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (!walls[2]) {
	                Main.player.moveRight();
	                Main.update();
	            }
	        }
	    });

	    inputMap.put(KeyStroke.getKeyStroke("S"), "down");
	    actionMap.put("down", new AbstractAction() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if (!walls[3]) {
	                Main.player.moveDown();
	                Main.update();
	            }
	        }
	    });
	}
}

