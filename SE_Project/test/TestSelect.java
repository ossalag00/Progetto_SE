/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Tool.SelectTool;
import command.SelectCommand;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ciroc
 */
public class TestSelect {
    private Pane drawingPane;
    private Shape shape1;
    private Shape shape2;
    private SelectTool tool;
    
    
    @Before
    public void setUp() {
        drawingPane = new Pane();
        shape1 = new Ellipse(11,12,67,81);
        shape2 = new Line(11,21,76,18);
        tool = new SelectTool();
        drawingPane.getChildren().add(this.shape1);
        drawingPane.getChildren().add(this.shape2);        
    }
    
    @Test
    public void testSelect(){
        SelectCommand select;
        select = new SelectCommand(tool,shape1);
        select.execute();
        Shape s = tool.getSelectedShape();
        assertEquals(s,shape1);
        assertTrue(!tool.isToggle());
        tool.deSelect();
        assertTrue(tool.isToggle());
        assertNull(tool.getSelectedShape());
        
    }
    

}
