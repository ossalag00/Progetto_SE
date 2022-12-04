/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tool;

import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author lessa
 */
public class SelectTool extends Tool {
    private Shape selectedShape;
    private boolean toggle=true;
    
    
    public void select(Shape s){
        if(toggle){
            this.setSelectedShape(s);
            Effect effect = new DropShadow(BlurType.GAUSSIAN, Color.RED, 5, 0.75, 0, 0);
            this.selectedShape.setEffect(effect);
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
    
    public void deSelect(){  
        this.selectedShape.setEffect(null);
        this.toggle=true;
        this.selectedShape=null;
    }

    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }
     
    
}
