
import command.ToFrontCommand;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestToFront {
    Shape s1,s2;
    Pane pane;
    ToFrontCommand toFrontCommand;
    SelectToolForTest selectTool;
      
    @Before
    public void setUp() {
        pane=new Pane();
        s1=new Line();
        s2=new Rectangle();
        selectTool=new SelectToolForTest();
        pane.getChildren().add(s1);
        pane.getChildren().add(s2);
        this.selectTool.setSelectedShape(s1);
        toFrontCommand=new ToFrontCommand(selectTool);
    }
    
    @Test
    public void testFront(){
        toFrontCommand.execute();
        assertEquals(1,pane.getChildren().indexOf(s1));
        assertEquals(0,pane.getChildren().indexOf(s2));
        toFrontCommand.undo();
        assertEquals(1,pane.getChildren().indexOf(s2));
        assertEquals(0,pane.getChildren().indexOf(s1));
        
    }


}
