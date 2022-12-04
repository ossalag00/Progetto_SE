
import Tool.SelectTool;
import command.DeleteCommand;
import command.SelectCommand;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

 class TestDelete {
      private Pane drawingPane;
    private SelectTool tool;
    private Shape lineToDelete;
    private Shape rectangle;
    private int size;

    @Before
    public void setUp() {
        this.drawingPane = new Pane();
        this.lineToDelete = new Line(7,31,11,52);
        this.rectangle = new Rectangle(20,34,71,37);
        this.tool=new SelectTool();
        this.drawingPane.getChildren().add(lineToDelete);
        this.drawingPane.getChildren().add(rectangle);
        this.size = drawingPane.getChildren().size();
        
    }


    @Test
    public void testDelete(){
        DeleteCommand instance;
        SelectCommand select;
        select=new SelectCommand(tool,lineToDelete);
        select.execute();
        instance = new DeleteCommand(tool, drawingPane);
        instance.execute();
        assertFalse(drawingPane.getChildren().contains(lineToDelete));
        assertTrue(drawingPane.getChildren().contains(rectangle));
        assertEquals(size - 1, drawingPane.getChildren().size());

        

    }
}