public class Skeleton extends Enemy {
	
	public Skeleton(int square, DrawingPanel panel) {
		super(square, Main.random(5, 8), Main.random(20, 30), "new-sprites/Enemies/Skeleton-basic.png", panel);
	}
	
}