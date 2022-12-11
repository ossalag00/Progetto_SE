
import Tool.SelectTool;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;


public class SelectToolForTest extends SelectTool {
     @Override
     public void select(Shape s){
        if(this.isToggle()){
            this.setSelectedShape(s);
            Effect effect = new DropShadow(BlurType.GAUSSIAN, Color.RED, 5, 0.75, 0, 0);
            this.getSelectedShape().setEffect(effect);
            this.setToggle(false);
        }else{
            this.deSelect();
        }   
    }

     @Override
    public void deSelect(){  
        this.getSelectedShape().setEffect(null);
        this.setToggle(true);
        this.setSelectedShape(null);

    }

}
