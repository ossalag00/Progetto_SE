
import Tool.LineTool;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import se_project.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestTool {
    Shape line;
    Pane root;
    LineTool tooline;
    
   @Before
    public void setup() {

        root = new Pane();
        tooline = new LineTool();
        tooline.setStartX(3);
        tooline.setStartY(5);
        tooline.setEndX(7);
        tooline.setEndY(1);
        DrawCommandForTest command=new DrawCommandForTest(tooline,root);
        line=command.execute();
    }

    @Test
    public void testShapeInsertion() {
      
        assert(root.getChildren().contains(line));

    }
    
    @Test
    public void testShapeDimension() {

      assertEquals(tooline.getStartX(),3,0);
      assertEquals(tooline.getStartY(),5,0);
      assertEquals(tooline.getEndX(),7,0);
      assertEquals(tooline.getEndY(),1,0);

    }
}
