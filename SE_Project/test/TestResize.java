
import command.ResizeCommand;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;

public class TestResize {
     
    private Pane pane;
    private Shape rectangle;
    private ResizeCommand resizeCommand;
    private double newWidth, newHeight;
    private SelectToolForTest selectTool;
    
    

    @Before
    public void setUp() {
        this.pane=new Pane();
        this.rectangle = new Rectangle(10,20,200,300);
        this.pane.getChildren().add(this.rectangle);
        this.selectTool= new SelectToolForTest();
        this.selectTool.select(rectangle);
        this.newWidth = 600;
        this.newHeight = 400;
        this.resizeCommand = new ResizeCommand(this.selectTool, this.newWidth, this.newHeight);
        
    }
    
    @Test
    public void testResize(){
        assert(this.rectangle.getScaleX()==1);
        assert(this.rectangle.getScaleY()==1);
        this.resizeCommand.execute();
        assert(this.rectangle.getLayoutBounds().getWidth()*this.rectangle.getScaleX()==this.newWidth);
        assert(this.rectangle.getLayoutBounds().getHeight()*this.rectangle.getScaleY()==this.newHeight);
        this.resizeCommand.undo();
        assert(this.rectangle.getLayoutBounds().getWidth()*this.rectangle.getScaleX()==200);
        assert(this.rectangle.getLayoutBounds().getHeight()*this.rectangle.getScaleY()==300);
    }


}
