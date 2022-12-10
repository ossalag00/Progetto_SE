
package command;
import Tool.SelectTool;
import javafx.scene.shape.Shape;

public class ResizeCommand implements Command {
    private SelectTool selectTool;
    private Double newWidth;
    private Double newHeight;
    private Shape shape;
    private Double currentScaleX;
    private Double currentScaleY;
    
    public ResizeCommand(SelectTool selectTool, Double newWidth, Double newHeight) {
        this.selectTool = selectTool;
        this.shape=this.selectTool.getSelectedShape();
        this.newHeight = newHeight;
        this.newWidth = newWidth;
        this.currentScaleX =this.selectTool.getSelectedShape().getScaleX();
        this.currentScaleY =this.selectTool.getSelectedShape().getScaleY();
    }
    

    @Override
    public void execute() {
       Double widthScale = (newWidth/this.selectTool.getSelectedShape().getLayoutBounds().getWidth());
       Double heightScale = (newHeight/this.selectTool.getSelectedShape().getLayoutBounds().getHeight());
       this.selectTool.getSelectedShape().setScaleY(heightScale);
       this.selectTool.getSelectedShape().setScaleX(widthScale);
             
    }

    @Override
    public void undo() {
       this.shape.setScaleX(this.currentScaleX);
       this.shape.setScaleY(this.currentScaleY);
       
    }
        
}

