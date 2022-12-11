import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import Tool.*;
import command.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import static org.junit.Assert.assertFalse;

public class TestTool {
    private Shape line, rect, elli;
    private Pane root;
    private DrawingTool lineTool,rectTool,ellipseTool;
    private DrawCommand command,command2,command3;

    
   @Before
    public void setup() {
        this.root = new Pane();
        this.lineTool=new LineTool();
        this.lineTool.setDrawingWindow(this.root);
        MouseEvent press = new MouseEvent(MouseEvent.MOUSE_PRESSED, 3,4,6,9,MouseButton.PRIMARY,1,false,false,false,false,false,false,false,false,false,false,null);
        this.lineTool.mouseDown(press);
        MouseEvent release = new MouseEvent(MouseEvent.MOUSE_RELEASED, 13,14,16,19,MouseButton.PRIMARY,0,false,false,false,false,false,false,false,false,false,false,null);
        this.command=new DrawCommand(this.lineTool,release);
        this.command.execute();
        this.rectTool=new RectangleTool();
        this.rectTool.setDrawingWindow(this.root);
        MouseEvent press2 = new MouseEvent(MouseEvent.MOUSE_PRESSED, 7,8,10,13,MouseButton.PRIMARY,1,false,false,false,false,false,false,false,false,false,false,null);
        this.rectTool.mouseDown(press2);
        MouseEvent release2 = new MouseEvent(MouseEvent.MOUSE_RELEASED, 12,13,15,18,MouseButton.PRIMARY,0,false,false,false,false,false,false,false,false,false,false,null);
        this.command2=new DrawCommand(this.rectTool,release2);
        this.command2.execute();
        this.ellipseTool= new EllipseTool();
        this.ellipseTool.setDrawingWindow(this.root);
        MouseEvent press3 = new MouseEvent(MouseEvent.MOUSE_PRESSED, 3,4,6,9,MouseButton.PRIMARY,1,false,false,false,false,false,false,false,false,false,false,null);
        this.ellipseTool.mouseDown(press3);
        MouseEvent release3 = new MouseEvent(MouseEvent.MOUSE_RELEASED, 13,14,16,19,MouseButton.PRIMARY,0,false,false,false,false,false,false,false,false,false,false,null);
        this.command3=new DrawCommand(this.ellipseTool,release3);
        this.command3.execute();
        
    }

    @Test
    public void testShapeInsertion() {
      
        assert(this.root.getChildren().contains(this.lineTool.getDrawnShape()));
        assert(this.root.getChildren().contains(this.rectTool.getDrawnShape()));
        assert(this.root.getChildren().contains(this.ellipseTool.getDrawnShape()));
        this.command.undo();
        this.command2.undo();
        this.command3.undo();
        assertFalse(this.root.getChildren().contains(this.lineTool.getDrawnShape()));
        assertFalse(this.root.getChildren().contains(this.rectTool.getDrawnShape()));
        assertFalse(this.root.getChildren().contains(this.ellipseTool.getDrawnShape()));
    }
    
    @Test
    public void testShapeDimension() {

      assertEquals(this.lineTool.getStartX(),3,0);
      assertEquals(this.lineTool.getStartY(),4,0);
      assert(this.lineTool.getDrawnShape().contains(13, 14));
      
      assertEquals(this.rectTool.getStartX(), 7,0);
      assertEquals(this.rectTool.getStartY(), 8,0);
      assert(this.rectTool.getDrawnShape().contains(12, 13));
      
       assertEquals(this.ellipseTool.getStartX(), 3,0);
      assertEquals(this.ellipseTool.getStartY(), 4,0);
      assert(this.ellipseTool.getDrawnShape().contains(13, 4));//13,4 è l'estremo destro dell'asse maggiore dell'ellisse
    }
}
