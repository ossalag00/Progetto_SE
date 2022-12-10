

import Tool.SelectTool;
import command.ResizeCommand;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestResize {
     
    private Pane pane;
    private Shape rectangle;
    private ResizeCommandForTest resizeCommand;
    private double newWidth, newHeight;
    
    

    @Before
    public void setUp() {
        this.pane=new Pane();
        this.rectangle = new Rectangle(10,20,200,300);
        this.pane.getChildren().add(this.rectangle);
        this.newWidth = 600;
        this.newHeight = 400;
        this.resizeCommand = new ResizeCommandForTest(this.rectangle, this.newWidth, this.newHeight);
        
    }
    
    @Test
    public void testResize(){
        assert(this.rectangle.getScaleX()==1);
        assert(this.rectangle.getScaleY()==1);
        this.resizeCommand.execute();
        assert(this.rectangle.getLayoutBounds().getWidth()*this.rectangle.getScaleX()==this.newWidth);
        assert(this.rectangle.getLayoutBounds().getHeight()*this.rectangle.getScaleY()==this.newHeight);
        
    }


}
