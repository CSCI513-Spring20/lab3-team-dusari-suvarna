import java.util.ArrayList;
import java.util.List;

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
Point2D lPosition=null;
Scene scene;
Flower flower1;
FlowerBed flowerBed1;
Shape shape;
boolean dragMode=false;
List<Shape> shapes=new ArrayList<Shape>();



@Override
public void start(Stage primaryStage) throws Exception {
// TODO Auto-generated method stub
	root = new AnchorPane();
	scene = new Scene(root,600,600);
	scene.setFill(Color.ORANGE);
	scene.setOnMouseDragged(mouseHandler);
	scene.setOnMousePressed(mouseHandler);
	scene.setOnMouseReleased(mouseHandler);
	primaryStage.setTitle("Garden Layout");
	primaryStage.setScene(scene);
	primaryStage.show();
	flower1=new Flower(new Point2D(20,20),Color.BLUE,true);
	shapes.add(flower1);
	//flowerBed1=new FlowerBed(new Point2D(35,70),35,70);
	//shapes.add(flowerBed1);
	root.getChildren().addAll(/*flowerBed1.getRectangle(),*/flower1.getCircle());
}

EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

public void handle(MouseEvent mouseEvent) {

clickPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
String eventName = mouseEvent.getEventType().getName();
if(!dragMode) {
shape = getShape();
}
switch(eventName) {

case("MOUSE_DRAGGED"):
if(shapes!=null&&lPosition != null&&shape!=null) {
dragMode = true;
double xCells =clickPoint.getX()-lPosition.getX();
double yCells =clickPoint.getY()-lPosition.getY();
shape.move(xCells,yCells);
}

break;
case("MOUSE_RELEASED"):
if(shape!=null&&shape instanceof Flower) {
for(Shape s: shapes){
if(s instanceof FlowerBed && s.ContainsPoint(clickPoint)) {
//((FlowerBed) s).addChild(shape);
break;
}
}
}
dragMode = false;
}
lPosition = clickPoint;
}
};
private Shape getShape(){
    Shape selectedShape = null;
for(Shape s: shapes){
if (s.ContainsPoint(clickPoint)){
selectedShape = s;
break;
}
}
return selectedShape;
    }
public static void main(String[] args) {
launch(args);
}

}
