
import command.ToBackCommand;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestToBack {
    
    Shape s1,s2;
    Pane pane;
    ToBackCommand toBackCommand;
    SelectToolForTest selectTool;
    
    
    public TestToBack() {
    }

    
    @Before
    public void setUp() {
        pane=new Pane();
        s1=new Line(5,10,30,50);
        s2=new Rectangle(3,5,60,55);
        selectTool=new SelectToolForTest();
        pane.getChildren().add(s1);
        pane.getChildren().add(s2);
        this.selectTool.setSelectedShape(s2);
        toBackCommand=new ToBackCommand(selectTool);
    }
    
    @Test
    public void testBack(){
        toBackCommand.execute();
        assertEquals(1,pane.getChildren().indexOf(s1));
        assertEquals(0,pane.getChildren().indexOf(s2));
        toBackCommand.undo();
        assertEquals(1,pane.getChildren().indexOf(s2));
        assertEquals(0,pane.getChildren().indexOf(s1));
        
    }
}
