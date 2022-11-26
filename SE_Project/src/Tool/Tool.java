package Tool;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public abstract class Tool {
    
    private double startX;
    private double endX;
    private double startY;
    private double endY;
    private Color out=Color.BLACK;
    

    public Tool() {
    }

    public Color getOut() {
        return out;
    }
    
    public void setOut(Color out) {
        this.out = out;
    }


    public void setStartX(double startX) {
        this.startX = startX;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }

    public double getStartX() {
        return startX;
    }

    public double getEndX() {
        return endX;
    }

    public double getStartY() {
        return startY;
    }

    public double getEndY() {
        return endY;
    }
    
    public Shape mouseUp(){
        return new Line();
    }
    
}
