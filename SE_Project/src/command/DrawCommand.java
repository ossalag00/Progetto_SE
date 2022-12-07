/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import Tool.DrawingTool;
import Tool.Tool;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

/**
 *
 * @author giorgino
 */
public class DrawCommand implements Command {
    private DrawingTool tool;
    private MouseEvent event;
    private Shape drawnShape;
    
    public DrawCommand(Tool tool,MouseEvent event) {
        this.tool = (DrawingTool)tool;
        this.event=event;
        
    }

    @Override
    public void execute() {
       this.tool.mouseUp(this.event);
       this.drawnShape=this.tool.getDrawnShape();
    }

     @Override
    public void undo() {
        this.tool.erase(this.drawnShape);
    }

    
}
