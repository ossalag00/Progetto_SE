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
         if(line.getBoundsInParent().getMaxX()>this.getDrawingWindow().getWidth()){
            this.getDrawingWindow().setPrefSize(line.getBoundsInParent().getMaxX()+100,this.getDrawingWindow().getHeight());
            this.getScrollPane().layout();
            this.getScrollPane().setHvalue(1);
        }
        if(line.getBoundsInParent().getMaxY()>this.getDrawingWindow().getHeight()){
            this.getDrawingWindow().setPrefSize(this.getDrawingWindow().getPrefWidth(),line.getBoundsInParent().getMaxY()+100);
            this.getScrollPane().layout();
            this.getScrollPane().setVvalue(1);
        }
        this.setDrawnShape(line);
    }
}
