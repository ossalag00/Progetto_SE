package Tool;

import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class LineTool extends Tool {
    
    @Override
    public Shape mouseUp(){       
        Line line = new Line();
        line.setStartX(this.getStartX());
        line.setStartY(this.getStartY());
        line.setEndX(this.getEndX());
        line.setEndY(this.getEndY());
        line.setStroke(this.getOut());
        return line;
    }
}
