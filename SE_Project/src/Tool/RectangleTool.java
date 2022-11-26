package Tool;

import static java.lang.Math.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class RectangleTool extends Tool {
    
    private Color in=Color.WHITE;
    
            
    public Color getIn() {
        return in;
    }

    public void setIn(Color in) {
        this.in = in;
    }
    
    
    @Override
    public Shape mouseUp(){
        Rectangle rect = new Rectangle();
        if(this.getEndX()<this.getStartX()){
            rect.setX(this.getEndX());
        }else{
            rect.setX(this.getStartX());
        }
        if(this.getEndY()<this.getStartY()){
           rect.setY(this.getEndY());
           
        }else{
            rect.setY(this.getStartY());
        }
        rect.setWidth(abs((this.getStartX()-this.getEndX())));
        rect.setHeight(abs((this.getStartY()-this.getEndY())));
        rect.setFill(this.in);
        rect.setStroke(this.getOut());
        return rect;
    } /*Sovrascriviamo il metodo della classe astratta estesa così da ottenere 
    al rilascio del mouse un nuovo rettangolo le cui dimensioni e posizione
    dipendono da coordinate iniziali e finali*/
        
    
    
}
