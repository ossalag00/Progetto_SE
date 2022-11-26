import Tool.LineTool;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import Tool.EllipseTool;
import Tool.RectangleTool;

public class TestTool {
    Shape line, rect, elli;
    Pane root;
    LineTool tooline;
    RectangleTool toolret;
    EllipseTool toolelli;
    DrawCommandForTest command;
    
   @Before
    public void setup() {

        root = new Pane();
        tooline = new LineTool();
        tooline.setStartX(3);
        tooline.setStartY(5);
        tooline.setEndX(7);
        tooline.setEndY(1);
        command=new DrawCommandForTest(tooline,root);
        line=command.execute();
        toolret = new RectangleTool();
        toolret.setStartX(5);
        toolret.setStartY(6);
        toolret.setEndX(2.5);
        toolret.setEndY(2);
        command = new DrawCommandForTest(toolret,root);
        rect = command.execute();
    }

    @Test
    public void testShapeInsertion() {
      
        assert(root.getChildren().contains(line));
        
        assert(root.getChildren().contains(rect));

    }
    
    @Test
    public void testShapeDimension() {

      assertEquals(tooline.getStartX(),3,0);
      assertEquals(tooline.getStartY(),5,0);
      assertEquals(tooline.getEndX(),7,0);
      assertEquals(tooline.getEndY(),1,0);
      
      assertEquals(toolret.getStartX(), 5,0);
      assertEquals(toolret.getStartY(), 6,0);
      assertEquals(toolret.getEndX(), 2.5,0);
      assertEquals(toolret.getEndY(), 2 ,0);

    }
}
