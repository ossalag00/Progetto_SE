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
        if(this.getScrollPane()!=null){//If inutile ai fini dell'applicazione ma necessario pee il funzionamento del testTool
         if(ellipse.getBoundsInParent().getMaxX()>this.getDrawingWindow().getWidth()){
            this.getDrawingWindow().setPrefSize(ellipse.getBoundsInParent().getMaxX()+100,this.getDrawingWindow().getHeight());
            this.getScrollPane().layout();
            this.getScrollPane().setHvalue(1);
        }
        if(ellipse.getBoundsInParent().getMaxY()>this.getDrawingWindow().getHeight()){
            this.getDrawingWindow().setPrefSize(this.getDrawingWindow().getPrefWidth(),ellipse.getBoundsInParent().getMaxY()+100);
            this.getScrollPane().layout();
            this.getScrollPane().setVvalue(1);
        }
        }
        this.setDrawnShape(ellipse);
        
    }/*Sovrascriviamo il metodo della classe astratta estesa così da ottenere 
    al rilascio del mouse una nuova ellisse le cui dimensioni dipendono 
    da coordinate iniziali e finali, mentre la posizione del centro 
    da quelle iniziali*/
}
