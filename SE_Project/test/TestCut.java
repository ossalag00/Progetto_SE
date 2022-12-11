/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import command.CutCommand;
import Tool.ClipBoardTool;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestCut {
    private SelectToolForTest selectTool;
    private ClipBoardTool clipBoard;
    private Shape copy,shapeToCopy;
    private Pane pane;
   
    
    
    
    @Before
    public void setUp() {
        this.pane=new Pane();
        this.selectTool=new SelectToolForTest();
        this.clipBoard= ClipBoardTool.getInstance(this.selectTool);
        this.shapeToCopy=new Rectangle(10,19,20,30);
        this.pane.getChildren().add(this.shapeToCopy);
    }
    
    

        @Test
    public void testCut(){
        selectTool.select(shapeToCopy);
        CutCommand cutCommand=new CutCommand(this.selectTool,this.pane);
        cutCommand.execute();
        this.copy=this.clipBoard.getClipBoardTool();
        assertEquals(this.copy.getLayoutX(),this.shapeToCopy.getLayoutX(),0.1);
        assertEquals(this.copy.getLayoutY(),this.shapeToCopy.getLayoutY(),0.1);
        assertEquals(this.copy.getFill(),this.shapeToCopy.getFill());
        assertEquals(this.copy.getStroke(),this.shapeToCopy.getStroke());
        assertFalse(this.pane.getChildren().contains(this.shapeToCopy));
        selectTool.deSelect();
        cutCommand.undo();
        assertEquals(this.clipBoard.getClipBoardTool(),null);    
        assertTrue(this.pane.getChildren().contains(shapeToCopy));
    }
}
