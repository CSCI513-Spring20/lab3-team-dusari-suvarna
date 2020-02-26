import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

// Flower bed class implementing shape interface
public class FlowerBed implements Shape {
// List of leaf nodes
	List<Shape> inShape = new ArrayList<Shape>();
	Rectangle rect = new Rectangle();

	public FlowerBed(Point2D point, int height, int width) {
		rect.setHeight(height);
		rect.setWidth(width);
		rect.setX(point.getX());
		rect.setY(point.getY());
		rect.setFill(Color.BROWN);
		rect.setStrokeWidth(4);
		rect.setStroke(Color.BLACK);
	}

	@Override
	public boolean ContainsPoint(Point2D point) {
		// TODO Auto-generated method stub
		return rect.contains(point);

	}

	// Method for adding child to flower bed
	public void addChild(Shape shape) {
		if(!inShape.contains(shape)) {
			inShape.add(shape);
		}
	}

	// Method for returning rectangle
	public Rectangle getRectangle() {
		// TODO Auto-generated method stub
		return rect;
	}

	// Move method for flowerbed
//@Override
	public void move(double dX, double dY) {
// TODO Auto-generated method stub
		rect.setX(rect.getX() + dX);
		rect.setY(rect.getY() + dY);
		for (Shape shape : inShape) {
			shape.move(dX, dY);

		}

	}
}
