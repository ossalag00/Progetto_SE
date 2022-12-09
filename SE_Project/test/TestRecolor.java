
import Tool.SelectTool;
import command.RecolorCommand;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRecolor {
    private Pane drawingPane;
    private Shape rectangle;
    private SelectTool tool;
    private RecolorCommand recolorCommand;
    
    @Before
    public void setUp() {
        drawingPane = new Pane();
        rectangle = new Rectangle (10,100,300,22);
        tool= new SelectTool();
        recolorCommand = new RecolorCommand(tool, Color.AQUA,Color.BROWN);
    }
    
    @Test
    public void testRecolor() {
        this.tool.select(rectangle);
        recolorCommand.execute();
        assertEquals(rectangle.getFill(),Color.AQUA);
        assertEquals(rectangle.getStroke(),Color.BROWN);
    }

}
