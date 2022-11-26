/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import javafx.scene.layout.Pane;
import Tool.Tool;

/**
 *
 * @author giorgino
 */
public class DrawCommand implements Command {
    private Tool tool;
    private Pane pane;

    public DrawCommand(Tool tool,Pane pane) {
        this.tool = tool;
        this.pane=pane;
        
    }

    @Override
    public void execute() {
        this.pane.getChildren().add(this.tool.mouseUp());
    }

   

    
}
