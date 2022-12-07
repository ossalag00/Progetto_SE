/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tool;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;


public abstract class DrawingTool extends Tool {
    private Pane drawingWindow;
    private double startX;
    private double startY;
    private Shape drawnShape;
    private Color out=Color.BLACK;

    public DrawingTool() {
    }
    
    @Override
    public void mouseDown(MouseEvent event){
        startX=event.getX();
        startY=event.getY();
    }
    
    public void setDrawingWindow(Pane drawingWindow) {
        this.drawingWindow = drawingWindow;
    }

    public Pane getDrawingWindow() {
        return drawingWindow;
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


    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public Shape getDrawnShape() {
        return drawnShape;
    }

    public void setDrawnShape(Shape drawnShape) {
        this.drawnShape = drawnShape;
    }
    
    public void erase(Shape s){
        drawingWindow.getChildren().remove(s);
    }
}
