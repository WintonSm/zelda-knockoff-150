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
	        	Main.player.moveLeft();
	        	if (!Main.player.getInFight()) {
	        		Main.update();
	        	}
	        }
	    });

	    inputMap.put(KeyStroke.getKeyStroke("W"), "up");
	    actionMap.put("up", new AbstractAction() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	Main.player.moveUp();
	        	if (!Main.player.getInFight()) {
	        		Main.update();
	        	}
	        }
	    });

	    inputMap.put(KeyStroke.getKeyStroke("D"), "right");
	    actionMap.put("right", new AbstractAction() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	Main.player.moveRight();
	        	if (!Main.player.getInFight()) {
	        		Main.update();
	        	}
	        }
	    });

	    inputMap.put(KeyStroke.getKeyStroke("S"), "down");
	    actionMap.put("down", new AbstractAction() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	Main.player.moveDown();
	        	if (!Main.player.getInFight()) {
	        		Main.update();
	        	}
	        }
	    });
	}
}

