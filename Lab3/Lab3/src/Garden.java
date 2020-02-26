import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Garden extends Application {
	Pane root;
	Point2D clickPoint;
	Point2D lastPosition = null;
	Scene scene;
	Flower flower;
	FlowerBed flowerBed;
	Shape shape;
	boolean mouseReleased = true;
	List<Shape> shapes = new ArrayList<Shape>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
// TODO Auto-generated method stub
		root = new AnchorPane();
		scene = new Scene(root, 600, 600);
		scene.setFill(Color.DARKGREY);
		scene.setOnMouseDragged(mouseHandler);
		scene.setOnMousePressed(mouseHandler);
		scene.setOnMouseReleased(mouseHandler);
		primaryStage.setTitle("Garden Layout");
		primaryStage.setScene(scene);
		primaryStage.show();
		flower = new Flower(new Point2D(20, 20), Color.BLUE, true);
		shapes.add(flower);
		flowerBed = new FlowerBed(new Point2D(35, 70), 35, 70);
		shapes.add(flowerBed);
		root.getChildren().addAll(flowerBed.getRectangle(), flower.getCircle());
	}

	EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

		public void handle(MouseEvent mouseEvent) {

			clickPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
			String eventName = mouseEvent.getEventType().getName();
			if (mouseReleased) {
				getShape();
			}
			switch (eventName) {

			case ("MOUSE_DRAGGED"):
				// System.out.println(lastPosition);
				if (shapes != null && lastPosition != null && shape != null) {
					mouseReleased = false;
					double xCells = clickPoint.getX() - lastPosition.getX();
					double yCells = clickPoint.getY() - lastPosition.getY();
					shape.move(xCells, yCells);
				}
				break;

			case ("MOUSE_RELEASED"):
				mouseReleased = true;
				if (shape != null && shape instanceof Flower) {
					for (Shape s : shapes) {
						if (s instanceof FlowerBed && s.ContainsPoint(clickPoint)) {
							((FlowerBed) s).addChild(shape);
							break;
						}
					}
				}

			}
			lastPosition = clickPoint;
		}
	};

	private void getShape() {
		for (Shape s : shapes) {
			if (s.ContainsPoint(clickPoint)) {
				shape = s;
				break;
			}
		}
	}

}
