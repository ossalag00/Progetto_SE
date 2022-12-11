/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Tool.ClipBoardTool;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

 public class TestPaste {
    
    private Shape pasted,toPaste;
    private ClipBoardTool clipBoard;
    private Pane pane;
    private SelectToolForTest selectTool;
    
    
    @Before
    public void setUp() {
        this.selectTool=new SelectToolForTest();
        this.pane=new Pane();
        this.toPaste = new Rectangle(10,10,20,20);
        this.clipBoard = ClipBoardTool.getInstance(this.selectTool);
        this.selectTool.select(this.toPaste);
        this.clipBoard.setClipBoardTool(this.toPaste);
    }
    
    @Test
    public void testPaste(){
        
        PasteCommandForTest command = new PasteCommandForTest(this.selectTool,pane);
        this.pasted = command.execute();
        assert(pane.getChildren().contains(this.pasted));
        assertEquals(this.pasted.getLayoutX(),this.toPaste.getLayoutX(),0.1);
        assertEquals(this.pasted.getLayoutY(),this.toPaste.getLayoutY(),0.1);
        assertEquals(this.pasted.getFill(),this.toPaste.getFill());
        assertEquals(this.pasted.getStroke(),this.toPaste.getStroke());
        command.undo();
        assertFalse(this.pane.getChildren().contains(this.pasted));
    }
    
    
}
