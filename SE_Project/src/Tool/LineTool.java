package Tool;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;


public class LineTool extends DrawingTool {
    
     @Override
    public void mouseUp(MouseEvent event){       
        Line line = new Line();
        line.setStartX(this.getStartX());
        line.setStartY(this.getStartY());
        line.setEndX(event.getX());
        line.setEndY(event.getY());
        line.setStroke(this.getOut());
        this.getDrawingWindow().getChildren().add(line);
        this.setDrawnShape(line);
    }
}
