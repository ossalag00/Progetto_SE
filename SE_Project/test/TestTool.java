import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import Tool.*;
import command.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class TestTool {
    Shape line, rect, elli;
    Pane root;
    DrawingTool lineTool,rectTool,ellipseTool;
    
   @Before
    public void setup() {
        root = new Pane();
        //tool= new LineTool();
        lineTool=new LineTool();
        lineTool.setDrawingWindow(root);
        MouseEvent press = new MouseEvent(MouseEvent.MOUSE_PRESSED, 3,4,6,9,MouseButton.PRIMARY,1,false,false,false,false,false,false,false,false,false,false,null);
        lineTool.mouseDown(press);
        MouseEvent release = new MouseEvent(MouseEvent.MOUSE_RELEASED, 13,14,16,19,MouseButton.PRIMARY,0,false,false,false,false,false,false,false,false,false,false,null);
        DrawCommand command=new DrawCommand(lineTool,release);
        command.execute();
        rectTool=new RectangleTool();
        rectTool.setDrawingWindow(root);
        MouseEvent press2 = new MouseEvent(MouseEvent.MOUSE_PRESSED, 7,8,10,13,MouseButton.PRIMARY,1,false,false,false,false,false,false,false,false,false,false,null);
        rectTool.mouseDown(press2);
        MouseEvent release2 = new MouseEvent(MouseEvent.MOUSE_RELEASED, 12,13,15,18,MouseButton.PRIMARY,0,false,false,false,false,false,false,false,false,false,false,null);
        DrawCommand command2=new DrawCommand(rectTool,release2);
        command2.execute();
        ellipseTool= new EllipseTool();
        ellipseTool.setDrawingWindow(root);
        MouseEvent press3 = new MouseEvent(MouseEvent.MOUSE_PRESSED, 3,4,6,9,MouseButton.PRIMARY,1,false,false,false,false,false,false,false,false,false,false,null);
        ellipseTool.mouseDown(press3);
        MouseEvent release3 = new MouseEvent(MouseEvent.MOUSE_RELEASED, 13,14,16,19,MouseButton.PRIMARY,0,false,false,false,false,false,false,false,false,false,false,null);
        DrawCommand command3=new DrawCommand(ellipseTool,release3);
        command3.execute();
        
    }

    @Test
    public void testShapeInsertion() {
      
        assert(root.getChildren().contains(lineTool.getDrawnShape()));
        assert(root.getChildren().contains(rectTool.getDrawnShape()));
        assert(root.getChildren().contains(ellipseTool.getDrawnShape()));
    }
    
    @Test
    public void testShapeDimension() {

      assertEquals(lineTool.getStartX(),3,0);
      assertEquals(lineTool.getStartY(),4,0);
      assert(lineTool.getDrawnShape().contains(13, 14));
      
      assertEquals(rectTool.getStartX(), 7,0);
      assertEquals(rectTool.getStartY(), 8,0);
      assert(rectTool.getDrawnShape().contains(12, 13));
      
       assertEquals(ellipseTool.getStartX(), 3,0);
      assertEquals(ellipseTool.getStartY(), 4,0);
      assert(ellipseTool.getDrawnShape().contains(13, 4));//13,4 è l'estremo destro dell'asse maggiore dell'ellisse
    }
}
