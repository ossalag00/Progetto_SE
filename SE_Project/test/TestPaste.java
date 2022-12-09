/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import command.PasteCommand;
import Tool.ClipBoardTool;
import Tool.SelectTool;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author giorgino
 */
public class TestPaste {
    
    private Shape pasted,toPaste;
    private ClipBoardTool clipBoard;
    private Pane pane;
    private SelectTool selectTool;
    
    
    @Before
    public void setUp() {
        selectTool=new SelectTool();
        pane=new Pane();
        toPaste = new Rectangle(10,10,20,20);
        clipBoard = ClipBoardTool.getInstance(this.selectTool);
        selectTool.select(toPaste);
        clipBoard.setClipBoardTool(toPaste);
    }
    
    @Test
    public void testPaste(){
        
        PasteCommandForTest command = new PasteCommandForTest(selectTool,pane);
        pasted = command.execute();
        assert(pane.getChildren().contains(pasted));
        assertEquals(pasted.getLayoutX(),toPaste.getLayoutX(),0.1);
        assertEquals(pasted.getLayoutY(),toPaste.getLayoutY(),0.1);
        assertEquals(pasted.getFill(),toPaste.getFill());
        assertEquals(pasted.getStroke(),toPaste.getStroke());
    }
    
    
}
