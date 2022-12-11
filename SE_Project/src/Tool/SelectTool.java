/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tool;

import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author lessa
 */
public class SelectTool extends Tool {
    private Shape selectedShape;
    private boolean toggle=true;
    private TextField width;
    private TextField height;
    
    public void setTextField(TextField width, TextField height){
        this.width=width;
        this.height=height;
    }
    
    public void select(Shape s){
        if(toggle){
            this.setSelectedShape(s);
            Effect effect = new DropShadow(BlurType.GAUSSIAN, Color.RED, 5, 0.75, 0, 0);
            this.selectedShape.setEffect(effect);
            this.toggle=false;
            this.width.setText(String.valueOf(this.getWidth()));
            this.height.setText(String.valueOf(this.getHeight()));
        }else{
            this.deSelect();
        }   
    }
    
    public void mouseDown(MouseEvent event){
        if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getTarget() instanceof Shape){
                    select((Shape)event.getTarget());
                }
        else{
                if(selectedShape!=null){
                    deSelect();
                    }
            }
        }
    }

    public Shape getSelectedShape() {
        return selectedShape;
    }

    public double getWidth() {
        return (double)this.selectedShape.getLayoutBounds().getWidth()*this.selectedShape.getScaleX();
    }

    public double getHeight() {
        return (double)this.selectedShape.getLayoutBounds().getHeight()*this.selectedShape.getScaleY();
    }
    
    public void setSelectedShape(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }
    
    public void deSelect(){  
        this.selectedShape.setEffect(null);
        this.toggle=true;
        this.selectedShape=null;
        width.setText("");
        height.setText("");
    }

    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }
     
    
}
