import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Flower implements Shape {
	Circle circle = new Circle();

	boolean movable;

	public Flower(Point2D point, Color color, boolean bool) {
		this.movable = bool;
		circle.setCenterX(point.getX());
		circle.setCenterY(point.getY());
		circle.setRadius(12);
		circle.setFill(color);
		circle.setStroke(Color.BLACK);
		circle.setStrokeWidth(1);
	}

	@Override
	public boolean ContainsPoint(Point2D point) { // See if the clicked point is within the circle
		// TODO Auto-generated method stub
		return circle.contains(point);
	}

	// Move method implemented based on the drag
	@Override
	public void move(double dX, double dY) {
		// TODO Auto-generated method stub
		circle.setCenterX(circle.getCenterX() + dX);
		circle.setCenterY(circle.getCenterY() + dY);
	}

	// Returns circle
	public Circle getCircle() {
		return circle;
	}

}
