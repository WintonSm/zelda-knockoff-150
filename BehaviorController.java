import java.awt.event.ActionEvent;

import javax.swing.*;

/*
 * An intermediary class for storing and transferring certain data between the view and model logic.
 * Also stores the WASD functionality.
 * @author Quenton Smith
 */

public class BehaviorController {
	private static final BehaviorController instance = new BehaviorController();
	
	public static BehaviorController getInstance() {
		if (instance == null) {
			BehaviorController instance = new BehaviorController();
		}
		return instance;	
	}
	
	private BehaviorController() {
	}
	
	
	/*
	 * This is where all the key bindings go.
	 * If you need to create a new one, copy one of the InputMap/ActionMap statements and
	 * adjust it to the key you need and the function you're trying to call.
	 */
	public void wasdSupport(DrawingPanel panel) {

	    panel.setFocusable(true);
	    
    	InputMap inputMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	    ActionMap actionMap = panel.getActionMap();
	    
	    inputMap.put(KeyStroke.getKeyStroke("A"), "left");
	    actionMap.put("left", new AbstractAction() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	boolean[] walls = Main.player.getMaze().getSquare(Main.player.getSquare());
	        	
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
	        	boolean[] walls = Main.player.getMaze().getSquare(Main.player.getSquare());
	        	
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
	        	boolean[] walls = Main.player.getMaze().getSquare(Main.player.getSquare());
	        	
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
	        	boolean[] walls = Main.player.getMaze().getSquare(Main.player.getSquare());
	        	
	        	if (!walls[3]) {
	                Main.player.moveDown();
	                Main.update();
	            }
	        }
	    });
	}
}

