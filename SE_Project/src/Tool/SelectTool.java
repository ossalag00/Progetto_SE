/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tool;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author lessa
 */
public class SelectTool extends Tool {
     private Shape selectedShape;
    private boolean toggle=true;
    private Color colorOut;
    
    @Override
    public void select(Shape s){
        if(toggle){
        this.setSelectedShape(s);
        this.colorOut=(Color)s.getStroke();
        this.selectedShape.getStrokeDashArray().addAll(25d,10d);
        this.selectedShape.setStroke(Color.RED);
        this.toggle=false;
        }else{
            this.deSelect();
        }
    }

    public Shape getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }
    
    private void deSelect(){
        this.selectedShape.getStrokeDashArray().clear();
        this.selectedShape.setStroke(colorOut);
        this.toggle=true;
       
    }
    
}
