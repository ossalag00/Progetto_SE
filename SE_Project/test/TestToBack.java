
import command.ToBackCommand;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestToBack {
    
    private Shape s1,s2;
    private Pane pane;
    private ToBackCommand toBackCommand;
    private SelectToolForTest selectTool;
    
    @Before
    public void setUp() {
        this.pane=new Pane();
        this.s1=new Line(5,10,30,50);
        this.s2=new Rectangle(3,5,60,55);
        this.selectTool=new SelectToolForTest();
        this.pane.getChildren().add(this.s1);
        this.pane.getChildren().add(this.s2);
        this.selectTool.setSelectedShape(this.s2);
        this.toBackCommand=new ToBackCommand(this.selectTool);
    }
    
    @Test
    public void testBack(){
        this.toBackCommand.execute();
        assertEquals(1,this.pane.getChildren().indexOf(this.s1));
        assertEquals(0,this.pane.getChildren().indexOf(this.s2));
        this.toBackCommand.undo();
        assertEquals(1,this.pane.getChildren().indexOf(this.s2));
        assertEquals(0,this.pane.getChildren().indexOf(this.s1));
        
    }
}
