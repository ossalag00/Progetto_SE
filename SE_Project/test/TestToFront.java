/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Tool.SelectTool;
import command.SelectCommand;
import command.ToFrontCommand;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ciroc
 */
public class TestToFront {
    Shape s1,s2;
    Pane pane;
    ToFrontCommand toFrontCommand;
    SelectTool selectTool;
    SelectCommand select;
    
    public TestToFront() {
    }

    
    @Before
    public void setUp() {
        pane=new Pane();
        s1=new Line();
        s2=new Rectangle();
        selectTool=new SelectTool();
        pane.getChildren().add(s1);
        pane.getChildren().add(s2);
        select = new SelectCommand(selectTool,s1);
        toFrontCommand=new ToFrontCommand(selectTool);
    }
    
    @Test
    public void testFront(){
        select.execute();
        toFrontCommand.execute();
        assertEquals(1,pane.getChildren().indexOf(s1));
        assertEquals(0,pane.getChildren().indexOf(s2));
    }


}
