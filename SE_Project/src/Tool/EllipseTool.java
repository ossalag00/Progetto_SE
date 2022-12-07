package Tool;

import static java.lang.Math.abs;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;


public class EllipseTool extends DrawingTool{
    
    private Color in=Color.WHITE;
    
    public Color getIn() {
        return in;
    }

    public void setIn(Color in) {
        this.in = in;
    }
    
    
   @Override
    public void mouseUp(MouseEvent event){
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(this.getStartX());
        ellipse.setCenterY(this.getStartY());
        ellipse.setRadiusX(abs((this.getStartX()-event.getX())));
        ellipse.setRadiusY(abs((this.getStartY()-event.getY())));
        ellipse.setFill(this.in);
        ellipse.setStroke(this.getOut());
        this.getDrawingWindow().getChildren().add(ellipse);
        this.setDrawnShape(ellipse);
        
    }/*Sovrascriviamo il metodo della classe astratta estesa così da ottenere 
    al rilascio del mouse una nuova ellisse le cui dimensioni dipendono 
    da coordinate iniziali e finali, mentre la posizione del centro 
    da quelle iniziali*/
}
