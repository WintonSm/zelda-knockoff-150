
/*
 * An intermediary class for storing and transferring certain data between the view and model logic.
 * @author Quenton Smith
 */

public class BehaviorController {
	private int floor;

	BehaviorController() {
		this.floor = 1;
	}

	//Floor methods
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	
}
