package Tool;

import static java.lang.Math.abs;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

public class EllipseTool extends Tool{
    
    private Color in=Color.WHITE;
    
    public Color getIn() {
        return in;
    }

    public void setIn(Color in) {
        this.in = in;
    }
    
    
    @Override
    public Shape mouseUp(){
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(this.getStartX());
        ellipse.setCenterY(this.getStartY());
        ellipse.setRadiusX(abs((this.getStartX()-this.getEndX())));
        ellipse.setRadiusY(abs((this.getStartY()-this.getEndY())));
        ellipse.setFill(this.in);
        ellipse.setStroke(this.getOut());
        return ellipse;
    }/*Sovrascriviamo il metodo della classe astratta estesa così da ottenere 
    al rilascio del mouse una nuova ellisse le cui dimensioni dipendono 
    da coordinate iniziali e finali, mentre la posizione del centro 
    da quelle iniziali*/
}
