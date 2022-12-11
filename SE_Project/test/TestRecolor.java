
import command.RecolorCommand;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRecolor {
    private Shape rectangle;
    private SelectToolForTest tool;
    private RecolorCommand recolorCommand;
    
    @Before
    public void setUp() {
        this.rectangle = new Rectangle (10,100,300,22);
        this.rectangle.setStroke(Color.BLACK);
        this.rectangle.setFill(Color.YELLOW);
        this.tool= new SelectToolForTest();
        this.recolorCommand = new RecolorCommand(this.tool, Color.AQUA,Color.BROWN);
    }
    
    @Test
    public void testRecolor() {
        this.tool.select(rectangle);
        this.recolorCommand.execute();
        assertEquals(this.rectangle.getFill(),Color.AQUA);
        assertEquals(this.rectangle.getStroke(),Color.BROWN);
        this.recolorCommand.undo();
        assertEquals(this.rectangle.getFill(),Color.YELLOW);
        assertEquals(this.rectangle.getStroke(),Color.BLACK);
    }

}
