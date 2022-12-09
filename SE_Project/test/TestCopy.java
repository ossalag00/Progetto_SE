/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Tool.ClipBoardTool;
import Tool.SelectTool;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author giorgino
 */
public class TestCopy {
    
    private SelectTool selectTool;
    private ClipBoardTool clipBoard;
    private Shape copy,shapeToCopy;
   
    @Before
    public void setUp() {
        this.selectTool=new SelectTool();
        this.clipBoard= ClipBoardTool.getInstance(this.selectTool);
        this.shapeToCopy=new Rectangle(10,19,20,30);
    }
    @Test
    public void testCopy(){
        this.selectTool.select(this.shapeToCopy);
        CopyCommandForTest copyCommand=new CopyCommandForTest(this.selectTool);
        this.copy=copyCommand.execute();
        assertEquals(this.copy.getLayoutX(),this.selectTool.getSelectedShape().getLayoutX(),0.1);
        assertEquals(this.copy.getLayoutY(),this.selectTool.getSelectedShape().getLayoutY(),0.1);
        assertEquals(this.copy.getFill(),this.selectTool.getSelectedShape().getFill());
        assertEquals(this.copy.getStroke(),this.selectTool.getSelectedShape().getStroke());
        
        
    }
    
    
}
