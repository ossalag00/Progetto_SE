
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
        this.pane=new Pane();
        this.s1=new Line();
        this.s2=new Rectangle();
        this.selectTool=new SelectToolForTest();
        this.pane.getChildren().add(this.s1);
        this.pane.getChildren().add(this.s2);
        this.selectTool.setSelectedShape(this.s1);
        this.toFrontCommand=new ToFrontCommand(this.selectTool);
    }
    
    @Test
    public void testFront(){
        this.toFrontCommand.execute();
        assertEquals(1,this.pane.getChildren().indexOf(this.s1));
        assertEquals(0,this.pane.getChildren().indexOf(this.s2));
        this.toFrontCommand.undo();
        assertEquals(1,this.pane.getChildren().indexOf(this.s2));
        assertEquals(0,this.pane.getChildren().indexOf(this.s1));
        
    }


}
