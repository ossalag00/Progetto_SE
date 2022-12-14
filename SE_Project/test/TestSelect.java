/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestSelect {
    private Pane drawingPane;
    private Shape shape1;
    private Shape shape2;
    private SelectToolForTest tool;
    
    
    @Before
    public void setUp() {
        this.drawingPane = new Pane();
        this.shape1 = new Ellipse(11,12,67,81);
        this.shape2 = new Line(11,21,76,18);
        this.tool = new SelectToolForTest();
        this.drawingPane.getChildren().add(this.shape1);
        this.drawingPane.getChildren().add(this.shape2);        
    }
    
    @Test
    public void testSelect(){
        this.tool.select(shape1);
        Shape s = this.tool.getSelectedShape();
        assertEquals(s,shape1);
        assertTrue(!this.tool.isToggle());
        this.tool.deSelect();
        assertTrue(this.tool.isToggle());
        assertNull(this.tool.getSelectedShape());
        
    }
    

}
