import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import Tool.Tool;

public class DrawCommandForTest  {
    private Tool tool;
    private Pane pane;

    public DrawCommandForTest(Tool tool,Pane pane) {
        this.tool = tool;
        this.pane=pane;
        
    }

    
    public Shape execute() {
        Shape s = this.tool.mouseUp();
        this.pane.getChildren().add(s);
        return s;
        
    }
    
}


