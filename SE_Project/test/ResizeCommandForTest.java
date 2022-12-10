

import Tool.SelectTool;
import javafx.scene.shape.Shape;

public class ResizeCommandForTest {
    private Double newWidth;
    private Double newHeight;
    private Shape shape;

    
    public ResizeCommandForTest(Shape shape, Double newWidth, Double newHeight) {
        this.shape=shape;
        this.newHeight = newHeight;
        this.newWidth = newWidth;
    }
    


    public void execute() {
       Double widthScale = (newWidth/this.shape.getLayoutBounds().getWidth());
       Double heightScale = (newHeight/this.shape.getLayoutBounds().getHeight());
       this.shape.setScaleY(heightScale);
       this.shape.setScaleX(widthScale);
             
    }


        
}

