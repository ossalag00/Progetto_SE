package Tool;

import static java.lang.Math.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class RectangleTool extends DrawingTool {
    
    private Color in=Color.WHITE;
    
            
    public Color getIn() {
        return in;
    }

    public void setIn(Color in) {
        this.in = in;
    }
    
    
    @Override
    public void mouseUp(MouseEvent event){
        Rectangle rect = new Rectangle();
        if(event.getX()<this.getStartX()){
            rect.setX(event.getX());
        }else{
            rect.setX(this.getStartX());
        }
        if(event.getY()<this.getStartY()){
           rect.setY(event.getY());
           
        }else{
            rect.setY(this.getStartY());
        }
        rect.setWidth(abs((this.getStartX()-event.getX())));
        rect.setHeight(abs((this.getStartY()-event.getY())));
        rect.setFill(this.in);
        rect.setStroke(this.getOut());
        this.getDrawingWindow().getChildren().add(rect);
        if(this.getScrollPane()!=null){//If inutile ai fini dell'applicazione ma necessario pee il funzionamento del testTool
          if(rect.getBoundsInParent().getMaxX()>this.getDrawingWindow().getWidth()){
            this.getDrawingWindow().setPrefWidth(rect.getBoundsInParent().getMaxX()+100);
            this.getScrollPane().layout();
            this.getScrollPane().setHvalue(1);
        }
        if(rect.getBoundsInParent().getMaxY()>this.getDrawingWindow().getHeight()){
            this.getDrawingWindow().setPrefHeight(rect.getBoundsInParent().getMaxY()+100);
            this.getScrollPane().layout();
            this.getScrollPane().setVvalue(1);
        }
        }
        this.setDrawnShape(rect);
    } /*Sovrascriviamo il metodo della classe astratta estesa così da ottenere 
    al rilascio del mouse un nuovo rettangolo le cui dimensioni e posizione
    dipendono da coordinate iniziali e finali*/
        
    
    
}
